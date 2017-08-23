package com.myapp.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author yichaoran
 * @create 2017-08-22 14:52
 * @Description:
 **/
public class MybatisUtils {

    public static SqlSession getSqlSession() {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
            session = sqlSessionFactory.openSession(true);
        } catch (Exception e) {
            System.out.println("SqlSession获取异常！" + e.toString());
            e.printStackTrace();
        } finally {
            return session;
        }
    }
}

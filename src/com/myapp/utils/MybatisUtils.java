package com.myapp.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author yichaoran
 * @create 2017-08-22 14:52
 * @Description:
 **/
public class MybatisUtils {

    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
        } catch (IOException e) {
            System.out.println("SqlSession获取异常！" + e.toString());
            e.printStackTrace();
        } finally {
            return sqlSessionFactory;
        }
    }
}

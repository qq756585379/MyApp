package com.myapp.dao;

import com.myapp.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * Author： yichaoran
 * Data： 2017-08-23 16:13
 * Description：
 **/
public interface DaoUtils {

    public User queryUser(@Param("username") String userName, @Param("password") String passWord);

}

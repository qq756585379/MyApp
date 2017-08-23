package com.myapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author： yichaoran
 * Data： 2017-08-23 19:19
 * Description：
 **/
public class RegisterServlet extends HttpServlet {
    public RegisterServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //接收数据
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        //字符转码
        userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
        password = new String(password.getBytes("ISO-8859-1"), "UTF-8");


    }
}

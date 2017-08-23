package com.myapp.servlet;


import com.google.gson.Gson;
import com.myapp.bean.User;
import com.myapp.dao.DaoUtils;
import com.myapp.resultbean.LoginBean;
import com.myapp.utils.MybatisUtils;
import com.myapp.utils.PrintUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author： yichaoran
 * Data： 2017-08-23 16:01
 * Description：用户登录的接口
 **/
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
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

        System.out.println("name" + userName + "   pwa" + password);

        //查询数据库
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DaoUtils dao = sqlSession.getMapper(DaoUtils.class);
        User user = dao.queryUser(userName, password);
        System.out.println(user);
        sqlSession.close();

        //组装返回的数据
        LoginBean lb = new LoginBean();
        if (user != null) {
            System.out.println("---------------用户存在且密码正确，可以登录");
            lb.setCode(200);
            lb.setMsg("登录成功！");
            LoginBean.User bb = new LoginBean.User();
            bb.setJuuid(user.getJuuid());
            bb.setPhone(user.getPhone());
            bb.setUserName(user.getUserName());
            bb.setUserIcon(user.getUserIcon());
            bb.setArea(user.getArea());
            bb.setAbstracts(user.getAbstracts());
            bb.setMessage(user.getMessage());
            lb.setBody(bb);
        } else {
            System.out.println("---------------用户名或密码错误");
            lb.setCode(201);
            lb.setMsg("用户名或密码错误！");
        }
        //返回的Json数据
        Gson gson = new Gson();
        String json = gson.toJson(lb);
        PrintUtil.print(json, resp);
    }
}

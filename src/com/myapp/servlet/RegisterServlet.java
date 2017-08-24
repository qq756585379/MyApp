package com.myapp.servlet;

import com.google.gson.Gson;
import com.myapp.bean.User;
import com.myapp.dao.DaoUtils;
import com.myapp.resultbean.CommentBean;
import com.myapp.utils.MybatisUtils;
import com.myapp.utils.PrintUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author： yichaoran
 * Data： 2017-08-23 19:19
 * Description：
 **/
public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
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
        System.out.println("");
        //接收数据
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(172800);

        //字符转码
        userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
        password = new String(password.getBytes("ISO-8859-1"), "UTF-8");

        System.out.println("name = " + userName + "   pwa = " + password + "session = " + session.getId());
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession(true);
        DaoUtils dao = sqlSession.getMapper(DaoUtils.class);

        CommentBean bean = new CommentBean();
        User user1 = dao.queryUserByPhone(userName);
        if (user1 == null) {
            System.out.println("可以注册！");
            User user = new User();
            user.setPhone(userName);
            user.setPassword(password);
            user.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            dao.insertSingle(user);

            sqlSession.commit();
            sqlSession.close();

            bean.setCode(200);
            bean.setStatus("success");
            bean.setMsg("注册成功！");
        } else {
            bean.setCode(201);
            bean.setStatus("false");
            bean.setMsg("该用户已存在！");
        }

        //返回的Json数据
        Gson gson = new Gson();
        String json = gson.toJson(bean);
        PrintUtil.print(json, resp);
    }
}

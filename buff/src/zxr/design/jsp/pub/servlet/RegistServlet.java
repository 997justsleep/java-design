package zxr.design.jsp.pub.servlet;

import zxr.design.jsp.pub.dao.Impl.UserDaoImpl;
import zxr.design.jsp.pub.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        User user = new User(username,password);
        if(UserDaoImpl.getInstance().registUser(user)){//注册成功
            System.out.println("注册成功");
            resp.sendRedirect("login.jsp");
        }else{//注册失败
            //跳转到注册页面
            System.out.println("注册失败");
            resp.sendRedirect("regist.jsp");
        }
    }
}

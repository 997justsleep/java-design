package zxr.design.jsp.pub.servlet;

import zxr.design.jsp.pub.dao.Impl.UserDaoImpl;
import zxr.design.jsp.pub.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username == null || "".equals(username)||password == null || "".equals(password)){//有一个没输入
            resp.sendRedirect("login.jsp");
        }
        User user = new User(username,password);
        User user1 = UserDaoImpl.getInstance().loginUser(user);
        if( user1 !=  null){//用户存在
            if("admin".equals(UserDaoImpl.getInstance().loginUser(user).getAtrribute())){//管理员
                System.out.println("管理员登录");
                req.getSession().setAttribute("user", user1);
                //req.setAttribute("user", user1);
                req.getRequestDispatcher("admin/adminMain.jsp").forward(req, resp);
            }else{//普通用户
                System.out.println("普通用户登录");
                req.getSession().setAttribute("user", user1);
                //req.setAttribute("user", user1);
                req.getRequestDispatcher("normal/normalMain.jsp").forward(req, resp);
            }
        }else{//用户不存在
            //跳转到注册页面
            System.out.println("跳转注册");
            resp.sendRedirect("regist.jsp");
        }

    }
}

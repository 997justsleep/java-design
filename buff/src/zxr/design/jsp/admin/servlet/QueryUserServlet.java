package zxr.design.jsp.admin.servlet;

import zxr.design.jsp.admin.service.IUserService;
import zxr.design.jsp.admin.service.Impl.UserServiceImpl;
import zxr.design.jsp.normal.service.IInventoryService;
import zxr.design.jsp.normal.service.impl.InventoryServiceImpl;
import zxr.design.jsp.pub.pojo.Inventory;
import zxr.design.jsp.pub.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/querybyid")
public class QueryUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String userid = req.getParameter("userid");
        Integer id = Integer.parseInt(userid);
        System.out.println(id);
        IUserService iUserService = new UserServiceImpl();
        User user = iUserService.getUserinfo(id);
        System.out.println("querybyid: "+user.toString());
        req.setAttribute("user",user);
        req.getRequestDispatcher("userinfo.jsp").forward(req, resp);
    }
}

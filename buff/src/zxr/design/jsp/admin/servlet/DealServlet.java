package zxr.design.jsp.admin.servlet;

import zxr.design.jsp.admin.service.IUserService;
import zxr.design.jsp.admin.service.Impl.UserServiceImpl;
import zxr.design.jsp.normal.service.IInventoryService;
import zxr.design.jsp.normal.service.impl.InventoryServiceImpl;
import zxr.design.jsp.pub.pojo.Market;
import zxr.design.jsp.pub.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deal")
public class DealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String status = req.getParameter("status");
        if("false".equals(status)){//允许交易
            String id = req.getParameter("userid");
            User user = new User();
            user.setId(Integer.parseInt(id));
            IUserService iUserService = new UserServiceImpl();
            Boolean res = iUserService.letDeal(user.getId());
            req.setAttribute("result",res? "成功":"失败");
            req.getRequestDispatcher("/admin/userresult.jsp").forward(req,resp);
        }else{//禁止交易
            String id = req.getParameter("userid");
            User user = new User();
            user.setId(Integer.parseInt(id));
            IUserService iUserService = new UserServiceImpl();
            Boolean res = iUserService.stopDeal(user.getId());
            req.setAttribute("result",res? "成功":"失败");
            req.getRequestDispatcher("/admin/userresult.jsp").forward(req,resp);
        }
    }
}

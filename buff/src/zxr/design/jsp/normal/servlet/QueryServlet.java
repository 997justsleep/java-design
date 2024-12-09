package zxr.design.jsp.normal.servlet;

import zxr.design.jsp.normal.service.IInventoryService;
import zxr.design.jsp.normal.service.impl.InventoryServiceImpl;
import zxr.design.jsp.pub.pojo.Inventory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/normal/queryByid")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String invenid = req.getParameter("id");
        Integer id = Integer.parseInt(invenid);
        System.out.println(id);
        IInventoryService inventoryService = new InventoryServiceImpl();
        Inventory inventory = inventoryService.selectSkinByid(id);
        System.out.println(inventory.toString());
        req.setAttribute("inventory",inventory);
        System.out.println("querybyid     id"+req.getParameter("id")+",page"+req.getParameter("page"));
        req.setAttribute("id",req.getParameter("id"));
        req.setAttribute("page",req.getParameter("page"));

        req.getRequestDispatcher("sellskin.jsp").forward(req, resp);
    }
}

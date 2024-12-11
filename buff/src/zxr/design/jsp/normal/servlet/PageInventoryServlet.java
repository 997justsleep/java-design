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
import java.util.List;

@WebServlet("/normal/pagingInventory")
public class PageInventoryServlet extends HttpServlet {
    private static final int PAGE_SIZE = 5; // 每页显示的记录数

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int currentPage = 1; // 默认当前页码为1
        String pageParam = req.getParameter("page");
        String userid = req.getParameter("userid");
        String sellstatus = req.getParameter("sellstatus");
        Integer id = Integer.parseInt(userid);
        if (pageParam!= null &&!pageParam.isEmpty()) {
            try {
                currentPage = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                // 如果参数转换失败，保持默认页码为1
                System.out.println("获取页数失败");
            }
        }
        IInventoryService iInventoryService = new InventoryServiceImpl();
        List<Inventory> invenList =iInventoryService.getMineInventory(id, currentPage, PAGE_SIZE);

        int totalCount = iInventoryService.getTotalPage(id);
        int totalPages = (totalCount + PAGE_SIZE - 1) / PAGE_SIZE; // 计算总页数
        System.out.println("totalCount: "+totalCount+",totalPages: "+totalPages);
        req.getSession().setAttribute("userid",userid);
        req.getSession().setAttribute("sellstatus",sellstatus);
        req.getSession().setAttribute("invenList", invenList);
        req.getSession().setAttribute("currentPage", currentPage);
        req.getSession().setAttribute("totalPages", totalPages);
        req.getRequestDispatcher("inventory.jsp").forward(req, resp);
    }
}

package zxr.design.jsp.admin.servlet;

import zxr.design.jsp.pub.dao.Impl.SellDaoImpl;
import zxr.design.jsp.pub.pojo.Sell;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/pagingSell")
public class PageSellServlet extends HttpServlet {
    private static final int PAGE_SIZE = 5; // 每页显示的记录数

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = 1; // 默认当前页码为1
        String pageParam = req.getParameter("page");
        if (pageParam!= null &&!pageParam.isEmpty()) {
            try {
                currentPage = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                // 如果参数转换失败，保持默认页码为1
                System.out.println("获取页数失败");
            }
        }

        List<Sell> List = SellDaoImpl.getInstance().selectAll(currentPage, PAGE_SIZE);

        int totalCount = SellDaoImpl.getInstance().getTotalSellCount();
        int totalPages = (totalCount + PAGE_SIZE - 1) / PAGE_SIZE; // 计算总页数
        System.out.println("totalCount: "+totalCount+",totalPages: "+totalPages);

        req.setAttribute("sellList", List);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPages", totalPages);

        req.getRequestDispatcher("sell.jsp").forward(req, resp);
    }
}

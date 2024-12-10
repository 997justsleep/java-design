package zxr.design.jsp.admin.servlet;

import zxr.design.jsp.pub.dao.Impl.UserDaoImpl;
import zxr.design.jsp.pub.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/pagingUser")
public class PageUserServlet extends HttpServlet {
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
        if (pageParam!= null &&!pageParam.isEmpty()) {
            try {
                currentPage = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                // 如果参数转换失败，保持默认页码为1
                System.out.println("获取页数失败");
            }
        }

        List<User> userList = UserDaoImpl.getInstance().selectAll(currentPage, PAGE_SIZE);

        int totalCount = UserDaoImpl.getInstance().getTotalUserCount();
        int totalPages = (totalCount + PAGE_SIZE - 1) / PAGE_SIZE; // 计算总页数
        System.out.println("totalCount: "+totalCount+",totalPages: "+totalPages);
        
        req.getSession().setAttribute("userList", userList);
        req.getSession().setAttribute("currentPage", currentPage);
        req.getSession().setAttribute("totalPages", totalPages);

        req.getRequestDispatcher("alluser.jsp").forward(req, resp);
    }
}

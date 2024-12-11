package zxr.design.jsp.admin.servlet;

import zxr.design.jsp.admin.service.IEvaluationService;
import zxr.design.jsp.admin.service.Impl.EvaluationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleva")
public class DelEvaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("evaid");

        IEvaluationService iEvaluationService = new EvaluationServiceImpl();
        Boolean res = iEvaluationService.deleteEva(Integer.parseInt(id));
        req.setAttribute("result",res? "成功":"失败");
        req.getRequestDispatcher("/admin/delevaresult.jsp").forward(req,resp);
    }
}

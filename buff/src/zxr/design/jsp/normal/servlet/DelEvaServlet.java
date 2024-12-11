package zxr.design.jsp.normal.servlet;

import zxr.design.jsp.normal.service.IEvaluationService;
import zxr.design.jsp.normal.service.impl.EvaluationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/normal/deleva")
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
        req.setAttribute("page",req.getParameter("page"));
        req.getRequestDispatcher("/normal/delevaresult.jsp").forward(req,resp);
    }
}

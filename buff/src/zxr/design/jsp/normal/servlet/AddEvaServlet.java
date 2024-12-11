package zxr.design.jsp.normal.servlet;

import zxr.design.jsp.normal.service.IEvaluationService;
import zxr.design.jsp.normal.service.impl.EvaluationServiceImpl;
import zxr.design.jsp.pub.pojo.Evaluation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/normal/addeva")
public class AddEvaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String sellid = req.getParameter("sellid");
        String userid = req.getParameter("userid");
        String content = req.getParameter("content");

        Evaluation evaluation = new Evaluation();
        evaluation.setSellid(Integer.parseInt(sellid));
        evaluation.setUserid(Integer.parseInt(userid));
        evaluation.setContent(content);

        IEvaluationService iEvaluationService = new EvaluationServiceImpl();
        boolean res = iEvaluationService.addEva(evaluation);

        req.setAttribute("result",res? "成功":"失败");
        req.getRequestDispatcher("/normal/addevaresult.jsp").forward(req,resp);
    }
}

package zxr.design.jsp.admin.servlet;

import zxr.design.jsp.admin.service.IEvaluationService;
import zxr.design.jsp.admin.service.Impl.EvaluationServiceImpl;
import zxr.design.jsp.pub.pojo.Evaluation;
import zxr.design.jsp.pub.pojo.EvaluationAndSell;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/evaconnsell")
public class EvaConnSellServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String evaid = req.getParameter("evaid");
        String userid = req.getParameter("userid");
        String sellid = req.getParameter("sellid");
        String content = req.getParameter("content");
        Evaluation evaluation = new Evaluation(
                Integer.parseInt(evaid),
                Integer.parseInt(userid),
                Integer.parseInt(sellid),
                content
        );
        IEvaluationService iEvaluationService = new EvaluationServiceImpl();
        EvaluationAndSell evaluationAndSell = iEvaluationService.getinfo(evaluation);
        req.getSession().setAttribute("evaluation",evaluationAndSell.getEvaluation());
        req.getSession().setAttribute("sell",evaluationAndSell.getSell());
        req.getRequestDispatcher("evaInfo.jsp").forward(req, resp);
    }
}

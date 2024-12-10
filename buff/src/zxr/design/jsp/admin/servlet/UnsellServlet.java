package zxr.design.jsp.admin.servlet;

import zxr.design.jsp.admin.service.IMarketService;
import zxr.design.jsp.admin.service.Impl.MarketServiceImpl;
import zxr.design.jsp.pub.pojo.Inventory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/unsell")
public class UnsellServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String marketid = req.getParameter("marketid");
        String marketfrom = req.getParameter("marketfrom");
        String guntype = req.getParameter("guntype");
        String skinname = req.getParameter("skinname");
        Inventory inventory = new Inventory();
        inventory.setBelong(Integer.parseInt(marketfrom));
        inventory.setGuntype(guntype);
        inventory.setSkinname(skinname);
        inventory.setSelling("true");
        System.out.println("unsell:"+inventory.toString());
        IMarketService iMarketService = new MarketServiceImpl();
        boolean res = iMarketService.unsell(Integer.parseInt(marketid),inventory);
        req.setAttribute("result",res? "成功":"失败");
        req.getRequestDispatcher("/admin/unsellresult.jsp").forward(req,resp);
    }
}

package zxr.design.jsp.normal.servlet;

import zxr.design.jsp.normal.service.IMarketService;
import zxr.design.jsp.normal.service.impl.MarketServiceImpl;
import zxr.design.jsp.pub.pojo.Market;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/normal/buySkin")
public class BuySkinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 设置请求编码为UTF-8
        IMarketService iMarketService = new MarketServiceImpl();
        String userid = req.getParameter("userid");
        String marketid = req.getParameter("marketid");
        String marketfrom = req.getParameter("marketfrom");
        String marketguntype = req.getParameter("marketguntype");
        String marketskinname = req.getParameter("marketskinname");
        String marketprice = req.getParameter("marketprice");

        // 打印请求参数
        System.out.println("Received parameters:");
        System.out.println("userid: " + userid);
        System.out.println("marketid: " + marketid);
        System.out.println("marketfrom: " + marketfrom);
        System.out.println("marketguntype: " + marketguntype);
        System.out.println("marketskinname: " + marketskinname);
        System.out.println("marketprice: " + marketprice);

        Market market = new Market();
        System.out.println("buyskin:"+userid);

        market.setId(Integer.parseInt(marketid));
        market.setFrom(Integer.parseInt(marketfrom));
        market.setGuntype(marketguntype);
        market.setSkinname(marketskinname);
        market.setPrice(Integer.parseInt(marketprice));
        System.out.println(market.toString());

        Boolean res = iMarketService.buySkin(Integer.parseInt(userid),market);
        req.setAttribute("result",res? "成功":"失败");
        req.getRequestDispatcher("/normal/buyresult.jsp").forward(req,resp);
    }
}

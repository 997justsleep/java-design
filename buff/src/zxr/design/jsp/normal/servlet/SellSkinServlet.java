package zxr.design.jsp.normal.servlet;

import zxr.design.jsp.normal.service.IInventoryService;
import zxr.design.jsp.normal.service.impl.InventoryServiceImpl;
import zxr.design.jsp.pub.pojo.Market;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/normal/sellskin")
public class SellSkinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String type = req.getParameter("type");
        if("sell".equals(type)){//上架
            String id = req.getParameter("id");
            String from = req.getParameter("from");
            String guntype = req.getParameter("guntype");
            String skin = req.getParameter("skin");
            String price = req.getParameter("price");
            Market market = new Market();
            market.setFrom(Integer.parseInt(from));
            market.setPrice(Integer.parseInt(price));
            market.setGuntype(guntype);
            market.setSkinname(skin);
            IInventoryService iInventoryService = new InventoryServiceImpl();
            Boolean res = iInventoryService.sellSkin(Integer.parseInt(id),market);
            req.setAttribute("result",res? "成功":"失败");

            req.getRequestDispatcher("/normal/sellresult.jsp").forward(req,resp);
        }else{//下架
            String id = req.getParameter("id");
            String from = req.getParameter("from");
            String guntype = req.getParameter("guntype");
            String skin = req.getParameter("skin");
            IInventoryService iInventoryService = new InventoryServiceImpl();
            Boolean res = iInventoryService.unsellSkin(Integer.parseInt(id),Integer.parseInt(from),guntype,skin);
            req.setAttribute("result",res? "成功":"失败");

            req.getRequestDispatcher("/normal/sellresult.jsp").forward(req,resp);
        }

    }
}

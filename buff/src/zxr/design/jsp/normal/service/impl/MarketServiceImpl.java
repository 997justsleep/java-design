package zxr.design.jsp.normal.service.impl;

import zxr.design.jsp.normal.service.IMarketService;
import zxr.design.jsp.pub.dao.Impl.InventoryDaoImpl;
import zxr.design.jsp.pub.dao.Impl.MarketDaoImpl;
import zxr.design.jsp.pub.dao.Impl.SellDaoImpl;
import zxr.design.jsp.pub.pojo.Inventory;
import zxr.design.jsp.pub.pojo.Market;
import zxr.design.jsp.pub.pojo.Sell;

import java.util.List;

public class MarketServiceImpl implements IMarketService {
    @Override
    public List<Market> getAllMarket(int currentPage, int pageSize) {
        return MarketDaoImpl.getInstance().selectAll(currentPage,pageSize);
    }

    @Override
    public Integer getTotalMarketCount() {
        return MarketDaoImpl.getInstance().getTotalMarketCount();
    }

    @Override
    public Boolean buySkin(int userid,Market market) {
        //从市场删除
        Boolean a = MarketDaoImpl.getInstance().deleteByid(market.getId());
        //给用户添加，（更新belong字段和sellstatus）
        //先查询这个记录的库存id
        Inventory inventory = InventoryDaoImpl.getInstance().selectBysome(market.getGuntype(),
                market.getSkinname(),market.getFrom(),"true");
        int invenid = inventory.getId();
        Boolean b = InventoryDaoImpl.getInstance().updateBelong_sellstatus(userid,invenid);
        //添加交易记录
        Sell sell = new Sell();
        sell.setFrom(market.getFrom());
        sell.setTo(userid);
        sell.setGuntype(market.getGuntype());
        sell.setSkinname(market.getSkinname());
        sell.setMoney(market.getPrice());
        Boolean c = SellDaoImpl.getInstance().insertNew(sell);
        return a&&b&&c;
    }

    @Override
    public List<Market> selectByGun_skin(String guntype, String skinname,int currentPage,int pageSize) {
        return MarketDaoImpl.getInstance().selectByGun_skin(guntype,skinname,currentPage,pageSize);
    }

    @Override
    public List<Market> selectByMoney_min_max(int min_much, int max_much,int currentPage,int pageSize) {
        return MarketDaoImpl.getInstance().selectByMonney_min_max(min_much, max_much, currentPage, pageSize);
    }
}

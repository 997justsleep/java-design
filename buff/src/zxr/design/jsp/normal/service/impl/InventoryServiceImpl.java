package zxr.design.jsp.normal.service.impl;

import zxr.design.jsp.normal.service.IInventoryService;
import zxr.design.jsp.pub.dao.Impl.InventoryDaoImpl;
import zxr.design.jsp.pub.dao.Impl.MarketDaoImpl;
import zxr.design.jsp.pub.pojo.Inventory;
import zxr.design.jsp.pub.pojo.Market;

import java.util.List;

public class InventoryServiceImpl implements IInventoryService {
    @Override
    public List<Inventory> getMineInventory(int id, int currentPage, int pageSize) {
        return InventoryDaoImpl.getInstance().selectMine(id, currentPage, pageSize);
    }

    @Override
    public int getTotalPage(int id) {
        return InventoryDaoImpl.getInstance().getTotalInventoryCount(id);
    }

    @Override
    public boolean sellSkin(int invenid, Market market) {
        System.out.println(invenid+" \n" +market.toString());
        return InventoryDaoImpl.getInstance().updateSelling(invenid,"true") &&
                MarketDaoImpl.getInstance().inserMarket(market);
    }

    @Override
     public boolean unsellSkin(int invenid,int from ,String guntype,String skinname) {
        Boolean a = InventoryDaoImpl.getInstance().updateSelling(invenid,"false");
        int marid = MarketDaoImpl.getInstance().selectBySome(from, guntype, skinname).getId();
        Boolean b = MarketDaoImpl.getInstance().deleteByid(marid);
        return a&&b;
    }

    @Override
    public Inventory selectSkinByid(int id) {
        return InventoryDaoImpl.getInstance().selectByid(id);
    }
}

package zxr.design.jsp.admin.service.Impl;

import zxr.design.jsp.admin.service.IMarketService;
import zxr.design.jsp.pub.dao.Impl.InventoryDaoImpl;
import zxr.design.jsp.pub.dao.Impl.MarketDaoImpl;
import zxr.design.jsp.pub.pojo.Inventory;

public class MarketServiceImpl implements IMarketService {
    @Override
    public boolean unsell(int marid, Inventory inventory) {
        int invenid = InventoryDaoImpl.getInstance().selectBysome(inventory.getGuntype(),inventory.getSkinname(),
                inventory.getBelong(),inventory.getSelling()).getId();
        return MarketDaoImpl.getInstance().deleteByid(marid) &&
            InventoryDaoImpl.getInstance().updateSelling(invenid,"false");
    }
}

package zxr.design.jsp.normal.service;


import zxr.design.jsp.pub.pojo.Inventory;
import zxr.design.jsp.pub.pojo.Market;

import java.util.List;

public interface IInventoryService {
    List<Inventory> getMineInventory(int id, int currentPage, int pageSize);
    boolean sellSkin(int invenid, Market market);
    boolean unsellSkin(int invenid,int from ,String guntype,String skinname);
    int getTotalPage(int id);
    Inventory selectSkinByid(int id);
}

package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Inventory;

import java.util.List;

public interface IInventoryDao {
    List<Inventory> selectMine(int id,int currentPage, int pageSize);
    Integer getTotalInventoryCount(int id);
    Inventory selectByid(int id);
    boolean updateSelling(int id,String status);
    boolean insertNew(Inventory inventory);
    boolean updateBelong_sellstatus(int belong,int id);
    Inventory selectBysome(String guntype,String skinname,int belong,String sellsatus);
    Boolean updateSellingBybelong(int belong,String status);
}

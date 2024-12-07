package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Inventory;

import java.util.List;

public interface IInventoryDao {
    List<Inventory> selectMine(int id,int currentPage, int pageSize);
    Integer getTotalInventoryCount(int id);

}

package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Sell;

import java.util.List;

public interface ISellDao {
    List<Sell> selectAll(int currentPage, int pageSize);
    Integer getTotalSellCount();
    List<Sell> selectMine(int id,int currentPage,int pageSize);
    Integer getMineTotalSellCount(int id);
    Boolean insertNew(Sell sell);
}

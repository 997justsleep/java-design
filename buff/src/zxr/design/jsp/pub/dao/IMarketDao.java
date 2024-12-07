package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Market;

import java.util.List;

public interface IMarketDao {
    List<Market> selectAll(int currentPage, int pageSize);
    Integer getTotalMarketCount();
}

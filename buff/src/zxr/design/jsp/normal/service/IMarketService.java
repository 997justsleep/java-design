package zxr.design.jsp.normal.service;

import zxr.design.jsp.pub.pojo.Market;

import java.util.List;

public interface IMarketService {
    List<Market> getAllMarket();
    void buySkin(int id);
}

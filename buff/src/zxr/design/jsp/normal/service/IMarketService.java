package zxr.design.jsp.normal.service;

import zxr.design.jsp.pub.pojo.Market;

import java.util.List;

public interface IMarketService {
    List<Market> getAllMarket(int currentPage,int pageSize);
    Integer getTotalMarketCount();
    Boolean buySkin(int userid,Market market);
    List<Market> selectByGun_skin(String guntype,String skinname,int currentPage,int pageSize);
    Integer selectGunSkinCount(String guntype,String skinname);
}

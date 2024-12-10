package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Market;

import java.util.List;

public interface IMarketDao {
    List<Market> selectAll(int currentPage, int pageSize);
    Integer getTotalMarketCount();
    Boolean inserMarket(Market market);
    Market selectBySome(int from,String guntype,String skinname);
    Boolean deleteByid(int id);
    List<Market> selectByGun_skin(String guntype,String skinname,int currentPage,int pageSize);
    Integer selectGunSkinCount(String guntype,String skinname);
    Boolean deleteByFrom(int fromid);

}

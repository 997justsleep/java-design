package zxr.design.jsp.admin.service.Impl;

import zxr.design.jsp.admin.service.IUserService;
import zxr.design.jsp.pub.dao.Impl.InventoryDaoImpl;
import zxr.design.jsp.pub.dao.Impl.MarketDaoImpl;
import zxr.design.jsp.pub.dao.Impl.UserDaoImpl;
import zxr.design.jsp.pub.pojo.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User getUserinfo(int id) {
        return UserDaoImpl.getInstance().selectByUserid(id);
    }

    @Override
    public Boolean letDeal(int id) {
        return UserDaoImpl.getInstance().updateSellStatus(id,"true");
    }

    @Override
    public Boolean stopDeal(int id) {
        //下架该用户所有商品
        MarketDaoImpl.getInstance().deleteByFrom(id);
        //修改交易状态
        InventoryDaoImpl.getInstance().updateSellingBybelong(id,"false");
        //更新状态
        return UserDaoImpl.getInstance().updateSellStatus(id,"false");

    }
}

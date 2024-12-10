package zxr.design.jsp.admin.service;

import zxr.design.jsp.pub.pojo.User;

public interface IUserService {
    User getUserinfo(int id);
    Boolean letDeal(int id);
    Boolean stopDeal(int id);
}

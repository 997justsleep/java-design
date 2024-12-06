package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.User;

import java.util.List;

public interface IUserDao {
    User loginUser(User user);
    Boolean registUser(User user);
    List<User> selectAll(int currentPage, int pageSize);
    Integer getTotalUserCount();
}

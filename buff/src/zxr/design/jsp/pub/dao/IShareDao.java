package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Share;

import java.util.List;

public interface IShareDao {
    List<Share> selectAll(int currentPage, int pageSize);
    Integer getTotalShareCount();
}

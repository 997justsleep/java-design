package zxr.design.jsp.admin.service;

import zxr.design.jsp.pub.pojo.Inventory;

public interface IMarketService {
    boolean unsell(int marid, Inventory inventory);
}

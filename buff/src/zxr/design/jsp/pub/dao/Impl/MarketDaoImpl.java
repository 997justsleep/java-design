package zxr.design.jsp.pub.dao.Impl;

import zxr.design.jsp.pub.dao.IMarketDao;
import zxr.design.jsp.pub.pojo.Market;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarketDaoImpl implements IMarketDao {
    //单例模式三件套
    private static MarketDaoImpl instance;//静态对象
    private Connection conn;

    private MarketDaoImpl() {//私有构造函数
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/buff?serverTimeZone=Asia/Shanghai",
                    "root",
                    "root"
            );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动错误！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库访问错误！");
        }
    }

    static public MarketDaoImpl getInstance() {//共有静态方法获取实例
        if(instance == null){
            instance = new MarketDaoImpl();
        }
        return instance;
    }
    //以上为单例模式模板


    @Override
    public List<Market> selectAll(int currentPage, int pageSize) {
        List<Market> marketList = new ArrayList<>();
        String sql = "select * from market limit ?,?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Market market = new Market();
                market.setId(rs.getInt(1));
                market.setFrom(rs.getInt(2));
                market.setGuntype(rs.getString(3));
                market.setSkinname(rs.getString(4));
                market.setPrice(rs.getDouble(5));
                marketList.add(market);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("market列表的大小"+marketList.size());
        return marketList;
    }

    @Override
    public Integer getTotalMarketCount() {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from market";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}

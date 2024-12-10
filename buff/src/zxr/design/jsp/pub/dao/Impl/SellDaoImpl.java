package zxr.design.jsp.pub.dao.Impl;

import zxr.design.jsp.pub.dao.ISellDao;
import zxr.design.jsp.pub.pojo.Sell;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellDaoImpl implements ISellDao {
    //单例模式三件套
    private static SellDaoImpl instance;//静态对象
    private Connection conn;

    private SellDaoImpl() {//私有构造函数
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

    static public SellDaoImpl getInstance() {//共有静态方法获取实例
        if(instance == null){
            instance = new SellDaoImpl();
        }
        return instance;
    }
    //以上为单例模式模板


    @Override
    public List<Sell> selectAll(int currentPage, int pageSize) {
        List<Sell> sellList = new ArrayList<>();
        String sql = "select * from sell limit ?,?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Sell sell = new Sell();
                sell.setId(rs.getInt(1));
                sell.setFrom(rs.getInt(2));
                sell.setTo(rs.getInt(3));
                sell.setGuntype(rs.getString(4));
                sell.setSkinname(rs.getString(5));
                sell.setMoney(rs.getInt(6));
                sellList.add(sell);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("sell列表的大小"+sellList.size());
        return sellList;
    }

    @Override
    public Integer getTotalSellCount() {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from sell";
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

    @Override
    public List<Sell> selectMine(int id, int currentPage, int pageSize) {
        List<Sell> sellList = new ArrayList<>();
        String sql = "select * from sell where come = ? or arrive = ? limit ?,?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);
            pstmt.setInt(3, (currentPage - 1) * pageSize);
            pstmt.setInt(4, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Sell sell = new Sell();
                sell.setId(rs.getInt(1));
                sell.setFrom(rs.getInt(2));
                sell.setTo(rs.getInt(3));
                sell.setGuntype(rs.getString(4));
                sell.setSkinname(rs.getString(5));
                sell.setMoney(rs.getInt(6));
                sellList.add(sell);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Minesell列表的大小"+sellList.size());
        return sellList;
    }

    @Override
    public Integer getMineTotalSellCount(int id) {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from sell where come = ? or arrive = id";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Boolean insertNew(Sell sell) {
        String sql = "insert into sell(come,arrive,guntype,skinname,money) values(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sell.getFrom());
            pstmt.setInt(2,sell.getTo());
            pstmt.setString(3,sell.getGuntype());
            pstmt.setString(4,sell.getSkinname());
            pstmt.setInt(5,sell.getMoney());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {//检查受影响的条数
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

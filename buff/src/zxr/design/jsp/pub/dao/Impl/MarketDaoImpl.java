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
                market.setPrice(rs.getInt(5));
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

    @Override
    public Boolean inserMarket(Market market) {
        String sql = "insert into market(come,guntype,skinname,price) values(?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,market.getFrom());
            pstmt.setString(2,market.getGuntype());
            pstmt.setString(3,market.getSkinname());
            pstmt.setDouble(4,market.getPrice());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {//检查受影响的条数
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Market selectBySome(int from, String guntype, String skinname) {
        String sql = "select * from market where come = ? and guntype = ? and skinname = ?";
        PreparedStatement pstmt;
        ResultSet rs;
        Market market = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, from);
            pstmt.setString(2, guntype);
            pstmt.setString(3, skinname);
            rs = pstmt.executeQuery();
            if(rs.next()){
                market = new Market();
                market.setId(rs.getInt(1));
                market.setFrom(rs.getInt(2));
                market.setGuntype(rs.getString(3));
                market.setSkinname(rs.getString(4));
                market.setPrice(rs.getInt(5));
                System.out.println("market属性 "+market.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return market;
    }

    @Override
    public Boolean deleteByid(int id) {
        String sql = "delete from market where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {//检查受影响的条数
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Market> selectByGun_skin(String guntype, String skinname,int currentPage,int pageSize) {
        List<Market> marketList = new ArrayList<>();
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            if(guntype != null && !"".equals(guntype) && skinname != null && ! "".equals(skinname)){
                String sql = "select * from market where guntype like ? and skinname like ? limit ?,?";
                guntype = '%'+guntype+'%';
                skinname = '%'+skinname+'%';
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,guntype);
                pstmt.setString(2,skinname);
                pstmt.setInt(3, (currentPage - 1) * pageSize);
                pstmt.setInt(4, pageSize);
            }else if(guntype == null || "".equals(guntype)){
                String sql = "select * from market where skinname like ? limit ?,?";
                skinname = '%'+skinname+'%';
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,skinname);
                pstmt.setInt(2, (currentPage - 1) * pageSize);
                pstmt.setInt(3, pageSize);
            }else{
                String sql = "select * from market where guntype like ? limit ?,?";
                pstmt = conn.prepareStatement(sql);
                guntype = '%'+guntype+'%';
                pstmt.setString(1,guntype);
                pstmt.setInt(2, (currentPage - 1) * pageSize);
                pstmt.setInt(3, pageSize);
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Market market = new Market();
                market.setId(rs.getInt(1));
                market.setFrom(rs.getInt(2));
                market.setGuntype(rs.getString(3));
                market.setSkinname(rs.getString(4));
                market.setPrice(rs.getInt(5));
                marketList.add(market);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("market列表的大小"+marketList.size());
        return marketList;
    }

    @Override
    public Integer selectGunSkinCount(String guntype, String skinname) {
        int count = 0;
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            if(guntype != null && !"".equals(guntype) && skinname != null && ! "".equals(skinname)){
                String sql = "select count(*) from market where guntype like ? and skinname like ?";
                guntype = '%'+guntype+'%';
                skinname = '%'+skinname+'%';
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,guntype);
                pstmt.setString(2,skinname);
            }else if(guntype == null || "".equals(guntype)){
                String sql = "select count(*) from market where skinname like ?";
                skinname = '%'+skinname+'%';
                pstmt = conn.prepareStatement(sql);;
                pstmt.setString(1,skinname);
            }else{
                String sql = "select count(*) from market where guntype like ?";
                guntype = '%'+guntype+'%';
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,guntype);
            }
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

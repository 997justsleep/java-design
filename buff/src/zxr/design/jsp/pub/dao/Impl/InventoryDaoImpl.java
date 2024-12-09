package zxr.design.jsp.pub.dao.Impl;

import zxr.design.jsp.pub.dao.IInventoryDao;
import zxr.design.jsp.pub.pojo.Inventory;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDaoImpl implements IInventoryDao {
    //单例模式三件套
    private static InventoryDaoImpl instance;//静态对象
    private Connection conn;

    private InventoryDaoImpl() {//私有构造函数
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

    static public InventoryDaoImpl getInstance() {//共有静态方法获取实例
        if(instance == null){
            instance = new InventoryDaoImpl();
        }
        return instance;
    }
    //以上为单例模式模板


    @Override
    public List<Inventory> selectMine(int id, int currentPage, int pageSize) {
        System.out.println("id: "+id+",currentpage: "+currentPage+",pagesize: "+pageSize);
        List<Inventory> invenList = new ArrayList<>();
        String sql = "select * from inventory where belong = ? limit ?,?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setInt(2, (currentPage - 1) * pageSize);
            pstmt.setInt(3, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Inventory inventory = new Inventory();
                inventory.setId(rs.getInt(1));
                inventory.setGuntype(rs.getString(2));
                inventory.setSkinname(rs.getString(3));
                inventory.setBelong(rs.getInt(4));
                inventory.setSelling(rs.getString(5));
                invenList.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("inventory列表的大小"+invenList.size());
        return invenList;
    }

    @Override
    public Integer getTotalInventoryCount(int id) {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from inventory where belong = ?";
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
    public Inventory selectByid(int id) {
        String sql = "select * from inventory where id = ?";
        PreparedStatement pstmt;
        ResultSet rs;
        Inventory inventory = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                inventory = new Inventory();
                inventory.setId(rs.getInt(1));
                inventory.setGuntype(rs.getString(2));
                inventory.setSkinname(rs.getString(3));
                inventory.setBelong(rs.getInt(4));
                inventory.setSelling(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    @Override
    public boolean updateSelling(int id,String status) {
        String sql = "update inventory set selling = ? where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,status);
            pstmt.setInt(2,id);
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

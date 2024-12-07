package zxr.design.jsp.pub.dao.Impl;

import zxr.design.jsp.pub.dao.IShareDao;
import zxr.design.jsp.pub.pojo.Share;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShareDaoImpl implements IShareDao {
    //单例模式三件套
    private static ShareDaoImpl instance;//静态对象
    private Connection conn;

    private ShareDaoImpl() {//私有构造函数
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

    static public ShareDaoImpl getInstance() {//共有静态方法获取实例
        if(instance == null){
            instance = new ShareDaoImpl();
        }
        return instance;
    }
    //以上为单例模式模板


    @Override
    public List<Share> selectAll(int currentPage, int pageSize) {
        List<Share> shareList = new ArrayList<>();
        String sql = "select * from share limit ?,?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Share share = new Share();
                share.setId(rs.getInt(1));
                share.setUsername(rs.getString(2));
                share.setTime(rs.getString(3));
                share.setContent(rs.getString(4));
                shareList.add(share);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("share列表的大小"+shareList.size());
        return shareList;
    }

    @Override
    public Integer getTotalShareCount() {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from share";
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

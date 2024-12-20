package zxr.design.jsp.pub.dao.Impl;

import zxr.design.jsp.pub.dao.IUserDao;
import zxr.design.jsp.pub.pojo.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    //单例模式三件套
    private static UserDaoImpl instance;//实例
    private Connection conn;

    private UserDaoImpl() {//私有化构造函数
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

    static public UserDaoImpl getInstance() {//共有静态方法获取实例
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }
    //以上为单例模式模板

    //MD5加密
    public static String encryptMD5(String input) {
        try {
            // 创建MD5算法的MessageDigest实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将输入字符串转换为字节数组并更新到MessageDigest
            md.update(input.getBytes());

            // 计算MD5摘要
            byte[] digest = md.digest();

            // 将字节数组转换为十六进制字符串表示
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            System.out.println(hexString);
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User loginUser(User user) {//匹配登录用户
        String sql = "select * from user where username=? and password=?";
        User ansuser = new User();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,encryptMD5(user.getPassword()));
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                ansuser.setId(rs.getInt(1));
                ansuser.setUsername(rs.getString(2));
                ansuser.setPassword(rs.getString(3));
                ansuser.setAtrribute(rs.getString(4));
                ansuser.setSellstatus(rs.getString(5));
                System.out.println(ansuser.toString());
                return ansuser;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean registUser(User user) {//注册
        String sql = "insert into user(username,password) values(?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,encryptMD5(user.getPassword()));
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
    public List<User> selectAll(int currentPage, int pageSize) {//查询所有用户
        List<User> userList = new ArrayList<>();
        String sql = "select * from user limit ?,?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAtrribute(rs.getString(4));
                user.setSellstatus(rs.getString(5));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("user列表的大小"+userList.size());
        return userList;
    }

    @Override
    public Integer getTotalUserCount() {//获取总用户数量
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from user";
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
    public User selectByUserid(int id) {
        String sql = "select * from user where id = ?";
        User ansuser = new User();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                ansuser.setId(rs.getInt(1));
                ansuser.setUsername(rs.getString(2));
                ansuser.setPassword(rs.getString(3));
                ansuser.setAtrribute(rs.getString(4));
                ansuser.setSellstatus(rs.getString(5));
                System.out.println(ansuser.toString());
                return ansuser;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updateSellStatus(int id, String status) {
        String sql = "update user set sellstatus = ? where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,status);
            pstmt.setInt(2,id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {//检查受影响的条数
                System.out.println("执行成功");
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}

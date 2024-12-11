package zxr.design.jsp.pub.dao.Impl;

import zxr.design.jsp.pub.dao.IEvaluationDao;
import zxr.design.jsp.pub.pojo.Evaluation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvaluationDaoImpl implements IEvaluationDao {
    //单例模式三件套
    private static EvaluationDaoImpl instance;//静态对象
    private Connection conn;

    private EvaluationDaoImpl() {//私有构造函数
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

    static public EvaluationDaoImpl getInstance() {//共有静态方法获取实例
        if(instance == null){
            instance = new EvaluationDaoImpl();
        }
        return instance;
    }
    //以上为单例模式模板


    @Override
    public List<Evaluation> selectAll(int currentPage, int pageSize) {
        List<Evaluation> evaluationList = new ArrayList<>();
        String sql = "select * from evaluation limit ?,?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Evaluation evaluation = new Evaluation();
                evaluation.setId(rs.getInt(1));
                evaluation.setSellid(rs.getInt(2));
                evaluation.setUserid(rs.getInt(3));
                evaluation.setContent(rs.getString(4));
                evaluationList.add(evaluation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("evaluation列表的大小"+ evaluationList.size());
        return evaluationList;
    }

    @Override
    public Integer getTotalShareCount() {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from evaluation";
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
    public Boolean deleteFromId(int id) {
        String sql = "delete from  evaluation where id = ?";
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
    public Boolean insertNew(Evaluation evaluation) {
        String sql = "insert into evaluation(sellid,userid,content) values (?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,evaluation.getSellid());
            pstmt.setInt(2,evaluation.getUserid());
            pstmt.setString(3,evaluation.getContent());
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

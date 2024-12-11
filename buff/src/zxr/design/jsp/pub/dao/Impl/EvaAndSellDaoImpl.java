package zxr.design.jsp.pub.dao.Impl;

import zxr.design.jsp.pub.dao.IEvaAndSellDao;
import zxr.design.jsp.pub.pojo.Evaluation;
import zxr.design.jsp.pub.pojo.EvaluationAndSell;
import zxr.design.jsp.pub.pojo.Sell;

import java.sql.*;

public class EvaAndSellDaoImpl implements IEvaAndSellDao {
    //单例模式三件套
    private static  EvaAndSellDaoImpl instance;//静态对象
    private Connection conn;

    private EvaAndSellDaoImpl() {//私有构造函数
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

    static public EvaAndSellDaoImpl getInstance() {//共有静态方法获取实例
        if(instance == null){
            instance = new EvaAndSellDaoImpl();
        }
        return instance;
    }
    //以上为单例模式模板
    @Override
    public EvaluationAndSell selectInfo(Evaluation evaluation) {
        String sql = "select evaluation.id , sell.id , sell.come , sell.arrive , guntype , skinname , money , content " +
                "from evaluation join sell on evaluation.sellid = sell.id where evaluation.id = ?";
        PreparedStatement pstmt;
        ResultSet rs;
        EvaluationAndSell evaluationAndSell = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, evaluation.getId());
            rs = pstmt.executeQuery();
            if(rs.next()){
                evaluationAndSell = new EvaluationAndSell();
                Evaluation evaluation1 = new Evaluation();
                Sell sell = new Sell();
                evaluation1.setId(rs.getInt(1));
                sell.setId(rs.getInt(2));
                sell.setFrom(rs.getInt(3));
                sell.setTo(rs.getInt(4));
                sell.setGuntype(rs.getString(5));
                sell.setSkinname(rs.getString(6));
                sell.setMoney(rs.getInt(7));
                evaluation1.setContent(rs.getString(8));
                evaluation1.setUserid(evaluation.getUserid());

                evaluationAndSell.setEvaluation(evaluation1);
                evaluationAndSell.setSell(sell);
                System.out.println(evaluation1);
                System.out.println(sell);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return evaluationAndSell;
    }


}

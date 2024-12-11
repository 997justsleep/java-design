package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Evaluation;
import zxr.design.jsp.pub.pojo.EvaluationAndSell;

public interface IEvaAndSellDao {
    EvaluationAndSell selectInfo(Evaluation evaluation);
}

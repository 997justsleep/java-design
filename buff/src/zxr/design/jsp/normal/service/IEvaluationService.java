package zxr.design.jsp.normal.service;

import zxr.design.jsp.pub.pojo.Evaluation;
import zxr.design.jsp.pub.pojo.EvaluationAndSell;

public interface IEvaluationService {
    EvaluationAndSell getinfo(Evaluation evaluation);
    boolean deleteEva(int id);
    boolean addEva(Evaluation evaluation);
}

package zxr.design.jsp.pub.dao;

import zxr.design.jsp.pub.pojo.Evaluation;

import java.util.List;

public interface IEvaluationDao {
    List<Evaluation> selectAll(int currentPage, int pageSize);
    Integer getTotalShareCount();
    Boolean deleteFromId(int id);
    Boolean insertNew(Evaluation evaluation);
}

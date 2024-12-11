package zxr.design.jsp.normal.service.impl;

import zxr.design.jsp.normal.service.IEvaluationService;

import zxr.design.jsp.pub.dao.Impl.EvaAndSellDaoImpl;
import zxr.design.jsp.pub.dao.Impl.EvaluationDaoImpl;
import zxr.design.jsp.pub.pojo.Evaluation;
import zxr.design.jsp.pub.pojo.EvaluationAndSell;

public class EvaluationServiceImpl implements IEvaluationService {
    @Override
    public EvaluationAndSell getinfo(Evaluation evaluation) {
        return EvaAndSellDaoImpl.getInstance().selectInfo(evaluation);
    }

    @Override
    public boolean deleteEva(int id) {
        return EvaluationDaoImpl.getInstance().deleteFromId(id);
    }

    @Override
    public boolean addEva(Evaluation evaluation) {
        return EvaluationDaoImpl.getInstance().insertNew(evaluation);
    }
}
package zxr.design.jsp.pub.pojo;

public class EvaluationAndSell {
    private Evaluation evaluation;
    private Sell sell;

    public EvaluationAndSell() {
    }

    public EvaluationAndSell(Evaluation evaluation, Sell sell) {
        this.evaluation = evaluation;
        this.sell = sell;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "EvaluationAndSell{" +
                "evaluation=" + evaluation +
                ", sell=" + sell +
                '}';
    }
}

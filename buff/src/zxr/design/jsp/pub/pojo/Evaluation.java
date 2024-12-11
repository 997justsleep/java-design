package zxr.design.jsp.pub.pojo;

public class Evaluation {
    private Integer id;
    private Integer userid;
    private Integer sellid;
    private String content;

    public Evaluation() {
    }

    public Evaluation(Integer id, Integer userid, Integer sellid, String content) {
        this.id = id;
        this.userid = userid;
        this.sellid = sellid;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSellid() {
        return sellid;
    }

    public void setSellid(Integer sellid) {
        this.sellid = sellid;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", userid=" + userid +
                ", sellid=" + sellid +
                ", content='" + content + '\'' +
                '}';
    }
}

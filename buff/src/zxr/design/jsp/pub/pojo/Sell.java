package zxr.design.jsp.pub.pojo;

public class Sell {
    Integer id;
    Integer from;
    Integer to;
    String guntype;
    String skinname;
    Integer money;

    public Sell() {
    }

    public Sell(int from, int to, String guntype, String skinname, int money) {
        this.from = from;
        this.to = to;
        this.guntype = guntype;
        this.skinname = skinname;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getGuntype() {
        return guntype;
    }

    public void setGuntype(String guntype) {
        this.guntype = guntype;
    }

    public String getSkinname() {
        return skinname;
    }

    public void setSkinname(String skinname) {
        this.skinname = skinname;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "from=" + from +
                ", to=" + to +
                ", guntype='" + guntype + '\'' +
                ", skinname='" + skinname + '\'' +
                ", money=" + money +
                '}';
    }
}

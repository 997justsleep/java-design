package zxr.design.jsp.pub.pojo;

public class Sell {
    Integer from;
    Integer to;
    String guntype;
    String skinname;
    Double money;

    public Sell() {
    }

    public Sell(int from, int to, String guntype, String skinname, double money) {
        this.from = from;
        this.to = to;
        this.guntype = guntype;
        this.skinname = skinname;
        this.money = money;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
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

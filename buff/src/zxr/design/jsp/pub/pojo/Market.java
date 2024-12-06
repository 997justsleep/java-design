package zxr.design.jsp.pub.pojo;

public class Market {
    Integer from;
    String guntype;
    String skinname;
    Double price;

    public Market() {
    }

    public Market(int from, String guntype, String skinname, double price) {
        this.from = from;
        this.guntype = guntype;
        this.skinname = skinname;
        this.price = price;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Market{" +
                "from=" + from +
                ", guntype='" + guntype + '\'' +
                ", skinname='" + skinname + '\'' +
                ", price=" + price +
                '}';
    }
}

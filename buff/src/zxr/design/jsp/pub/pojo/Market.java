package zxr.design.jsp.pub.pojo;

public class Market {
    Integer id;
    Integer from;
    String guntype;
    String skinname;
    Integer price;

    public Market() {
    }

    public Market(int from, String guntype, String skinname, int price) {
        this.from = from;
        this.guntype = guntype;
        this.skinname = skinname;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", from=" + from +
                ", guntype='" + guntype + '\'' +
                ", skinname='" + skinname + '\'' +
                ", price=" + price +
                '}';
    }
}

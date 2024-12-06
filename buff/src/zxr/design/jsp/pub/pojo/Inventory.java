package zxr.design.jsp.pub.pojo;

public class Inventory {
    String guntype;
    String skinname;
    Integer belong;

    public Inventory() {
    }

    public Inventory(String guntype, String skinname, int belong) {
        this.guntype = guntype;
        this.skinname = skinname;
        this.belong = belong;
    }

    public String getSkinname() {
        return skinname;
    }

    public void setSkinname(String skinname) {
        this.skinname = skinname;
    }

    public int getBelong() {
        return belong;
    }

    public void setBelong(int belong) {
        this.belong = belong;
    }

    public String getGuntype() {
        return guntype;
    }

    public void setGuntype(String guntype) {
        this.guntype = guntype;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "guntype='" + guntype + '\'' +
                ", skinname='" + skinname + '\'' +
                ", belong=" + belong +
                '}';
    }
}

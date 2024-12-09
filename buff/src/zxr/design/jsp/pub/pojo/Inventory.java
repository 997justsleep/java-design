package zxr.design.jsp.pub.pojo;

public class Inventory {
    Integer id;
    String guntype;
    String skinname;
    Integer belong;
    String selling;

    public Inventory() {
    }

    public Inventory(String guntype, String skinname, int belong) {
        this.guntype = guntype;
        this.skinname = skinname;
        this.belong = belong;
    }

    public Inventory(String guntype, String skinname, Integer belong, String selling) {
        this.guntype = guntype;
        this.skinname = skinname;
        this.belong = belong;
        this.selling = selling;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkinname() {
        return skinname;
    }

    public void setSkinname(String skinname) {
        this.skinname = skinname;
    }

    public String getGuntype() {
        return guntype;
    }

    public void setGuntype(String guntype) {
        this.guntype = guntype;
    }

    public Integer getBelong() {
        return belong;
    }

    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", guntype='" + guntype + '\'' +
                ", skinname='" + skinname + '\'' +
                ", belong=" + belong +
                ", selling='" + selling + '\'' +
                '}';
    }
}

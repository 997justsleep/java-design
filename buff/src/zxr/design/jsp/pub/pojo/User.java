package zxr.design.jsp.pub.pojo;

public class User {
    Integer id;
    String username;
    String password;
    String atrribute;
    String sellstatus;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAtrribute() {
        return atrribute;
    }

    public void setAtrribute(String atrribute) {
        this.atrribute = atrribute;
    }

    public String getSellstatus() {
        return sellstatus;
    }

    public void setSellstatus(String sellstatus) {
        this.sellstatus = sellstatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", atrribute='" + atrribute + '\'' +
                ", sellstatus='" + sellstatus + '\'' +
                '}';
    }
}

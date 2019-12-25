package com.zelin.pojo;

public class UsersCustom extends User {
    private int id;
    private String cno;
    private String userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "UsersCustom{" +
                super.toString()+
                "id=" + id +
                ", cno='" + cno + '\'' +
                ", uid='" + userid + '\'' +
                '}';
    }
}

package com.zelin.pojo;

public class IdCard {
    private int id;
    private String cno;
    private String uid;

    private User user;
    public IdCard() {
    }

    public IdCard(int id, String cno, String uid) {
        this.id = id;
        this.cno = cno;
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", cno='" + cno + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}

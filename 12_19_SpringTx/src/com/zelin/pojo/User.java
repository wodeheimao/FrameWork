package com.zelin.pojo;

public class User {
    private int id;
    private String uname;
    private double banlance;

    public User() {
    }

    public User(int id, String uname, double banlance) {
        this.id = id;
        this.uname = uname;
        this.banlance = banlance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", banlance=" + banlance +
                '}';
    }
}

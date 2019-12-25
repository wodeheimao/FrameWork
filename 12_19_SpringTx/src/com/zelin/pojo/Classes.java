package com.zelin.pojo;

public class Classes {
    private int cid;
    private String cname;

    public Classes() {
    }

    public Classes(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}

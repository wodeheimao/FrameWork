package com.zelin.pojo;

public class StudentVo {
    private String sname;
    private String addr;
    private int sid;
    private int[] sids;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int[] getSids() {
        return sids;
    }

    public void setSids(int[] sids) {
        this.sids = sids;
    }
}

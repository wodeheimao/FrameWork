package com.zelin.pojo;

import java.util.List;

public class Classes {
    private int cid;
    private String cname;

    private List<Student> studentList;
    public Classes() {
    }

    public Classes(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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

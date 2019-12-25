package com.zelin.pojo;

public class Student {
    private int sid;
    private String sname;
    private String sex;
    private String age;
    private String addr;
    private String cid;
    private String cname;

    public Student() {
    }

    public Student(int sid, String sname, String sex, String age, String addr, String cid, String cname) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
        this.cid = cid;
        this.cname = cname;
    }

    public Student(String sname, String sex, String age, String addr, String cid) {
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
        this.cid = cid;
    }

    public Student(int sid, String sname, String sex, String age, String addr, String cid) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
        this.cid = cid;
    }


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", addr='" + addr + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}

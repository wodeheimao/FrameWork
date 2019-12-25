package com.bm.web.pojo;

public class Book {
    private String bno;
    private String bname;
    private String author;
    private String publisher;
    private String discount;
    private String yprice;
    private String zprice;

    public Book() {
    }

    public Book(String bno, String bname, String author, String publisher, String discount, String yprice, String zprice) {
        this.bno = bno;
        this.bname = bname;
        this.author = author;
        this.publisher = publisher;
        this.discount = discount;
        this.yprice = yprice;
        this.zprice = zprice;
    }

    public Book(String bno, String bname, String author, String publisger, String yprice) {
        this.bno = bno;
        this.bname = bname;
        this.author = author;
        this.yprice = yprice;
    }


    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYprice() {
        return yprice;
    }

    public void setYprice(String yprice) {
        this.yprice = yprice;
    }

    public String getZprice() {
        return zprice;
    }

    public void setZprice(String zprice) {
        this.zprice = zprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bno='" + bno + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yprice='" + yprice + '\'' +
                ", zprice='" + zprice + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}

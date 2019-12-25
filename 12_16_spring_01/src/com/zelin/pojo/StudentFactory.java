package com.zelin.pojo;

public class StudentFactory {
    public static Student getStudent(){
        return new Student();
    }

    public Student getStudent2(){
        return new Student();
    }
}

package com.zelin.pojo;
import java.util.Arrays;
import	java.util.Map;

import java.util.List;

public class CollectionBean {
    private String[] names;
    private List<Student> syudents;
    private Map <Integer,Book> maps;

    public CollectionBean() {
    }

    public CollectionBean(String[] names, List<Student> syudents, Map<Integer, Book> maps) {
        this.names = names;
        this.syudents = syudents;
        this.maps = maps;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List<Student> getSyudents() {
        return syudents;
    }

    public void setSyudents(List<Student> syudents) {
        this.syudents = syudents;
    }

    public Map<Integer, Book> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, Book> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                " \n names=" + Arrays.toString(names) +
                ",\n syudents=" + syudents +
                ",\n maps=" + maps +
                '}';
    }
}

package com.zelin.pojo;

import java.util.List;

public class PageResult<T> {
    private Long total;         //总记录数
    private List<T> rows;       //当前结果集
    private int page;           //当前页数
    private int totalPages;    //总页数

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows, int page, int totalPages) {
        this.total = total;
        this.rows = rows;
        this.page = page;
        this.totalPages = totalPages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}

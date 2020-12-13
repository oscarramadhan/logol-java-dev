package com.logol.java.developer.Model;

public class PageSort {
    private int page = 0;
    private int size = 0;
    private String sortColumn = "";
    private String sortType = "";

    public int getPage() {
        return this.page <= 0 ? 1 : this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return this.size < 0 ? 5 : this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortColumn() {
        return this.sortColumn.isEmpty() ? "createdAt" : this.sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortType() {
        return this.sortType.isEmpty() ? "desc" : this.sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}

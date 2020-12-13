package com.logol.java.developer.Model;

public class RequestUpdateNews {
    private String id;
    private String title;
    private String description;

    public RequestUpdateNews() {
    }

    public RequestUpdateNews(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
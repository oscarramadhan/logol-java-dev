package com.logol.java.developer.Model;

import java.util.Date;

public class RequestNewsByFilter extends PageSort{
    private String title = "";
    private String description = "";
    private Date createdFrom = null;
    private Date createdTo = null;

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

    public Date getCreatedFrom() {
        return this.createdFrom;
    }

    public void setCreatedFrom(Date createdFrom) {
        this.createdFrom = createdFrom;
    }

    public Date getCreatedTo() {
        return this.createdTo;
    }

    public void setCreatedTo(Date createdTo) {
        this.createdTo = createdTo;
    }
}
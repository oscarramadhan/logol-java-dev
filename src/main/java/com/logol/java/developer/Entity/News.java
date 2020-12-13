package com.logol.java.developer.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "news")
public class News {
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "varchar", length = 32, unique = true)
    private String id;

    @Column(name = "title", columnDefinition = "varchar", length = 32)
    private String title;

    @Lob
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS Z")
    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Date createdAt;

    public News () {
    }

    public News(String title, String description, Date createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
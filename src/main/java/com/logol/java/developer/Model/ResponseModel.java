package com.logol.java.developer.Model;

public class ResponseModel {
    private String code;
    private String description;
    private Object content;

    public ResponseModel() {
    }

    public ResponseModel(String code, String description, Object content) {
        this.code = code;
        this.description = description;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
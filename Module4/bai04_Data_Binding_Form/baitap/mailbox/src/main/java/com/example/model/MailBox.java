package com.example.model;

public class MailBox {
    private String languages;
    private String size;
    private boolean filter;
    private String signature;

    public MailBox() {
    }

    public MailBox(String languages, String size, boolean filter, String signature) {
        this.languages = languages;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

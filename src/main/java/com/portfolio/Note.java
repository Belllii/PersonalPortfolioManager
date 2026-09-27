package com.portfolio;

public class Note extends PortfolioEntity {

    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getCategoryType() {
        return "Note";
    }

    @Override
    public String getDisplayName() {
        return title;
    }

    @Override
    public String getDetails() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return title;
    }
}
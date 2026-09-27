package com.portfolio;

public class TaskItem extends PortfolioEntity {

    private String title;
    private boolean completed;
    private String priority;

    public TaskItem(String title, boolean completed) {
        this(title, completed, "Medium");
    }

    public TaskItem(String title, boolean completed, String priority) {
        this.title = title;
        this.completed = completed;
        this.priority = (priority != null && !priority.isBlank()) ? priority : "Medium";
    }

    @Override
    public String getCategoryType() {
        return "Task";
    }

    @Override
    public String getDisplayName() {
        String icon = completed ? "✅ " : "⏳ ";
        return icon + "[" + priority + "] " + title;
    }

    @Override
    public String getDetails() {
        return "Priority: " + priority + " | Status: " + (completed ? "Completed" : "Pending");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
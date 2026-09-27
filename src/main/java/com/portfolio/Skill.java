package com.portfolio;

public class Skill extends PortfolioEntity {

    private String name;
    private String category;
    private int level;

    public Skill(String name, String category, int level) {
        this.name = name;
        this.category = category;
        this.level = level;
    }

    @Override
    public String getCategoryType() {
        return "Skill";
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String getDetails() {
        return category + " (" + level + "%)";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return name + " (" + level + "%)";
    }
}
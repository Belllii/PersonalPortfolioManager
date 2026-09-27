package com.portfolio;

public class Project extends PortfolioEntity {

    private String title;
    private String description;
    private String technology;
    private String githubLink;

    public Project(
            String title,
            String description,
            String technology,
            String githubLink) {
        this.title = title;
        this.description = description;
        this.technology = technology;
        this.githubLink = githubLink;
    }

    @Override
    public String getCategoryType() {
        return "Project";
    }

    @Override
    public String getDisplayName() {
        return title;
    }

    @Override
    public String getDetails() {
        return technology + " | " + description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }
}
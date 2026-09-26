package com.portfolio;

public class Project {

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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnology() {
        return technology;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }
}
package com.portfolio;
public class Project {
    private int id;
    private String title;
    private String description;
    private String technology;
    private String githubLink;
    // CONSTRUCTOR
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
    // ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    // TITLE
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    // DESCRIPTION
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    // TECHNOLOGY
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    // GITHUB LINK

    public String getGithubLink() {
        return githubLink;
    }
    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }
}
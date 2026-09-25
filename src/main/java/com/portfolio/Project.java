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
}
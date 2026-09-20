package portfolio;

public class Project {

    private String title;
    private String description;
    private String githubLink;

    public Project(String title, String description, String githubLink) {
        this.title = title;
        this.description = description;
        this.githubLink = githubLink;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGithubLink() {
        return githubLink;
    }

    @Override
    public String toString() {
        return title;
    }
}
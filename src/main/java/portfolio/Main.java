package portfolio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    // Store all projects
    private ArrayList<Project> projects = new ArrayList<>();

    // Display projects
    private ListView<String> projectList = new ListView<>();

    @Override
    public void start(Stage stage) {

        Label heading = new Label("Personal Portfolio Manager");

        // Project title
        TextField titleField = new TextField();
        titleField.setPromptText("Project Title");

        // Project description
        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Project Description");

        // GitHub link
        TextField githubField = new TextField();
        githubField.setPromptText("GitHub Repository Link");

        // Add button
        Button addButton = new Button("Add Project");

        Label message = new Label();

        // Add project
        addButton.setOnAction(e -> {

            String title = titleField.getText();
            String description = descriptionField.getText();
            String github = githubField.getText();

            if (title.isEmpty() ||
                    description.isEmpty() ||
                    github.isEmpty()) {

                message.setText("Please fill in all fields.");

            } else {

                Project project =
                        new Project(title, description, github);

                // Add project to ArrayList
                projects.add(project);

                // Add project title to dashboard
                projectList.getItems().add(project.getTitle());

                message.setText("Project added successfully.");

                // Clear input fields
                titleField.clear();
                descriptionField.clear();
                githubField.clear();
            }
        });

        Label dashboardLabel = new Label("Project Dashboard");

        VBox layout = new VBox(10);

        layout.getChildren().addAll(
                heading,
                titleField,
                descriptionField,
                githubField,
                addButton,
                message,
                dashboardLabel,
                projectList
        );

        Scene scene = new Scene(layout, 600, 600);

        stage.setTitle("Personal Portfolio Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
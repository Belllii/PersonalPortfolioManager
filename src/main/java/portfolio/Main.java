package portfolio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private ArrayList<Project> projects = new ArrayList<>();

    private ListView<String> projectList = new ListView<>();

    @Override
    public void start(Stage stage) {

        Label heading = new Label("Personal Portfolio Manager");

        TextField titleField = new TextField();
        titleField.setPromptText("Project Title");

        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Project Description");

        TextField githubField = new TextField();
        githubField.setPromptText("GitHub Repository Link");

        Button addButton = new Button("Add Project");

        // NEW FEATURE: Delete button
        Button deleteButton = new Button("Delete Selected Project");

        Label message = new Label();

        // ADD PROJECT
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

                projects.add(project);

                projectList.getItems().add(project.getTitle());

                message.setText("Project added successfully.");

                titleField.clear();
                descriptionField.clear();
                githubField.clear();
            }
        });

        // DELETE PROJECT
        deleteButton.setOnAction(e -> {

            int selectedIndex =
                    projectList.getSelectionModel().getSelectedIndex();

            if (selectedIndex == -1) {

                message.setText("Please select a project to delete.");

            } else {

                // Remove from ArrayList
                projects.remove(selectedIndex);

                // Remove from ListView
                projectList.getItems().remove(selectedIndex);

                message.setText("Project deleted successfully.");
            }
        });

        Label dashboardLabel =
                new Label("Project Dashboard");

        VBox layout = new VBox(10);

        layout.getChildren().addAll(
                heading,
                titleField,
                descriptionField,
                githubField,
                addButton,
                deleteButton,
                message,
                dashboardLabel,
                projectList
        );

        Scene scene =
                new Scene(layout, 600, 600);

        stage.setTitle("Personal Portfolio Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
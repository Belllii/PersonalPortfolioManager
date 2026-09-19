package portfolio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label heading = new Label("Add New Project");

        TextField titleField = new TextField();
        titleField.setPromptText("Project Title");

        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Project Description");

        TextField githubField = new TextField();
        githubField.setPromptText("GitHub Repository Link");

        Button addButton = new Button("Add Project");

        Label result = new Label();

        addButton.setOnAction(e -> {

            String title = titleField.getText();
            String description = descriptionField.getText();
            String github = githubField.getText();

            if (title.isEmpty() || description.isEmpty() || github.isEmpty()) {
                result.setText("Please fill in all fields.");
            } else {
                result.setText("Project added: " + title);

                titleField.clear();
                descriptionField.clear();
                githubField.clear();
            }
        });

        VBox layout = new VBox(10);

        layout.getChildren().addAll(
                heading,
                titleField,
                descriptionField,
                githubField,
                addButton,
                result
        );

        Scene scene = new Scene(layout, 600, 500);

        stage.setTitle("Personal Portfolio Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
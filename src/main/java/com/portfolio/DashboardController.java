package com.portfolio;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardController {

    @FXML
    private VBox sidebar;

    @FXML
    private VBox content;

    @FXML
    private Label logo;

    @FXML
    private Label menuTitle;

    @FXML
    private Label pageTitle;

    @FXML
    private Label welcome;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button projectsButton;

    @FXML
    private Button skillsButton;

    @FXML
    private Button notesButton;

    @FXML
    private Button tasksButton;

    @FXML
    private Button apiButton;

    @FXML
    private Button settingsButton;

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField technologyField;

    @FXML
    private TextField githubField;

    @FXML
    private Button addProjectButton;

    @FXML
    private Label projectMessage;


    @FXML
    public void initialize() {

        // Logo
        logo.setFont(
                Font.font("Arial", FontWeight.BOLD, 25)
        );

        logo.setTextFill(
                Color.web("#38BDF8")
        );


        // Menu title
        menuTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 11)
        );

        menuTitle.setTextFill(
                Color.web("#94A3B8")
        );


        // Sidebar buttons
        setupButton(dashboardButton);
        setupButton(projectsButton);
        setupButton(skillsButton);
        setupButton(notesButton);
        setupButton(tasksButton);
        setupButton(apiButton);
        setupButton(settingsButton);


        // Page title
        pageTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 30)
        );

        pageTitle.setTextFill(Color.WHITE);


        // Welcome text
        welcome.setFont(
                Font.font("Arial", 16)
        );

        welcome.setTextFill(
                Color.web("#CBD5E1")
        );


        // Form button
        addProjectButton.setPrefWidth(150);
        addProjectButton.setPrefHeight(40);

        addProjectButton.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        addProjectButton.setTextFill(Color.WHITE);

        addProjectButton.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#2563EB"),
                                new CornerRadii(8),
                                Insets.EMPTY
                        )
                )
        );


        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );
    }


    private void setupButton(Button button) {

        button.setPrefWidth(180);
        button.setPrefHeight(42);

        button.setAlignment(Pos.CENTER_LEFT);

        button.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        button.setTextFill(Color.WHITE);

        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#111827"),
                                new CornerRadii(8),
                                Insets.EMPTY
                        )
                )
        );
    }


    // ==========================================
    // ADD PROJECT
    // ==========================================

    @FXML
    private void addProject() {

        String title = titleField.getText();
        String description = descriptionField.getText();
        String technology = technologyField.getText();
        String github = githubField.getText();


        if (title.isEmpty() ||
                description.isEmpty() ||
                technology.isEmpty()) {

            projectMessage.setText(
                    "Please fill in all required fields."
            );

            projectMessage.setTextFill(
                    Color.web("#F87171")
            );

            return;
        }


        Project project = new Project(
                title,
                description,
                technology,
                github
        );


        projectMessage.setText(
                "Project added: " + project.getTitle()
        );

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );


        // Clear form
        titleField.clear();
        descriptionField.clear();
        technologyField.clear();
        githubField.clear();
    }


    // ==========================================
    // NAVIGATION
    // ==========================================

    @FXML
    private void showDashboard() {

        pageTitle.setText("Dashboard");

        welcome.setText(
                "Welcome back! Here's an overview of your portfolio."
        );
    }


    @FXML
    private void showProjects() {

        pageTitle.setText("Projects");

        welcome.setText(
                "Add a new project to your portfolio."
        );
    }


    @FXML
    private void showSkills() {

        pageTitle.setText("Skills");

        welcome.setText(
                "Track your technical skills."
        );
    }


    @FXML
    private void showNotes() {

        pageTitle.setText("Notes");

        welcome.setText(
                "Keep your important development notes."
        );
    }


    @FXML
    private void showTasks() {

        pageTitle.setText("Tasks");

        welcome.setText(
                "Manage your development tasks."
        );
    }


    @FXML
    private void showApi() {

        pageTitle.setText("API Data");

        welcome.setText(
                "External data and API information."
        );
    }


    @FXML
    private void showSettings() {

        pageTitle.setText("Settings");

        welcome.setText(
                "Application settings."
        );
    }
}
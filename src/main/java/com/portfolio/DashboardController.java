package com.portfolio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label pageDescription;

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


        // Main content
        pageTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 30)
        );

        pageTitle.setTextFill(Color.WHITE);


        welcome.setFont(
                Font.font("Arial", 16)
        );

        welcome.setTextFill(
                Color.web("#CBD5E1")
        );


        pageDescription.setFont(
                Font.font("Arial", 14)
        );

        pageDescription.setTextFill(
                Color.web("#94A3B8")
        );
    }


    private void setupButton(Button button) {

        button.setPrefWidth(180);
        button.setPrefHeight(42);

        button.setAlignment(
                javafx.geometry.Pos.CENTER_LEFT
        );

        button.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        button.setTextFill(Color.WHITE);

        button.setBackground(
                new javafx.scene.layout.Background(
                        new javafx.scene.layout.BackgroundFill(
                                Color.web("#111827"),
                                new javafx.scene.layout.CornerRadii(8),
                                javafx.geometry.Insets.EMPTY
                        )
                )
        );
    }


    // ==========================
    // NAVIGATION EVENTS
    // ==========================

    @FXML
    private void showDashboard() {

        pageTitle.setText("Dashboard");

        welcome.setText(
                "Welcome back! Here's an overview of your portfolio."
        );

        pageDescription.setText(
                "Manage your projects, skills, notes and tasks from one place."
        );
    }


    @FXML
    private void showProjects() {

        pageTitle.setText("Projects");

        welcome.setText(
                "Manage your coding projects."
        );

        pageDescription.setText(
                "Add, edit and organize your portfolio projects."
        );
    }


    @FXML
    private void showSkills() {

        pageTitle.setText("Skills");

        welcome.setText(
                "Track your technical skills."
        );

        pageDescription.setText(
                "Organize programming languages, tools and technologies."
        );
    }


    @FXML
    private void showNotes() {

        pageTitle.setText("Notes");

        welcome.setText(
                "Keep your important development notes."
        );

        pageDescription.setText(
                "Store ideas, learning notes and useful information."
        );
    }


    @FXML
    private void showTasks() {

        pageTitle.setText("Tasks");

        welcome.setText(
                "Manage your development tasks."
        );

        pageDescription.setText(
                "Keep track of things you need to complete."
        );
    }


    @FXML
    private void showApi() {

        pageTitle.setText("API Data");

        welcome.setText(
                "External data and API information."
        );

        pageDescription.setText(
                "This section will later connect to a JSON/API service."
        );
    }


    @FXML
    private void showSettings() {

        pageTitle.setText("Settings");

        welcome.setText(
                "Application settings."
        );

        pageDescription.setText(
                "Customize your DevFolio application."
        );
    }
}
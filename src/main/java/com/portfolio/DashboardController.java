package com.portfolio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardController {

    // ==========================================
    // SIDEBAR
    // ==========================================

    @FXML
    private VBox sidebar;

    @FXML
    private VBox content;

    @FXML
    private Label logo;

    @FXML
    private Label menuTitle;

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


    // ==========================================
    // PAGE HEADER
    // ==========================================

    @FXML
    private Label pageTitle;

    @FXML
    private Label welcome;


    // ==========================================
    // PROJECT FORM
    // ==========================================

    @FXML
    private Label projectTitleLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label technologyLabel;

    @FXML
    private Label githubLabel;

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
    private Button updateProjectButton;

    @FXML
    private Button deleteProjectButton;

    @FXML
    private Label projectMessage;


    // ==========================================
    // PROJECT TABLE
    // ==========================================

    @FXML
    private Label myProjectsLabel;

    @FXML
    private TableView<Project> projectTable;

    @FXML
    private TableColumn<Project, String> titleColumn;

    @FXML
    private TableColumn<Project, String> technologyColumn;

    @FXML
    private TableColumn<Project, String> githubColumn;


    // ==========================================
    // PROJECT DETAILS
    // ==========================================

    @FXML
    private Label detailTitle;

    @FXML
    private Label detailTechnology;

    @FXML
    private Label detailDescription;

    @FXML
    private Label detailGithub;


    // ==========================================
    // PROJECT LIST
    // ==========================================

    private ObservableList<Project> projectList =
            FXCollections.observableArrayList();


    // ==========================================
    // INITIALIZE
    // ==========================================

    @FXML
    public void initialize() {

        // ------------------------------------------
        // Background colors
        // ------------------------------------------

        sidebar.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#020617"),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );


        content.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#0F172A"),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );


        // ------------------------------------------
        // Logo
        // ------------------------------------------

        logo.setFont(
                Font.font("Arial", FontWeight.BOLD, 25)
        );

        logo.setTextFill(
                Color.web("#38BDF8")
        );


        // ------------------------------------------
        // Menu title
        // ------------------------------------------

        menuTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 11)
        );

        menuTitle.setTextFill(
                Color.web("#94A3B8")
        );


        // ------------------------------------------
        // Sidebar buttons
        // ------------------------------------------

        setupButton(dashboardButton);
        setupButton(projectsButton);
        setupButton(skillsButton);
        setupButton(notesButton);
        setupButton(tasksButton);
        setupButton(apiButton);
        setupButton(settingsButton);


        // ------------------------------------------
        // Page title
        // ------------------------------------------

        pageTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 30)
        );

        pageTitle.setTextFill(
                Color.WHITE
        );


        // ------------------------------------------
        // Welcome text
        // ------------------------------------------

        welcome.setFont(
                Font.font("Arial", 16)
        );

        welcome.setTextFill(
                Color.web("#CBD5E1")
        );


        // ------------------------------------------
        // Form labels
        // ------------------------------------------

        setupFormLabel(projectTitleLabel);
        setupFormLabel(descriptionLabel);
        setupFormLabel(technologyLabel);
        setupFormLabel(githubLabel);


        // ------------------------------------------
        // My Projects label
        // ------------------------------------------

        myProjectsLabel.setFont(
                Font.font("Arial", FontWeight.BOLD, 18)
        );

        myProjectsLabel.setTextFill(
                Color.WHITE
        );


        // ------------------------------------------
        // Text fields
        // ------------------------------------------

        setupTextField(titleField);
        setupTextField(technologyField);
        setupTextField(githubField);

        setupTextArea(descriptionField);


        // ------------------------------------------
        // Add button
        // ------------------------------------------

        setupActionButton(addProjectButton);


        // ------------------------------------------
        // Update button
        // ------------------------------------------

        setupActionButton(updateProjectButton);


        // ------------------------------------------
        // Delete button
        // ------------------------------------------

        deleteProjectButton.setPrefWidth(150);
        deleteProjectButton.setPrefHeight(40);

        deleteProjectButton.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        deleteProjectButton.setTextFill(
                Color.WHITE
        );

        deleteProjectButton.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#DC2626"),
                                new CornerRadii(8),
                                Insets.EMPTY
                        )
                )
        );


        // ------------------------------------------
        // Project message
        // ------------------------------------------

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );


        // ==========================================
        // TABLEVIEW
        // ==========================================

        titleColumn.setCellValueFactory(
                new PropertyValueFactory<>("title")
        );

        technologyColumn.setCellValueFactory(
                new PropertyValueFactory<>("technology")
        );

        githubColumn.setCellValueFactory(
                new PropertyValueFactory<>("githubLink")
        );

        projectTable.setItems(projectList);


        // ==========================================
        // PROJECT SELECTION
        // ==========================================

        projectTable.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldProject, selectedProject) -> {

                            if (selectedProject != null) {

                                // Show details

                                detailTitle.setText(
                                        "Title: "
                                                + selectedProject.getTitle()
                                );

                                detailTechnology.setText(
                                        "Technology: "
                                                + selectedProject.getTechnology()
                                );

                                detailDescription.setText(
                                        "Description: "
                                                + selectedProject.getDescription()
                                );

                                detailGithub.setText(
                                        "GitHub: "
                                                + selectedProject.getGithubLink()
                                );


                                // Load data into form

                                titleField.setText(
                                        selectedProject.getTitle()
                                );

                                descriptionField.setText(
                                        selectedProject.getDescription()
                                );

                                technologyField.setText(
                                        selectedProject.getTechnology()
                                );

                                githubField.setText(
                                        selectedProject.getGithubLink()
                                );
                            }
                        }
                );
    }


    // ==========================================
    // FORM LABEL STYLE
    // ==========================================

    private void setupFormLabel(Label label) {

        label.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        label.setTextFill(
                Color.web("#E2E8F0")
        );
    }


    // ==========================================
    // TEXT FIELD STYLE
    // ==========================================

    private void setupTextField(TextField field) {

        field.setPrefHeight(38);

        field.setFont(
                Font.font("Arial", 14)
        );

        field.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(7),
                                Insets.EMPTY
                        )
                )
        );
    }

    // ==========================================
    // TEXT AREA STYLE
    // ==========================================

    private void setupTextArea(TextArea area) {

        area.setFont(
                Font.font("Arial", 14)
        );

        area.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(7),
                                Insets.EMPTY
                        )
                )
        );
    }


    // ==========================================
    // SIDEBAR BUTTON STYLE
    // ==========================================

    private void setupButton(Button button) {

        button.setPrefWidth(180);

        button.setPrefHeight(42);

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        button.setTextFill(
                Color.WHITE
        );

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
    // ACTION BUTTON STYLE
    // ==========================================

    private void setupActionButton(Button button) {

        button.setPrefWidth(150);

        button.setPrefHeight(40);

        button.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        button.setTextFill(
                Color.WHITE
        );

        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#2563EB"),
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

        String title =
                titleField.getText().trim();

        String description =
                descriptionField.getText().trim();

        String technology =
                technologyField.getText().trim();

        String github =
                githubField.getText().trim();


        if (title.isEmpty()
                || description.isEmpty()
                || technology.isEmpty()) {

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


        projectList.add(project);


        projectMessage.setText(
                "Project added: " + project.getTitle()
        );

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );


        clearForm();
    }


    // ==========================================
    // UPDATE PROJECT
    // ==========================================

    @FXML
    private void updateProject() {

        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedProject == null) {

            projectMessage.setText(
                    "Please select a project first."
            );

            projectMessage.setTextFill(
                    Color.web("#F87171")
            );

            return;
        }


        String title =
                titleField.getText().trim();

        String description =
                descriptionField.getText().trim();

        String technology =
                technologyField.getText().trim();

        String github =
                githubField.getText().trim();


        if (title.isEmpty()
                || description.isEmpty()
                || technology.isEmpty()) {

            projectMessage.setText(
                    "Please fill in all required fields."
            );

            projectMessage.setTextFill(
                    Color.web("#F87171")
            );

            return;
        }


        selectedProject.setTitle(title);

        selectedProject.setDescription(description);

        selectedProject.setTechnology(technology);

        selectedProject.setGithubLink(github);


        projectTable.refresh();


        detailTitle.setText(
                "Title: " + title
        );

        detailTechnology.setText(
                "Technology: " + technology
        );

        detailDescription.setText(
                "Description: " + description
        );

        detailGithub.setText(
                "GitHub: " + github
        );


        projectMessage.setText(
                "Project updated successfully."
        );

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );
    }


    // ==========================================
    // DELETE PROJECT
    // ==========================================

    @FXML
    private void deleteProject() {

        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedProject == null) {

            projectMessage.setText(
                    "Please select a project first."
            );

            projectMessage.setTextFill(
                    Color.web("#F87171")
            );

            return;
        }


        projectList.remove(
                selectedProject
        );


        projectMessage.setText(
                "Project deleted successfully."
        );

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );


        clearForm();


        detailTitle.setText(
                "No project selected"
        );

        detailTechnology.setText("");

        detailDescription.setText("");

        detailGithub.setText("");
    }


    // ==========================================
    // CLEAR FORM
    // ==========================================

    private void clearForm() {

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

        pageTitle.setText(
                "Dashboard"
        );

        welcome.setText(
                "Welcome back! Here's an overview of your portfolio."
        );
    }


    @FXML
    private void showProjects() {

        pageTitle.setText(
                "Projects"
        );

        welcome.setText(
                "Add, update and manage your portfolio projects."
        );
    }


    @FXML
    private void showSkills() {

        pageTitle.setText(
                "Skills"
        );

        welcome.setText(
                "Track your technical skills."
        );
    }


    @FXML
    private void showNotes() {

        pageTitle.setText(
                "Notes"
        );

        welcome.setText(
                "Keep your important development notes."
        );
    }


    @FXML
    private void showTasks() {

        pageTitle.setText(
                "Tasks"
        );

        welcome.setText(
                "Manage your development tasks."
        );
    }


    @FXML
    private void showApi() {

        pageTitle.setText(
                "API Data"
        );

        welcome.setText(
                "External data and API information."
        );
    }


    @FXML
    private void showSettings() {

        pageTitle.setText(
                "Settings"
        );

        welcome.setText(
                "Application settings."
        );
    }
}
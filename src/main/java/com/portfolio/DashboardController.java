package com.portfolio;

import com.portfolio.database.ProjectDAO;

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
    // PROJECT FORM
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
    // PROJECT TABLE
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
    // PROJECT DETAILS

    @FXML
    private Label detailTitle;

    @FXML
    private Label detailTechnology;

    @FXML
    private Label detailDescription;

    @FXML
    private Label detailGithub;

    // DATA
    private final ObservableList<Project> projectList =
            FXCollections.observableArrayList();
    private final ProjectDAO projectDAO =
            new ProjectDAO();

    // INITIALIZE
    @FXML
    public void initialize() {
        // Background
        sidebar.setBackground(
                new Background(
                        new BackgroundFill(Color.web("#020617"), CornerRadii.EMPTY, Insets.EMPTY)));
        content.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#0F172A"),
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));
        // Logo
        logo.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        25));
        logo.setTextFill(Color.web("#38BDF8"));
        // Menu title
        menuTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 11));
        menuTitle.setTextFill(Color.web("#94A3B8"));
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
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        30));
        pageTitle.setTextFill(
                Color.WHITE
        );


        // ------------------------------------------
        // Welcome
        // ------------------------------------------

        welcome.setFont(
                Font.font(
                        "Arial",
                        16
                )
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
        // My Projects
        // ------------------------------------------

        myProjectsLabel.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        18
                )
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
        // Buttons
        // ------------------------------------------

        setupActionButton(addProjectButton);

        setupActionButton(updateProjectButton);

        setupDeleteButton(deleteProjectButton);


        // ------------------------------------------
        // Message
        // ------------------------------------------

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );


        // ==========================================
        // TABLE
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


        projectTable.setItems(
                projectList
        );


        // ==========================================
        // LOAD DATABASE PROJECTS
        // ==========================================

        loadProjects();


        // ==========================================
        // TABLE SELECTION
        // ==========================================

        projectTable.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable,
                         oldProject,
                         selectedProject) -> {

                            if (selectedProject != null) {

                                showProjectDetails(
                                        selectedProject
                                );

                                loadProjectIntoForm(
                                        selectedProject
                                );
                            }
                        }
                );
    }


    // ==========================================
    // LOAD PROJECTS
    // ==========================================

    private void loadProjects() {

        projectList.clear();

        projectList.addAll(
                projectDAO.getAllProjects()
        );
    }


    // ==========================================
    // SHOW PROJECT DETAILS
    // ==========================================

    private void showProjectDetails(
            Project project) {


        detailTitle.setText(
                "Title: "
                        + project.getTitle()
        );


        detailTechnology.setText(
                "Technology: "
                        + project.getTechnology()
        );


        detailDescription.setText(
                "Description: "
                        + project.getDescription()
        );


        detailGithub.setText(
                "GitHub: "
                        + project.getGithubLink()
        );
    }


    // ==========================================
    // LOAD PROJECT INTO FORM
    // ==========================================

    private void loadProjectIntoForm(
            Project project) {


        titleField.setText(
                project.getTitle()
        );


        descriptionField.setText(
                project.getDescription()
        );


        technologyField.setText(
                project.getTechnology()
        );


        githubField.setText(
                project.getGithubLink()
        );
    }
    // ADD PROJECT
    @FXML
    private void addProject() {
        String title =
                titleField.getText().trim();
        String description =
                descriptionField
                        .getText()
                        .trim();
        String technology =
                technologyField
                        .getText()
                        .trim();
        String github =
                githubField
                        .getText()
                        .trim();
        // Validate
        if (title.isEmpty()
                || description.isEmpty()
                || technology.isEmpty()) {
            showError("Please fill in all required fields.");
            return;
        }// Create object
        Project project =
                new Project(title, description, technology, github);
        // Save to database
        projectDAO.insertProject(project);
        // Reload table
        loadProjects();
        // Message
        showSuccess("Project added successfully.");

        clearForm();
    }
    // UPDATE PROJECT
    @FXML
    private void updateProject() {
        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();
        if (selectedProject == null) {
            showError("Please select a project first.");
            return;
        }
        String title =
                titleField.getText().trim();
        String description =
                descriptionField
                        .getText()
                        .trim();
        String technology =
                technologyField
                        .getText()
                        .trim();
        String github =
                githubField
                        .getText()
                        .trim();
        // Validate
        if (title.isEmpty()
                || description.isEmpty()
                || technology.isEmpty()) {
            showError("Please fill in all required fields.");
            return;
        }
        // Update object
        selectedProject.setTitle(title);
        selectedProject.setDescription(description);
        selectedProject.setTechnology(technology);
        selectedProject.setGithubLink(
                github);
        // Update database
        projectDAO.updateProject(
                selectedProject.getId(),
                selectedProject);
        // Reload table
        loadProjects();
        showSuccess(
                "Project updated successfully.");
        clearForm();
    }// DELETE PROJECT
    @FXML
    private void deleteProject() {
        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();
        if (selectedProject == null) {
            showError("Please select a project first.");
            return;
        }
        // Delete from database
        projectDAO.deleteProject(
                selectedProject.getId());
        // Delete from table
        projectList.remove(selectedProject);
        showSuccess("Project deleted successfully.");
        clearForm();
        clearDetails();
    }
    // CLEAR FORM
    private void clearForm() {
        titleField.clear();
        descriptionField.clear();
        technologyField.clear();
        githubField.clear();
    }
    // CLEAR DETAILS
    private void clearDetails() {
        detailTitle.setText("No project selected");
        detailTechnology.setText("");
        detailDescription.setText("");
        detailGithub.setText("");
    }
    // SUCCESS MESSAGE
    private void showSuccess(
            String message) {
        projectMessage.setText(
                message);
        projectMessage.setTextFill(
                Color.web("#38BDF8"));
    }
    // ERROR MESSAGE

    private void showError(
            String message) {
        projectMessage.setText(
                message);
        projectMessage.setTextFill(
                Color.web("#F87171"));
    }
    // FORM LABEL STYLE
    private void setupFormLabel(
            Label label) {
        label.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13));
        label.setTextFill(
                Color.web("#E2E8F0"));
    }
    // TEXT FIELD STYLE
    private void setupTextField(
            TextField field) {
        field.setPrefHeight(38);
        field.setFont(
                Font.font(
                        "Arial",
                        14));
        field.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(7),
                                Insets.EMPTY)));
    }
    // TEXT AREA STYLE
    private void setupTextArea(
            TextArea area) {
        area.setFont(
                Font.font(
                        "Arial",
                        14));
        area.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(7),
                                Insets.EMPTY)));
    }
    // SIDEBAR BUTTON STYLE
    private void setupButton(
            Button button) {
        button.setPrefWidth(180);
        button.setPrefHeight(42);
        button.setAlignment(Pos.CENTER_LEFT);
        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13));

        button.setTextFill(Color.WHITE);
        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#111827"),
                                new CornerRadii(8),
                                Insets.EMPTY)));
    }
    // ACTION BUTTON STYLE
    private void setupActionButton(
            Button button) {
        button.setPrefWidth(150);
        button.setPrefHeight(40);
        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13));
        button.setTextFill(Color.WHITE);
        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#2563EB"),
                                new CornerRadii(8),
                                Insets.EMPTY)));}
    // DELETE BUTTON STYLE
    private void setupDeleteButton(
            Button button) {
        button.setPrefWidth(150);
        button.setPrefHeight(40);
        button.setFont(
                Font.font("Arial", FontWeight.BOLD, 13));
        button.setTextFill(Color.WHITE);
        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#DC2626"),
                                new CornerRadii(8),
                                Insets.EMPTY)));
    }
    // NAVIGATION
    @FXML
    private void showDashboard() {
        pageTitle.setText(
                "Dashboard");
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
                "Skills");
        welcome.setText(
                "Track your technical skills.");
    }
    @FXML
    private void showNotes() {
        pageTitle.setText(
                "Notes");
        welcome.setText(
                "Keep your important development notes.");
    }
    @FXML
    private void showTasks() {
        pageTitle.setText(
                "Tasks");
        welcome.setText(
                "Manage your development tasks.");}
    @FXML
    private void showApi() {
        pageTitle.setText(
                "API Data");
        welcome.setText(
                "External data and API information.");
    }
    @FXML
    private void showSettings() {
        pageTitle.setText(
                "Settings");
        welcome.setText(
                "Application settings.");
    }
}
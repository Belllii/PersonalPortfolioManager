  package com.portfolio;

import com.portfolio.database.ProjectDAO;
import com.portfolio.database.SkillDAO;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class DashboardController {

    // =========================================================
    // SIDEBAR
    // =========================================================

    @FXML
    private VBox sidebar;

    @FXML
    private VBox content;

    @FXML
    private StackPane pageContainer;

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

    @FXML
    private Label pageTitle;

    @FXML
    private Label welcome;

    @FXML
    private Button fetchApiButton;

    @FXML
    private Label apiStatusLabel;

    @FXML
    private TextArea apiResultArea;

    @FXML
    private ProgressBar apiProgress;

    private final ApiService apiService =
            new ApiService();
    private final ExecutorService apiExecutor =
            Executors.newFixedThreadPool(2);
    // =========================================================
    // PROJECT FORM
    // =========================================================

    @FXML
    private Label projectFormTitle;

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


    // =========================================================
    // PROJECT TABLE
    // =========================================================

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


    // =========================================================
    // PROJECT DETAILS
    // =========================================================

    @FXML
    private Label detailTitle;

    @FXML
    private Label detailTechnology;

    @FXML
    private Label detailDescription;

    @FXML
    private Label detailGithub;


    // =========================================================
    // COMMIT 14 CONTROLS
    // =========================================================

    @FXML
    private ComboBox<String> technologyComboBox;

    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    @FXML
    private DatePicker projectDatePicker;

    @FXML
    private RadioButton lowPriority;

    @FXML
    private RadioButton mediumPriority;

    @FXML
    private RadioButton highPriority;

    @FXML
    private CheckBox featuredCheckBox;

    @FXML
    private Slider completionSlider;

    @FXML
    private Label completionLabel;

    @FXML
    private Spinner<Integer> teamSpinner;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TreeView<String> technologyTree;

    @FXML
    private ListView<String> toolsList;

    @FXML
    private ProgressBar portfolioProgress;

    @FXML
    private ImageView profileImage;

// =========================================================
// PAGE NAVIGATION
// =========================================================

    @FXML
    private VBox dashboardPage;

    @FXML
    private VBox projectsPage;

    @FXML
    private VBox skillsPage;

    @FXML
    private VBox notesPage;

    @FXML
    private VBox tasksPage;

    @FXML
    private VBox apiPage;

    @FXML
    private VBox settingsPage;
    // =========================================================
    // DATABASE DATA
    // =========================================================

    private final ObservableList<Project> projectList =
            FXCollections.observableArrayList();

    private final ProjectDAO projectDAO =
            new ProjectDAO();
// =========================================================
// COMMIT 12 - SKILLS
// =========================================================

    @FXML
    private VBox skillsSection;

    @FXML
    private TextField skillNameField;

    @FXML
    private TextField skillCategoryField;

    @FXML
    private Slider skillLevelSlider;

    @FXML
    private Label skillLevelLabel;

    @FXML
    private ListView<Skill> skillListView;

    @FXML
    private ListView<Skill> projectSkillListView;

    @FXML
    private Button addSkillButton;

    @FXML
    private Button updateSkillButton;

    @FXML
    private Button deleteSkillButton;

    @FXML
    private Button assignSkillButton;

    private final ObservableList<Skill> skillList =
            FXCollections.observableArrayList();

    private final ObservableList<Skill> projectSkillList =
            FXCollections.observableArrayList();

    private final SkillDAO skillDAO =
            new SkillDAO();
// =========================================================
// COMMIT 15 - HTTP + JSON
// =========================================================

    // =========================================================
// COMMIT 16 - MULTITHREADING + THREAD POOL
// =========================================================

    @FXML
    private void fetchApiData() {

        apiStatusLabel.setText(
                "Status: Running in thread pool..."
        );
        apiResultArea.setText(
                "Fetching data...\n"
                        + "Using background thread pool."
        );

        apiProgress.setProgress(
                ProgressIndicator.INDETERMINATE_PROGRESS
        );

        apiExecutor.submit(() -> {

            try {

                String result =
                        apiService.fetchData();

                String threadName =
                        Thread.currentThread()
                                .getName();

                Platform.runLater(() -> {

                    apiResultArea.setText(
                            "Status: Completed\n"
                                    + "Worker Thread: "
                                    + threadName
                                    + "\n\n"
                                    + result
                    );

                    apiProgress.setProgress(1);
                    apiStatusLabel.setText(
                            "Status: Completed"
                    );

                });

            } catch (Exception e) {

                String error =
                        e.getMessage();

                Platform.runLater(() -> {

                    apiResultArea.setText(
                            "Status: Failed\n\n"
                                    + error
                    );

                    apiProgress.setProgress(0);
                    apiStatusLabel.setText(
                            "Status: Failed"
                    );

                });
            }
        });

    }

    private void showPage(VBox page) {

        dashboardPage.setVisible(false);
        dashboardPage.setManaged(false);

        projectsPage.setVisible(false);
        projectsPage.setManaged(false);

        skillsPage.setVisible(false);
        skillsPage.setManaged(false);

        notesPage.setVisible(false);
        notesPage.setManaged(false);

        tasksPage.setVisible(false);
        tasksPage.setManaged(false);

        apiPage.setVisible(false);
        apiPage.setManaged(false);

        settingsPage.setVisible(false);
        settingsPage.setManaged(false);

        page.setVisible(true);
        page.setManaged(true);
    }
    // =========================================================
    // INITIALIZE
    // =========================================================

    @FXML
    public void initialize() {

        // -----------------------------------------------------
        // BACKGROUND
        // -----------------------------------------------------

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

        // Make normal labels readable on the dark application background.
        setupReadableText(content);
        setupReadableText(sidebar);


        // -----------------------------------------------------
        // LOGO
        // -----------------------------------------------------

        logo.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        25
                )
        );

        logo.setTextFill(
                Color.web("#38BDF8")
        );


        // -----------------------------------------------------
        // MENU TITLE
        // -----------------------------------------------------

        menuTitle.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        11
                )
        );

        menuTitle.setTextFill(
                Color.web("#94A3B8")
        );


        // -----------------------------------------------------
        // SIDEBAR BUTTONS
        // -----------------------------------------------------

        setupButton(dashboardButton);
        setupButton(projectsButton);
        setupButton(skillsButton);
        setupButton(notesButton);
        setupButton(tasksButton);
        setupButton(apiButton);
        setupButton(settingsButton);


        // -----------------------------------------------------
        // PAGE TITLE
        // -----------------------------------------------------

        pageTitle.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        30
                )
        );

        pageTitle.setTextFill(
                Color.WHITE
        );


        // -----------------------------------------------------
        // WELCOME
        // -----------------------------------------------------

        welcome.setFont(
                Font.font(
                        "Arial",
                        16
                )
        );

        welcome.setTextFill(
                Color.web("#CBD5E1")
        );


        // -----------------------------------------------------
        // FORM LABELS
        // -----------------------------------------------------

        setupFormLabel(projectTitleLabel);
        setupFormLabel(descriptionLabel);
        setupFormLabel(technologyLabel);
        setupFormLabel(githubLabel);

        setupFormLabel(projectFormTitle);

        if (apiStatusLabel != null) {
            apiStatusLabel.setTextFill(Color.web("#38BDF8"));
            apiStatusLabel.setFont(
                    Font.font("Arial", FontWeight.BOLD, 14)
            );
        }

        if (apiResultArea != null) {
            apiResultArea.setFont(
                    Font.font("Consolas", 13)
            );
        }


        // -----------------------------------------------------
        // PROJECT TITLE
        // -----------------------------------------------------

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

        setupFormLabel(detailTitle);
        setupFormLabel(detailTechnology);
        setupFormLabel(detailDescription);
        setupFormLabel(detailGithub);


        // -----------------------------------------------------
        // TEXT FIELDS
        // -----------------------------------------------------

        setupTextField(titleField);
        setupTextField(technologyField);
        setupTextField(githubField);

        setupTextArea(descriptionField);


        // -----------------------------------------------------
        // BUTTONS
        // -----------------------------------------------------

        setupActionButton(addProjectButton);
        setupActionButton(updateProjectButton);
        setupDeleteButton(deleteProjectButton);


        // -----------------------------------------------------
        // MESSAGE
        // -----------------------------------------------------

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );


        // -----------------------------------------------------
        // TABLE COLUMNS
        // -----------------------------------------------------

        titleColumn.setCellValueFactory(
                new PropertyValueFactory<>("title")
        );

        technologyColumn.setCellValueFactory(
                new PropertyValueFactory<>("technology")
        );

        githubColumn.setCellValueFactory(
                new PropertyValueFactory<>("githubLink")
        );


        // -----------------------------------------------------
        // TABLE
        // -----------------------------------------------------

        projectTable.setItems(projectList);

        loadProjects();


        // -----------------------------------------------------
        // TABLE SELECTION
        // -----------------------------------------------------

        projectTable
                .getSelectionModel()
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

                                loadProjectSkills(
                                        selectedProject.getId()
                                );
                            }
                        }
                );


        // -----------------------------------------------------
        // COMMIT 14
        // -----------------------------------------------------

        setupPortfolioTools();
        setupSkills();
        setupResponsiveLayout();
        showPage(dashboardPage);
    }


    // =========================================================
    // LOAD PROJECTS
    // =========================================================

    private void loadProjects() {

        projectList.clear();

        projectList.addAll(
                projectDAO.getAllProjects()
        );
    }


    // =========================================================
    // SHOW PROJECT DETAILS
    // =========================================================

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


    // =========================================================
    // LOAD PROJECT INTO FORM
    // =========================================================

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


    // =========================================================
    // ADD PROJECT
    // =========================================================

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


        if (title.isEmpty()
                || description.isEmpty()
                || technology.isEmpty()) {

            showError(
                    "Please fill in all required fields."
            );

            return;
        }


        Project project =
                new Project(
                        title,
                        description,
                        technology,
                        github
                );


        projectDAO.insertProject(project);

        loadProjects();

        showSuccess(
                "Project added successfully."
        );

        clearForm();
    }


    // =========================================================
    // UPDATE PROJECT
    // =========================================================

    @FXML
    private void updateProject() {

        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedProject == null) {

            showError(
                    "Please select a project first."
            );

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


        if (title.isEmpty()
                || description.isEmpty()
                || technology.isEmpty()) {

            showError(
                    "Please fill in all required fields."
            );

            return;
        }


        selectedProject.setTitle(title);

        selectedProject.setDescription(
                description
        );

        selectedProject.setTechnology(
                technology
        );

        selectedProject.setGithubLink(
                github
        );


        projectDAO.updateProject(
                selectedProject.getId(),
                selectedProject
        );


        loadProjects();

        showSuccess(
                "Project updated successfully."
        );

        clearForm();
    }


    // =========================================================
    // DELETE PROJECT
    // =========================================================

    @FXML
    private void deleteProject() {

        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedProject == null) {

            showError(
                    "Please select a project first."
            );

            return;
        }


        projectDAO.deleteProject(
                selectedProject.getId()
        );


        projectList.remove(
                selectedProject
        );


        showSuccess(
                "Project deleted successfully."
        );

        clearForm();

        clearDetails();
    }


    // =========================================================
    // CLEAR FORM
    // =========================================================

    private void clearForm() {

        titleField.clear();

        descriptionField.clear();

        technologyField.clear();

        githubField.clear();
    }


    // =========================================================
    // CLEAR DETAILS
    // =========================================================

    private void clearDetails() {

        detailTitle.setText(
                "No project selected"
        );

        detailTechnology.setText("");

        detailDescription.setText("");

        detailGithub.setText("");
    }


    // =========================================================
    // SUCCESS MESSAGE
    // =========================================================

    private void showSuccess(
            String message) {

        projectMessage.setText(
                message
        );

        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );
    }


    // =========================================================
    // ERROR MESSAGE
    // =========================================================

    private void showError(
            String message) {

        projectMessage.setText(
                message
        );

        projectMessage.setTextFill(
                Color.web("#F87171")
        );
    }

// =========================================================
// SKILLS SETUP
// =========================================================

    private void setupSkills() {

        // The current FXML may still contain the Skills placeholder.
        // Do not let missing skill controls crash application startup.
        if (skillListView == null
                || projectSkillListView == null
                || skillNameField == null
                || skillCategoryField == null
                || skillLevelSlider == null
                || skillLevelLabel == null) {
            return;
        }

        skillListView.setItems(skillList);

        projectSkillListView.setItems(
                projectSkillList
        );

        skillLevelSlider.setMin(0);
        skillLevelSlider.setMax(100);
        skillLevelSlider.setValue(50);

        skillLevelLabel.setText("50%");

        skillLevelSlider.valueProperty()
                .addListener((observable, oldValue, newValue) -> {

                    skillLevelLabel.setText(
                            String.format(
                                    "%.0f%%",
                                    newValue.doubleValue()
                            )
                    );
                });

        skillListView
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable,
                         oldSkill,
                         selectedSkill) -> {

                            if (selectedSkill != null) {

                                skillNameField.setText(
                                        selectedSkill.getName()
                                );

                                skillCategoryField.setText(
                                        selectedSkill.getCategory()
                                );

                                skillLevelSlider.setValue(
                                        selectedSkill.getLevel()
                                );
                            }
                        }
                );

        loadSkills();
    }
    private void loadSkills() {

        skillList.clear();

        skillList.addAll(
                skillDAO.getAllSkills()
        );
    }
    // =========================================================
// ADD SKILL
// =========================================================

    @FXML
    private void addSkill() {

        String name =
                skillNameField.getText().trim();

        String category =
                skillCategoryField.getText().trim();

        int level =
                (int) skillLevelSlider.getValue();

        if (name.isEmpty()
                || category.isEmpty()) {

            showError(
                    "Please enter skill name and category."
            );

            return;
        }

        Skill skill =
                new Skill(
                        name,
                        category,
                        level
                );

        skillDAO.insertSkill(skill);

        loadSkills();

        clearSkillForm();

        showSuccess(
                "Skill added successfully."
        );
    }
    // =========================================================
// UPDATE SKILL
// =========================================================

    @FXML
    private void updateSkill() {

        Skill selectedSkill =
                skillListView
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedSkill == null) {

            showError(
                    "Please select a skill first."
            );

            return;
        }

        String name =
                skillNameField.getText().trim();

        String category =
                skillCategoryField.getText().trim();

        int level =
                (int) skillLevelSlider.getValue();

        if (name.isEmpty()
                || category.isEmpty()) {

            showError(
                    "Please enter skill name and category."
            );

            return;
        }

        Skill updatedSkill =
                new Skill(
                        name,
                        category,
                        level
                );

        skillDAO.updateSkill(
                selectedSkill.getId(),
                updatedSkill
        );

        loadSkills();

        clearSkillForm();

        showSuccess(
                "Skill updated successfully."
        );
    }
    // =========================================================
// DELETE SKILL
// =========================================================

    @FXML
    private void deleteSkill() {

        Skill selectedSkill =
                skillListView
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedSkill == null) {

            showError(
                    "Please select a skill first."
            );

            return;
        }

        skillDAO.deleteSkill(
                selectedSkill.getId()
        );

        loadSkills();

        projectSkillList.clear();

        clearSkillForm();

        showSuccess(
                "Skill deleted successfully."
        );
    }
    // =========================================================
// ASSIGN SKILL TO PROJECT
// =========================================================

    @FXML
    private void assignSkillToProject() {

        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();

        Skill selectedSkill =
                skillListView
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedProject == null) {

            showError(
                    "Please select a project first."
            );

            return;
        }

        if (selectedSkill == null) {

            showError(
                    "Please select a skill first."
            );

            return;
        }

        skillDAO.assignSkillToProject(
                selectedProject.getId(),
                selectedSkill.getId()
        );

        loadProjectSkills(
                selectedProject.getId()
        );

        showSuccess(
                "Skill assigned to project."
        );
    }
    private void loadProjectSkills(
            int projectId) {

        if (projectSkillListView == null) {
            return;
        }

        projectSkillList.clear();

        projectSkillList.addAll(
                skillDAO.getSkillsForProject(
                        projectId
                )
        );
    }
    private void clearSkillForm() {

        skillNameField.clear();

        skillCategoryField.clear();

        skillLevelSlider.setValue(50);

        skillListView
                .getSelectionModel()
                .clearSelection();
    }
    // =========================================================
    // READABLE TEXT
    // =========================================================

    private void setupReadableText(Node node) {

        if (node instanceof Label) {
            Label label = (Label) node;

            label.setTextFill(
                    Color.web("#E2E8F0")
            );

            if (label.getFont() == null) {
                label.setFont(
                        Font.font("Arial", 14)
                );
            }
        }

        if (node instanceof javafx.scene.Parent) {
            for (Node child :
                    ((javafx.scene.Parent) node).getChildrenUnmodifiable()) {

                setupReadableText(child);
            }
        }
    }


    // =========================================================
    // FORM LABEL STYLE
    // =========================================================

    private void setupFormLabel(
            Label label) {

        label.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
        );

        label.setTextFill(
                Color.web("#E2E8F0")
        );
    }


    // =========================================================
    // TEXT FIELD STYLE
    // =========================================================

    private void setupTextField(
            TextField field) {

        field.setPrefHeight(38);

        field.setFont(
                Font.font(
                        "Arial",
                        14
                )
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


    // =========================================================
    // TEXT AREA STYLE
    // =========================================================

    private void setupTextArea(
            TextArea area) {

        area.setFont(
                Font.font(
                        "Arial",
                        14
                )
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


    // =========================================================
    // SIDEBAR BUTTON STYLE
    // =========================================================

    private void setupButton(
            Button button) {

        button.setPrefWidth(180);

        button.setPrefHeight(42);

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
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


    // =========================================================
    // ACTION BUTTON STYLE
    // =========================================================

    private void setupActionButton(
            Button button) {

        button.setPrefWidth(150);

        button.setPrefHeight(40);

        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
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


    // =========================================================
    // DELETE BUTTON STYLE
    // =========================================================

    private void setupDeleteButton(
            Button button) {

        button.setPrefWidth(150);

        button.setPrefHeight(40);

        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
        );

        button.setTextFill(
                Color.WHITE
        );

        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#DC2626"),
                                new CornerRadii(8),
                                Insets.EMPTY
                        )
                )
        );
    }


    // =========================================================
    // NAVIGATION
    // =========================================================

    @FXML
    private void showDashboard() {

        showPage(dashboardPage);

        pageTitle.setText("Dashboard");

        welcome.setText(
                "Welcome back! Here's an overview of your portfolio."
        );
    }

    @FXML
    private void showProjects() {

        showPage(projectsPage);

        pageTitle.setText("Projects");

        welcome.setText(
                "Add, update and manage your portfolio projects."
        );
    }

    @FXML
    private void showSkills() {

        showPage(skillsPage);

        pageTitle.setText("Skills");

        welcome.setText(
                "Manage your technical skills."
        );
    }

    @FXML
    private void showNotes() {

        showPage(notesPage);

        pageTitle.setText("Notes");

        welcome.setText(
                "Create and manage your portfolio notes."
        );
    }

    @FXML
    private void showTasks() {

        showPage(tasksPage);

        pageTitle.setText("Tasks");

        welcome.setText(
                "Track your portfolio tasks and progress."
        );
    }

    @FXML
    private void showApi() {

        showPage(apiPage);

        pageTitle.setText("API");

        welcome.setText(
                "Fetch and process data from an external API."
        );
    }

    @FXML
    private void showSettings() {

        showPage(settingsPage);

        pageTitle.setText("Settings");

        welcome.setText(
                "Manage application settings."
        );
    }
    // =========================================================
    // COMMIT 14 - PORTFOLIO TOOLS
    // =========================================================

    private void setupPortfolioTools() {

        // -----------------------------------------------------
        // COMBO BOX
        // -----------------------------------------------------

        technologyComboBox.setItems(
                FXCollections.observableArrayList(
                        "Java",
                        "C++",
                        "Python",
                        "JavaFX",
                        "Arduino",
                        "FPGA",
                        "SQL",
                        "HTML/CSS"
                )
        );


        // -----------------------------------------------------
        // CHOICE BOX
        // -----------------------------------------------------

        categoryChoiceBox.setItems(
                FXCollections.observableArrayList(
                        "Web Development",
                        "Desktop Application",
                        "Embedded System",
                        "Data Science",
                        "Artificial Intelligence",
                        "Digital Logic"
                )
        );

        categoryChoiceBox.setValue(
                "Desktop Application"
        );


        // -----------------------------------------------------
        // RADIO BUTTONS
        // -----------------------------------------------------

        ToggleGroup priorityGroup =
                new ToggleGroup();

        lowPriority.setToggleGroup(
                priorityGroup
        );

        mediumPriority.setToggleGroup(
                priorityGroup
        );

        highPriority.setToggleGroup(
                priorityGroup
        );

        mediumPriority.setSelected(
                true
        );


        // -----------------------------------------------------
        // SLIDER
        // -----------------------------------------------------

        completionSlider
                .valueProperty()
                .addListener(
                        (observable,
                         oldValue,
                         newValue) -> {

                            int value =
                                    newValue.intValue();

                            completionLabel.setText(
                                    value + "%"
                            );

                            portfolioProgress.setProgress(
                                    value / 100.0
                            );
                        }
                );


        // -----------------------------------------------------
        // SPINNER
        // -----------------------------------------------------

        teamSpinner.setValueFactory(
                new SpinnerValueFactory
                        .IntegerSpinnerValueFactory(
                        1,
                        20,
                        1
                )
        );


        // -----------------------------------------------------
        // LIST VIEW
        // -----------------------------------------------------

        toolsList.setItems(
                FXCollections.observableArrayList(
                        "JavaFX",
                        "SQLite",
                        "Git",
                        "Maven",
                        "GitHub"
                )
        );

        toolsList
                .getSelectionModel()
                .setSelectionMode(
                        SelectionMode.MULTIPLE
                );


        // -----------------------------------------------------
        // TREE VIEW
        // -----------------------------------------------------

        TreeItem<String> root =
                new TreeItem<>(
                        "Technologies"
                );


        TreeItem<String> programming =
                new TreeItem<>(
                        "Programming"
                );

        programming.getChildren().addAll(
                new TreeItem<>("Java"),
                new TreeItem<>("C++"),
                new TreeItem<>("Python")
        );


        TreeItem<String> database =
                new TreeItem<>(
                        "Database"
                );

        database.getChildren().addAll(
                new TreeItem<>("SQLite"),
                new TreeItem<>("MySQL")
        );


        TreeItem<String> embedded =
                new TreeItem<>(
                        "Embedded"
                );

        embedded.getChildren().addAll(
                new TreeItem<>("Arduino"),
                new TreeItem<>("FPGA")
        );


        root.getChildren().addAll(
                programming,
                database,
                embedded
        );


        root.setExpanded(true);

        programming.setExpanded(true);

        technologyTree.setRoot(root);


        // -----------------------------------------------------
        // INITIAL PROGRESS
        // -----------------------------------------------------

        portfolioProgress.setProgress(
                completionSlider.getValue() / 100.0
        );
    }


    // =========================================================
    // RESPONSIVE LAYOUT
    // =========================================================

    private void setupResponsiveLayout() {

        if (projectTable != null
                && content != null
                && !projectTable.prefWidthProperty().isBound()) {

            projectTable.prefWidthProperty().bind(
                    content.widthProperty()
                            .subtract(50)
            );
        }
    }


    // =========================================================
    // FILE CHOOSER + IMAGE VIEW
    // =========================================================

    @FXML
    private void chooseImage() {

        FileChooser fileChooser =
                new FileChooser();

        fileChooser.setTitle(
                "Choose Profile Image"
        );


        fileChooser
                .getExtensionFilters()
                .add(
                        new FileChooser.ExtensionFilter(
                                "Image Files",
                                "*.png",
                                "*.jpg",
                                "*.jpeg"
                        )
                );


        Stage stage =
                (Stage)
                        content
                                .getScene()
                                .getWindow();


        File file =
                fileChooser.showOpenDialog(
                        stage
                );


        if (file != null) {

            Image image =
                    new Image(
                            file.toURI()
                                    .toString()
                    );

            profileImage.setImage(
                    image
            );
        }
    }


    // =========================================================
    // ABOUT ALERT
    // =========================================================

    @FXML
    private void showAbout() {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                "About DevFolio"
        );

        alert.setHeaderText(
                "DevFolio - Personal Portfolio Manager"
        );

        alert.setContentText(
                "A JavaFX portfolio management application "
                        + "for managing projects, skills, notes and tasks."
        );

        alert.showAndWait();
    }


    // =========================================================
    // EXIT
    // =========================================================

    @FXML
    private void exitApplication() {

        Alert alert =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        alert.setTitle(
                "Exit"
        );

        alert.setHeaderText(
                "Exit DevFolio?"
        );

        alert.setContentText(
                "Are you sure you want to close the application?"
        );


        if (alert.showAndWait()
                .orElse(null)
                == ButtonType.OK) {

            apiExecutor.shutdownNow();
            Platform.exit();
        }
    }
}
package com.portfolio;

import com.portfolio.database.ProjectDAO;
import com.portfolio.database.SkillDAO;
import com.portfolio.database.NoteDAO;
import com.portfolio.database.TaskDAO;

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
import javafx.scene.control.ListCell;
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
import javafx.scene.control.ProgressIndicator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

import javafx.animation.FadeTransition;
import javafx.scene.Cursor;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.control.ScrollPane;
import javafx.scene.chart.PieChart;
import javafx.collections.transformation.FilteredList;
import java.util.Map;
import java.util.LinkedHashMap;


public class DashboardController {

    // =========================================================
    // ROOT, SIDEBAR & TOP NAVBAR
    // =========================================================

    @FXML
    private BorderPane rootBorderPane;

    @FXML
    private VBox sidebar;

    @FXML
    private Button sidebarToggleButton;

    @FXML
    private Button closeSidebarButton;

    @FXML
    private HBox topNavBar;

    @FXML
    private HBox pageHeaderBox;

    @FXML
    private Button topWelcomeBtn;

    @FXML
    private Button topDashboardBtn;

    @FXML
    private Button topProjectsBtn;

    @FXML
    private Button topSkillsBtn;

    @FXML
    private Button topNotesBtn;

    @FXML
    private Button topTasksBtn;

    @FXML
    private Button topApiBtn;

    @FXML
    private Button topSettingsBtn;

    @FXML
    private VBox content;

    @FXML
    private ScrollPane mainScrollPane;

    @FXML
    private StackPane pageContainer;

    @FXML
    private Label logo;

    @FXML
    private Label menuTitle;

    @FXML
    private Button welcomeButton;

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


    // =========================================================
    // API
    // =========================================================

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
    private TextField projectSearchField;

    @FXML
    private Button clearSearchButton;

    private FilteredList<Project> filteredProjects;

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
    // COMMIT 14 - PORTFOLIO TOOLS
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
    private VBox welcomePage;

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

    // Welcome Page components
    @FXML private VBox welcomeHero;
    @FXML private Label welcomeHeading;
    @FXML private Label welcomeSubheading;
    @FXML private Button welcomeDashBtn;
    @FXML private Button welcomeProjBtn;
    @FXML private Button welcomeSkillsBtn;
    @FXML private Button welcomeNotesBtn;
    @FXML private Button welcomeTasksBtn;
    @FXML private Label welcomeFeaturesTitle;
    @FXML private VBox featureCard1;
    @FXML private VBox featureCard2;
    @FXML private VBox featureCard3;
    @FXML private VBox featureCard4;
    @FXML private Label featureTitle1;
    @FXML private Label featureTitle2;
    @FXML private Label featureTitle3;
    @FXML private Label featureTitle4;
    @FXML private Label dbStatusBadge;
    @FXML private Label systemUptimeLabel;

    // Dashboard Page components
    @FXML private Label dashOverviewTitle;
    @FXML private Label dashOverviewSubtitle;
    @FXML private Label liveClockLabel;
    @FXML private Label systemStatusBadge;
    @FXML private VBox statCard1;
    @FXML private VBox statCard2;
    @FXML private VBox statCard3;
    @FXML private VBox statCard4;
    @FXML private Label statLabel1;
    @FXML private Label statLabel2;
    @FXML private Label statLabel3;
    @FXML private Label statLabel4;
    @FXML private Label statProjectsCount;
    @FXML private Label statSkillsCount;
    @FXML private Label statNotesCount;
    @FXML private Label statTasksCount;
    @FXML private Label statSub1;
    @FXML private Label statSub2;
    @FXML private Label statSub3;
    @FXML private Label statSub4;
    @FXML private Button openPreviewButton;
    @FXML private Button previewProjectButton;
    @FXML private Label formattedDateLabel;
    @FXML private FlowPane techBadgesPane;

    // Pagination / Next-Previous Page Navigation
    @FXML private Button prevPageButton;
    @FXML private Button nextPageButton;
    @FXML private Label pageIndicatorLabel;

    private int currentPageIndex = 0;
    private static final int TOTAL_PAGES = 8;
    private boolean isSidebarOpen = false;


    // =========================================================
    // DATABASE
    // =========================================================

    private final ObservableList<Project> projectList =
            FXCollections.observableArrayList();

    private final ProjectDAO projectDAO =
            new ProjectDAO();


    // =========================================================
    // SKILLS
    // =========================================================

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

    @FXML
    private Label skillMessage;

    @FXML
    private PieChart skillsPieChart;

    private final ObservableList<Skill> skillList =
            FXCollections.observableArrayList();

    private final ObservableList<Skill> projectSkillList =
            FXCollections.observableArrayList();

    private final SkillDAO skillDAO =
            new SkillDAO();


    // =========================================================
    // NOTES
    // =========================================================

    @FXML
    private TextField noteTitleField;

    @FXML
    private TextArea noteContentArea;

    @FXML
    private ListView<Note> noteListView;

    @FXML
    private Button addNoteButton;

    @FXML
    private Button updateNoteButton;

    @FXML
    private Button deleteNoteButton;

    private final ObservableList<Note> noteList =
            FXCollections.observableArrayList();

    private final NoteDAO noteDAO =
            new NoteDAO();


    // =========================================================
    // TASKS
    // =========================================================

    @FXML
    private TextField taskTitleField;

    @FXML
    private CheckBox taskCompletedCheckBox;

    @FXML
    private ChoiceBox<String> taskPriorityChoice;

    @FXML
    private ChoiceBox<String> taskPriorityFilterChoice;

    private FilteredList<TaskItem> filteredTasks;

    @FXML
    private ListView<TaskItem> taskListView;

    @FXML
    private Button addTaskButton;

    @FXML
    private Button updateTaskButton;

    @FXML
    private Button deleteTaskButton;

    @FXML
    private Button toggleTaskButton;

    private final ObservableList<TaskItem> taskList =
            FXCollections.observableArrayList();

    private final TaskDAO taskDAO =
            new TaskDAO();


    // =========================================================
    // API
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


    // =========================================================
    // PAGE VISIBILITY & SIDEBAR DRAWER
    // =========================================================

    @FXML
    private void toggleSidebar() {
        setSidebarOpen(!isSidebarOpen);
    }

    private void setSidebarOpen(boolean open) {
        this.isSidebarOpen = open;

        if (sidebar != null) {
            sidebar.setVisible(open);
            sidebar.setManaged(open);
        }

        if (rootBorderPane != null) {
            rootBorderPane.setLeft(open ? sidebar : null);
        }

        if (sidebarToggleButton != null) {
            sidebarToggleButton.setText(open ? "✕ Close Menu" : "☰ Menu");
        }
    }

    private void showPage(VBox page) {

        if (welcomePage != null) {
            welcomePage.setVisible(false);
            welcomePage.setManaged(false);
        }

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

        if (pageHeaderBox != null) {
            boolean showBanner = (page != welcomePage);
            pageHeaderBox.setVisible(showBanner);
            pageHeaderBox.setManaged(showBanner);
        }

        // Automatically close the sidebar drawer on page change so it doesn't stay stuck on screen
        setSidebarOpen(false);

        if (mainScrollPane != null) {
            mainScrollPane.setVvalue(0.0);
        }

        FadeTransition fade = new FadeTransition(Duration.millis(180), page);
        fade.setFromValue(0.25);
        fade.setToValue(1.0);
        fade.play();
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

        if (mainScrollPane != null) {
            mainScrollPane.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web("#0F172A"),
                                    CornerRadii.EMPTY,
                                    Insets.EMPTY
                            )
                    )
            );
        }

        if (topNavBar != null) {
            topNavBar.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web("#020617"),
                                    new CornerRadii(10),
                                    Insets.EMPTY
                            )
                    )
            );
            topNavBar.setPadding(new Insets(10, 14, 10, 14));
        }

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
        // SIDEBAR & TOP NAVBAR BUTTONS
        // -----------------------------------------------------

        if (welcomeButton != null) setupButton(welcomeButton);
        setupButton(dashboardButton);
        setupButton(projectsButton);
        setupButton(skillsButton);
        setupButton(notesButton);
        setupButton(tasksButton);
        setupButton(apiButton);
        setupButton(settingsButton);

        setupNavControlButton(sidebarToggleButton);
        setupNavControlButton(closeSidebarButton);
        setupTopNavButton(topWelcomeBtn);
        setupTopNavButton(topDashboardBtn);
        setupTopNavButton(topProjectsBtn);
        setupTopNavButton(topSkillsBtn);
        setupTopNavButton(topNotesBtn);
        setupTopNavButton(topTasksBtn);
        setupTopNavButton(topApiBtn);
        setupTopNavButton(topSettingsBtn);

        setSidebarOpen(false);


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
                Font.font("Arial", 16)
        );

        welcome.setTextFill(
                Color.web("#CBD5E1")
        );


        // -----------------------------------------------------
        // PROJECT LABELS
        // -----------------------------------------------------

        setupFormLabel(projectTitleLabel);
        setupFormLabel(descriptionLabel);
        setupFormLabel(technologyLabel);
        setupFormLabel(githubLabel);
        setupFormLabel(projectFormTitle);

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
        // API
        // -----------------------------------------------------

        if (apiStatusLabel != null) {

            apiStatusLabel.setTextFill(
                    Color.web("#38BDF8")
            );

            apiStatusLabel.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            14
                    )
            );
        }

        if (apiResultArea != null) {

            apiResultArea.setFont(
                    Font.font(
                            "Consolas",
                            13
                    )
            );
        }


        // -----------------------------------------------------
        // PROJECT FIELDS
        // -----------------------------------------------------

        setupTextField(titleField);
        setupTextField(technologyField);
        setupTextField(githubField);

        setupTextArea(descriptionField);


        // -----------------------------------------------------
        // PROJECT BUTTONS
        // -----------------------------------------------------

        setupActionButton(addProjectButton);
        setupActionButton(updateProjectButton);
        setupDeleteButton(deleteProjectButton);


        projectMessage.setTextFill(
                Color.web("#38BDF8")
        );


        // -----------------------------------------------------
        // PROJECT TABLE
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

        filteredProjects = new FilteredList<>(projectList, p -> true);

        projectTable.setItems(filteredProjects);

        loadProjects();

        setupProjectSearch();


        // -----------------------------------------------------
        // PROJECT SELECTION
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
        // SETUP FEATURES
        // -----------------------------------------------------

        setupPortfolioTools();

        setupSkills();

        setupNotes();

        setupTasks();

        setupResponsiveLayout();

        setupWelcomePage();

        setupBeautifulDashboard();

        startLiveClock();

        setupTechBadges();

        setupDatePickerFormatter();

        if (openPreviewButton != null) {
            setupActionButton(openPreviewButton);
        }

        if (previewProjectButton != null) {
            setupActionButton(previewProjectButton);
        }

        setupPageNavigationControls();

        showWelcome();
    }


    // =========================================================
    // PROJECTS
    // =========================================================

    private void loadProjects() {

        projectList.clear();

        projectList.addAll(
                projectDAO.getAllProjects()
        );
    }


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

        projectSkillList.clear();
    }


    private void clearForm() {

        titleField.clear();
        descriptionField.clear();
        technologyField.clear();
        githubField.clear();
    }


    private void clearDetails() {

        detailTitle.setText(
                "No project selected"
        );

        detailTechnology.setText("");
        detailDescription.setText("");
        detailGithub.setText("");
    }


    private void showSuccess(
            String message) {

        if (projectMessage != null) {
            projectMessage.setText(
                    message
            );
            projectMessage.setTextFill(
                    Color.web("#38BDF8")
            );
        }

        if (skillMessage != null) {
            skillMessage.setText(
                    message
            );
            skillMessage.setTextFill(
                    Color.web("#38BDF8")
            );
        }
    }


    private void showError(
            String message) {

        if (projectMessage != null) {
            projectMessage.setText(
                    message
            );
            projectMessage.setTextFill(
                    Color.web("#F87171")
            );
        }

        if (skillMessage != null) {
            skillMessage.setText(
                    message
            );
            skillMessage.setTextFill(
                    Color.web("#F87171")
            );
        }
    }


    // =========================================================
    // SKILLS
    // =========================================================
    private void setupSkills() {

        setupTextField(skillNameField);
        setupTextField(skillCategoryField);

        setupActionButton(addSkillButton);
        setupActionButton(updateSkillButton);
        setupDeleteButton(deleteSkillButton);
        setupActionButton(assignSkillButton);

        if (skillMessage != null) {
            skillMessage.setTextFill(Color.web("#38BDF8"));
        }

        // Connect the ObservableList to the ListView
        skillListView.setItems(skillList);

        // Make sure the ListView has enough visible space
        skillListView.setPrefHeight(180);
        skillListView.setMinHeight(180);

        // Custom display for each Skill
        skillListView.setCellFactory(listView -> new ListCell<Skill>() {

            @Override
            protected void updateItem(Skill skill, boolean empty) {

                super.updateItem(skill, empty);

                if (empty || skill == null) {

                    setText("");
                    setGraphic(null);

                } else {

                    String text =
                            skill.getName()
                                    + " - "
                                    + skill.getCategory()
                                    + " ("
                                    + skill.getLevel()
                                    + "%)";

                    setText(text);

                    if (isSelected()) {
                        setTextFill(Color.WHITE);
                    } else {
                        setTextFill(Color.BLACK);
                    }

                    setFont(
                            Font.font(
                                    "Arial",
                                    FontWeight.NORMAL,
                                    14
                            )
                    );
                }
            }
        });


        // ---------------------------------------------------------
        // SKILL LEVEL SLIDER
        // ---------------------------------------------------------

        skillLevelSlider.setMin(0);
        skillLevelSlider.setMax(100);
        skillLevelSlider.setValue(50);

        skillLevelLabel.setText("50%");


        skillLevelSlider.valueProperty().addListener(
                (obs, oldValue, newValue) -> {

                    int value =
                            newValue.intValue();

                    skillLevelLabel.setText(
                            value + "%"
                    );
                }
        );


        // ---------------------------------------------------------
        // SELECT SKILL
        // ---------------------------------------------------------

        skillListView
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldSkill, selectedSkill) -> {

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

                                skillLevelLabel.setText(
                                        selectedSkill.getLevel()
                                                + "%"
                                );
                            }
                        }
                );


        // ---------------------------------------------------------
        // PROJECT SKILL LIST
        // ---------------------------------------------------------

        projectSkillListView.setItems(
                projectSkillList
        );

        projectSkillListView.setPrefHeight(150);
        projectSkillListView.setMinHeight(150);

        projectSkillListView.setCellFactory(
                listView -> new ListCell<Skill>() {

                    @Override
                    protected void updateItem(
                            Skill skill,
                            boolean empty) {

                        super.updateItem(
                                skill,
                                empty
                        );

                        if (empty || skill == null) {

                            setText("");
                            setGraphic(null);

                        } else {

                            setText(
                                    skill.getName()
                                            + " - "
                                            + skill.getCategory()
                                            + " ("
                                            + skill.getLevel()
                                            + "%)"
                            );

                            if (isSelected()) {
                                setTextFill(Color.WHITE);
                            } else {
                                setTextFill(Color.BLACK);
                            }

                            setFont(
                                    Font.font(
                                            "Arial",
                                            14
                                    )
                            );
                        }
                    }
                }
        );


        // ---------------------------------------------------------
        // LOAD FROM DATABASE
        // ---------------------------------------------------------

        loadSkills();
    }

    private void loadSkills() {

        System.out.println("================================");
        System.out.println("Loading skills...");

        try {

            skillList.clear();

            java.util.List<Skill> skills =
                    skillDAO.getAllSkills();

            System.out.println(
                    "Database returned: "
                            + skills.size()
                            + " skills"
            );

            for (Skill skill : skills) {

                System.out.println(
                        "ID: " + skill.getId()
                                + " | Name: " + skill.getName()
                                + " | Category: " + skill.getCategory()
                                + " | Level: " + skill.getLevel()
                );
            }

            skillList.addAll(skills);

            updateSkillsPieChart();

            skillListView.refresh();

            System.out.println(
                    "ListView now contains: "
                            + skillListView.getItems().size()
                            + " skills"
            );

            System.out.println("================================");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    @FXML
    private void addSkill() {

        String name = (skillNameField.getText() == null) ? "" : skillNameField.getText().trim();
        String category = (skillCategoryField.getText() == null) ? "" : skillCategoryField.getText().trim();
        int level = (int) skillLevelSlider.getValue();

        if (name.isEmpty() || category.isEmpty()) {
            showError("Please enter skill name and category.");
            return;
        }

        try {

            Skill skill = new Skill(name, category, level);

            boolean inserted = skillDAO.insertSkill(skill);

            if (inserted) {

                System.out.println("Skill inserted successfully: " + name);

                loadSkills();

                clearSkillForm();

                showSuccess("Skill added successfully.");

            } else {

                System.out.println("Skill was NOT inserted.");

                showError("Could not add skill.");

            }

        } catch (Exception e) {

            e.printStackTrace();

            showError("Could not add skill: " + e.getMessage());
        }
    }

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
                (skillNameField.getText() == null)
                        ? ""
                        : skillNameField.getText().trim();

        String category =
                (skillCategoryField.getText() == null)
                        ? ""
                        : skillCategoryField.getText().trim();

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


        Project selectedProject =
                projectTable
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedProject != null) {

            loadProjectSkills(
                    selectedProject.getId()
            );
        }
    }


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
    // NOTES
    // =========================================================

    private void setupNotes() {

        noteListView.setItems(
                noteList
        );

        loadNotes();


        // -----------------------------------------------------
        // SELECT NOTE
        // -----------------------------------------------------

        noteListView
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable,
                         oldNote,
                         selectedNote) -> {

                            if (selectedNote != null) {

                                noteTitleField.setText(
                                        selectedNote.getTitle()
                                );

                                noteContentArea.setText(
                                        selectedNote.getContent()
                                );
                            }
                        }
                );
    }


    private void loadNotes() {

        noteList.clear();

        noteList.addAll(
                noteDAO.getAllNotes()
        );
    }


    @FXML
    private void addNote() {

        String title =
                noteTitleField
                        .getText()
                        .trim();

        String content =
                noteContentArea.getText();


        if (title.isEmpty()) {

            showError(
                    "Please enter a note title."
            );

            return;
        }


        Note note =
                new Note(
                        title,
                        content
                );


        noteDAO.insertNote(note);

        loadNotes();

        clearNoteForm();

        showSuccess(
                "Note added successfully."
        );
    }


    @FXML
    private void updateNote() {

        Note selectedNote =
                noteListView
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedNote == null) {

            showError(
                    "Please select a note first."
            );

            return;
        }


        String title =
                noteTitleField
                        .getText()
                        .trim();

        String content =
                noteContentArea.getText();


        if (title.isEmpty()) {

            showError(
                    "Please enter a note title."
            );

            return;
        }


        Note updatedNote =
                new Note(
                        title,
                        content
                );


        noteDAO.updateNote(
                selectedNote.getId(),
                updatedNote
        );


        loadNotes();

        clearNoteForm();

        showSuccess(
                "Note updated successfully."
        );
    }


    @FXML
    private void deleteNote() {

        Note selectedNote =
                noteListView
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedNote == null) {

            showError(
                    "Please select a note first."
            );

            return;
        }


        noteDAO.deleteNote(
                selectedNote.getId()
        );


        loadNotes();

        clearNoteForm();

        showSuccess(
                "Note deleted successfully."
        );
    }


    private void clearNoteForm() {

        noteTitleField.clear();

        noteContentArea.clear();

        noteListView
                .getSelectionModel()
                .clearSelection();
    }


    // =========================================================
    // TASKS
    // =========================================================

    private void setupTasks() {

        // Priority choices
        ObservableList<String> priorities =
                FXCollections.observableArrayList(
                        "High", "Medium", "Low"
                );

        if (taskPriorityChoice != null) {
            taskPriorityChoice.setItems(priorities);
            taskPriorityChoice.setValue("Medium");
        }

        if (taskPriorityFilterChoice != null) {
            taskPriorityFilterChoice.setItems(
                    FXCollections.observableArrayList(
                            "All", "High", "Medium", "Low"
                    )
            );
            taskPriorityFilterChoice.setValue("All");
            taskPriorityFilterChoice.valueProperty().addListener(
                    (obs, oldVal, newVal) -> {
                        if (filteredTasks != null) {
                            filteredTasks.setPredicate(t -> {
                                if (newVal == null || newVal.equals("All")) return true;
                                return t.getPriority().equals(newVal);
                            });
                        }
                    }
            );
        }

        filteredTasks = new FilteredList<>(taskList, t -> true);

        taskListView.setItems(filteredTasks);

        loadTasks();


        // -----------------------------------------------------
        // SELECT TASK
        // -----------------------------------------------------

        taskListView
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable,
                         oldTask,
                         selectedTask) -> {

                            if (selectedTask != null) {

                                taskTitleField.setText(
                                        selectedTask.getTitle()
                                );

                                taskCompletedCheckBox
                                        .setSelected(
                                                selectedTask
                                                        .isCompleted()
                                        );

                                if (taskPriorityChoice != null) {
                                    taskPriorityChoice.setValue(
                                            selectedTask.getPriority()
                                    );
                                }
                            }
                        }
                );
    }


    private void loadTasks() {

        taskList.clear();

        taskList.addAll(
                taskDAO.getAllTasks()
        );
    }


    @FXML
    private void addTask() {

        String title =
                taskTitleField
                        .getText()
                        .trim();


        if (title.isEmpty()) {

            showError(
                    "Please enter a task title."
            );

            return;
        }


        String priority =
                taskPriorityChoice != null
                        ? taskPriorityChoice.getValue()
                        : "Medium";

        TaskItem task =
                new TaskItem(
                        title,
                        taskCompletedCheckBox
                                .isSelected(),
                        priority
                );


        taskDAO.insertTask(task);

        loadTasks();

        clearTaskForm();

        showSuccess(
                "Task added successfully."
        );
    }


    @FXML
    private void updateTask() {

        TaskItem selectedTask =
                taskListView
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedTask == null) {

            showError(
                    "Please select a task first."
            );

            return;
        }


        String title =
                taskTitleField
                        .getText()
                        .trim();


        if (title.isEmpty()) {

            showError(
                    "Please enter a task title."
            );

            return;
        }


        String priority =
                taskPriorityChoice != null
                        ? taskPriorityChoice.getValue()
                        : selectedTask.getPriority();

        TaskItem updatedTask =
                new TaskItem(
                        title,
                        taskCompletedCheckBox
                                .isSelected(),
                        priority
                );


        taskDAO.updateTask(
                selectedTask.getId(),
                updatedTask
        );


        loadTasks();

        clearTaskForm();

        showSuccess(
                "Task updated successfully."
        );
    }


    @FXML
    private void deleteTask() {

        TaskItem selectedTask =
                taskListView
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedTask == null) {

            showError(
                    "Please select a task first."
            );

            return;
        }


        taskDAO.deleteTask(
                selectedTask.getId()
        );


        loadTasks();

        clearTaskForm();

        showSuccess(
                "Task deleted successfully."
        );
    }


    @FXML
    private void toggleTask() {

        TaskItem selectedTask =
                taskListView
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedTask == null) {

            showError(
                    "Please select a task first."
            );

            return;
        }


        boolean newStatus =
                !selectedTask.isCompleted();


        TaskItem updatedTask =
                new TaskItem(
                        selectedTask.getTitle(),
                        newStatus,
                        selectedTask.getPriority()
                );


        taskDAO.updateTask(
                selectedTask.getId(),
                updatedTask
        );


        loadTasks();

        taskCompletedCheckBox
                .setSelected(newStatus);


        showSuccess(
                newStatus
                        ? "Task marked as completed."
                        : "Task marked as incomplete."
        );
    }


    private void clearTaskForm() {

        taskTitleField.clear();

        taskCompletedCheckBox
                .setSelected(false);

        taskListView
                .getSelectionModel()
                .clearSelection();
    }


    // =========================================================
    // READABLE TEXT
    // =========================================================

    private void setupReadableText(Node node) {

        if (node instanceof Label) {

            Label label =
                    (Label) node;

            label.setTextFill(
                    Color.web("#E2E8F0")
            );
        }


        if (node instanceof javafx.scene.Parent) {

            for (Node child :
                    ((javafx.scene.Parent) node)
                            .getChildrenUnmodifiable()) {

                setupReadableText(child);
            }
        }
    }


    // =========================================================
    // FORM LABEL STYLE
    // =========================================================

    private void setupFormLabel(
            Label label) {

        if (label == null) {
            return;
        }

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
    private void showWelcome() {

        showPage(welcomePage);

        pageTitle.setText("Welcome");

        welcome.setText(
                "Welcome to DevFolio — your personal portfolio manager."
        );

        updatePageIndicator(0);
    }


    @FXML
    private void showDashboard() {

        showPage(dashboardPage);

        pageTitle.setText("Dashboard");

        welcome.setText(
                "Welcome back! Here's an overview of your portfolio."
        );

        updateDashboardStats();

        updatePageIndicator(1);
    }


    @FXML
    private void showProjects() {

        showPage(projectsPage);

        pageTitle.setText("Projects");

        welcome.setText(
                "Add, update and manage your portfolio projects."
        );

        updatePageIndicator(2);
    }


    @FXML
    private void showSkills() {

        showPage(skillsPage);

        pageTitle.setText("Skills");

        welcome.setText(
                "Manage your technical skills and connect them to projects."
        );

        loadSkills();

        updatePageIndicator(3);
    }


    @FXML
    private void showNotes() {

        showPage(notesPage);

        pageTitle.setText("Notes");

        welcome.setText(
                "Create and manage your portfolio notes."
        );

        updatePageIndicator(4);
    }


    @FXML
    private void showTasks() {

        showPage(tasksPage);

        pageTitle.setText("Tasks");

        welcome.setText(
                "Track your portfolio tasks and progress."
        );

        updatePageIndicator(5);
    }


    @FXML
    private void showApi() {

        showPage(apiPage);

        pageTitle.setText("API");

        welcome.setText(
                "Fetch and process data from an external API."
        );

        updatePageIndicator(6);
    }


    @FXML
    private void showSettings() {

        showPage(settingsPage);

        pageTitle.setText("Settings");

        welcome.setText(
                "Manage application settings."
        );

        updatePageIndicator(7);
    }


    // =========================================================
    // PAGE NAVIGATION CONTROLS (Next / Previous)
    // =========================================================

    @FXML
    private void showPreviousPage() {
        if (currentPageIndex > 0) {
            navigateToPageIndex(currentPageIndex - 1);
        }
    }


    @FXML
    private void showNextPage() {
        if (currentPageIndex < TOTAL_PAGES - 1) {
            navigateToPageIndex(currentPageIndex + 1);
        }
    }


    private void navigateToPageIndex(int index) {
        switch (index) {
            case 0 -> showWelcome();
            case 1 -> showDashboard();
            case 2 -> showProjects();
            case 3 -> showSkills();
            case 4 -> showNotes();
            case 5 -> showTasks();
            case 6 -> showApi();
            case 7 -> showSettings();
        }
    }


    private void updatePageIndicator(int index) {
        this.currentPageIndex = index;
        if (pageIndicatorLabel != null) {
            String[] pageNames = {
                "Welcome", "Dashboard", "Projects", "Skills",
                "Notes", "Tasks", "API", "Settings"
            };
            if (index >= 0 && index < pageNames.length) {
                pageIndicatorLabel.setText((index + 1) + " / " + TOTAL_PAGES + " : " + pageNames[index]);
            }
        }
        if (prevPageButton != null) {
            prevPageButton.setDisable(index <= 0);
        }
        if (nextPageButton != null) {
            nextPageButton.setDisable(index >= TOTAL_PAGES - 1);
        }
        updateActiveNavButtons(index);
    }

    private void updateActiveNavButtons(int activeIndex) {
        Button[] topButtons = {
            topWelcomeBtn, topDashboardBtn, topProjectsBtn, topSkillsBtn,
            topNotesBtn, topTasksBtn, topApiBtn, topSettingsBtn
        };
        for (int i = 0; i < topButtons.length; i++) {
            Button btn = topButtons[i];
            if (btn == null) continue;
            boolean isActive = (i == activeIndex);
            btn.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web(isActive ? "#2563EB" : "#1E293B"),
                                    new CornerRadii(6),
                                    Insets.EMPTY
                            )
                    )
            );
            btn.setTextFill(isActive ? Color.WHITE : Color.web("#CBD5E1"));
        }

        Button[] sideButtons = {
            welcomeButton, dashboardButton, projectsButton, skillsButton,
            notesButton, tasksButton, apiButton, settingsButton
        };
        for (int i = 0; i < sideButtons.length; i++) {
            Button btn = sideButtons[i];
            if (btn == null) continue;
            boolean isActive = (i == activeIndex);
            btn.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web(isActive ? "#2563EB" : "#111827"),
                                    new CornerRadii(8),
                                    Insets.EMPTY
                            )
                    )
            );
            btn.setTextFill(Color.WHITE);
        }
    }

    private void setupTopNavButton(Button button) {
        if (button == null) return;

        button.setPrefHeight(32);
        button.setPadding(new Insets(6, 12, 6, 12));
        button.setCursor(Cursor.HAND);
        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        12
                )
        );
        button.setTextFill(Color.web("#CBD5E1"));
        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#1E293B"),
                                new CornerRadii(6),
                                Insets.EMPTY
                        )
                )
        );

        button.setOnMouseEntered(e -> {
            button.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web("#3B82F6"),
                                    new CornerRadii(6),
                                    Insets.EMPTY
                            )
                    )
            );
            button.setTextFill(Color.WHITE);
        });

        button.setOnMouseExited(e -> updateActiveNavButtons(currentPageIndex));
    }


    private void setupPageNavigationControls() {
        setupNavControlButton(prevPageButton);
        setupNavControlButton(nextPageButton);

        if (pageIndicatorLabel != null) {
            pageIndicatorLabel.setFont(
                    Font.font("Arial", FontWeight.BOLD, 12)
            );
            pageIndicatorLabel.setTextFill(Color.web("#94A3B8"));
            pageIndicatorLabel.setPadding(new Insets(0, 6, 0, 6));
        }

        updatePageIndicator(0);
    }


    private void setupNavControlButton(Button button) {
        if (button == null) return;

        button.setPrefHeight(32);
        button.setPadding(new Insets(6, 14, 6, 14));
        button.setCursor(Cursor.HAND);
        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        12
                )
        );
        button.setTextFill(Color.WHITE);
        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#1E293B"),
                                new CornerRadii(6),
                                Insets.EMPTY
                        )
                )
        );

        button.setOnMouseEntered(e -> {
            if (!button.isDisabled()) {
                button.setBackground(
                        new Background(
                                new BackgroundFill(
                                        Color.web("#334155"),
                                        new CornerRadii(6),
                                        Insets.EMPTY
                                )
                        )
                );
            }
        });

        button.setOnMouseExited(e -> {
            button.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web("#1E293B"),
                                    new CornerRadii(6),
                                    Insets.EMPTY
                            )
                    )
            );
        });
    }


    // =========================================================
    // PORTFOLIO TOOLS
    // =========================================================

    private void setupPortfolioTools() {

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


        teamSpinner.setValueFactory(
                new SpinnerValueFactory
                        .IntegerSpinnerValueFactory(
                        1,
                        20,
                        1
                )
        );


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


        technologyTree.setRoot(
                root
        );


        portfolioProgress.setProgress(
                completionSlider
                        .getValue()
                        / 100.0
        );
    }


    // =========================================================
    // RESPONSIVE LAYOUT
    // =========================================================

    private void setupResponsiveLayout() {

        if (projectTable != null
                && content != null
                && !projectTable
                .prefWidthProperty()
                .isBound()) {

            projectTable.prefWidthProperty().bind(
                    content.widthProperty()
                            .subtract(50)
            );
        }
    }


    // =========================================================
    // FILE CHOOSER
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
    // ABOUT
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


    // =========================================================
    // WELCOME PAGE SETUP
    // =========================================================

    private void setupWelcomePage() {

        if (welcomeHero != null) {

            welcomeHero.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web("#0F172A"),
                                    new CornerRadii(16),
                                    Insets.EMPTY
                            )
                    )
            );

            welcomeHero.setPadding(
                    new Insets(40, 40, 40, 40)
            );
        }


        if (welcomeHeading != null) {

            welcomeHeading.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            42
                    )
            );

            welcomeHeading.setTextFill(
                    Color.web("#38BDF8")
            );
        }


        if (welcomeSubheading != null) {

            welcomeSubheading.setFont(
                    Font.font("Arial", 18)
            );

            welcomeSubheading.setTextFill(
                    Color.web("#CBD5E1")
            );
        }


        if (welcomeFeaturesTitle != null) {

            welcomeFeaturesTitle.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            20
                    )
            );

            welcomeFeaturesTitle.setTextFill(
                    Color.WHITE
            );
        }


        styleFeatureCard(featureCard1, featureTitle1, "📁  Projects →", this::showProjects);
        styleFeatureCard(featureCard2, featureTitle2, "🛠  Skills →", this::showSkills);
        styleFeatureCard(featureCard3, featureTitle3, "📝  Notes →", this::showNotes);
        styleFeatureCard(featureCard4, featureTitle4, "✅  Tasks →", this::showTasks);


        if (dbStatusBadge != null) {

            dbStatusBadge.setText("● Database Connected");

            dbStatusBadge.setTextFill(
                    Color.web("#4ADE80")
            );

            dbStatusBadge.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            13
                    )
            );
        }


        if (systemUptimeLabel != null) {

            systemUptimeLabel.setTextFill(
                    Color.web("#94A3B8")
            );

            systemUptimeLabel.setFont(
                    Font.font("Arial", 12)
            );
        }


        styleWelcomeNavBtn(welcomeDashBtn,   "#2563EB");
        styleWelcomeNavBtn(welcomeProjBtn,   "#7C3AED");
        styleWelcomeNavBtn(welcomeSkillsBtn, "#0D9488");
        styleWelcomeNavBtn(welcomeNotesBtn,  "#D97706");
        styleWelcomeNavBtn(welcomeTasksBtn,  "#DC2626");
    }


    private void styleFeatureCard(
            VBox card, Label title, String text, Runnable onNavigate) {

        if (card == null) return;

        card.setCursor(Cursor.HAND);

        card.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#1E293B"),
                                new CornerRadii(12),
                                Insets.EMPTY
                        )
                )
        );

        card.setPadding(
                new Insets(20, 20, 20, 20)
        );

        card.setOnMouseEntered(e -> card.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#334155"),
                                new CornerRadii(12),
                                Insets.EMPTY
                        )
                )
        ));

        card.setOnMouseExited(e -> card.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#1E293B"),
                                new CornerRadii(12),
                                Insets.EMPTY
                        )
                )
        ));

        if (onNavigate != null) {
            card.setOnMouseClicked(e -> onNavigate.run());
        }

        if (title != null) {

            title.setText(text);

            title.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            16
                    )
            );

            title.setTextFill(
                    Color.WHITE
            );
        }
    }


    private void styleWelcomeNavBtn(
            Button button, String colorHex) {

        if (button == null) return;

        button.setPrefWidth(140);

        button.setPrefHeight(44);

        button.setCursor(Cursor.HAND);

        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
        );

        button.setTextFill(Color.WHITE);

        button.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web(colorHex),
                                new CornerRadii(10),
                                Insets.EMPTY
                        )
                )
        );
    }


    // =========================================================
    // BEAUTIFUL DASHBOARD SETUP
    // =========================================================

    private void setupBeautifulDashboard() {

        if (dashOverviewTitle != null) {

            dashOverviewTitle.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            26
                    )
            );

            dashOverviewTitle.setTextFill(
                    Color.WHITE
            );
        }


        if (dashOverviewSubtitle != null) {

            dashOverviewSubtitle.setFont(
                    Font.font("Arial", 14)
            );

            dashOverviewSubtitle.setTextFill(
                    Color.web("#94A3B8")
            );
        }


        if (liveClockLabel != null) {

            liveClockLabel.setFont(
                    Font.font(
                            "Consolas",
                            FontWeight.BOLD,
                            22
                    )
            );

            liveClockLabel.setTextFill(
                    Color.web("#38BDF8")
            );
        }


        if (systemStatusBadge != null) {

            systemStatusBadge.setText("● System Online");

            systemStatusBadge.setTextFill(
                    Color.web("#4ADE80")
            );

            systemStatusBadge.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            13
                    )
            );
        }


        styleStatCard(statCard1, statLabel1, statProjectsCount, statSub1,
                "Projects →", "#3B82F6", this::showProjects);

        styleStatCard(statCard2, statLabel2, statSkillsCount, statSub2,
                "Skills →", "#8B5CF6", this::showSkills);

        styleStatCard(statCard3, statLabel3, statNotesCount, statSub3,
                "Notes →", "#F59E0B", this::showNotes);

        styleStatCard(statCard4, statLabel4, statTasksCount, statSub4,
                "Tasks →", "#10B981", this::showTasks);


        if (formattedDateLabel != null) {

            formattedDateLabel.setTextFill(
                    Color.web("#94A3B8")
            );

            formattedDateLabel.setFont(
                    Font.font("Arial", 13)
            );
        }


        updateDashboardStats();
    }


    private void styleStatCard(
            VBox card,
            Label titleLabel,
            Label countLabel,
            Label subLabel,
            String title,
            String colorHex,
            Runnable onNavigate) {

        if (card == null) return;

        card.setCursor(Cursor.HAND);

        card.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#1E293B"),
                                new CornerRadii(14),
                                Insets.EMPTY
                        )
                )
        );

        card.setPadding(
                new Insets(20, 20, 20, 20)
        );

        card.setMinWidth(160);

        card.setOnMouseEntered(e -> card.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#334155"),
                                new CornerRadii(14),
                                Insets.EMPTY
                        )
                )
        ));

        card.setOnMouseExited(e -> card.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#1E293B"),
                                new CornerRadii(14),
                                Insets.EMPTY
                        )
                )
        ));

        if (onNavigate != null) {
            card.setOnMouseClicked(e -> onNavigate.run());
        }


        if (titleLabel != null) {

            titleLabel.setText(title);

            titleLabel.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            14
                    )
            );

            titleLabel.setTextFill(
                    Color.web("#94A3B8")
            );
        }


        if (countLabel != null) {

            countLabel.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            44
                    )
            );

            countLabel.setTextFill(
                    Color.web(colorHex)
            );
        }


        if (subLabel != null) {

            subLabel.setFont(
                    Font.font("Arial", 12)
            );

            subLabel.setTextFill(
                    Color.web("#475569")
            );
        }
    }


    // =========================================================
    // DASHBOARD STATS
    // =========================================================

    private void updateDashboardStats() {

        int projects = projectDAO
                .getAllProjects()
                .size();

        int skills = skillDAO
                .getAllSkills()
                .size();

        int notes = noteDAO
                .getAllNotes()
                .size();

        int tasks = taskDAO
                .getAllTasks()
                .size();


        if (statProjectsCount != null) {
            statProjectsCount.setText(
                    String.valueOf(projects)
            );
        }

        if (statSkillsCount != null) {
            statSkillsCount.setText(
                    String.valueOf(skills)
            );
        }

        if (statNotesCount != null) {
            statNotesCount.setText(
                    String.valueOf(notes)
            );
        }

        if (statTasksCount != null) {
            statTasksCount.setText(
                    String.valueOf(tasks)
            );
        }


        if (statSub1 != null) {
            statSub1.setText("Total projects added");
        }

        if (statSub2 != null) {
            statSub2.setText("Skills recorded");
        }

        if (statSub3 != null) {
            statSub3.setText("Notes created");
        }

        if (statSub4 != null) {
            statSub4.setText("Tasks tracked");
        }
    }


    // =========================================================
    // LIVE CLOCK (Stage 26 — background daemon thread)
    // =========================================================

    private void startLiveClock() {

        Thread clockThread = new Thread(() -> {

            java.time.format.DateTimeFormatter fmt =
                    java.time.format.DateTimeFormatter
                            .ofPattern("HH:mm:ss  |  EEE, MMM d yyyy");

            while (!Thread.currentThread().isInterrupted()) {

                String time = java.time.LocalDateTime
                        .now()
                        .format(fmt);

                Platform.runLater(() -> {

                    if (liveClockLabel != null) {
                        liveClockLabel.setText(time);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        clockThread.setDaemon(true);

        clockThread.setName("LiveClock");

        clockThread.start();
    }


    // =========================================================
    // TECH BADGES (Stage 8 — FlowPane)
    // =========================================================

    private void setupTechBadges() {

        if (techBadgesPane == null) return;

        String[] techs = {
            "Java", "JavaFX", "SQLite", "Maven",
            "Git", "C++", "Python", "HTML/CSS",
            "Arduino", "FPGA", "SQL"
        };

        String[] colors = {
            "#3B82F6", "#8B5CF6", "#F59E0B", "#10B981",
            "#EC4899", "#EF4444", "#06B6D4", "#F97316",
            "#84CC16", "#A78BFA", "#67E8F9"
        };

        techBadgesPane.getChildren().clear();

        techBadgesPane.setHgap(8);

        techBadgesPane.setVgap(8);

        for (int i = 0; i < techs.length; i++) {

            Label badge = new Label(techs[i]);

            final String color = colors[i % colors.length];

            badge.setFont(
                    Font.font(
                            "Arial",
                            FontWeight.BOLD,
                            12
                    )
            );

            badge.setTextFill(Color.WHITE);

            badge.setPadding(
                    new Insets(6, 14, 6, 14)
            );

            badge.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web(color),
                                    new CornerRadii(20),
                                    Insets.EMPTY
                            )
                    )
            );

            techBadgesPane.getChildren().add(badge);
        }
    }


    // =========================================================
    // DATE PICKER FORMATTER (Stage 12)
    // =========================================================

    private void setupDatePickerFormatter() {

        if (projectDatePicker == null
                || formattedDateLabel == null) return;

        projectDatePicker
                .valueProperty()
                .addListener(
                        (obs, oldDate, newDate) -> {

                            if (newDate != null) {

                                java.time.format.DateTimeFormatter fmt =
                                        java.time.format.DateTimeFormatter
                                                .ofPattern("MMMM d, yyyy");

                                formattedDateLabel.setText(
                                        "Selected: "
                                                + newDate.format(fmt)
                                );

                            } else {

                                formattedDateLabel.setText("");
                            }
                        }
                );
    }


    // =========================================================
    // OPEN PROJECT IN NEW WINDOW (Stages 18 & 19)
    // =========================================================

    @FXML
    private void openProjectPreviewWindow() {

        Project selected = projectTable
                .getSelectionModel()
                .getSelectedItem();

        if (selected == null) {

            showError("Please select a project to preview.");

            return;
        }

        try {

            java.net.URL fxmlUrl =
                    getClass().getResource("preview.fxml");

            if (fxmlUrl == null) {

                showError("preview.fxml not found.");

                return;
            }

            FXMLLoader loader =
                    new FXMLLoader(fxmlUrl);

            javafx.scene.Parent root =
                    loader.load();

            PreviewController controller =
                    loader.getController();

            controller.initData(
                    selected.getTitle(),
                    selected.getTechnology(),
                    selected.getDescription(),
                    selected.getGithubLink()
            );

            Stage previewStage = new Stage();

            previewStage.setTitle(
                    "Project Preview — "
                            + selected.getTitle()
            );

            previewStage.setScene(
                    new Scene(root, 500, 420)
            );

            previewStage.show();

        } catch (Exception e) {

            showError(
                    "Could not open preview: "
                            + e.getMessage()
            );
        }
    }


    // =========================================================
    // PROJECT SEARCH / FILTER
    // =========================================================

    private void setupProjectSearch() {

        if (projectSearchField == null) return;

        setupTextField(projectSearchField);

        if (clearSearchButton != null) {
            setupActionButton(clearSearchButton);
        }

        projectSearchField.textProperty().addListener(
                (obs, oldVal, newVal) -> {

                    String lower = newVal.toLowerCase().trim();

                    filteredProjects.setPredicate(p -> {

                        if (lower.isEmpty()) return true;

                        return p.getTitle().toLowerCase().contains(lower)
                                || p.getTechnology().toLowerCase().contains(lower)
                                || p.getDescription().toLowerCase().contains(lower);
                    });
                }
        );
    }

    @FXML
    private void clearProjectSearch() {

        if (projectSearchField != null) {
            projectSearchField.clear();
        }
    }


    // =========================================================
    // SKILLS PIE CHART
    // =========================================================

    private void updateSkillsPieChart() {

        if (skillsPieChart == null) return;

        if (skillList.isEmpty()) {
            skillsPieChart.getData().clear();
            return;
        }

        Map<String, Integer> categoryCount = new LinkedHashMap<>();

        for (Skill s : skillList) {

            String cat = s.getCategory() == null || s.getCategory().isBlank()
                    ? "Uncategorized"
                    : s.getCategory();

            categoryCount.merge(cat, 1, Integer::sum);
        }

        ObservableList<PieChart.Data> chartData =
                FXCollections.observableArrayList();

        for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
            chartData.add(
                    new PieChart.Data(
                            entry.getKey() + " (" + entry.getValue() + ")",
                            entry.getValue()
                    )
            );
        }

        skillsPieChart.setData(chartData);

        skillsPieChart.setTitle("Skills by Category");

        skillsPieChart.setLabelsVisible(true);
    }
}

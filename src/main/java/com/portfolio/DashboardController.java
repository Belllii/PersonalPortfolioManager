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
    // PAGE VISIBILITY
    // =========================================================

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

        projectTable.setItems(
                projectList
        );

        loadProjects();


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

        showPage(dashboardPage);
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

        taskListView.setItems(
                taskList
        );

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


        TaskItem task =
                new TaskItem(
                        title,
                        taskCompletedCheckBox
                                .isSelected()
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


        TaskItem updatedTask =
                new TaskItem(
                        title,
                        taskCompletedCheckBox
                                .isSelected()
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
                        newStatus
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
                "Manage your technical skills and connect them to projects."
        );

        loadSkills();
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
}
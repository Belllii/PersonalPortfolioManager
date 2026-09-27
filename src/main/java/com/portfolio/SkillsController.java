package com.portfolio;

import com.portfolio.database.SkillDAO;
import com.portfolio.database.ProjectDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SkillsController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField categoryField;

    @FXML
    private Slider levelSlider;

    @FXML
    private Label levelLabel;

    @FXML
    private ListView<Skill> skillList;

    @FXML
    private ComboBox<Project> projectComboBox;

    @FXML
    private ListView<Skill> projectSkillList;

    private final SkillDAO skillDAO = new SkillDAO();
    private final ProjectDAO projectDAO = new ProjectDAO();

    private final ObservableList<Skill> skills =
            FXCollections.observableArrayList();

    private final ObservableList<Project> projects =
            FXCollections.observableArrayList();

    private Skill selectedSkill;

    @FXML
    public void initialize() {

        levelSlider.setMin(0);
        levelSlider.setMax(100);
        levelSlider.setValue(50);

        levelLabel.setText("50%");

        levelSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    levelLabel.setText(
                            String.valueOf(newValue.intValue()) + "%"
                    );
                }
        );

        skillList.setItems(skills);
        projectComboBox.setItems(projects);

        loadSkills();
        loadProjects();

        skillList.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldSkill, newSkill) -> {

                            if (newSkill != null) {
                                selectedSkill = newSkill;

                                nameField.setText(
                                        newSkill.getName()
                                );

                                categoryField.setText(
                                        newSkill.getCategory()
                                );

                                levelSlider.setValue(
                                        newSkill.getLevel()
                                );
                            }
                        }
                );

        projectComboBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldProject, newProject) -> {

                            if (newProject != null) {
                                loadProjectSkills(
                                        newProject.getId()
                                );
                            }
                        }
                );
    }

    private void loadSkills() {

        skills.setAll(
                skillDAO.getAllSkills()
        );
    }

    private void loadProjects() {

        projects.setAll(
                projectDAO.getAllProjects()
        );
    }

    @FXML
    private void addSkill() {

        String name = nameField.getText().trim();
        String category = categoryField.getText().trim();

        if (name.isEmpty()) {
            showMessage("Please enter a skill name.");
            return;
        }

        Skill skill = new Skill(
                name,
                category,
                (int) levelSlider.getValue()
        );

        skillDAO.insertSkill(skill);

        loadSkills();
        clearFields();
    }

    @FXML
    private void updateSkill() {

        if (selectedSkill == null) {
            showMessage("Please select a skill first.");
            return;
        }

        String name = nameField.getText().trim();
        String category = categoryField.getText().trim();

        if (name.isEmpty()) {
            showMessage("Please enter a skill name.");
            return;
        }

        Skill updatedSkill = new Skill(
                name,
                category,
                (int) levelSlider.getValue()
        );

        skillDAO.updateSkill(
                selectedSkill.getId(),
                updatedSkill
        );

        loadSkills();
        clearFields();
    }

    @FXML
    private void deleteSkill() {

        if (selectedSkill == null) {
            showMessage("Please select a skill first.");
            return;
        }

        skillDAO.deleteSkill(
                selectedSkill.getId()
        );

        loadSkills();
        clearFields();
    }

    @FXML
    private void assignSkill() {

        Project selectedProject =
                projectComboBox.getValue();

        Skill selected =
                skillList.getSelectionModel()
                        .getSelectedItem();

        if (selectedProject == null) {
            showMessage("Please select a project.");
            return;
        }

        if (selected == null) {
            showMessage("Please select a skill.");
            return;
        }

        skillDAO.assignSkillToProject(
                selectedProject.getId(),
                selected.getId()
        );

        loadProjectSkills(
                selectedProject.getId()
        );
    }

    private void loadProjectSkills(int projectId) {

        projectSkillList.setItems(
                FXCollections.observableArrayList(
                        skillDAO.getSkillsForProject(projectId)
                )
        );
    }

    @FXML
    private void clearFields() {

        nameField.clear();
        categoryField.clear();

        levelSlider.setValue(50);

        selectedSkill = null;

        skillList.getSelectionModel()
                .clearSelection();
    }

    private void showMessage(String message) {

        Alert alert = new Alert(
                Alert.AlertType.INFORMATION
        );

        alert.setTitle("Portfolio Manager");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

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
    private ListView<String> skillList = new ListView<>();
    private ListView<String> noteList = new ListView<>();

    @Override
    public void start(Stage stage) {

        Label heading =
                new Label("Personal Portfolio Manager");


        // ================= PROJECT SECTION =================

        TextField titleField =
                new TextField();

        titleField.setPromptText("Project Title");

        TextArea descriptionField =
                new TextArea();

        descriptionField.setPromptText(
                "Project Description"
        );

        TextField githubField =
                new TextField();

        githubField.setPromptText(
                "GitHub Repository Link"
        );

        Button addButton =
                new Button("Add Project");

        Button deleteButton =
                new Button("Delete Selected Project");

        Label projectMessage =
                new Label();


        // ADD PROJECT
        addButton.setOnAction(e -> {

            String title = titleField.getText();
            String description = descriptionField.getText();
            String github = githubField.getText();

            if (title.isEmpty() ||
                    description.isEmpty() ||
                    github.isEmpty()) {

                projectMessage.setText(
                        "Please fill in all fields."
                );

            } else {

                Project project =
                        new Project(
                                title,
                                description,
                                github
                        );

                projects.add(project);

                projectList.getItems()
                        .add(project.getTitle());

                projectMessage.setText(
                        "Project added successfully."
                );

                titleField.clear();
                descriptionField.clear();
                githubField.clear();
            }
        });


        // DELETE PROJECT
        deleteButton.setOnAction(e -> {

            int selectedIndex =
                    projectList.getSelectionModel()
                            .getSelectedIndex();

            if (selectedIndex == -1) {

                projectMessage.setText(
                        "Please select a project to delete."
                );

            } else {

                projects.remove(selectedIndex);

                projectList.getItems()
                        .remove(selectedIndex);

                projectMessage.setText(
                        "Project deleted successfully."
                );
            }
        });


        Label dashboardLabel =
                new Label("Project Dashboard");


        // ================= SKILLS SECTION =================

        Label skillsLabel =
                new Label("Skills");

        TextField skillField =
                new TextField();

        skillField.setPromptText(
                "Enter a skill"
        );

        Button addSkillButton =
                new Button("Add Skill");

        Button deleteSkillButton =
                new Button(
                        "Delete Selected Skill"
                );

        Label skillMessage =
                new Label();


        // ADD SKILL
        addSkillButton.setOnAction(e -> {

            String skill =
                    skillField.getText();

            if (skill.isEmpty()) {

                skillMessage.setText(
                        "Please enter a skill."
                );

            } else {

                skillList.getItems()
                        .add(skill);

                skillMessage.setText(
                        "Skill added successfully."
                );

                skillField.clear();
            }
        });


        // DELETE SKILL
        deleteSkillButton.setOnAction(e -> {

            int selectedIndex =
                    skillList.getSelectionModel()
                            .getSelectedIndex();

            if (selectedIndex == -1) {

                skillMessage.setText(
                        "Please select a skill to delete."
                );

            } else {

                skillList.getItems()
                        .remove(selectedIndex);

                skillMessage.setText(
                        "Skill deleted successfully."
                );
            }
        });


        // ================= NOTES / TO-DO =================

        Label notesLabel =
                new Label("Notes / To-Do");

        TextField noteField =
                new TextField();

        noteField.setPromptText(
                "Enter a note or task"
        );

        Button addNoteButton =
                new Button("Add Note");

        Button deleteNoteButton =
                new Button(
                        "Delete Selected Note"
                );

        Label noteMessage =
                new Label();


        // ADD NOTE
        addNoteButton.setOnAction(e -> {

            String note =
                    noteField.getText();

            if (note.isEmpty()) {

                noteMessage.setText(
                        "Please enter a note."
                );

            } else {

                noteList.getItems()
                        .add(note);

                noteMessage.setText(
                        "Note added successfully."
                );

                noteField.clear();
            }
        });


        // DELETE NOTE
        deleteNoteButton.setOnAction(e -> {

            int selectedIndex =
                    noteList.getSelectionModel()
                            .getSelectedIndex();

            if (selectedIndex == -1) {

                noteMessage.setText(
                        "Please select a note to delete."
                );

            } else {

                noteList.getItems()
                        .remove(selectedIndex);

                noteMessage.setText(
                        "Note deleted successfully."
                );
            }
        });


        // ================= LAYOUT =================

        VBox layout =
                new VBox(10);

        layout.getChildren().addAll(

                heading,

                // Projects
                titleField,
                descriptionField,
                githubField,

                addButton,
                deleteButton,

                projectMessage,

                dashboardLabel,
                projectList,

                // Skills
                skillsLabel,

                skillField,
                addSkillButton,
                deleteSkillButton,

                skillMessage,

                skillList,

                // Notes
                notesLabel,

                noteField,
                addNoteButton,
                deleteNoteButton,

                noteMessage,

                noteList
        );


        Scene scene =
                new Scene(layout, 600, 800);

        stage.setTitle(
                "Personal Portfolio Manager"
        );

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
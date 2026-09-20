package portfolio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private ArrayList<Project> projects = new ArrayList<>();

    private ListView<String> projectList = new ListView<>();
    private ListView<String> skillList = new ListView<>();
    private ListView<String> noteList = new ListView<>();

    @Override
    public void start(Stage stage) {

        // ================= MAIN HEADING =================

        Label heading =
                new Label("Personal Portfolio Manager");

        heading.setStyle(
                "-fx-font-size: 24px; " +
                        "-fx-font-weight: bold;"
        );


        Label subtitle =
                new Label(
                        "Manage your projects, skills and tasks"
                );

        subtitle.setStyle(
                "-fx-font-size: 14px;"
        );


        // ================= PROJECT SECTION =================

        Label projectSection =
                new Label("Projects");

        projectSection.setStyle(
                "-fx-font-size: 18px; " +
                        "-fx-font-weight: bold;"
        );


        TextField titleField =
                new TextField();

        titleField.setPromptText(
                "Project Title"
        );


        TextArea descriptionField =
                new TextArea();

        descriptionField.setPromptText(
                "Project Description"
        );

        descriptionField.setPrefRowCount(3);


        TextField githubField =
                new TextField();

        githubField.setPromptText(
                "GitHub Repository Link"
        );


        Button addButton =
                new Button("Add Project");


        Button deleteButton =
                new Button(
                        "Delete Selected Project"
                );


        Label projectMessage =
                new Label();


        // ADD PROJECT
        addButton.setOnAction(e -> {

            String title =
                    titleField.getText();

            String description =
                    descriptionField.getText();

            String github =
                    githubField.getText();


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

            String selectedTitle =
                    projectList.getSelectionModel()
                            .getSelectedItem();


            if (selectedTitle == null) {

                projectMessage.setText(
                        "Please select a project to delete."
                );

            } else {

                for (int i = 0;
                     i < projects.size();
                     i++) {

                    if (projects.get(i)
                            .getTitle()
                            .equals(selectedTitle)) {

                        projects.remove(i);
                        break;
                    }
                }


                projectList.getItems()
                        .remove(selectedTitle);


                projectMessage.setText(
                        "Project deleted successfully."
                );
            }
        });


        // SEARCH
        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search projects..."
        );


        searchField.textProperty()
                .addListener(
                        (observable,
                         oldValue,
                         newValue) -> {

                            projectList.getItems()
                                    .clear();


                            for (Project project :
                                    projects) {

                                if (project.getTitle()
                                        .toLowerCase()
                                        .contains(
                                                newValue
                                                        .toLowerCase()
                                        )) {

                                    projectList.getItems()
                                            .add(
                                                    project.getTitle()
                                            );
                                }
                            }
                        });


        projectList.setPrefHeight(150);


        HBox projectButtons =
                new HBox(10);

        projectButtons.getChildren()
                .addAll(
                        addButton,
                        deleteButton
                );


        // ================= SKILLS =================

        Label skillsSection =
                new Label("Skills");

        skillsSection.setStyle(
                "-fx-font-size: 18px; " +
                        "-fx-font-weight: bold;"
        );


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


        skillList.setPrefHeight(120);


        HBox skillButtons =
                new HBox(10);

        skillButtons.getChildren()
                .addAll(
                        addSkillButton,
                        deleteSkillButton
                );


        // ================= NOTES =================

        Label notesSection =
                new Label("Notes / To-Do");

        notesSection.setStyle(
                "-fx-font-size: 18px; " +
                        "-fx-font-weight: bold;"
        );


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


        noteList.setPrefHeight(120);


        HBox noteButtons =
                new HBox(10);

        noteButtons.getChildren()
                .addAll(
                        addNoteButton,
                        deleteNoteButton
                );


        // ================= SAVE / LOAD =================

        Button saveButton =
                new Button("Save Data");


        Button loadButton =
                new Button("Load Data");


        Label dataMessage =
                new Label();


        saveButton.setOnAction(e -> {

            saveData();

            dataMessage.setText(
                    "Data saved successfully."
            );
        });


        loadButton.setOnAction(e -> {

            loadData();

            dataMessage.setText(
                    "Data loaded successfully."
            );
        });


        HBox dataButtons =
                new HBox(10);

        dataButtons.getChildren()
                .addAll(
                        saveButton,
                        loadButton
                );


        // ================= MAIN LAYOUT =================

        VBox layout =
                new VBox(15);


        layout.setPadding(
                new Insets(20)
        );


        layout.getChildren().addAll(

                heading,
                subtitle,

                // Projects
                projectSection,

                titleField,
                descriptionField,
                githubField,

                projectButtons,

                projectMessage,

                new Label("Project Dashboard"),

                searchField,
                projectList,

                // Skills
                skillsSection,

                skillField,
                skillButtons,

                skillMessage,

                skillList,

                // Notes
                notesSection,

                noteField,
                noteButtons,

                noteMessage,

                noteList,

                // Save / Load
                dataButtons,

                dataMessage
        );


        // ================= SCROLL =================

        ScrollPane scrollPane =
                new ScrollPane(layout);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );


        // ================= SCENE =================

        Scene scene =
                new Scene(
                        scrollPane,
                        700,
                        750
                );


        stage.setTitle(
                "Personal Portfolio Manager"
        );

        stage.setScene(scene);

        stage.show();


        // Automatically load saved data
        loadData();
    }


    // ====================================================
    // SAVE DATA
    // ====================================================

    private void saveData() {

        try {

            FileWriter writer =
                    new FileWriter(
                            "portfolio_data.txt"
                    );


            writer.write("PROJECTS\n");


            for (Project project :
                    projects) {

                writer.write(
                        project.getTitle() +
                                "|" +
                                project.getDescription() +
                                "|" +
                                project.getGithubLink() +
                                "\n"
                );
            }


            writer.write("SKILLS\n");


            for (String skill :
                    skillList.getItems()) {

                writer.write(
                        skill + "\n"
                );
            }


            writer.write("NOTES\n");


            for (String note :
                    noteList.getItems()) {

                writer.write(
                        note + "\n"
                );
            }


            writer.close();


        } catch (IOException ex) {

            System.out.println(
                    "Error saving data."
            );
        }
    }


    // ====================================================
    // LOAD DATA
    // ====================================================

    private void loadData() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "portfolio_data.txt"
                            )
                    );


            String line;
            String section = "";


            projects.clear();

            projectList.getItems()
                    .clear();

            skillList.getItems()
                    .clear();

            noteList.getItems()
                    .clear();


            while (
                    (line = reader.readLine())
                            != null
            ) {

                if (line.equals("PROJECTS")) {

                    section = "PROJECTS";
                    continue;
                }


                if (line.equals("SKILLS")) {

                    section = "SKILLS";
                    continue;
                }


                if (line.equals("NOTES")) {

                    section = "NOTES";
                    continue;
                }


                if (section.equals("PROJECTS")) {

                    String[] data =
                            line.split(
                                    "\\|",
                                    -1
                            );


                    if (data.length == 3) {

                        Project project =
                                new Project(
                                        data[0],
                                        data[1],
                                        data[2]
                                );


                        projects.add(project);


                        projectList.getItems()
                                .add(
                                        project.getTitle()
                                );
                    }
                }


                else if (
                        section.equals("SKILLS")
                ) {

                    skillList.getItems()
                            .add(line);
                }


                else if (
                        section.equals("NOTES")
                ) {

                    noteList.getItems()
                            .add(line);
                }
            }


            reader.close();


        } catch (IOException ex) {

            System.out.println(
                    "No saved data found."
            );
        }
    }


    public static void main(String[] args) {

        launch(args);
    }
}
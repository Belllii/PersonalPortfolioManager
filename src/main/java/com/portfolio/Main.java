package com.portfolio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    // ---------- COLORS ----------
    private final Color DARK = Color.web("#0F172A");
    private final Color SIDEBAR = Color.web("#111827");
    private final Color CARD = Color.web("#1E293B");
    private final Color BLUE = Color.web("#2563EB");
    private final Color LIGHT_BLUE = Color.web("#38BDF8");
    private final Color WHITE = Color.WHITE;
    private final Color GRAY = Color.web("#94A3B8");


    @Override
    public void start(Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        Label logo = new Label("DEVFOLIO");

        logo.setFont(
                Font.font("Arial", FontWeight.BOLD, 25)
        );

        logo.setTextFill(LIGHT_BLUE);


        Label menuTitle = new Label("MAIN MENU");

        menuTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 11)
        );

        menuTitle.setTextFill(GRAY);


        Button dashboardButton = createMenuButton("⌂   Dashboard");
        Button projectsButton = createMenuButton("▣   Projects");
        Button skillsButton = createMenuButton("★   Skills");
        Button notesButton = createMenuButton("▤   Notes");
        Button tasksButton = createMenuButton("✓   Tasks");
        Button apiButton = createMenuButton("↗   API Data");
        Button settingsButton = createMenuButton("⚙   Settings");


        // Highlight dashboard
        dashboardButton.setBackground(
                new Background(
                        new BackgroundFill(
                                BLUE,
                                new CornerRadii(8),
                                Insets.EMPTY
                        )
                )
        );


        VBox sidebar = new VBox(
                15,
                logo,
                menuTitle,
                dashboardButton,
                projectsButton,
                skillsButton,
                notesButton,
                tasksButton,
                apiButton,
                settingsButton
        );

        sidebar.setPadding(
                new Insets(30, 20, 30, 20)
        );

        sidebar.setPrefWidth(220);

        sidebar.setBackground(
                new Background(
                        new BackgroundFill(
                                SIDEBAR,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );


        // =====================================================
        // DASHBOARD HEADER
        // =====================================================

        Label pageTitle = new Label("Dashboard");

        pageTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 30)
        );

        pageTitle.setTextFill(WHITE);


        Label welcome = new Label(
                "Welcome back! Here's an overview of your portfolio."
        );

        welcome.setFont(
                Font.font("Arial", 14)
        );

        welcome.setTextFill(GRAY);


        VBox header = new VBox(
                6,
                pageTitle,
                welcome
        );


        // =====================================================
        // STATISTICS CARDS
        // =====================================================

        VBox projectCard = createStatCard(
                "PROJECTS",
                "6",
                "Coding projects"
        );

        VBox skillCard = createStatCard(
                "SKILLS",
                "12",
                "Technical skills"
        );

        VBox taskCard = createStatCard(
                "TASKS",
                "8",
                "Pending tasks"
        );


        HBox statistics = new HBox(
                20,
                projectCard,
                skillCard,
                taskCard
        );


        // =====================================================
        // RECENT PROJECTS
        // =====================================================

        Label recentTitle = new Label("Recent Projects");

        recentTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 20)
        );

        recentTitle.setTextFill(WHITE);


        VBox project1 = createProjectRow(
                "ConnectSphere",
                "C++ / Data Structures"
        );

        VBox project2 = createProjectRow(
                "Smart Energy System",
                "Arduino / Embedded System"
        );

        VBox project3 = createProjectRow(
                "13-bit Mini Computer",
                "Logisim / Computer Architecture"
        );


        VBox projectList = new VBox(
                12,
                project1,
                project2,
                project3
        );


        VBox recentProjects = new VBox(
                15,
                recentTitle,
                projectList
        );


        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox content = new VBox(
                30,
                header,
                statistics,
                recentProjects
        );

        content.setPadding(
                new Insets(35)
        );

        content.setBackground(
                new Background(
                        new BackgroundFill(
                                DARK,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );


        // =====================================================
        // ROOT LAYOUT
        // =====================================================

        BorderPane root = new BorderPane();

        root.setLeft(sidebar);
        root.setCenter(content);


        // =====================================================
        // SCENE
        // =====================================================

        Scene scene = new Scene(
                root,
                1100,
                700
        );


        stage.setTitle(
                "DevFolio - Personal Portfolio Manager"
        );

        stage.setScene(scene);

        stage.setMinWidth(900);
        stage.setMinHeight(600);

        stage.show();
    }


    // =========================================================
    // CREATE SIDEBAR BUTTON
    // =========================================================

    private Button createMenuButton(String text) {

        Button button = new Button(text);

        button.setPrefWidth(180);
        button.setPrefHeight(42);

        button.setAlignment(Pos.CENTER_LEFT);

        button.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        button.setTextFill(WHITE);

        button.setBackground(
                new Background(
                        new BackgroundFill(
                                SIDEBAR,
                                new CornerRadii(8),
                                Insets.EMPTY
                        )
                )
        );

        return button;
    }


    // =========================================================
    // CREATE STATISTICS CARD
    // =========================================================

    private VBox createStatCard(
            String title,
            String number,
            String description) {

        Label titleLabel = new Label(title);

        titleLabel.setFont(
                Font.font("Arial", FontWeight.BOLD, 11)
        );

        titleLabel.setTextFill(GRAY);


        Label numberLabel = new Label(number);

        numberLabel.setFont(
                Font.font("Arial", FontWeight.BOLD, 32)
        );

        numberLabel.setTextFill(LIGHT_BLUE);


        Label descriptionLabel = new Label(description);

        descriptionLabel.setFont(
                Font.font("Arial", 12)
        );

        descriptionLabel.setTextFill(GRAY);


        VBox card = new VBox(
                8,
                titleLabel,
                numberLabel,
                descriptionLabel
        );

        card.setPadding(
                new Insets(20)
        );

        card.setPrefWidth(210);
        card.setPrefHeight(140);


        card.setBackground(
                new Background(
                        new BackgroundFill(
                                CARD,
                                new CornerRadii(12),
                                Insets.EMPTY
                        )
                )
        );


        return card;
    }


    // =========================================================
    // CREATE PROJECT ROW
    // =========================================================

    private VBox createProjectRow(
            String projectName,
            String technology) {

        Label name = new Label(projectName);

        name.setFont(
                Font.font("Arial", FontWeight.BOLD, 15)
        );

        name.setTextFill(WHITE);


        Label tech = new Label(technology);

        tech.setFont(
                Font.font("Arial", 12)
        );

        tech.setTextFill(GRAY);


        VBox row = new VBox(
                5,
                name,
                tech
        );

        row.setPadding(
                new Insets(15)
        );

        row.setBackground(
                new Background(
                        new BackgroundFill(
                                CARD,
                                new CornerRadii(8),
                                Insets.EMPTY
                        )
                )
        );


        return row;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
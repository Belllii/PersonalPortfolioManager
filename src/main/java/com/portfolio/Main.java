package com.portfolio;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Title
        Label title = new Label("DEVFOLIO");

        title.setFont(
                Font.font("Arial", FontWeight.BOLD, 40)
        );

        title.setTextFill(
                Color.web("#38BDF8")
        );


        // Subtitle
        Label subtitle = new Label(
                "Personal Portfolio Manager"
        );

        subtitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 22)
        );

        subtitle.setTextFill(Color.WHITE);


        // Description
        Label description = new Label(
                "Organize your coding projects, skills, notes and tasks."
        );

        description.setFont(
                Font.font("Arial", 15)
        );

        description.setTextFill(Color.LIGHTGRAY);


        // Button
        Button startButton = new Button(
                "Get Started"
        );

        startButton.setPrefWidth(160);
        startButton.setPrefHeight(45);

        startButton.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        14
                )
        );

        startButton.setTextFill(Color.WHITE);

        startButton.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#2563EB"),
                                new CornerRadii(10),
                                Insets.EMPTY
                        )
                )
        );


        // Layout
        VBox layout = new VBox(
                15,
                title,
                subtitle,
                description,
                startButton
        );

        layout.setAlignment(Pos.CENTER);

        layout.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#0F172A"),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );


        // Scene
        Scene scene = new Scene(
                layout,
                1000,
                650
        );


        // Stage
        stage.setTitle(
                "DevFolio - Personal Portfolio Manager"
        );

        stage.setScene(scene);

        stage.setMinWidth(900);
        stage.setMinHeight(600);

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

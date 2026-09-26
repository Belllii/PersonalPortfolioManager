package com.portfolio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.portfolio.database.Database;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Database.createTables();

        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/com/portfolio/dashboard.fxml")
        );

        BorderPane root = loader.load();

        root.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#0F172A"),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );

        Scene scene = new Scene(
                root,
                1100,
                700
        );

        stage.setTitle("DevFolio - Personal Portfolio Manager");
        stage.setScene(scene);

        stage.setMinWidth(900);
        stage.setMinHeight(600);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
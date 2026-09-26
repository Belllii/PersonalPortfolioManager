package com.portfolio;

import com.portfolio.database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Database.createTables();

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            Main.class.getResource(
                                    "/com/portfolio/dashboard.fxml"
                            )
                    );

            Scene scene =
                    new Scene(
                            loader.load(),
                            1200,
                            750
                    );

            stage.setTitle(
                    "DevFolio - Personal Portfolio Manager"
            );

            stage.setScene(scene);

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        launch();
    }
}
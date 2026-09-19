package portfolio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Personal Portfolio Manager");
        Label message = new Label("Manage your coding projects and skills.");

        VBox layout = new VBox(15);
        layout.getChildren().addAll(title, message);

        Scene scene = new Scene(layout, 600, 400);

        stage.setTitle("Personal Portfolio Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
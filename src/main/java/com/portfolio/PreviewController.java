package com.portfolio;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
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

/**
 * Controller for secondary preview scene.
 * Covers Roadmap Stage 18 (Scene switching) & Stage 19 (Passing data from TextField to second scene).
 */
public class PreviewController {

    @FXML
    private VBox rootContainer;

    @FXML
    private Label previewHeading;

    @FXML
    private Label titleLabel;

    @FXML
    private Label techLabel;

    @FXML
    private Label descLabel;

    @FXML
    private Label githubLabel;

    @FXML
    private Button closeButton;

    @FXML
    public void initialize() {
        if (rootContainer != null) {
            rootContainer.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web("#0F172A"),
                                    CornerRadii.EMPTY,
                                    Insets.EMPTY
                            )
                    )
            );
        }

        if (previewHeading != null) {
            previewHeading.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            previewHeading.setTextFill(Color.web("#38BDF8"));
        }

        if (closeButton != null) {
            closeButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
            closeButton.setTextFill(Color.WHITE);
            closeButton.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.web("#2563EB"),
                                    new CornerRadii(8),
                                    Insets.EMPTY
                            )
                    )
            );
        }
    }

    /**
     * Receives data passed from the primary scene's TextFields.
     */
    public void initData(String title, String tech, String desc, String github) {
        if (titleLabel != null) {
            titleLabel.setText("Title: " + (title.isEmpty() ? "Untitled Project" : title));
            titleLabel.setTextFill(Color.WHITE);
            titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        }

        if (techLabel != null) {
            techLabel.setText("Technology: " + (tech.isEmpty() ? "N/A" : tech));
            techLabel.setTextFill(Color.web("#38BDF8"));
            techLabel.setFont(Font.font("Arial", 14));
        }

        if (descLabel != null) {
            descLabel.setText("Description:\n" + (desc.isEmpty() ? "No description provided." : desc));
            descLabel.setTextFill(Color.web("#CBD5E1"));
            descLabel.setFont(Font.font("Arial", 14));
        }

        if (githubLabel != null) {
            githubLabel.setText("GitHub: " + (github.isEmpty() ? "Not specified" : github));
            githubLabel.setTextFill(Color.web("#94A3B8"));
            githubLabel.setFont(Font.font("Arial", 13));
        }
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

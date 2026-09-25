package com.portfolio;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardController {

    @FXML
    private VBox sidebar;

    @FXML
    private VBox content;

    @FXML
    private Label logo;

    @FXML
    private Label menuTitle;

    @FXML
    private Label pageTitle;

    @FXML
    private Label welcome;


    @FXML
    public void initialize() {

        logo.setFont(
                Font.font("Arial", FontWeight.BOLD, 25)
        );

        logo.setTextFill(
                Color.web("#38BDF8")
        );


        menuTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 11)
        );

        menuTitle.setTextFill(
                Color.web("#94A3B8")
        );


        pageTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 30)
        );

        pageTitle.setTextFill(Color.WHITE);


        welcome.setFont(
                Font.font("Arial", 14)
        );

        welcome.setTextFill(
                Color.web("#94A3B8")
        );
    }
}
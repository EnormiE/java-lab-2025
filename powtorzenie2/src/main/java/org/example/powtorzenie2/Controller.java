package org.example.powtorzenie2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onStartServerClicked(ActionEvent actionEvent) {
    }

    public void onConnectClicked(ActionEvent actionEvent) {
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
    }
}
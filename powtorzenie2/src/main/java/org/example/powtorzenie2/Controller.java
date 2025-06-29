package org.example.powtorzenie2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.example.powtorzenie2.client.ServerThread;
import org.example.powtorzenie2.server.Server;

import java.io.IOException;

public class Controller {

    @FXML
    private ColorPicker colorPicker; // odpowiada linijce `<ColorPicker fx:id="colorPicker">` z app-view.fxml
    @FXML
    private Slider radiusSlider;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField portField;
    @FXML
    private TextField addressField;

    private ServerThread serverThread;


    public void onStartServerClicked(ActionEvent actionEvent) {
        try {
            String address = addressField.getText();
            String port = portField.getText();
            Server server = new Server(Integer.parseInt(port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onConnectClicked(ActionEvent actionEvent) {
        String address = addressField.getText();
        String port = portField.getText();
        serverThread = new ServerThread(address, port);
        serverThread.start(); // ważne!
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        double x =  mouseEvent.getX();
        double y =  mouseEvent.getY();

        Color color = colorPicker.getValue();
        double radius = radiusSlider.getValue();
        Canvas currentCanvas = canvas;
        System.out.println("Wybrany kolor: " + color.toString());
        System.out.println("Wybrany radius: " + radius);
        System.out.println("Obecna kanwa: " + currentCanvas.getWidth() + " x " + currentCanvas.getHeight());

        GraphicsContext context = currentCanvas.getGraphicsContext2D();
        context.setFill(color);

        // rysuje owal wpisany w prostokąt
        context.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        // x i y przesunięte o promień w celu wyśrodkowania
        // wysokość i szerokośc to dwukrotności promienia (średnica == 2 długości promienia)

//        serverThread.send(color.toString() + "|" + radius); // wysyła do serwera, tylko jak jesteś klientem
    }
}
package org.example.kolo2powtjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
//    public boolean win = false;
    Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        GameCanvas gameCanvas = new GameCanvas(512, 512, this::end);
        gameCanvas.draw();

        StackPane root = new StackPane(gameCanvas);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Gra");
        primaryStage.setScene(scene);
        primaryStage.show();

//        end(primaryStage);
    }

    public void end(boolean win) {
        EndCanvas endCanvas = new EndCanvas(512, 512);
        endCanvas.draw();

        Label endMessage = new Label(win ? "Wygranko :D" : "Przegranko :<");
        endMessage.setTranslateX(0);
        endMessage.setTranslateY(-100);
        endMessage.setStyle("-fx-font-size: 20px; -fx-text-fill: " + (win ? "green;" : "red;"));

        Button closeButton = new Button("Wyjście");
        closeButton.setOnAction(e -> {
            System.out.println("Closed by in-game button");
            primaryStage.close();
        });

        StackPane root = new StackPane(endCanvas, endMessage, closeButton);
        Scene scene = new Scene(root);

        primaryStage.setTitle(win ? "Gratulacje użytkowniku, wygrałeś..." : "Bambik");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

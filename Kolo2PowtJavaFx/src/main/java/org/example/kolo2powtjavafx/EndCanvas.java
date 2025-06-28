package org.example.kolo2powtjavafx;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;

public class EndCanvas extends Canvas {

    private final GraphicsContext graphicsContext;


    public EndCanvas(double width, double height) {
        super(width, height);
        this.graphicsContext = getGraphicsContext2D();
        GraphicsItem.setCanvasSize(width, height);
    }

    private void handleMouseMoved(javafx.scene.input.MouseEvent mouseEvent) {
//        paddle.moveTo(mouseEvent.getX());
        draw();
    }

    public void draw() {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, getWidth(), getHeight());
    }
}

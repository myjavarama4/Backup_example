/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class StackPan extends javafx.application.Application {

    int indexs = 0;

    @Override
    public void start(Stage primaryStage) {
        var x = 0;
        var y = 0;
        var radius = 50;
        var moveToStart = new MoveTo(x, y);
        var lineToStart = new LineTo(x, y - radius);
        LineTo lineToEnd;
        Path path;
        var arcTo = new ArcTo(radius, radius, 0, x, y + radius, false, true);
        for (var deg = 0; deg <= 359; deg += 1) {
            path = new Path(moveToStart, lineToStart);
            if (deg <= 180) {
                lineToEnd = new LineTo(x + radius * Math.sin(Math.toRadians(deg)), y - radius * Math.cos(Math.toRadians(deg)));
            } else {
                path.getElements().add(arcTo);
                lineToEnd = new LineTo(x - radius * Math.sin(Math.toRadians(deg - 180)), y + radius * Math.cos(Math.toRadians(deg - 180)));
            }
            path.getElements().addAll(new ArcTo(radius, radius, 0, lineToEnd.getX(), lineToEnd.getY(), false, true), new LineTo(moveToStart.getX(), moveToStart.getY()));
            //       this.list_of_shape.add(path);
        }
        var pathw = new Path(new MoveTo(200, 300), new LineTo(200, 200), new LineTo(300, 200),
                new ArcTo(radius, radius, 0, x, y + radius, false, true));
        pathw.setFill(Color.TURQUOISE);
        pathw.setStrokeWidth(0);
        var stack = new StackPane(pathw);
        var pane = new Pane(stack/*, paths.get(0).list_of_shape.get(200)*/);
        //  pane.setStyle("-fx-background-color: green");
        primaryStage.setScene(new Scene(pane, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

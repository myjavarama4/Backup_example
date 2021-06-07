package example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class SkipPartsOfCycle extends Application {

    @Override
    public void start(Stage stage) {
        var pane = new Pane();
        pane.getChildren().add(new Circle(500, 500, 100, Color.GREEN));
       /* for (var i = 0; i <= 360; i += 5) {
            pane.getChildren().add(new Line(500,500, 500 + (100 * Math.sin(Math.toRadians(i))), 500 + (100 * Math.cos(Math.toRadians(i)))));
        }*/
        drawLine(pane, 0, 20, 5);
        drawLine(pane, 70, 110, 5);
        drawLine(pane, 160, 200, 5);
        drawLine(pane, 250, 290, 5);
        drawLine(pane, 340, 360, 5);
        stage.setScene(new Scene(pane, 1000, 1000));
        stage.show();
    }
    
    public static void drawLine (Pane pane, int start, int end, int increment) {
        for (var i = start; i <= end; i += increment) {
            pane.getChildren().add(new Line(500,500, 500 + (100 * Math.sin(Math.toRadians(i))), 500 + (100 * Math.cos(Math.toRadians(i)))));
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}

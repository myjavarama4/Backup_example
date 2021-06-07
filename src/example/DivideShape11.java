package example;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class DivideShape11 extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        var pane = new Pane();
        var moveToStart = new MoveTo(200, 380);
        var lineTo = new LineTo(0, 300);
        var arc_big = lineTo.getY() - lineTo.getX();
        var arc_small = moveToStart.getY() - moveToStart.getX();
        var lineY = lineTo.getY();
        var moveY = moveToStart.getY();
        double sin, cos;
        Path path;
        for (var deg = 198; deg <= 270; deg += 18) {
            sin = Math.sin(Math.toRadians(deg));
            cos = Math.cos(Math.toRadians(deg));
            path = new Path(moveToStart, lineTo);
            lineTo = new LineTo(lineY + arc_big * cos, lineY + arc_big * sin);
            path.getElements().add(new ArcTo(arc_big, arc_big, 0, lineTo.getX(), lineTo.getY(), false, true));
            var moveTo = new MoveTo(moveY + arc_small * cos, moveY + arc_small * sin);
            path.getElements().addAll(new LineTo(moveTo.getX(), moveTo.getY()),
                    new ArcTo(arc_small, arc_small, 0, moveToStart.getX(), moveToStart.getY(), false, false));
            moveToStart = moveTo;
            path.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(path);
        }
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        System.out.println(primaryStage.getScene().getWidth());
        System.out.println(primaryStage.getScene().getHeight());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package example;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class DivideShape extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        var pane = new Pane();
        var smallRadius = 180;
        var smallCenter = new Point2D(380, 380);
        var bigRadius = 300;
        var bigCenter = new Point2D(300, 300);

        var startAngle = Math.toRadians(180);
        var endAngle = Math.toRadians(270);
        var stepCount = 5;

        var sin = Math.sin(startAngle);
        var cos = Math.cos(startAngle);
        var bigArcStart = new Point2D(bigCenter.getX() + bigRadius * cos, bigCenter.getY() + bigRadius * sin);
        var smallArcStart = new Point2D(smallCenter.getX() + smallRadius * cos, smallCenter.getY() + smallRadius * sin);

        var step = (endAngle - startAngle) / stepCount;

        for (var rad = startAngle + step; rad <= endAngle; rad += step) {
            sin = Math.sin(rad);
            cos = Math.cos(rad);
            var bigArcEnd = new Point2D(bigCenter.getX() + bigRadius * cos, bigCenter.getY() + bigRadius * sin);
            var smallArcEnd = new Point2D(smallCenter.getX() + smallRadius * cos, smallCenter.getY() + smallRadius * sin);

            var path = new Path(
                    new MoveTo(smallArcStart.getX(), smallArcStart.getY()),
                    new LineTo(bigArcStart.getX(), bigArcStart.getY()),
                    new ArcTo(bigRadius, bigRadius, 0, bigArcEnd.getX(), bigArcEnd.getY(), false, true),
                    new LineTo(smallArcEnd.getX(), smallArcEnd.getY()),
                    new ArcTo(smallRadius, smallRadius, 0, smallArcStart.getX(), smallArcStart.getY(), false, false)
            );

            path.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(path);

            bigArcStart = bigArcEnd;
            smallArcStart = smallArcEnd;
        }
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

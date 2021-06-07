package example;

import java.util.ArrayList;
import java.util.stream.IntStream;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationLinearGradient extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        var linear_gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop[]{new Stop(0, Color.YELLOW), new Stop(1, Color.RED)});
        var rectangle = new Rectangle(1000, 100, linear_gradient);
        var button1 = new Button("-");
        var button2 = new Button("+");
        button1.setMinSize(300, 100);
        button2.setMinSize(300, 100);
        var stops = new ArrayList<LinearGradient>();
        var timeline = new Timeline();
        button1.setOnAction((event) -> {
            stops.clear();
            for (var i = 1; i <= 500; i += 1) {
                stops.add(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                        new Stop[]{new Stop((double) i / 500, Color.YELLOW), new Stop(1, Color.RED)}));
            }
            IntStream
                    .range(0, stops.size())
                    .mapToObj(
                            index -> new KeyFrame(
                                    Duration.millis(index * 1), event2 -> {
                                rectangle.setFill(stops.get(index));
                            }
                            )
                    )
                    .forEach(timeline.getKeyFrames()::add);
            timeline.play();
        });
        button2.setOnAction((event) -> {
            stops.clear();
            for (var i = 500; i >= 0; i -= 1) {
                stops.add(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                        new Stop[]{new Stop((double) i / 500, Color.YELLOW), new Stop(1, Color.RED)}));
            }
            IntStream
                    .range(0, stops.size())
                    .mapToObj(
                            index -> new KeyFrame(
                                    Duration.millis(index * 1), event2 -> {
                                rectangle.setFill(stops.get(index));
                            }
                            )
                    )
                    .forEach(timeline.getKeyFrames()::add);
            timeline.play();
        });
        var hbox = new HBox(button1, button2);
        hbox.setSpacing(50);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(new VBox(rectangle, hbox)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

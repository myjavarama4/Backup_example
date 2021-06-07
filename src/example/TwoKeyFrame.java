/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.stream.IntStream;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TwoKeyFrame extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        var rectangle = new Rectangle(200, 200, Color.BLACK);
        var list_of_character = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        var list_of_color = new Color[]{Color.PINK, Color.MAGENTA, Color.RED, Color.GREEN, Color.YELLOW, Color.TURQUOISE, Color.BLUE, Color.ORANGE};
        var timeline = new Timeline();
        var text = new Text("NONE");
        text.setFont(Font.font(100));
        rectangle.setOnMouseClicked((t) -> {
            IntStream
                    .range(0, list_of_color.length)
                    .mapToObj(
                            index -> new KeyFrame(
                                    Duration.millis(index * 400), event -> {
                                rectangle.setFill(list_of_color[index]);
                            }
                            )
                    )
                    .forEach(timeline.getKeyFrames()::add);
            IntStream
                    .range(0, list_of_character.length)
                    .mapToObj(
                            index -> new KeyFrame(
                                    Duration.millis(index * 200), event -> {
                                text.setText(list_of_character[index]);
                            }
                            )
                    )
                    .forEach(timeline.getKeyFrames()::add);
            timeline.play();
        });
        primaryStage.setTitle("Example!");
        primaryStage.setScene(new Scene(new VBox(rectangle, text)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

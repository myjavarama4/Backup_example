package example;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class TextHeightInPixel extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var text = new Text("I");
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFont(Font.loadFont(getClass().getResourceAsStream("GT Pressura Mono Regular Regular.ttf"), 100));
        var pane = new HBox(text);
        text.setFill(Color.BLUE);
        var scene = new Scene(pane, 700, 400);
        setPixelHeight(scene, text, 99);
        stage.setScene(scene);
        stage.show();
    }

    public static void setPixelHeight(Scene scene, Text text, int size) {
        for (var i = size + 1;; i++) {
            text.setStyle("-fx-font-size:" + i + ";");
            var pixelReader = scene.snapshot(null).getPixelReader();
            if (!(pixelReader.getColor(0, size)).equals(pixelReader.getColor(0, size + 1))) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

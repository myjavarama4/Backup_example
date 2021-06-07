package pokus;

import java.awt.Toolkit;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class NewFXMain extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        var height = Toolkit.getDefaultToolkit().getScreenSize().height;
        var width = Toolkit.getDefaultToolkit().getScreenSize().width;
        var text = new Text("E");
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFont(Font.loadFont(getClass().getResourceAsStream("GT_Pressura_Mono_Regular_Regular.ttf"), 200));
        text.setFill(Color.BLUE);
        var pane = new HBox(text);
        var scene = new Scene(pane, 700, 400);
        var size = setPixelHeight(scene, text, (int) (height * 0.2));
        scene = new Scene(new Board(size.get(0), size.get(1), size.get(2)), width, height, true, SceneAntialiasing.BALANCED);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("Ctrl+E"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static ArrayList<Integer> setPixelHeight(Scene scene, Text text, int height) {
        var size = (int) Math.floor((height - 16) / 9);
        var array = new ArrayList<Integer>() {
            {
                add(size);
            }
        };
        for (var i = size + 1;; i++) {
            text.setStyle("-fx-font-size:" + i + ";");
            var pixelReader = scene.snapshot(null).getPixelReader();
            if (!(pixelReader.getColor(0, size)).equals(pixelReader.getColor(0, size + 1))) {
                array.add(i);
                break;
            }
        }
        for (var j = 1;; j++) {
            var pixelReader = scene.snapshot(null).getPixelReader();
            if (!(pixelReader.getColor(j, 0)).equals(pixelReader.getColor(j + 1, 0))) {
                array.add(j);
                break;
            }
        }
        return array;
    }
}

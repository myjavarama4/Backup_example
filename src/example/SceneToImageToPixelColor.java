package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class SceneToImageToPixelColor extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var text = new Text("I");
        text.setFont(Font.font(100));
        text.setBoundsType(TextBoundsType.VISUAL);
     //   text.setLayoutX(50);
   //     text.setLayoutY(50);
          try {
            text.setFont(Font.loadFont(new FileInputStream(new File("src/example/GT Pressura Mono Regular Regular.ttf")), 100));
        } catch (FileNotFoundException ex) {
        }
        var pane = new HBox(text);
        var scene = new Scene(pane, 100, 100);
        var writableImage = scene.snapshot(null);
        var pixelReader = writableImage.getPixelReader();
        for (int y = 0; y < scene.getWidth(); y++) {
            System.out.println(pixelReader.getColor(y, 50));
        }
       
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

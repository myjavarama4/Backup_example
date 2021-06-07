package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class TextHeight1 extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var text = new Text("EXAMPLE");
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setTextOrigin(VPos.TOP);
       // var tempFile = new File(getClass().getResourceAsStream("GT Pressura Mono Regular Regular.ttf").toString());
     //   System.out.println(ClassLoader.getSystemResourceAsStream("GT Pressura Mono Regular Regular.ttf"));
   //     System.out.println(getClass().getResource("GT Pressura Mono Regular Regular.ttf"));
         InputStream is = TextHeight1.class.getResourceAsStream("/GT Pressura Mono Regular Regular.ttf");
        
    /*    if (is == null) {
            System.out.println("cat");
        }*/
        text.setFont(Font.loadFont(TextHeight1.class.getClass().getResourceAsStream("/GT Pressura Mono Regular Regular.ttf"), 100));
  /*      try {
            text.setFont(Font.loadFont(new FileInputStream(new File("src/" + getClass().getPackage() + "/GT Pressura Mono Regular Regular.ttf")), 50));
        } catch (FileNotFoundException ex) {

        }*/
        text.setFill(Color.BLUE);
        var pane = new Pane(text);
        var scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

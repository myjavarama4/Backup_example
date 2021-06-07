package example;

import java.awt.FontMetrics;
import java.awt.Toolkit;
import javafx.beans.binding.Bindings;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class VerticalPositionForEachLetter extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var rectangle = new Rectangle(500, 500, Color.CYAN);
        var line = new Line(0, 0, 500, 500);
        var line2 = new Line(0, 500, 500, 0);
        var line3 = new Line(250, 0, 250, 500);
        var line4 = new Line(0, 250, 500, 250);
        var pane = new Pane(rectangle, line, line2, line3, line4, new Rectangle(360, 208, 10, 100));
        addText("EXAMPLE", 1, pane, rectangle);
        stage.setScene(new Scene(pane, 500, 500));
        stage.show();
    }

    public void addText(String textt, int updown, Pane pane, Rectangle rectangle) {
        var startX = rectangle.getWidth() / 2;
        var startY = rectangle.getHeight() / 2;
        var text = new Text("CAT");
        var catsize = 100 * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0;
        text.setFont(Font.loadFont(getClass().getResourceAsStream("GT Pressura Mono Regular Regular.ttf"), catsize));
        text.setBoundsType(TextBoundsType.LOGICAL_VERTICAL_CENTER);
        text.setFill(Color.GREENYELLOW);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextOrigin(VPos.CENTER);
        double size = text.getFont().getSize();
        double fontSize = (1 / 72 / 96) * 100;
        double font = text.getBoundsInLocal().getWidth();
        System.out.println(font);
        if (textt.length() % 2 == 1) {
            var center = (int) Math.floor(textt.length() / 2);
          /*  for (var i = center; i > 1; i-=1) {
               text.setText(textt.substring(i - 1, i)); 
                System.out.println(textt.substring(i - 1, i));
            }
            for (var i = center; i < textt.length(); i+=1) {
                
            }*/
        //    text.setText(textt.charAt(updown));
        text.setX(startX - text.getLayoutBounds().getWidth() / 2);
        text.setY(startY);
        }
        
        pane.getChildren().add(text);
        /*  for (var i = 0; i < 0; i += 1) {
            var textt = new Text(startX, startY, String.valueOf(text.charAt(i)));
            textt.setFont(Font.loadFont(getClass().getResourceAsStream("GT Pressura Mono Regular Regular.ttf"), 100));
            textt.setText(String.valueOf(text.charAt(i)));
            textt.setBoundsType(TextBoundsType.VISUAL);
            textt.setTextOrigin(VPos.CENTER);
            startY = leftright * 50;
            textt.setLayoutX(startX);
            textt.setLayoutY(startY);
            var cat = textt.getLayoutBounds().getWidth();
            //   pane.getChildren().add(textt);
            startX += cat;
            startY += leftright * cat;
        }*/
    }

    public static void main(String[] args) {
        launch(args);
    }

}

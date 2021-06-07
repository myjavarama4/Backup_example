package example;

import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class TextAlignment extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: yellow ;");
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        var texx = "EXAMPLE";
        for (var i = 0; i < texx.length(); i += 1) {
            var text = new Text(String.valueOf(texx.charAt(i)));
            text.setBoundsType(TextBoundsType.VISUAL);
            text.setTextOrigin(VPos.BOTTOM);
            text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            text.setFill(Color.BLUE);
            text.setX(0);
            text.setY(0);
            var textPane = new TextPane(text);
            textPane.setLayoutX(-10);
            textPane.setMinHeight(100);
            textPane.setMaxHeight(100);
            gridPane.add(textPane, i, i);
        }
        stage.setScene(new Scene(new Pane(gridPane), 600, 800));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

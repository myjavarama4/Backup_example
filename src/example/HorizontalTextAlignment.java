package example;

import javafx.beans.binding.Bindings;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class HorizontalTextAlignment extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var rectangle = new Rectangle(600, 100, Color.TURQUOISE);
        rectangle.setLayoutX(100);
        rectangle.setLayoutY(100);
        var text = new Text("monospace");
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFont(new Font(50));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextOrigin(VPos.CENTER);
        text.layoutXProperty().bind(Bindings.createDoubleBinding(() -> rectangle.getLayoutX() + rectangle.getWidth() / 2 - text.getLayoutBounds().getWidth() / 2,
                rectangle.widthProperty(),
                text.layoutBoundsProperty()));
        text.layoutYProperty().bind(Bindings.createDoubleBinding(() -> rectangle.getLayoutY() + rectangle.getHeight() / 2,
                rectangle.heightProperty(), text.layoutBoundsProperty()));
        stage.setScene(new Scene(new Pane(rectangle, text)));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

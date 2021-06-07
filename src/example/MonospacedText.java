package example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class MonospacedText extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var textA = new Text("ABCD");
        textA.setBoundsType(TextBoundsType.LOGICAL);
        textA.setFont(new Font("Consolas", 100));

        var textB = new Text("B");
        textB.setBoundsType(TextBoundsType.LOGICAL);
        textB.setFont(new Font("Consolas", 100));

        var textC = new Text("C");
        textC.setBoundsType(TextBoundsType.LOGICAL);
        textC.setFont(new Font("Consolas", 100));

        var textD = new Text("D");
        textD.setBoundsType(TextBoundsType.LOGICAL);
        textD.setFont(new Font("Consolas", 100));

        var textE = new Text("E");
        textE.setBoundsType(TextBoundsType.LOGICAL);
        textE.setFont(new Font("Consolas", 100));

        System.out.println(textA.getLayoutBounds().getWidth());
        System.out.println(textB.getLayoutBounds().getWidth());
        System.out.println(textC.getLayoutBounds().getWidth());
        System.out.println(textD.getLayoutBounds().getWidth());
        System.out.println(textE.getLayoutBounds().getWidth());
        System.out.println(Font.getFontNames("Consolas"));
        var vbox = new VBox(textA, textB, textC, textD, textE);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setSpacing(0);
        stage.setScene(new Scene(vbox));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

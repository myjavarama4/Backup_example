package PlayersIcon;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AnimationIcon extends javafx.application.Application {

    private int indexs = 0;

    @Override
    public void start(Stage primaryStage) {
        var paths = new PathPane(20, 0, 50);
        //     paths.getChildren().add(new PathPlayer(50));
        var button = new Button("+");
        var button2 = new Button("-");
        button2.setDisable(true);
        var vbox = new VBox(button, button2);
        vbox.setLayoutX(500);
        vbox.setLayoutY(500);
        button.setOnMouseClicked((t) -> {
            paths.anime(button, button2, true);
        });
        button2.setOnMouseClicked(t2 -> {
            paths.anime(button, button2, false);

            //    bright(paths, button, button2, false, colors);
        });
        var pane = new Pane(paths, vbox/*, paths.get(0).list_of_shape.get(200)*/);
        //  pane.setStyle("-fx-background-color: green");
        primaryStage.setScene(new Scene(pane, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

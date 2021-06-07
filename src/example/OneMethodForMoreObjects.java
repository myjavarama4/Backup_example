package example;

import java.util.ArrayList;
import java.util.function.Function;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;

public class OneMethodForMoreObjects extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        javafx.scene.layout.Pane root = new Pane();
        ArrayList<Shape1> first_shapes = create_array(10, 10, 50, 50, Shape1::new);
        ArrayList<Shape2> second_shapes = create_array(20, 20, 80, 80, Shape2::new);
        root.getChildren().addAll(first_shapes);
        root.getChildren().addAll(second_shapes);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static <S extends Path> ArrayList<S> create_array(int X1, int Y1, int X2, int Y2, Function<PathElement[], S> shapeConstructor) {
        var shapes = new ArrayList<S>();
        shapes.add(shapeConstructor.apply(new PathElement[]{
            new MoveTo(X1, Y1), new LineTo(X2, Y2)
        }));
        return shapes;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class CopyArray extends Application {

    @Override
    public void start(Stage stage) {
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>() {
            {
                add(new Rectangle(10, 10, Color.RED));
                add(new Rectangle(20, 20, Color.GREEN));
                add(new Rectangle(30, 30, Color.YELLOW));
                add(new Rectangle(40, 40, Color.BLUE));
                add(new Rectangle(50, 50, Color.PURPLE));
            }
        };
        Path path = new Path(new MoveTo(0, 0), new LineTo(100, 100), new LineTo(200, 100));
        Map<Integer, ObservableList<PathElement>> cat = Map.of(1, path.getElements());
        Map<Integer, Color> map = Map.of(10, Color.RED, 20, Color.GREEN, 30, Color.YELLOW, 40, Color.BLUE, 50, Color.PURPLE);

        Map<Integer, Color> treeMap = new TreeMap<>(map);

        List<Rectangle> rectangless = IntStream.range(0, 4).boxed()
                .flatMap(i
                        -> treeMap.entrySet().stream().map(entry -> {
                    Rectangle rectangle = new Rectangle(entry.getKey(), entry.getKey(), entry.getValue());
                    rectangle.getTransforms().add(new Rotate(90 * i, 500, 500));
                    return rectangle;
                }))
                .collect(Collectors.toList());
        rectangless.forEach((t) -> {
            System.out.println(((Rectangle) t).getTransforms().get(0));
            System.out.println(((Rectangle) t).getWidth());

        });
        rectangles = (ArrayList) IntStream.range(0, 4).boxed()
                .flatMap(i
                        -> treeMap.entrySet().stream().map(entry -> {
                    Rectangle rectangle = new Rectangle(entry.getKey(), entry.getKey(), entry.getValue());
                    rectangle.getTransforms().add(new Rotate(90 * i, 500, 500));
                    return rectangle;
                }))
                .collect(Collectors.toList());
        rectangles.forEach((t) -> {
            System.out.println(((Rectangle) t).getTransforms().get(0));
            System.out.println(((Rectangle) t).getWidth());

        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}

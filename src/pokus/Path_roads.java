package pokus;

import javafx.scene.paint.Color;
import javafx.scene.shape.PathElement;

public class Path_roads extends javafx.scene.shape.Path {

    Path_carts cart;

    public Path_roads(PathElement... elements) {
        super(elements);
        setFill(Color.LIGHTYELLOW);
    }

}

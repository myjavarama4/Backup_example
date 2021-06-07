package PlayersIcon;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public final class PathPlayer extends javafx.scene.shape.Path {

    static ArrayList<Path> list_of_shape = new ArrayList<>();

    protected static void setShape(int radius) {
        var moveToStart = new MoveTo(radius, radius);
        var lineToStart = new LineTo(radius, 0);
        LineTo lineToEnd;
        Path path;
        var arcTo = new ArcTo(radius, radius, 0, radius, 2 * radius, false, true);
        for (var deg = 0; deg <= 360; deg += 1) {
            path = new Path(moveToStart, lineToStart);
            if (deg <= 180) {
                lineToEnd = new LineTo(radius * Math.sin(Math.toRadians(deg)) + radius, radius - (radius * Math.cos(Math.toRadians(deg))));
            } else {
                path.getElements().add(arcTo);
                lineToEnd = new LineTo(radius - (radius * Math.sin(Math.toRadians(deg - 180))), radius * Math.cos(Math.toRadians(deg - 180)) + radius);
            }
            path.getElements().addAll(new ArcTo(radius, radius, 0, lineToEnd.getX(), lineToEnd.getY(), false, true), new LineTo(moveToStart.getX(), moveToStart.getY()));
            list_of_shape.add(path);
        }
    }

    public PathPlayer(int radius, boolean first) {
        if (first) {
            getElements().addAll(list_of_shape.get(360).getElements());
        }
        setStrokeWidth(0);
    }

    public void changeColor(Color color) {
        setFill(color);
    }
}

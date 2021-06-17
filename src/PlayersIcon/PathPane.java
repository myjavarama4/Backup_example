package PlayersIcon;

import java.util.stream.IntStream;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PathPane extends javafx.scene.layout.Pane {

    private int indexs = 0;

    public PathPane(int x, int y, int radius) {
        PathPlayer.setShape(radius);
        getChildren().addAll(
                new PathPlayer(Color.RED, true),
                new PathPlayer(Color.GREEN, false),
                new PathPlayer(Color.YELLOW, false),
                new PathPlayer(Color.BLUE, false)
        );
        setPrefSize(radius * 2, radius * 2);
        setLayoutX(100);
        setLayoutY(100);
    }

    public PathPlayer getPathPlayer(int number) {
        return (PathPlayer) getChildren().get(number);
    }

    public void animus(Button button, Button button2, Timeline timeline, int range, int number, int add, boolean plus) {
        IntStream
                .range(0, range)
                .mapToObj(
                        index -> new KeyFrame(
                                Duration.millis(index * 10), event -> {
                            getPathPlayer(number).getElements().clear();
                            getPathPlayer(number).getElements().addAll(PathPlayer.list_of_shape.get(index + add).getElements());
                            getPathPlayer(number).setFill(getPathPlayer(number).getColor());
                        }
                        )
                )
                .forEach(timeline.getKeyFrames()::add);
        button.setDisable(true);
        button2.setDisable(true);
        if (!plus) {
            timeline.setRate(-1);
        }
        timeline.setOnFinished(t3 -> {
            setIndex(plus, button, button2);
        });
    }

    public void anime(Button button, Button button2, boolean plus) {
        var timeline = new Timeline();
        if (!plus) {
            indexs -= 1;
        }
        switch (indexs) {
            case 0 -> {
                animus(button, button2, timeline, 361, 0, 0, plus);
                break;
            }
            case 1 -> {
                animus(button, button2, timeline, 181, 1, 0, plus);
                break;
            }
            case 2 -> {
                animus(button, button2, timeline, 121, 2, 0, plus);
                animus(button, button2, timeline, 61, 1, 180, plus);
                break;
            }
            case 3 -> {
                animus(button, button2, timeline, 91, 3, 0, plus);
                animus(button, button2, timeline, 61, 2, 120, plus);
                animus(button, button2, timeline, 31, 1, 240, plus);
            }
        }
        timeline.play();
    }

    private void setIndex(boolean isPlus, Button plus, Button minus) {
        if (isPlus) {
            indexs += 1;
        }
        if (isPlus) {
            minus.setDisable(false);
            if (indexs < 4) {
                plus.setDisable(false);
            }
        } else {
            plus.setDisable(false);
            if (indexs > 0) {
                minus.setDisable(false);
            }
        }
    }
}

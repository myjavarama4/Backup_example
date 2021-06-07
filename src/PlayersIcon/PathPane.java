package PlayersIcon;

import java.util.stream.IntStream;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class PathPane extends javafx.scene.layout.Pane {

    private int indexs = 0;

    public PathPane(int x, int y, int radius) {
        PathPlayer.setShape(radius);
        getChildren().addAll(
                new PathPlayer(radius, true),
                new PathPlayer(radius, false),
                new PathPlayer(radius, false),
                new PathPlayer(radius, false)
        );
        setPrefSize(radius * 2, radius * 2);
        //setStyle("-fx-background-color: purple");
    }

    public PathPlayer getPathPlayer(int number) {
        return (PathPlayer) getChildren().get(number);
    }

    public int getNumber() {
        return indexs;
    }

    public void addPlayer() {
        indexs += 1;
    }

    public void removePlayer() {
        indexs -= 1;
    }

    public void animus(Button button, Button button2, Timeline timeline, int range, int number, int add, boolean plus) {
        IntStream
                .range(0, range)
                .mapToObj(
                        index -> new KeyFrame(
                                Duration.millis(index * 10), event -> {
                            getPathPlayer(number).getElements().clear();
                            getPathPlayer(number).getElements().addAll(PathPlayer.list_of_shape.get(index + add).getElements());
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
            button.setDisable(false);
            button2.setDisable(false);
            if (plus) {
                indexs += 1;
            } else {
                indexs -= 1;
            }
        });
    }

    public void anime(Button button, Button button2, boolean plus) {
        var timeline = new Timeline();
        if (!plus) {
            indexs -= 1;
        }
        switch (indexs) {
            case 0 -> {
                //      getPathPlayer(0).changeColor(color);
                timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(getPathPlayer(0).opacityProperty(), 0)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(getPathPlayer(0).opacityProperty(), 1)));
                button.setDisable(true);
                button2.setDisable(true);
                if (!plus) {
                    timeline.setRate(-1);
                }
                System.out.println(timeline.getRate());
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    button2.setDisable(false);
                    if (plus) {
                        indexs += 1;
                    } else {
                        indexs -= 1;
                    }
                });
                break;
            }
            case 1 -> {
                //    getPathPlayer(1).changeColor(color);
                animus(button, button2, timeline, 181, 1, 0, plus);
                break;
            }
            case 2 -> {
                //      getPathPlayer(2).changeColor(color);
                animus(button, button2, timeline, 121, 2, 0, plus);
                animus(button, button2, timeline, 61, 1, 180, plus);
                break;
            }
            default -> {
                //         getPathPlayer(3).changeColor(color);
                animus(button, button2, timeline, 91, 3, 0, plus);
                animus(button, button2, timeline, 61, 2, 120, plus);
                animus(button, button2, timeline, 31, 1, 240, plus);
            }
        }
        timeline.play();
    }
}

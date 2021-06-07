package PlayersIcon;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AnimationShape extends javafx.application.Application {

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

    /*  public void bright(PathPane paths, Button button, Button button2, boolean plus, ArrayList<Color> color) {
        var timeline = new Timeline();
        switch (indexs) {
            case 0 -> {
                paths.getPathPlayer(0).changeColor(color.get(indexs));
                timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(paths.getPathPlayer(0).opacityProperty(), 0)),
                        new KeyFrame(Duration.seconds(2), new KeyValue(paths.getPathPlayer(0).opacityProperty(), 1)));
                /*     IntStream
                        .range(0, paths.getPathPlayer(0).list_of_shape.size())
                        .mapToObj(
                                index -> new KeyFrame(
                                        Duration.millis(index * 10), event -> {
                                    paths.getPathPlayer(0).getElements().clear();
                                    paths.getPathPlayer(0).getElements().addAll(paths.getPathPlayer(0).list_of_shape.get(index).getElements());
                                }
                                )
                        )
                        .forEach(timeline.getKeyFrames()::add);
                button.setDisable(true);
                button2.setDisable(true);
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    indexs += 1;
                });
                break;
            }
            case 1 -> {
                paths.getPathPlayer(1).changeColor(color.get(indexs));
                IntStream
                        .range(0, 181)
                        .mapToObj(
                                index -> new KeyFrame(
                                        Duration.millis(index * 10), event -> {
                                    paths.getPathPlayer(1).getElements().clear();
                                    paths.getPathPlayer(1).getElements().addAll(PathPlayer.list_of_shape.get(index).getElements());
                                }
                                )
                        )
                        .forEach(timeline.getKeyFrames()::add);
                button.setDisable(true);
                button2.setDisable(true);
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    indexs += 1;
                });
                break;
            }
            case 2 -> {
                paths.getPathPlayer(2).changeColor(color.get(indexs));
                IntStream
                        .range(0, 121)
                        .mapToObj(
                                index -> new KeyFrame(
                                        Duration.millis(index * 10), event -> {
                                    paths.getPathPlayer(2).getElements().clear();
                                    paths.getPathPlayer(2).getElements().addAll(PathPlayer.list_of_shape.get(index).getElements());
                                }
                                )
                        )
                        .forEach(timeline.getKeyFrames()::add);
                button.setDisable(true);
                button2.setDisable(true);
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    indexs += 1;
                });
                IntStream
                        .range(0, 61)
                        .mapToObj(
                                index -> new KeyFrame(
                                        Duration.millis(index * 20), event -> {
                                    paths.getPathPlayer(1).getElements().clear();
                                    paths.getPathPlayer(1).getElements().addAll(PathPlayer.list_of_shape.get(index + 180).getElements());
                                }
                                )
                        )
                        .forEach(timeline.getKeyFrames()::add);
                button.setDisable(true);
                button2.setDisable(true);
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    indexs += 1;
                });
                break;
            }
            case 3 -> {
                paths.getPathPlayer(3).changeColor(color.get(indexs));
                IntStream
                        .range(0, 31)
                        .mapToObj(
                                index -> new KeyFrame(
                                        Duration.millis(index * 30), event -> {
                                    paths.getPathPlayer(1).getElements().clear();
                                    paths.getPathPlayer(1).getElements().addAll(PathPlayer.list_of_shape.get(index + 240).getElements());
                                }
                                )
                        )
                        .forEach(timeline.getKeyFrames()::add);
                button.setDisable(true);
                button2.setDisable(true);
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    indexs += 1;
                });
                IntStream
                        .range(0, 91)
                        .mapToObj(
                                index -> new KeyFrame(
                                        Duration.millis(index * 10), event -> {
                                    paths.getPathPlayer(3).getElements().clear();
                                    paths.getPathPlayer(3).getElements().addAll(PathPlayer.list_of_shape.get(index).getElements());
                                }
                                )
                        )
                        .forEach(timeline.getKeyFrames()::add);
                button.setDisable(true);
                button2.setDisable(true);
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    indexs += 1;
                });
                IntStream
                        .range(0, 61)
                        .mapToObj(
                                index -> new KeyFrame(
                                        Duration.millis(index * 20), event -> {
                                    paths.getPathPlayer(2).getElements().clear();
                                    paths.getPathPlayer(2).getElements().addAll(PathPlayer.list_of_shape.get(index + 120).getElements());
                                }
                                )
                        )
                        .forEach(timeline.getKeyFrames()::add);
                button.setDisable(true);
                button2.setDisable(true);
                timeline.setOnFinished(t3 -> {
                    button.setDisable(false);
                    indexs += 1;
                });
            }
        }
        timeline.play();
    }*/

 /*  public void oneColor() {

    }

    public void TwoColor() {

    }

    public void ThreeColor() {

    }

    public void FourColor() {

    }*/
    public static void main(String[] args) {
        launch(args);
    }
}

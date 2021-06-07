package pokus;

import javafx.scene.shape.PathElement;

public class Path_carts extends javafx.scene.shape.Path {

    private String name;

    public Path_carts(PathElement... elements) {
        super(elements);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*   public void setHorse(Horse horse, Cart_background background, Cart box) {
        setOnMouseEntered((event) -> {
            event.consume();
            var effect = new BoxBlur(0, 0, 1);
            box.setEffect(effect);
            var timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(background.fillProperty(), background.getFill())),
                    new KeyFrame(Duration.millis(500),
                            evt -> {
                                box.getChildren().clear();
                                box.getChildren().addAll(horse.getAllFields());
                            },
                            new KeyValue(effect.widthProperty(), 10),
                            new KeyValue(effect.heightProperty(), 10)
                    ), new KeyFrame(Duration.millis(1000),
                            new KeyValue(effect.widthProperty(), 0),
                            new KeyValue(effect.heightProperty(), 0)
                      ,   new KeyValue(background.fillProperty(), horse.getFill())
                    )
            );
            timeline.play();
        });
    }*/
}

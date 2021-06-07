package pokus;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public final class Clock extends javafx.scene.control.Label {

    private final SimpleDateFormat SIMPLE_DATE_FORMAT;
    private Date date;

    public Clock(String type, int right_edge, int up_edge) {
        setTextFill(Color.BLUE);
        setLayoutX(right_edge);
        setLayoutY(up_edge);
        switch (type) {
            case "date" -> {
                SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd. MM. yyyy");
                setFont(Font.font("Arial", 20));
            }
            case "time" -> {
                SIMPLE_DATE_FORMAT = new SimpleDateFormat("hh:mm:ss a");
                setFont(Font.font("Arial", FontWeight.BOLD, 40));
            }
            default -> {
                SIMPLE_DATE_FORMAT = new SimpleDateFormat("EEEE");
                setFont(Font.font("Arial", 20));
            }
        }
        var timer = new Timeline(new KeyFrame(Duration.millis(250), (event) -> {
            date = new Date();
            setText(SIMPLE_DATE_FORMAT.format(date));
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }
}

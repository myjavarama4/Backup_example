package pokus;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Dice extends javafx.scene.text.Text {

    private static final Random NEW_NUMBER = new Random();

    public Dice(int count_player) {
        setText("0");
        setLayoutX(10);
        setLayoutY(javafx.stage.Screen.getPrimary().getVisualBounds().getHeight() * 0.3);
        setFont(javafx.scene.text.Font.font("Arial", javafx.scene.text.FontWeight.LIGHT, 40));
    //    setTextFill(javafx.scene.paint.Color.WHITE);
        var timer = new Timeline(new KeyFrame(Duration.millis(50), (event) -> {
            setText(String.valueOf(NEW_NUMBER.nextInt(5) + NEW_NUMBER.nextInt(5) + 2));
        }));
        setOnMouseClicked((event) -> {
            timer.setCycleCount(10);
            timer.setOnFinished((event2) -> {
                setDisable(false);
            });
            setDisable(true);
            timer.play();
        });
    }
    
    public void roll_the_dice() {
        
    }
}

package example;

import javafx.geometry.Orientation;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextPane extends javafx.scene.layout.Region {

    private final Text text;

    public TextPane(Text text) {
        this.text = text;
        getChildren().add(text);
    }

    @Override
    protected void layoutChildren() {
        adjustFontSize(getHeight());
        text.setY(getHeight());
        text.setX(0);
    }

    private void adjustFontSize(double height) {
        var textHeight = text.getBoundsInLocal().getHeight();
        if (Math.abs(height - textHeight) > 1) {
            var currentFont = text.getFont();
            var fontSize = currentFont.getSize();
            text.setFont(Font.font(currentFont.getFamily(), height * fontSize / textHeight));
            System.out.println(text.getLayoutBounds().getWidth());
        }
    }

    @Override
    protected double computePrefWidth(double height) {
        adjustFontSize(height);
        return text.getBoundsInLocal().getWidth();
    }

    @Override
    public Orientation getContentBias() {
        return Orientation.VERTICAL;
    }
}

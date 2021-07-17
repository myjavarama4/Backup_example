package example;

import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXComboBox extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        var comboBox = new ComboBox<String>();
        comboBox.setStyle("-fx-font: 30px \"Arial\";");
        comboBox.setPrefWidth(300);
        var enableComboBox = new CheckBox("enable_combo");
        enableComboBox.setSelected(true);
        enableComboBox.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            comboBox.setDisable(!t1);
            if (comboBox.isDisabled()) {
                comboBox.getSelectionModel().select(null);
            }
        });
        var colors = new ArrayList<String>() {
            {
                add("PURPLE");
                add("RED");
                add("GREEN");
                add("YELLOW");
                add("BLUE");
                add("TURQUOISE");
                add("BROWN");
                add("ORANGE");
            }
        };
        comboBox.getItems().addAll(colors);
        comboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String t, String t1) -> {
            comboBox.setStyle("-fx-background-color:" + t1 + "; -fx-font: 30px \"Arial\";");
        });

        stage.setScene(new Scene(new HBox(enableComboBox, comboBox)));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

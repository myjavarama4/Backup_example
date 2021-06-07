package pokus;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public final class Horse extends Carts {

    private final String NAME;
    private final int PORIZOVACI_CENA;
    private final int PROHLIDKA_STAJE;
    private final int DOSTIH[];
    private final int CENA_DOSTIHU;
    private int POCET_DOSTIHU = 0;
    ArrayList<Horse> husband = new ArrayList<>(2);
//    Integer array_number;
    private final Color COLOR;

    public Horse(String NAME, int PORIZOVACI_CENA, int PROHLIDKA_STAJE, int CENA_DOSTIHU, Color SERIE, int array_number) {
        this.NAME = NAME;
        this.PORIZOVACI_CENA = PORIZOVACI_CENA;
        this.PROHLIDKA_STAJE = PROHLIDKA_STAJE;
        this.CENA_DOSTIHU = CENA_DOSTIHU;
        this.DOSTIH = new int[]{PORIZOVACI_CENA * 5, PORIZOVACI_CENA * 15, PORIZOVACI_CENA * 45, 1, 1};
        //      this.array_number = array_number;
        COLOR = SERIE;
    }

    public ArrayList<Text> getAllFields() {
        return Arrays.stream(getClass().getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .map(this::getFieldValue)
                .filter(field -> !field.isEmpty())
                .map(field -> new Text(field))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private String getFieldValue(final Field field) {
        try {
            if (field.get(this) == null) {
                return "";
            }
            var value = field.get(this).toString();
            if (value.matches("-?\\d+")) {
                return field.getName() + " " + value;
            } else if (value.equals(NAME)) {
                return value;
            } else {
                return "";
            }
        } catch (final IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Color getColor() {
        return COLOR;
    }

    public int getPORIZOVACI_CENA() {
        return PORIZOVACI_CENA;
    }

    public int getCENA_DOSTIHU() {
        return CENA_DOSTIHU;
    }

    public int getPROHLIDKA_STAJE() {
        return PROHLIDKA_STAJE;
    }

    public int[] getDOSTIH() {
        return DOSTIH;
    }

    public String getNAME() {
        return NAME;
    }

    public int getPOCET_DOSTIHU() {
        return POCET_DOSTIHU;
    }

    public void setPOCET_DOSTIHU(int POCET_DOSTIHU) {
        if (this.POCET_DOSTIHU + POCET_DOSTIHU <= 5) {
            this.POCET_DOSTIHU += POCET_DOSTIHU;
        }
    }
}

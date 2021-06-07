package pokus;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public final class Player {

    final Color color;
    private int position = 0;
    private int money = 30000;
    private final ArrayList<Horse> horses = new ArrayList<>(24);

    public Player(Color color) {
        this.color = color;
    }

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public void removeHorse(Horse horse) {
        horses.remove(horse);
    }

    public int setNewPosition(int move) {
        position += move;
        if (position >= 40) {
            position -= 40;
        }
        return position;
    }

    public boolean changeMoney(int value) {
        money += value;
        return money > 0;
    }
}

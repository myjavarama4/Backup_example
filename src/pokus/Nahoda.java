package pokus;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Nahoda {
    
    ArrayList<String> cards = new ArrayList() {
        {
            add("Jdi o 3 pole zpět");
            add("Zrušen distanc (kartu lze zachovat pro pozdější použití, nebo prodat).");
            add("Jedeš se zúčastnit trenérského kurzu. Postoupíš na nejbližší pole Trenér. Dostaneš 4.000, pokud jedeš dopředu přes Start.");
            add("Zdržíš se na 2 kola.");
            add("Distanc (bez 4.000).");
            add("Zpět na nejbližší pole Finance.");
            add("Zpět na poslední pole ve hře (kůň Napoli), hráč obdrží 4.000.");
            add("Zpět na pole Distanc. Obdržíš 4.000, pokud jsi cestou zpět prošel Start.");
            add("Zpět na nejbližší pole Finance.");
            add("Tpět na start (hráč obdrží 4.000).");
            add("Zpět na start (bez 4.000).");
            add("Zdržíš se na 2 kola.");
            add("Zdržíš se na 1 kolo.");
            add("Zpět na pole Parkoviště. Dostaneš 4.000, pokud jsi cestou zpět prošel start.");
        }
    };
    int number = 0;
    
    public void takeCards() {
        if (number < cards.size()) {
            number += 1;
        } else {
            number = 0;
            Collections.shuffle(cards);
        }
    }
}

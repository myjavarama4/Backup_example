package pokus;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Finance {

    ArrayList<String> cards = new ArrayList() {
        {
            add("Zaplať pojistku 1000.");
            add("Pokuta za nedodržení předpisů 400.");
            add("Renovuješ všechny stáje. Za každý svůj obsazený dostih zaplať 500.");
            add("Mimořádný zisk z dostihů obdržíš 2.000.");
            add("Jako dárek k narozeninám obdržíš od každého 200.");
            add("Mimořádná prémie 500.");
            add("Obdržíš dotaci 4.000.");
            add("Zaplať dluh 3.000.");
            add("Za každý svůj obsazený dostih zaplať 800, za každý svůj obsazený hlavní dostih sezóny zaplať 2.300.");
            add("Zaplať příspěvek 2.000.");
            add("Nákup materiálu na opravu 100.");
            add("Výhra v loterii 1.000.");
            add("Obdržíš dotaci 2.000.");
            add("Z banky obdržíš přeplatek 3.000.");
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

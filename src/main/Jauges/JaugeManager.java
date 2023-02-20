package main.Jauges;

import main.TypeJauge;

import java.util.HashMap;
import java.util.Map;

public class JaugeManager {
    protected static HashMap <TypeJauge, Jauge> jauges;

    public  JaugeManager(HashMap<TypeJauge, Jauge> jauges) {
        this.jauges = jauges;
    }

    public static HashMap<TypeJauge, Jauge> getJauges() {
        return jauges;
    }

    public static void afficheJauges(){
         for (Map.Entry<TypeJauge, Jauge> jauge : JaugeManager.jauges.entrySet()){
             jauge.getValue().afficheJauge();
         }
    }
    public static boolean finDuJeu() {
        for (Map.Entry<TypeJauge, Jauge> jauge : JaugeManager.jauges.entrySet()) {
            if (0 >= jauge.getValue().getValeur() || jauge.getValue().getValeur() >= 50) {
                return true;
            }
        }
        return false;
    }
}

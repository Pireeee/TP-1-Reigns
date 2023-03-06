package main.jauges;

import java.util.HashMap;
import java.util.Map;

public class JaugeManager {
    protected  HashMap <TypeJauge, Jauge> jauges;

    public JaugeManager() {
        this.jauges = new HashMap<TypeJauge, Jauge>();
        for (TypeJauge type : TypeJauge.values() ){
            this.addJauges(type, new Jauge(type,15 + (int)(Math.random() * (35 - 15))));
        }
    }

    public  HashMap<TypeJauge, Jauge> getJauges() {
        return this.jauges;
    }
     public void addJauges(TypeJauge type, Jauge jauge){
        this.jauges.put(type, jauge);
     }

    public void afficheJauges(){
         for (Map.Entry<TypeJauge, Jauge> jauge : this.jauges.entrySet()){
             jauge.getValue().afficheJauge();
         }
    }
    
    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu() {
        for (Map.Entry<TypeJauge, Jauge> jauge : this.jauges.entrySet()) {
            if (0 >= jauge.getValue().getValeur() || jauge.getValue().getValeur() >= 50) {
                return true;
            }
        }
        return false;
    }

    public static JaugeManager init(){
        return new JaugeManager();
    }

}

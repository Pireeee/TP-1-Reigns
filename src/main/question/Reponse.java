package main.question;

import java.util.HashMap;
import main.Jauges.JaugeManager;
import main.TypeJauge;

import java.util.Map;

public class Reponse {
    private String direction;
    private String nom;
    private Map<TypeJauge,Integer> effets;

    public Reponse(String direction, String nom) {
        this.direction = direction;
        this.nom = nom;
        this.effets = new HashMap<>();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<TypeJauge, Integer> getEffets() {
        return effets;
    }

    public void putEffets(TypeJauge jauge, Integer valeur) {
        this.effets.put(jauge,valeur);
    }

    public String afficheReponse() {
        StringBuilder result = new StringBuilder();
        result.append("Effet "+this.direction);
        for (Map.Entry<TypeJauge, Integer> effet : this.effets.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
        }
        return result.toString();
    }
    public void AppliqueReponse(JaugeManager jaugeManager){
        for (TypeJauge type: this.effets.keySet()) {
            jaugeManager.getJauges().get(type).addValeur( this.effets.get(type));
        }
    }
}

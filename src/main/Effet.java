package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Effet {
    private String direction;
    private String nom;
    private Map<TypeJauge,Integer> effetsJauges;

    public Effet(String direction, String nom) {
        this.direction = direction;
        this.nom = nom;
        this.effetsJauges = new HashMap<>();
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

    public Map<TypeJauge, Integer> getEffetsJauges() {
        return effetsJauges;
    }

    public void putEffetsJauges(TypeJauge jauge, Integer valeur) {
        this.effetsJauges.put(jauge,valeur);
    }

    public String afficheEffets() {
        StringBuilder result = new StringBuilder();
        result.append("Effet "+this.direction);
        for (Map.Entry<TypeJauge, Integer> effet : this.effetsJauges.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
        }
        return result.toString();
    }
    public void AppliqueEffect(Personnage personnage){
        for (TypeJauge type: this.effetsJauges.keySet()) {
            switch(type){
                case ARMEE:
                    personnage.jaugeArmee.valeur += this.effetsJauges.get(TypeJauge.ARMEE);
                    break;
                case CLERGE:
                    personnage.jaugeClerge.valeur += this.effetsJauges.get(TypeJauge.CLERGE);
                    break;
                case FINANCE:
                    personnage.jaugeFinance.valeur += this.effetsJauges.get(TypeJauge.FINANCE);
                    break;
                case PEUPLE:
                    personnage.jaugePeuple.valeur += this.effetsJauges.get(TypeJauge.PEUPLE);
                    break;
            }
        }
    }
}

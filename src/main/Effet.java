package main;

import java.util.List;
import java.util.Map;

public class Effet {
    private String gD;
    private String nom;
    private Map<TypeJauge,Integer> effetsJauges;

    public Effet(String gD, String nom, Map<TypeJauge, Integer> effetsJauges) {
        this.gD = gD;
        this.nom = nom;
        this.effetsJauges = effetsJauges;
    }

    public String getgD() {
        return gD;
    }

    public void setgD(String gD) {
        this.gD = gD;
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
        result.append("Effet "+this.gD);
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

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
}

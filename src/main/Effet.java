package main;

import java.util.List;

public class Effet {
    private String gD;
    private String nom;
    private List<Jauge> jauges;
    private List<Integer> valeurs;

    public Effet(String gD, String nom, List<Jauge> jauges, List<Integer> valeurs) {
        this.gD = gD;
        this.nom = nom;
        this.jauges = jauges;
        this.valeurs = valeurs;
    }
}

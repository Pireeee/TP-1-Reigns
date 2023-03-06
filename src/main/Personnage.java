package main;

import java.util.Scanner;

public class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;
    /**
     * Le genre du personnage
     */
    protected Genre genre;
    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     * @param genre Le genre du personnage
     */
    protected int reignDuration;
    public Personnage(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;
        this.reignDuration = 0;
    }

    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    public int getReignDuration() {
        return reignDuration;
    }

    public void incrementReign(){
        this.reignDuration++;
    }
     public void print(){
         System.out.println(this.genre.longRegne()
                 +" "+this.nom);
     }
     public static Personnage init(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Entrez le nom du personnage: ");
         System.out.flush();
         String nom = scanner.nextLine();
         System.out.println(
                 "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
         int genre = scanner.nextInt();
         return new Personnage(nom, genre==1 ? Genre.ROI : Genre.REINE );    }
}

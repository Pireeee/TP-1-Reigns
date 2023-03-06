package main;

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
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retourne le genre du personnage
     * @return le genre du personnage
     */
    public Genre getGenre() {
        return genre;
    }
    /**
     * Modifie le genre du personnage
     * @param genre Le nouveau genre du personnage
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getReignDuration() {
        return reignDuration;
    }

    public void incrementReign(){
        this.reignDuration++;
    }
}

package main;
/**
 * Représente une jauge avec un nom, une valeur et un type.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public abstract class Jauge {
    /**
     * Le type de la jauge
     */
    protected TypeJauge type; // fusionner type et nom

    /**
     * La valeur de la jauge
     */
    protected int valeur;

    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public Jauge(TypeJauge nom, int valeur){
        this.type = nom;
        this.valeur = valeur;
    }
    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     */
    public void afficheJauge() {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<this.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i = 0; i<50-(Math.max(this.getValeur(), 0)); i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += this.getNom();
        System.out.println(resultat);
    }

    /**
     * Retourne le nom de la jauge.
     *
     * @return le nom de la jauge
     */
    public String getNom() {
        return type.name().toLowerCase();
    }

    /**
     * Retourne la valeur de la jauge.
     *
     * @return la valeur de la jauge
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la jauge.
     *
     * @param valeur La nouvelle valeur de la jauge
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

}

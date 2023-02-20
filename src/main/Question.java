package main;

import java.util.Map;
import java.util.TreeMap;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    /**
     * l'effet de la réponse de gauche
     */
    protected Effet effetGauche;
    /**
     * l'effet de la réponse de droite
     */
    protected Effet effetDroite;

    /**
     * Construit une nouvelle question avec les informations données
     *
     * @param nomPersonnage Le nom du personnage associé à la question
     * @param question La question à poser
     * @param effetGauche L'effet de la réponse de gauche
     * @param effetDroite L'effet de la réponse de droite
     */
    public Question(String nomPersonnage,
                    String question,
                    Effet effetGauche,
                    Effet effetDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effetGauche
                + ",D: "+effetDroite
                + "]";
        System.out.println(result);
        effetGauche.afficheEffets();
        effetDroite.afficheEffets();
        System.out.flush();
    }

    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets les effets de jauge à appliquer
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    private void appliqueEffets(Personnage personnage, String gD){


    }

    /**
     * Retourne le nom du personnage associé à la question.
     *
     * @return le nom du personnage associé à la question
     */
    public String getNomPersonnage() {
        return nomPersonnage;
    }

    /**
     * Modifie le nom du personnage associé à la question.
     *
     * @param nomPersonnage le nouveau nom du personnage associé à la question
     */
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    /**
     * Retourne la question.
     *
     * @return la question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Modifie la question.
     *
     * @param question la nouvelle question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    public Effet getEffetGauche() {
        return effetGauche;
    }

    public void setEffetGauche(Effet effetGauche) {
        this.effetGauche = effetGauche;
    }

    public Effet getEffetDroite() {
        return effetDroite;
    }

    public void setEffetDroite(Effet effetDroite) {
        this.effetDroite = effetDroite;
    }

    //a finir
    public void appliqueEffet(Personnage personnage,String gD){
        if (gD.equals("G")){
            for (Map.Entry<TypeJauge, Integer> effet : effetGauche.getEffetsJauges().entrySet()) {
                // a finir
            }
        }

    }
}

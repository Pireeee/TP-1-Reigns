package main;

import java.util.HashMap;
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
     * les effets
     * */
    protected HashMap<String,Effet> effets;

    public Question(String nomPersonnage,
                    String question,
                    Map<String,Effet> effets) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effets.putAll(effets);
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effets.get("G").getNom()
                + ",D: "+effets.get("D").getNom()
                + "]";
        System.out.println(result);
        for(String gD: effets.keySet()){
            effets.get(gD).afficheEffets();
        }
        System.out.flush();
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

    public HashMap<String, Effet> getEffets() {
        return effets;
    }

    public void setEffets(HashMap<String, Effet> effets) {
        this.effets = effets;
    }
}

package main.question;

import main.jauges.JaugeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {

    //faire https://refactoring.guru/fr/design-patterns/prototype

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
    protected Map<String, Reponse> reponses;

    public Question() {
        reponses = new HashMap<>();
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+ reponses.get("G").getNom()
                + ",D: "+ reponses.get("D").getNom()
                + "]";
        System.out.println(result);
        for(String gD: reponses.keySet()){
            reponses.get(gD).afficheReponse();
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

    public Map<String, Reponse> getReponses() {
        return reponses;
    }

    public void addReponse(String direction, Reponse reponse) {
        this.reponses.put(direction,reponse);
    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     */
    public void poseQuestion(JaugeManager jauges){
        this.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        this.getReponses().get(reponse).AppliqueReponse(jauges);
    }
    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    public static Question getQuestionAleatoire(List<Question> questions){
        return questions.get((int) (Math.random()*questions.size()));
    }
}

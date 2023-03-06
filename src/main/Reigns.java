package main;

import main.question.BanqueQuestion;
import main.jauges.JaugeManager;
import main.question.Question;

import java.util.*;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {
    /**
     * le personnage joué
     */
    private static Personnage personnage;
    /**
     * la banque de questions
     */
    private static List<Question> questions;

    private static JaugeManager jaugeManager;

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){
        // début du jeu
        Reigns.startGame();

        // tirage des questions
        while(!Reigns.jaugeManager.finDuJeu()){
            personnage.incrementReign();
            Question question = Question.getQuestionAleatoire(questions);
            question.poseQuestion(jaugeManager);
            jaugeManager.afficheJauges();
        }
        // fin du jeu
        Reigns.endGame();
    }

    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    private static void startGame(){
        System.out.println("Bienvenue sur Reigns");
        questions = BanqueQuestion.init();
        System.out.println("Création du personnage...");
        Reigns.personnage = Personnage.init();
        Reigns.jaugeManager = JaugeManager.init();
        personnage.print();
        jaugeManager.afficheJauges();
    }
    private static void endGame(){
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        + personnage.getReignDuration()
                        + " tours");
    }
}

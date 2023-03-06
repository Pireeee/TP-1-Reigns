package main;

import main.question.BanqueQuestion;
import main.Jauges.JaugeManager;
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

    private static void initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
                "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Reigns.personnage = new Personnage(nom, genre==1 ? Genre.ROI : Genre.REINE );
    }


    private static void startGame(){
        System.out.println("Bienvenue sur Reigns");

        questions = BanqueQuestion.init();

        System.out.println("Création du personnage...");

        initPersonnage();

        Reigns.jaugeManager = new JaugeManager();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

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

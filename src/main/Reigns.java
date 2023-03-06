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
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            jaugeManager.afficheJauges();
        }

        // fin du jeu
        Reigns.endGame();


    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        question.getReponses().get(reponse).AppliqueReponse(jaugeManager);

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

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire(){
        return questions.get((int) (Math.random()*questions.size()));
    }

    private static void initJauges(){

        Reigns.jaugeManager = new JaugeManager();
    }

    private static void startGame(){
        System.out.println("Bienvenue sur Reigns");

        questions = BanqueQuestion.init();

        System.out.println("Création du personnage...");

        initPersonnage();

        initJauges();

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
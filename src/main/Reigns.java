package main;

import main.Jauges.JaugeManager;

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
    private static ArrayList<Question> questions;

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
        System.out.println("Bienvenue sur Reigns");

        initBanqueQuestions();

        System.out.println("Création du personnage...");

        initPersonnage();

        initJauges();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

        personnage.AfficheJauges(jaugeManager);

        // tirage des questions
        int nbTours = 0;
        while(!Reigns.jaugeManager.finDuJeu()){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            personnage.AfficheJauges(jaugeManager);
        }

        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

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
        question.effets.get(reponse).AppliqueEffect(jaugeManager);

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
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    private static void initBanqueQuestions(){
        questions = new ArrayList<>();
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                new HashMap<>(){{
                    put("G", new Effet("G","Oui", HashMap.newHashMap(2)));
                    put("D",new Effet("D","Non", HashMap.newHashMap(1)));
                }}
                );
        question1.effets.get("D").putEffetsJauges(TypeJauge.ARMEE, -5);
        question1.effets.get("D").putEffetsJauges(TypeJauge.PEUPLE, +5);
        question1.effets.get("G").putEffetsJauges(TypeJauge.PEUPLE, -7);
        questions.add(question1);
        /*
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE,-5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        questions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        questions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        questions.add(question4);
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        questions.add(question5);
        */
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
}
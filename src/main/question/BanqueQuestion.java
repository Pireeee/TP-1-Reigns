package main.question;

import java.util.ArrayList;
import java.util.List;

import main.TypeJauge;

public class BanqueQuestion {
    public static List<Question> init(){
        //liste de questions
        List<Question> questions = new ArrayList<>();
        //commence le build de la question
        QuestionBuilder question1 = new QuestionBuilder("Yves Jean","tu veux la guerre ?");
        //on ajoute une réponse
        question1.addReponse("G","Oui");
        question1.addEffet("G", TypeJauge.ARMEE,+5);
        question1.addEffet("G", TypeJauge.PEUPLE,-5);
        question1.addReponse("D","Non");
        question1.addEffet("G", TypeJauge.PEUPLE,+7);
        questions.add(question1.build());
        return questions;
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
}

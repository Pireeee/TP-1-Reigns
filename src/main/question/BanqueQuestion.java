package main.question;

import java.util.ArrayList;
import java.util.List;

import main.TypeJauge;

public class BanqueQuestion {
    public static List<Question> init(){
        //liste de questions
        List<Question> questions = new ArrayList<>();
        //commence le build de la question
        Question question1 = QuestionBuilder.builder("Yves Jean","tu veux la guerre ?")
            .addReponse("G","Oui")
            .addEffet("G", TypeJauge.ARMEE,+5)
            .addEffet("G", TypeJauge.PEUPLE,-5)
            .addReponse("D","Non")
            .addEffet("G", TypeJauge.PEUPLE,+7)
            .build();
        questions.add(question1);
        Question question2 =QuestionBuilder.builder("Paysan","Il n'y a plus rien à manger")
                .addReponse("G","importer de la nourriture")
                .addEffet("G", TypeJauge.FINANCE,-5)
                .addEffet("G", TypeJauge.PEUPLE,+5)
                .addReponse("D","Ne rien faire")
                .addEffet("G", TypeJauge.PEUPLE,-7)
                .build();
        questions.add(question2);
        Question question3 =QuestionBuilder.builder("Prêtre","Les dieux sont en colère")
                .addReponse("G","Faire un sacrifice")
                .addEffet("G", TypeJauge.CLERGE,+5)
                .addEffet("G", TypeJauge.PEUPLE,-3)
                .addReponse("D","Ne rien faire")
                .addEffet("G", TypeJauge.CLERGE,-5)
                .build();
        questions.add(question2);
        return questions;
        /*

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

package main.question;

import java.util.ArrayList;
import java.util.List;

import main.jauges.TypeJauge;

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
        questions.add(question3);
        Question question4 =QuestionBuilder.builder("Main du roi","Le roi Baratheon rassemble son armée")
                .addReponse("G","Le soutenir")
                .addEffet("G", TypeJauge.ARMEE,+3)
                .addEffet("G", TypeJauge.FINANCE,-3)
                .addReponse("D","Rester neutre")
                .addEffet("G", TypeJauge.CLERGE,-3)
                .addEffet("G", TypeJauge.PEUPLE,+3)
                .build();
        questions.add(question4);

        Question question5 =QuestionBuilder.builder("Paysan","Abondance de récoltes cette année")
                .addReponse("G","Taxer énormément")
                .addEffet("G", TypeJauge.PEUPLE,-5)
                .addEffet("G", TypeJauge.FINANCE,+10)
                .addReponse("D","Taxer un tout petit peu")
                .addEffet("G", TypeJauge.FINANCE,+1)
                .addEffet("G", TypeJauge.PEUPLE,-3)
                .build();
        questions.add(question5);
        return questions;
    }
}

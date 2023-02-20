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
    }
}

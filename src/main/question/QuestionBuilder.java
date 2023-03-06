package main.question;

import main.Jauges.TypeJauge;

public class QuestionBuilder {

    private final Question question;

    private QuestionBuilder(String nomPersonnage,String question) {
        this.question = new Question();
        this.question.nomPersonnage = nomPersonnage;
        this.question.question = question;
    }

    public QuestionBuilder addReponse(String direction, String nom) {
        this.question.addReponse(direction, new Reponse(direction,nom));
        return this;
    }

    public QuestionBuilder addEffet(String direction, TypeJauge jauge, int valeur) {
        this.question.getReponses().get(direction).putEffets(jauge,valeur);
        return this;
    }

    public Question build() {
        return this.question;
    }

    public static QuestionBuilder builder(String nomPersonnage, String question) {
        return new QuestionBuilder(nomPersonnage, question);
    }
}


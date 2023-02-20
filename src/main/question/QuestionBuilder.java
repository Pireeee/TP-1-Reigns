package main.question;

import main.TypeJauge;

public class QuestionBuilder {
    public Question question;

    public QuestionBuilder(String nomPersonnage,String question) {
        this.question = new Question();
        this.question.nomPersonnage = nomPersonnage;
        this.question.question = question;
    }
    public void addReponse(String direction, String nom){
        this.question.addReponse(direction, new Reponse(direction,nom));
    }
    public void addEffet(String direction, TypeJauge jauge, Integer valeur){
        this.question.getReponses().get(direction).putEffets(jauge,valeur);
    }
    public Question build(){
        return this.question;
    }
}

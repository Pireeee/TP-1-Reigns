package main.Builder;

import com.sun.jdi.Value;
import main.Effet;
import main.Question;
import main.TypeJauge;

import java.lang.reflect.Type;
import java.util.Map;

public class QuestionBuilder {
    protected Question question;

    public QuestionBuilder() {
        this.question= new Question();
    }

    public void addEffet(String direction){
        this.question.addEffets(direction);
    }
    public void addEffetDeJauge(String direction, TypeJauge jauge, Integer valeur){

    }
    public void SetName(String Name) {

    }
    public Question build(){
        return this.question;
    }
}

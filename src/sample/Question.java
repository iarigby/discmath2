package sample;

import java.util.ArrayList;

import static sample.QuestionType.*;

enum type {

}

enum QuestionType {
    DEFINITION, THEOREM, PROOF, OTHER

}


public class Question {
    private String question;
    QuestionType type;

    Question(String question) {
        this.question = question;
        if (question.toLowerCase().contains("prove")) {
            type = PROOF;
        } else if (question.toLowerCase().contains("define")) {
            type = DEFINITION;
        } else if (question.toLowerCase().contains("theorem")) {
            type = THEOREM;
        } else {
            type = OTHER;
        }
    }

    @Override
    public String toString() {
        return question;
    }
}

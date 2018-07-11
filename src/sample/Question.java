package sample;

import static sample.QuestionType.*;

enum QuestionType {
    DEFINITION, THEOREM, PROOF, OTHER

}


public class Question {
    private String question;
    QuestionType type;

    Question(String question) {
        this.question = question;
        if (question.toLowerCase().contains("prove") || question.toLowerCase().contains("proof")) {
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

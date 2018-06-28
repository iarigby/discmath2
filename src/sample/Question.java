package sample;

enum type {

}

public class Question {
    private String question;

    Question(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return question;
    }
}

package sample;

class Card<AnswerType> {
    int number;
    Question question;
    AnswerType answer;
    boolean skip;

    Card(int number, Question question, AnswerType answer) {
        this.number = number;
        this.question = question;
        this.answer = answer;
        skip = false;
    }

    @Override
    public String toString() {
        return number + ". " + question;
    }
}

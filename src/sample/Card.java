package sample;

class Card<AnswerType> {
    Question question;
    AnswerType answer;
    boolean skip;

    Card(Question question, AnswerType answer) {
        this.question = question;
        this.answer = answer;
        skip = false;
    }
}

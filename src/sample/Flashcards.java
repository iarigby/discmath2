package sample;

import java.util.ArrayList;

class Flashcards<AnswerType> {

    private ArrayList<AnswerType> answers = new ArrayList<>();
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Integer> queue = new ArrayList<>();
    private int reviewLeft = 1;
    private int currentCard = 0;
    private boolean reviewMode = true;


    private int getIndex(int i) {
        return (getSize() + currentCard + i) % getSize();
    }

    int getSize() {
       return questions.size();
    }

    private int getNextIndex(int i) {
        if (reviewMode) {
            if (reviewLeft <= 0) {
                currentCard = getIndex(i);
                reviewLeft = 0;
                queue.add(currentCard);
                for (int k = 1; k < 4
                        && currentCard - k >= 0; k++) {
                    queue.add(currentCard - k);
                    reviewLeft++;
                }
            } else {
                reviewLeft--;
            }
            return queue.remove(0);
        } else {
            currentCard = getIndex(i);
            return currentCard;
        }
    }

    // returns value after changing
    boolean toggleReview() {
        reviewMode = !reviewMode;
        return reviewMode;
    }

    String getNextQuestion(int i) {
        int nextCard = getNextIndex(i);
        return nextCard + 1 + ". " + questions.get(nextCard);
    }

    AnswerType getNextAnswer (int i) {
        return answers.get(getNextIndex(i));
    }

    void reset() {
        questions.clear();
        answers.clear();
        queue.clear();
        reviewLeft = 1;
        currentCard = 0;
        reviewMode = true;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }

    void addAnswer(AnswerType answer) {
        answers.add(answer);
    }

    //todo this smells
    void addToQueue() {
        queue.add(0);
    }

}

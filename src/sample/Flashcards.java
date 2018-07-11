package sample;

import java.util.ArrayList;
import java.util.Random;

class Flashcards<AnswerType> {


    private static final int REVIEW_NUMBER = 3;

    private ArrayList<Card<AnswerType>> cards = new ArrayList<>();
    private ArrayList<Integer> queue = new ArrayList<>();
    private int reviewLeft = 1;
    private int currentCard = 0;
    private boolean reviewMode = true;
    private boolean randomMode = false;
    private ArrayList<QuestionType> filteredTypes = new ArrayList<>();
    private Random random = new Random();

    private int getIndex(int i) {
        return (getSize() + currentCard + i) % getSize();
    }

    boolean toggleRandom() {
        randomMode = !randomMode;
        return randomMode;
    }

    int getSize() {
       return cards.size();
    }

    void skipCurrent() {
        cards.get(currentCard).skip = true;
    }

    private int getNextIndex(int i) {
        if (randomMode) {
            i = random.nextInt(getSize());
        }
        if (reviewMode) {
            if (reviewLeft <= 0) {
                currentCard = getIndex(i);
                reviewLeft = 0;
                queue.add(currentCard);
                for (int k = REVIEW_NUMBER; k >= 0; k--) {
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

    boolean toggleType(QuestionType type) {
        if (!filteredTypes.remove(type)) {
            filteredTypes.add(type);
            return false;
        }
        return true;
    }

    boolean isFiltered(QuestionType type) {
        return filteredTypes.contains(type);
    }

    // returns value after changing
    boolean toggleReview() {
        reviewMode = !reviewMode;
        return reviewMode;
    }

    Card getNextCard(int i) {
        return cards.get(getNextIndex(i));
    }

    int getCurrentCard() {
        return currentCard;
    }

    void reset() {
        cards.clear();
        queue.clear();
        reviewLeft = 1;
        currentCard = 0;
        reviewMode = true;
    }

    void addCard(int i, Question question, AnswerType answer) {
        cards.add(new Card<>(i, question, answer));
    }

    //todo this smells
    void addToQueue() {
        queue.add(0);
    }

}

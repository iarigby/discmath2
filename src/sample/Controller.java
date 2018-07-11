package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    private ImageView answer;

    @FXML
    private Label question;

    @FXML
    private Button allTopics, randomButton, skipButton, review, definitions, theorems, proofs, other;

    @FXML
    private Button previous, next;

    @FXML
    private VBox box;

    @FXML
    private HBox topics;

    @FXML
    private HBox subtopics;

    @FXML
    private Button refresh;

    private Flashcards<Image> flashcards;

    private boolean answerShown = false;
    private Button currentTopic;
    private Button currentSubtopic;
    private Topic topic;


    @Override
    public void initialize(URL url, ResourceBundle arg1) {
        flashcards = new Flashcards<>();
        //refresh.setOnAction(e -> refresh());
        allTopics.setOnAction(e -> getAllCards());
        definitions.setOnAction(e -> toggleButton(QuestionType.DEFINITION, definitions));
        theorems.setOnAction(e -> toggleButton(QuestionType.THEOREM, theorems));
        proofs.setOnAction(e -> toggleButton(QuestionType.PROOF, proofs));
        other.setOnAction(e -> toggleButton(QuestionType.OTHER, other));
        review.setOnAction(e -> toggleReviewMode());
        skipButton.setOnAction(e -> skipCard());
        randomButton.setOnAction(e -> toggleButton(flashcards.toggleRandom(), randomButton));
        next.setOnAction(e -> showCard(-    1));
        previous.setOnAction(e -> showCard(1));
        addTopics();
        toggleReviewMode();
        ((Button)topics.getChildren().get(0)).fire();
        ((Button)subtopics.getChildren().get(0)).fire();
    }


    private void getAllCards() {
        reset();
        currentTopic.setId("off");
        currentSubtopic.setId("off");
        allTopics.setId("on");
        currentTopic = allTopics;
        for (Topic topic : Topic.values()) {
            for (Subtopic subtopic : topic.getSubtopics()) {
                updateCards(topic.name() + "/" + subtopic.name(), false);
            }
        }
    }

    private void skipCard() {
        flashcards.skipCurrent();
        showCard(1);
    }

    /*
    private void refresh() {
        topics.getChildren().clear();
        subtopics.getChildren().clear();
        reset();
        addTopics();
        toggleReviewMode();
    }
    */

    private void addTopics() {
        for (Topic topic : Topic.values()) {
            Button button = new Button();
            button.setText(topic.name());
            button.setId("off");
            button.setOnAction( e -> {
                if (currentTopic != button) {
                    if (currentTopic != null) currentTopic.setId("off");
                    currentTopic = button;
                    this.topic = topic;
                    changeTopic(topic);
                    }
                }
            );
            topics.getChildren().add(button);
        }
    }

    private void changeTopic(Topic topic) {
        addSubTopics(topic);
        currentTopic.setId("on");
    }

    private void changeSubTopic(Subtopic subtopic) {
        currentSubtopic.setId("on");
        updateCards(topic.name() + "/" + subtopic.name());
    }

    private void addSubTopics(Topic topic) {
        subtopics.getChildren().clear();
        for (Subtopic subtopic : topic.getSubtopics()) {
            Button button = new Button();
            button.setText(subtopic.getName());
            button.setId("off");
            button.setOnAction( e -> {
                    if (currentSubtopic != button) {
                        if (currentSubtopic != null) currentSubtopic.setId("off");
                        currentSubtopic = button;
                        changeSubTopic(subtopic);
                    }
                }
            );
            subtopics.getChildren().add(button);
        }
    }

    private void reset() {
        question.setText("");
//        answer.setVisible(false);
        flashcards.reset();
        toggleReviewMode();
    }

    private void updateCards(String path, boolean reset) {
        if (reset) {
            reset();
        }
        try {
            Scanner scanner = new Scanner(new File("topics/" + path + "/questions.txt"));
            int i = 1;
            while (scanner.hasNext()) {
                flashcards.addCard(
                        new Question(scanner.nextLine()),
                        new Image("file:topics/" + path + "/"+i+".PNG"));
                i++;
            }
            flashcards.addToQueue();
            showCard(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCards(String path) {
        updateCards(path, true);
    }

    void doSomething(KeyCode code) {
        switch (code) {
            case SPACE:  case DOWN:
                flip(); break;
            case UP:
                skipCard(); break;
            case LEFT:
                showCard(-1); break;
            case RIGHT:
                showCard(1); break;
            case R:
                toggleReviewMode(); break;
            case S:
                skipCard(); break;
        }
    }

    private void flip() {
        answerShown = !answerShown;
        answer.setVisible(answerShown);
    }

    private void showCard(int i) {
        Card card;
        int j = 0;
        do {
            card = flashcards.getNextCard(i);
            if (i == 0) i = 1;
            j++;
        } while ((flashcards.isFiltered(card.question.type) || card.skip) && j < flashcards.getSize());
        question.setText(flashcards.getCurrentCard() + 1 + ". " + card.question.toString());
        answerShown = true;
        flip();
        answer.setImage((Image)card.answer);
    }

    @FXML
    void toggleReviewMode() {
        toggleButton(flashcards.toggleReview(), review);
    }

    private void toggleButton(QuestionType type, Button button) {
        toggleButton(flashcards.toggleType(type), button);
    }

    private void toggleButton(boolean b, Button button) {
        if (b)
            changeMode(button, "on");
        else
            changeMode(button, "off");
    }

    private void changeMode(Button button, String mode) {
        button.setText(mode);
        button.setId(mode);
    }

}

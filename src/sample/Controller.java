package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button review;

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
        review.setOnAction(e -> toggleReviewMode());
        addTopics();
        toggleReviewMode();
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

    private void updateCards(String path) {
        reset();
        try {
            Scanner scanner = new Scanner(new File("topics/" + path + "/questions.txt"));
            while (scanner.hasNext()) {
                flashcards.addQuestion(new Question(scanner.nextLine()));
            }
            for (int i = 1; i <= flashcards.getSize(); i++) {
                //todo refactor further
                flashcards.addAnswer(new Image("file:topics/" + path + "/"+i+".PNG"));
            }
            flashcards.addToQueue();
            showCard(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void doSomething(KeyCode code) {
        switch (code) {
            case SPACE: case UP: case DOWN:
                flip(); break;
            case LEFT:
                showCard(-1); break;
            case RIGHT:
                showCard(1); break;
            case R:
                toggleReviewMode(); break;
        }
    }

    private void flip() {
        answerShown = !answerShown;
        answer.setVisible(answerShown);
    }

    private void showCard(int i) {
        question.setText(flashcards.getNextQuestion(i));
        answerShown = true;
        flip();
        answer.setImage(flashcards.getNextAnswer(i));
    }

    @FXML
    void toggleReviewMode() {
        if (flashcards.toggleReview()) {
            review.setText("On");
            review.setId("on");
        } else {
            review.setText("Off");
            review.setId("off");
        }
    }

}

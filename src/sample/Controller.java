package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    private ImageView answer;

    @FXML
    private Label question;

    private boolean answerShown = false;
    private ArrayList<Image> cards = new ArrayList<>();
    private ArrayList<String> questions = new ArrayList<>();

    private int currentCard = 0;
    private int size;

    @Override
    public void initialize(URL url, ResourceBundle arg1) {
        try {
            Scanner scanner = new Scanner(new File("questions.txt"));
            while (scanner.hasNext()) {
                questions.add(scanner.nextLine());
            }
            size = questions.size();
            for (int i = 1; i <= size; i++) {
                cards.add(new Image("file:"+i+".PNG"));
            }
            showCard(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void doSomething(KeyCode code) {
        switch (code) {
            case SPACE:
                flip(); break;
            case LEFT:
                showCard(-1); break;
            case RIGHT:
                showCard(1); break;
        }
    }

    private void flip() {
        answerShown = !answerShown;
        answer.setVisible(answerShown);
    }

    private void showCard(int i) {
        currentCard = (size + currentCard + i) % size;
        question.setText(currentCard + 1 + ". " + questions.get(currentCard));
        answerShown = true;
        flip();
        answer.setImage(cards.get(currentCard));
    }

}

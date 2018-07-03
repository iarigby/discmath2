package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Controller controller = new Controller();
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setTitle("Discrete Math flashcards");
        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.getScene().setOnKeyPressed(
               e -> controller.doSomething(e.getCode())
        );
        primaryStage.getScene().getStylesheets().add("/stylesheet.css");
        primaryStage.show();


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FlashcardsPU");
//        EntityManager em = emf.createEntityManager();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

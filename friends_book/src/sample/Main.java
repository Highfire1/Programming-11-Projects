package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static sample.Controller.getFriendsObject;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("friend_book.fxml"));
        primaryStage.setTitle("Andys Friend Book");
        primaryStage.setScene(new Scene(root, 480, 800));
        primaryStage.show();

        primaryStage.setMaxHeight(800);
        primaryStage.setMaxWidth(480);
    }

    @Override
    public void stop(){
        getFriendsObject().save_data();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

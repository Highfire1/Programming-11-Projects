package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("friend_book.fxml"));
        primaryStage.setTitle("Andys Friend Book");
        primaryStage.setScene(new Scene(root, 480, 800));
        primaryStage.show();
    }

    @Override
    public void stop(){
        Controller.getFriends().save_data();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

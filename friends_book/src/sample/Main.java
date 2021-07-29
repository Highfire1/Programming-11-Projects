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
        primaryStage.setTitle("Andy's Friend Book");
        primaryStage.setScene(new Scene(root, 480, 800));
        primaryStage.show();

        // ListView, let alone the AnchorView doesn't expand with the window and that will take 2 years to fix .-.
        primaryStage.setMaxWidth(480);
        primaryStage.setMaxHeight(800);
        primaryStage.setMinWidth(480);
    }

    @Override
    public void stop(){
        // save data when program is exited
        Controller.getFriendsObject().save_data();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import friend.Friend;
import friend.FriendManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ListView list_view;
    public MenuItem menu_close;
    public MenuItem menu_settings;
    public MenuItem menu_about;
    public MenuItem menu_delete;
    public MenuItem menu_new;
    public FriendManager friends;





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        friends = new FriendManager();
        friends.load_data();

        list_view.setItems(friends.getObservableList());

    }


    public void populate_label(FriendManager friends) {

        //list_view.setItems(friends.getObservableList());

    }

    public void menu_close_method(ActionEvent actionEvent) throws IOException {

        friends.save_data();
        Platform.exit();
    }

    public void list_view_mouseclicked(MouseEvent mouseEvent) {

        String x = list_view.getSelectionModel().getSelectedItems().toString();
        list_view.getSelectionModel().clearSelection();

        friends.add_blank_friend();
    }

    public void menu_about_method(ActionEvent actionEvent) {
    }

    public void menu_settings_method(ActionEvent actionEvent) {
    }

    public void menu_delete_method(ActionEvent actionEvent) {
    }

    public void menu_new_method(ActionEvent actionEvent) {
    }

    public void menu_save_method(ActionEvent actionEvent) {
        friends.save_data();
    }

    public void menu_load_method(ActionEvent actionEvent) {
        friends.load_data();
    }
}

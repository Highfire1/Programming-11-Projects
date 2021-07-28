package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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

        friends = load_from_file("data/friends.tmp");

        System.out.println(friends);

        list_view.getItems().add("Bob Jenkins");
        list_view.getItems().add("spooky man");

        populate_label(friends.getArray());
    }

    private void save_to_file(Object obj, String pathname) {
        try {
            FileOutputStream fos = new FileOutputStream(pathname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

    private FriendManager load_from_file(String pathname) {

        if (new File(pathname).exists()) {
            try {

                FileInputStream fis = new FileInputStream(pathname);
                ObjectInputStream ois = new ObjectInputStream(fis);
                friends = (FriendManager) ois.readObject();
                ois.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return friends;

        } else {
            // if no data exists, generate new
            return new FriendManager();
        }
    }

    public void populate_label(ArrayList<Friend> friends) {
        for (Friend fr : friends) {
            System.out.println(fr.toString());
        }
    }

    public void menu_close_method(ActionEvent actionEvent) throws IOException {

        save_to_file(friends,"data/friends.tmp");
        Platform.exit();
    }

    public void list_view_mouseclicked(MouseEvent mouseEvent) {
        list_view.getItems().add("MORE TEXT!");
        System.out.println(mouseEvent.getX());

        String x = list_view.getSelectionModel().getSelectedItems().toString();
        list_view.getSelectionModel().clearSelection();

        System.out.println(x);

        //Friend aa = new Friend(12);
        //friends.add(aa);
        System.out.println("FRIEND ADDED");

    }

    public void menu_about_method(ActionEvent actionEvent) {
    }

    public void menu_settings_method(ActionEvent actionEvent) {
    }

    public void menu_delete_method(ActionEvent actionEvent) {
    }

    public void menu_new_method(ActionEvent actionEvent) {
    }
}

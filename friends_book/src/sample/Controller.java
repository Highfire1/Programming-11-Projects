package sample;

import friend.Friend;
import friend.FriendManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    public ListView list_view;
    public MenuItem menu_close;
    public MenuItem menu_delete;
    public MenuItem menu_new;
    public TextField text_name;
    public TextField text_phone;
    public CheckBox check_favorite;
    public TextArea text_notes;
    public DatePicker date_birthday;

    private static FriendManager friends;
    public ImageView profile_image;
    private Friend selected;

    LinkedHashMap<String, Image> images = new LinkedHashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        friends = new FriendManager();
        friends.load_data();

        list_view.setItems(friends.getObservableList());
        list_view.setBackground(Background.EMPTY);

        images.put("default.png", load_img("default.png"));
        images.put("goose.jpg", load_img("goose.jpg"));

        System.out.println(images);

        list_view.scrollTo(0);
        list_view.getSelectionModel().select(0);
        selected = friends.getObservableList().get(0);
        set_fields();



    }

    public Image load_img(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/" + path)));
    }


    public void menu_close_method(ActionEvent actionEvent) throws IOException {

        friends.save_data();
        Platform.exit();
    }

    public void list_view_mouseclicked(MouseEvent mouseEvent) {

        Friend friend = (Friend) list_view.getSelectionModel().getSelectedItems().get(0);

        selected = friend;

        set_fields();

    }

    public void set_fields(){
        profile_image.setImage(images.get(selected.getProfile_image()));
        text_name.setText(selected.getName());
        date_birthday.setValue(selected.getBirthdate());
        text_phone.setText(selected.getPhone_number());
        check_favorite.setSelected(selected.getFavorite());
        text_notes.setText(selected.getNotes());
    }


    public void menu_delete_method(ActionEvent actionEvent) {
        friends.delete_friend(selected);
        list_view.getSelectionModel().clearSelection();

        profile_image.setImage(null);
        text_name.clear();
        text_phone.clear();
        check_favorite.setSelected(false);
        text_notes.clear();
    }

    public void menu_new_method(ActionEvent actionEvent) {
        friends.add_blank_friend();
    }

    public void menu_save_method(ActionEvent actionEvent) {
        friends.save_data();
    }

    public void menu_load_method(ActionEvent actionEvent) {
        friends.load_data();
    }

    public void check_favorite_update(MouseEvent inputMethodEvent) {
        selected.setFavorite(check_favorite.isSelected());
    }

    public void text_phone_update(KeyEvent inputMethodEvent) {
        selected.setPhone_number(text_phone.getText());
    }

    public void text_notes_update(KeyEvent inputMethodEvent) {
        selected.setNotes(text_notes.getText());
    }

    public void text_name_update(KeyEvent keyEvent) {
        selected.setName(text_name.getText());
        list_view.refresh();
    }

    public void date_birthday_method(ActionEvent actionEvent) {
        selected.setBirthdate(date_birthday.getValue());
    }

    public static FriendManager getFriends() {
        return friends;
    }

    public void profile_image_update(MouseEvent mouseEvent) {
        //if (selected.getProfile_image() == )
    }
}

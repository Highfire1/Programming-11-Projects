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
import java.time.LocalDate;
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
    public ImageView profile_image;

    private static FriendManager friends;
    ArrayList<String> images;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        friends = new FriendManager();
        friends.load_data();

        list_view.setItems(friends.getObservableList());
        list_view.setBackground(Background.EMPTY);
        text_notes.setWrapText(true);

        images = new ArrayList<>();
        images.add("default.png");
        images.add("goose.jpg");


        setListViewFirstItem();
    }

    private Friend getListViewSelected(){
        return (Friend) list_view.getSelectionModel().getSelectedItems().get(0);
    }

    private Image load_img(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/" + path)));
    }

    private void setListViewFirstItem(){
        list_view.scrollTo(0);
        list_view.getSelectionModel().select(0);
        set_anchorpane_fields();
    }


    public void menu_close_method(ActionEvent actionEvent) throws IOException {
        friends.save_data();
        Platform.exit();
    }

    public void list_view_mouseclicked(MouseEvent mouseEvent) {
        if (getListViewSelected() == null) {
            return;
        }
        set_anchorpane_fields();
    }

    public void set_anchorpane_fields(){
        Friend fr = getListViewSelected();

        profile_image.setImage(load_img(fr.getProfile_image()));
        text_name.setText(fr.getName());
        if (fr.getBirthdate().equals(LocalDate.of(1970, 1, 1))) {
            date_birthday.getEditor().clear();
        } else {
            date_birthday.setValue(fr.getBirthdate());
        }
        text_phone.setText(fr.getPhone_number());
        check_favorite.setSelected(fr.getFavorite());
        text_notes.setText(fr.getNotes());
    }


    public void menu_delete_method(ActionEvent actionEvent) {
        friends.delete_friend(getListViewSelected());
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
        list_view.refresh();
        setListViewFirstItem();
    }

    public void check_favorite_update(MouseEvent inputMethodEvent) {
        getListViewSelected().setFavorite(check_favorite.isSelected());
    }

    public void text_phone_update(KeyEvent inputMethodEvent) {
        getListViewSelected().setPhone_number(text_phone.getText());
    }

    public void text_notes_update(KeyEvent inputMethodEvent) {
        getListViewSelected().setNotes(text_notes.getText());
    }

    public void text_name_update(KeyEvent keyEvent) {
        getListViewSelected().setName(text_name.getText());
        list_view.refresh();
    }

    public void date_birthday_method(ActionEvent actionEvent) {
        getListViewSelected().setBirthdate(date_birthday.getValue());
    }

    public static FriendManager getFriendsObject() {
        return friends;
    }


    public void profile_image_update(MouseEvent mouseEvent) {

        int i = images.indexOf(getListViewSelected().getProfile_image());

        if(i == images.size() - 1) {
            i = 0;
        } else {
            i++;
        }

        getListViewSelected().setProfile_image(images.get(i));

        set_anchorpane_fields();
    }
}

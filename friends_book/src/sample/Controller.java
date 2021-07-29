package sample;

import com.sun.corba.se.impl.legacy.connection.USLPort;
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

        // create FriendManager and load data from file
        friends = new FriendManager();
        friends.load_data();

        // initialize JavaFX elements
        list_view.setItems(friends.getObservableList());
        list_view.setBackground(Background.EMPTY);
        text_notes.setWrapText(true);

        // load image paths into array
        // yes a hashmap would be more efficient but I couldn't figure out how to get an index from it
        images = new ArrayList<>();
        images.add("default.png");
        images.add("goose.jpg");
        images.add("BFF.png");
        images.add("doc.png");
        images.add("eye.png");
        images.add("pig.gif");

        // select first object in listview
        setListViewFirstItem();
    }

    // get selected item in listview
    private Friend getListViewSelected(){
        return (Friend) list_view.getSelectionModel().getSelectedItems().get(0);
    }

    // load Images from data
    private Image load_img(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/" + path)));
    }

    // set listview selection to first entry to avoid errors
    private void setListViewFirstItem(){
        list_view.scrollTo(0);
        list_view.getSelectionModel().select(0);
        set_anchorpane_fields();
    }

    // an alternative way to exit :D
    public void menu_close_method(ActionEvent actionEvent) throws IOException {
        Platform.exit(); // calls stop in Main so no need to save here
    }

    // update when new listview item is selected
    public void list_view_mouseclicked(MouseEvent mouseEvent) {
        set_anchorpane_fields();
    }

    // load data from selected Friend into the AnchorView
    public void set_anchorpane_fields(){
        Friend fr = getListViewSelected();

        profile_image.setImage(load_img(fr.getProfile_image()));
        text_name.setText(fr.getName());
        // if default date (defined in Friend.Java), do not print a value
        if (fr.getBirthdate().equals(LocalDate.of(1970, 1, 1))) {
            date_birthday.getEditor().clear();
        } else {
            date_birthday.setValue(fr.getBirthdate());
        }
        text_phone.setText(fr.getPhone_number());
        check_favorite.setSelected(fr.getFavorite());
        text_notes.setText(fr.getNotes());
    }

    // deletes selected Friend (and clears AnchorView)
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
        list_view.refresh(); // I thought the whole point of ObservableList was to skip requiring this but oh well
        setListViewFirstItem();
    }

    // use to call save/load from other classes
    public static FriendManager getFriendsObject() {
        return friends;
    }

    // Iterate through available profile images when profile image is clicked
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

    // Methods to update selected Friend when a change is made
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

    public void date_birthday_method2(KeyEvent keyEvent) {
        getListViewSelected().setBirthdate(date_birthday.getValue());
        System.out.println(date_birthday.getEditor().getText());
    }

    public void date_birthday_method3(MouseEvent mouseEvent) {
        getListViewSelected().setBirthdate(date_birthday.getValue());
        System.out.println(date_birthday.getEditor().getText());
    }
}

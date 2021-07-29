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

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        //this REFUSES to work properly ;-;
        // no but seriously I've spent so much time trying to make this work and it absolutely refuses
        // for some reason, the DatePicker isn't editable while its in focus and that's terrible
        // + a variety of other small annoying things
        date_birthday.disableProperty().set(true);
    }

    // get selected item in listview
    private Friend getListViewSelected(){
        return (Friend) list_view.getSelectionModel().getSelectedItems().get(0);
    }

    // load Images from /assets/
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
    public void menu_close_method(ActionEvent actionEvent) {
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
        date_birthday.getEditor().setText("");

        if (fr.getBirthdate().equals(LocalDate.of(1970, 1, 1))) {
            date_birthday.getEditor().setText("");
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
        Datepicker_Manager(date_birthday);
    }

    public void date_birthday_method3(MouseEvent mouseEvent) {
        Datepicker_Manager(date_birthday);
    }

    public void date_birthday_method1(ActionEvent actionEvent) {

        //Datepicker_Manager(date_birthday);
    }

    // fine maybe ill build a SMALL parser because LocalDate isn't playing nice
    public void Datepicker_Manager(DatePicker paincreator){
        // getValue cannot be used because it doesn't update upon text entry see
        // https://bugs.openjdk.java.net/browse/JDK-8092295?page=com.atlassian.jira.plugin.system.issuetabpanels%3Achangehistory-tabpanel
        String date = date_birthday.getEditor().getText();

        if (date.equals("")) {
            // if date is blank then set to "blank value"
            getListViewSelected().setBirthdate(LocalDate.of(1970, 1, 1));
        } else if (date.length() != 10) {
            // if date is of incorrect length don't potentially cause errors
            return;
        } else {
            // yes theres still many ways this can error and it's going to be painful to catch all of them
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            getListViewSelected().setBirthdate(LocalDate.parse(date, formatter));
        }
    }
}

package sample;

import javafx.scene.image.Image;

import java.util.Date;

public class Friend {
    public Name name;
    public Date birthdate;
    public String phone_number;
    public Image profile_image;
    public String notes;
    public Boolean favorite;

    Friend(){
        this.name = new Name();
        this.birthdate = new Date();
        this.phone_number = "";
        this.profile_image = new Image("/assets/default.png");
        this.notes = "";
        this.favorite = false;
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Image getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Image profile_image) {
        this.profile_image = profile_image;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}

package sample;

import java.io.Serializable;
import java.time.LocalDate;

public class Friend implements Serializable {
    private Name name = new Name();
    private LocalDate birthdate = LocalDate.of(0, 1, 1);
    private String phone_number = "";
    private String profile_image = "assets/default.png";
    private String notes = "";
    private Boolean favorite = false;
    private int id;



    Friend(int id){
        this.id = id;
    }

    Friend(){
        this.id = 0;
    }


    @Override
    public String toString(){
        return this.name.toString();
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

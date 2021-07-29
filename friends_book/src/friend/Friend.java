package friend;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

public class Friend implements Serializable {
    // keeping https://www.kalzumeus.com/2010/06/17/falsehoods-programmers-believe-about-names/ in mind...
    private String name = "BLANK_NAME";
    private LocalDate birthdate = LocalDate.of(1970, 1, 1);
    private String phone_number = "";
    private String profile_image = "default.png";
    private String notes = "";
    private Boolean favorite = false;


    Friend(){}



    @Override
    public String toString(){
        return this.name.toString();
    }

    public String save_values(){
        String data = "";
        for (Field f : getClass().getDeclaredFields()) {
            try {
                data += f.get(this) + "␟";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        data = data.substring(0, data.length() - 1); // remove last separator
        return data + "\u2028"; // add line separator
    }

    public void load_values(String content){
        String[] values = content.split("␟");

        this.name = values[0];
        this.birthdate = LocalDate.parse(values[1]);
        this.phone_number = values[2];
        this.profile_image = values[3];
        this.notes = values[4];
        this.favorite = Boolean.parseBoolean(values[5]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
}

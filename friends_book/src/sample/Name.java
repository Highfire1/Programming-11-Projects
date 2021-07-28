// keeping https://www.kalzumeus.com/2010/06/17/falsehoods-programmers-believe-about-names/ in mind...

// oh no 88 pages: https://www.fbiic.gov/public/2008/nov/Naming_practice_guide_UK_2006.pdf


package sample;

import java.io.Serializable;

public class Name implements Serializable {
    private String name;
    private String surname;
    private String middle_name;
    private String prefix;
    private String suffix;

    Name() {
        this.name = "";
        this.surname = "";
        this.middle_name = "";
        this.prefix = "";
        this.suffix = "";
    }

    @Override
    public String toString() {

        if (name.isEmpty() && surname.isEmpty() ) {
            return "NO_NAME";
        } else if (name.isEmpty()) {
            return surname;
        } else {
            return name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

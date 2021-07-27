// keeping https://www.kalzumeus.com/2010/06/17/falsehoods-programmers-believe-about-names/ in mind...

// oh no 88 pages: https://www.fbiic.gov/public/2008/nov/Naming_practice_guide_UK_2006.pdf


package sample;

public class Name {
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
            return "empty name";
        } else if (name.isEmpty()) {
            return surname;
        } else {
            return name;
        }
    }
}

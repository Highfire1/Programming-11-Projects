// Teacher Object
// Stores teacher name & subject
// Several helper functions
public class Teacher {
    private String namefirst;
    private String namelast;
    private String subject;


    Teacher(String namefirst, String namelast, String subject) {
        this.namefirst = namefirst;
        this.namelast = namelast;
        this.subject = subject;

    }

    // Lets object be printed
    @Override
    public String toString() {
        String temp1 = "Name: " + namefirst + " " + namelast;
        String spacing = " ".repeat(30 - temp1.length()) ;
        String temp2 = "Subject: " + subject;
        return temp1 + spacing + temp2 ;
    }

    void changeNameFirst (String change) {
        this.namefirst = change;
    }

    void changeNameLast (String change) {
        this.namelast = change;
    }

    void changeSubject (String subject) {
        this.subject = subject;
    }

    public String getNameFirst() {
        return namefirst;
    }

    public String getNameLast() {
        return namelast;
    }

    public String getSubject() {
        return subject;
    }

}

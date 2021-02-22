// Student Object
// Stores student name, grade & a unique id
// Several helper functions
public class Student {
    private String namefirst;
    private String namelast;
    private int grade;
    private int id;
    private static int idtracker;


    Student(String namefirst, String namelast, int grade) {
        this.namefirst = namefirst;
        this.namelast = namelast;
        this.grade = grade;
        this.id = idtracker;
        idtracker++;
    }

    // Lets object be printed
    @Override
    public String toString() {
        String temp1 = "Name: " + namefirst + " " + namelast;
        String spacing = " ".repeat(30 - temp1.length()) ;
        String temp2 = "Grade: " + grade; // + "\t\tId :" + id;

        return temp1 + spacing + temp2 ;
    }


    void changeNameFirst (String change) {
        this.namefirst = change;
    }

    void changeNameLast (String change) {
        this.namelast = change;
    }

    void changeGrade (int grade) {
        this.grade = grade;
    }

    public String getNameFirst() {
        return namefirst;
    }

    public String getNameLast() {
        return namelast;
    }

    public int getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }


}

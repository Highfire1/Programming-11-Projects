/* School Materializer 2000
*  By [redacted]
*
*  Note: Minimum of Java 11 required for .repeat()
*/

// Main Loop
public class Main {
    public static void main(String[] args) {
        School Westerburg = new School();
        Westerburg.addStudent("Veronica", "Sawyer", 12);
        Westerburg.addStudent("Jason", "Dean", 12);
        Westerburg.addStudent("Heather", "McNamara", 12);
        Westerburg.addStudent("Heather", "Duke", 12);
        Westerburg.addStudent("Heather", "Chandler", 12);
        Westerburg.addStudent("Martha", "Dunnstock", 12);
        Westerburg.addStudent("Ram", "Sweeney", 12);
        Westerburg.addStudent("Kurt", "Kelley", 12);
        Westerburg.addStudent("Alexander", "Hamilton", 13);
        Westerburg.addStudent("Lydia", "Deetz", 10);

        Westerburg.addTeacher("Concernape", "Starlee", "Art");
        Westerburg.addTeacher("Anuk", "Mindustrie", "Science");
        Westerburg.addTeacher("Noch", "Minaft", "English");

        Westerburg.dumpStudents();
        Westerburg.dumpTeachers();

        Westerburg.delStudent("Sweeney");
        Westerburg.delStudent("Kelley");
        Westerburg.delTeacher("Starlee");

        Westerburg.dumpStudents();
        Westerburg.dumpTeachers();

    }
}

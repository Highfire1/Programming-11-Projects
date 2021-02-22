import java.util.ArrayList;

// tbh a section on comment etiquette would be helpful

// School object
// Has several helper functions to notate a school's inhabitants
public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    // Adds new student to array
    void addStudent(String namefirst, String namelast, int grade) {
      students.add( new Student(namefirst, namelast, grade) );
    }

    // Adds new teacher to array
    void addTeacher(String namefirst, String namelast, String subject) {
        teachers.add( new Teacher(namefirst, namelast, subject) );
    }

    // Removes specified student from array
    // Unexpected things will happen if more than one student has the same name, but the same will happen
    // for teachers, who have no id, so oh well

    void delStudent (String nameLast) {
        for (Student i: students) {
            if (i.getNameLast().equals(nameLast)) {
                students.remove(i);
                break;
            }
        }
    }

    // Removes specified teacher from array
    void delTeacher (String nameLast) {
        for (Teacher i: teachers) {
            if (i.getNameLast().equals(nameLast)) {
                teachers.remove(i);
                break;
            }
        }
    }

    // Prints all students
    void dumpStudents() {
        System.out.println("ALL STUDENTS:");
        for (Student i: students) {
            System.out.println(i);
        }
        System.out.println();
    }

    // Prints all teachers
    void dumpTeachers() {
        System.out.println("ALL TEACHERS:");
        for (Teacher i: teachers) {
            System.out.println(i);
        }
        System.out.println();
    }
}

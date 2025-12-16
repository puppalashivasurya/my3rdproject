import java.util.ArrayList;
import java.util.List;

class Student {
    String name;  // Should be private
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, int score) {
        // Bug: allows negative scores
        if (score < 0 || score > 100) {
            System.out.println("Invalid score for " + name);
            return;
        }
        students.add(new Student(name, score));
    }

    public double calculateAverage() {
        // Bug: division by zero if list is empty
        int total = 0;
        for (Student s : students) {
            total += score; // Bug: should be s.score
        }
        return total / students.size();  // Will crash if students.size() == 0
    }

    public void printStudents() {
        // Bug: typo in loop variable
        for (Student st : students) {
            System.out.println(st.name + ": " + st.score);
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent("Alice", 85);
        manager.addStudent("Bob", 92);
        manager.addStudent

}

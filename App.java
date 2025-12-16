import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    // Add a student to the list
    public void addStudent(String name, int score) {
        if (score < 0 || score > 100) {
            System.out.println("Invalid score for student " + name + ". Must be 0-100.");
            return;
        }
        students.add(new Student(name, score));
    }

    // Calculate the average score
    public double calculateAverage() {
        if (students.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (Student s : students) {
            total += s.getScore();
        }
        return (double) total / students.size();
    }

    // Print all students
    public void printStudents() {
        System.out.println("Student List:");
        for (Student s : students) {
            System.out.println("- " + s.getName() + ": " + s.getScore());
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent("Alice", 85);
        manager.addStudent("Bob", 92);
        manager.addStudent("Charlie", 78);
        manager.addStudent("Dave", 105); // Invalid score, will be ignored

        manager.printStudents();

        double average = manager.calculateAverage();
        System.out.println("Average score: " + average);
    }
}

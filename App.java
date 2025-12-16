import java.util.ArrayList;
import java.util.List;

public class BuggyExample {

    // ❌ Bug: public mutable field
    public static List<String> names = null;

    public static void main(String[] args) {

        // ❌ Bug: NullPointerException (names is null)
        names.add("Alice");

        // ❌ Bug: possible division by zero
        int result = divide(10, 0);
        System.out.println(result);

        // ❌ Bug: unused variable
        int unusedVariable = 42;

        // ❌ Bug: hardcoded password (security issue)
        String password = "admin123";

        // ❌ Bug: infinite loop
        while (true) {
            System.out.println("Running forever...");
            break; // Sonar will flag confusing logic
        }

        // ❌ Bug: equals used incorrectly for String comparison
        if (password == "admin123") {
            System.out.println("Logged in");
        }

        // ❌ Bug: array index out of bounds
        int[] numbers = new int[3];
        numbers[5] = 100;

        // ❌ Bug: NullPointer dereference
        String text = null;
        System.out.println(text.length());

        // ❌ Bug: empty catch block
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            // ignored
        }
    }

    // ❌ Bug: division by zero not checked
    public static int divide(int a, int b) {
        return a / b;
    }
}

}

package com.mycompany.my3rdproject;

/**
 * Main application class
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    /**
     * Main logic of the application
     */
    public void run() {
        System.out.println("Hello, world from my3rdproject!");
        
        // Example of a small computation
        int a = 5;
        int b = 7;
        int sum = add(a, b);
        System.out.println(a + " + " + b + " = " + sum);
    }

    /**
     * Simple method to add two numbers
     * @param x first number
     * @param y second number
     * @return sum of x and y
     */
    public int add(int x, int y) {
        return x + y;
    }
}

2. AppTest.java (unit test)

File path: src/test/java/com/mycompany/my3rdproject/AppTest.java

package com.mycompany.my3rdproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for App class
 */
public class AppTest {

    @Test
    void testAdd() {
        App app = new App();
        int result = app.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void testAddNegative() {
        App app = new App();
        int result = app.add(-2, -3);
        assertEquals(-5, result, "-2 + -3 should equal -5");
    }
}

3. Directory Structure

my3rdproject/
│
├─ pom.xml
├─ sonar-project.properties
├─ src/
│  ├─ main/
│  │   └─ java/
│  │       └─ com/mycompany/my3rdproject/
│  │           └─ App.java
│  └─ test/
│      └─ java/
│          └─ com/mycompany/my3rdproject/
│              └─ AppTest.java

4. How this works

    mvn clean test runs your unit tests (AppTest.java) via Surefire.

    mvn sonar:sonar picks up the code from App.java and test coverage if JaCoCo is configured.

    Jenkins pipeline stages (Build & Unit Tests, SonarQube Analysis, Quality Gate) all work with this setup.

This is a minimal but functional Java app with:

    main() method for execution

    run() method for business logic

    add() method as an example of functionality

    JUnit 5 tests to validate logic

If you want, I can also add a small CLI input feature so the app can take numbers from the user and add them—makes it a little more interactive for learning.

Do you want me to do that?





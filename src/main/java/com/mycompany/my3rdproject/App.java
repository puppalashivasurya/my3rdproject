package com.mycompany.my3rdproject;

import java.util.Scanner;

/**
 * Simple Java application
 * Demonstrates user input, addition, and console output
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    /**
     * Main application logic
     */
    public void run() {
        System.out.println("Welcome to My 3rd Project!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = readInt(scanner);

        System.out.print("Enter second number: ");
        int num2 = readInt(scanner);

        int sum = add(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);

        scanner.close();
    }

    /**
     * Adds two numbers
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Reads an integer safely from the scanner
     */
    private int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}

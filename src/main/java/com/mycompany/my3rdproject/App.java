package com.mycompany.my3rdproject;

public class App {
    public static void main(String[] args) {
        int x = 10 / 0;   // BUG for SonarQube
        System.out.println(x);
    }
}

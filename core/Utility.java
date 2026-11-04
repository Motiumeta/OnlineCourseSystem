package core;

import java.util.Scanner;

public class Utility {

    static public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {

        }
    }

    static public void line() {
        for (int i = 0; i < 30; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    static public void line(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static public void line(int num, char c) {
        for (int i = 0; i < num; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    static public void line(char ch) {
        for (int i = 0; i < 30; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    static public void header(String message) {
        line();
        println(message.toUpperCase());
        line();
    }

    static public void print(String prompt) {
        System.out.print(prompt);
    }

    static public void println(String prompt) {
        System.out.println(prompt);
    }

    static public Scanner input = new Scanner(System.in);

    static public String getLine(String prompt) {

        try {
            print(prompt);
            String choice = input.nextLine();
            if (choice.equals("0")) {
                clearScreen();
                return null;
            } else if (choice.isEmpty()) {
                return "-1";
            }
            return choice;

        } catch (Exception e) {
            println(e.getMessage());
            return null;
        }
    }

    static public void toContinue(String prompt) {
        if (prompt == null) {
            prompt = "Enter to Continue";
        }
        getLine(prompt);
    }

    static public void format(String mess) {
        print("| ");
        print(String.format("%-5s", mess));
    }

    static public void format(String mess, int padNum) {
        print("| ");
        String t = "%-" + padNum + "s";
        print(String.format(t, mess));
    }
}

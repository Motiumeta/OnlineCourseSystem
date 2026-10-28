import java.util.Scanner;

public class Utility {
    static void line() {
        for (int i = 0; i < 30; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    static void line(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static void line(int num, char c) {
        for (int i = 0; i < num; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    static void print(String prompt) {
        System.out.print(prompt);
    }

    static void println(String prompt) {
        System.out.println(prompt);
    }

    static Scanner input = new Scanner(System.in);

    static String getLine(String prompt) {

        try {
            print(prompt);
            return input.nextLine();

        } catch (Exception e) {
            println(e.getMessage());
            return "-1";
        }
    }
}

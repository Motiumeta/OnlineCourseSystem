
public class Main {
    public static void main(String[] args) {

        String choice = "-1";

        do {
            Utility.line();
            System.out.println("welcome to our course system".toUpperCase());
            Utility.line();
            Utility.println("1 - Manage Users");
            Utility.println("2 - Manage Courses");
            Utility.println("3 - Manage Enrollment");
            Utility.println("0 - Exit");
            choice = Utility.getLine("Choice: ");

        } while (choice != "0");

        Utility.input.close();
        ;
    }
}

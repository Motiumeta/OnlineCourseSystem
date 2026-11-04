package core;

import entities.Course;

public class Home {

    static void showIfCourseIsEmpty() {

    }

    static void manageAccount() {
        Utility.clearScreen();
        Utility.header("manage account");
        Utility.println("1 - Manage Own Courses");
        Utility.println("2 - Enrolled Course");
        Utility.println("0 - Log out");
        Utility.line();

        String choice = Utility.getLine("> ");
        if (choice.equals("1")) {
            ManageCourse.manageCourse();
        } else if (choice.equals("2")) {
            // showCourses();
        } else if (choice.equals("0")) {
            Utility.clearScreen();
            Authentication.logout();
            return;

        } else {
            Utility.clearScreen();
            Utility.println("Invalid Input");
        }
    }

    static public void homePage() {
        Utility.clearScreen();
        Utility.line();
        Utility.println("Welcome " + Authentication.currentUser.getFullName());

        while (true) {
            Utility.header("Home Page");
            if (DB.courses.isEmpty()) {
                Utility.println("No Courses available in the system.");
                // showIfCourseIsEmpty();
            }

            Utility.println("1 - Manage Account");
            Utility.println("0 - Log out");
            Utility.line();

            String choice = Utility.getLine("> ");
            if (choice.equals("1")) {
                manageAccount();
            } else if (choice.equals("2")) {
                // showCourses();
            } else if (choice.equals("0")) {
                Utility.clearScreen();
                Authentication.logout();
                return;

            } else {
                Utility.clearScreen();
                Utility.println("Invalid Input");
            }

        }
    }
}

package core;

import java.util.ArrayList;

import entities.Course;

public class ManageCourse {
    static void addCourse() {
        Utility.clearScreen();
        Utility.header("Adding Course");
        String name;
        if ((name = Utility.getLine("Course Name: ")) == null)
            return;
        DB.courses.add(new Course(name, Authentication.currentUser.id));
        Utility.clearScreen();
        Utility.line();
        Utility.println("Course added");
    }

    static void showCourses() {
        Utility.clearScreen();
        Utility.header("All Course");

        Utility.format("Id");
        Utility.format("Name", 15);
        Utility.println("|");
        Utility.line('-');

        for (Course c : DB.courses) {
            Utility.format(c.id);
            Utility.format(c.name, 15);
            Utility.println("|");
        }
        Utility.line();
        Utility.toContinue(null);
        Utility.clearScreen();
    }

    static public ArrayList<Course> coursesById(String id) {
        ArrayList<Course> courses = new ArrayList<>();
        if (id != null) {
            for (Course c : DB.courses) {
                if (c.createrId.equals(id)) {
                    courses.add(c);
                }
            }
        }

        return courses;

    }

    static public void manageCourse() {
        Utility.clearScreen();
        while (true) {
            ArrayList<Course> myCourses = new ArrayList<>();
            myCourses = coursesById(Authentication.currentUser.id);
            Utility.header("manage courses");

            if (myCourses.size() == 0) {
                Utility.println("No Courses. Create your first course.");

            } else {
                Utility.format("Id");
                Utility.format("Name", 15);
                Utility.println("|");
                Utility.line('-');

                for (Course c : DB.courses) {
                    Utility.format(c.id);
                    Utility.format(c.name, 15);
                    Utility.println("|");
                }
                Utility.line();

            }

            Utility.line();
            Utility.println("1 - Add Courses");
            Utility.println("2 - Show Courses Detail");
            Utility.println("0 - Back");
            Utility.line();

            String choice = "-1";
            if ((choice = Utility.getLine("> ")) == null) {
                Utility.clearScreen();
                return;
            }
            if (choice.equals("1")) {
                addCourse();
            } else if (choice.equals("2")) {
                showCourses();
            } else {
                Utility.clearScreen();
                Utility.println("Invalid Input");
            }

        }
    }
}

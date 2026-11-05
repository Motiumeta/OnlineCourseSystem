package core;

import java.util.ArrayList;

import entities.Course;
import entities.Lesson;

public class ManageCourse {
    static void addCourse() {
        Utility.clearScreen();
        Utility.header("Adding Course");
        String name, heading, paragraph;
        if ((name = Utility.getLine("Course Name: ")) == null)
            return;
        Course course = new Course(name, Authentication.currentUser.id);

        Utility.println("Course should have at least one leasson");
        if ((heading = Utility.getLine("Lesson Title: ")) == null)
            return;
        if ((paragraph = Utility.getLine("Lesson Paragraph: ")) == null)
            return;

        Lesson lesson = new Lesson(course.id, heading, paragraph);

        DB.courses.add(course);
        DB.lessons.add(lesson);

        Utility.clearScreen();
        Utility.line();
        Utility.println("Course added");
    }

    static void showCourses(String header) {
        Utility.clearScreen();
        Utility.header(header);

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

    static ArrayList<Lesson> getLessonsByCourseId(String courseId) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        if (courseId != null) {
            for (Lesson l : DB.lessons) {
                if (l.courseId.equals(courseId)) {
                    lessons.add(l);
                }
            }
        }

        return lessons;
    }

    static void updateCourse() {
        Course course;
        while (true) {
            showCourses("Select Course By Id To Edit");
            course = getCourseById(Utility.getLine("ID: "));
            if (course != null)
                break;
        }
        Utility.clearScreen();
        Utility.header("Course Detail");
        Utility.println("Name: " + course.name);
        Utility.println("Id: " + course.id);
        Utility.println("Lessons");
        ArrayList<Lesson> lessons = getLessonsByCourseId(course.id);

    }

    static public ArrayList<Course> coursesByUserId(String id) {
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

    static public Course getCourseById(String courseId) {

        if (courseId != null) {
            for (Course c : DB.courses) {
                if (c.id.equals(courseId)) {
                    return c;
                }
            }
        }
        return null;
    }

    static public void manageCourse() {
        Utility.clearScreen();
        while (true) {
            ArrayList<Course> myCourses = new ArrayList<>();
            myCourses = coursesByUserId(Authentication.currentUser.id);
            Utility.header("manage courses");

            if (myCourses.size() == 0) {
                Utility.println("No Courses. Create your first course.");
                Utility.line();

            } /*
               * else {
               * Utility.format("Id");
               * Utility.format("Name", 15);
               * Utility.println("|");
               * Utility.line('-');
               * 
               * for (Course c : DB.courses) {
               * Utility.format(c.id);
               * Utility.format(c.name, 15);
               * Utility.println("|");
               * }
               * Utility.line();
               * 
               * }
               */

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
                showCourses("All Course");
            } else {
                Utility.clearScreen();
                Utility.println("Invalid Input");
            }

        }
    }
}

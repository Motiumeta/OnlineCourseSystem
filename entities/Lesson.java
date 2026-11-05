package entities;

import java.util.ArrayList;

import core.DB;
import entities.Questions.Question;

public class Lesson {
    public String id;
    public String courseId;
    public String heading;
    public String paragraph;
    public ArrayList<Question> questions = new ArrayList<>();

    public Lesson(String courseId, String heading, String paragraph) {
        this.id = "l" + DB.lessons.size();
        this.courseId = courseId;
        this.heading = heading;
        this.paragraph = paragraph;
    }

}

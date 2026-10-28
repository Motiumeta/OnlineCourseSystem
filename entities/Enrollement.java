package entities;

public class Enrollement {
    static int total = 0;
    String id;
    String courseId;
    String studentId;
    Boolean pending;

    public Enrollement(String courseId, String studentId) {
        this.id = Integer.toString(total);
        this.courseId = courseId;
        this.studentId = studentId;
        this.pending = true;
        total++;
    }
}

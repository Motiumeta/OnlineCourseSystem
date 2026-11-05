package entities;

import core.DB;

public class Course {
    public String id;
    public String name;
    public String createrId;

    public Course(String name, String createrId) {
        this.id = "c" + DB.courses.size();
        this.name = name;
        this.createrId = createrId;
    }
}

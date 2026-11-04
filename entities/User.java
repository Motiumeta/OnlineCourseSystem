package entities;

import core.DB;
import core.Utility;

public class User {
    public String id;
    int age;
    String first;
    String last;
    public String email;
    String phoneNumber;
    public String password;

    public String getFullName() {
        return this.first + " " + this.last;
    }

    public User(String email, String password) {
        this.id = "" + DB.users.size();
        this.age = age;
        this.first = first;
        this.last = last;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        Utility.println("ID: " + this.id);
    }

    public Boolean checkPassword(String password) {
        return password.equals(this.password);
    }
}

package entities;

public class User {
    String id;
    int age;
    String first;
    String last;
    String email;
    String phoneNumber;
    private String password;

    public User(String id, int age, String first, String last, String email, String phoneNumber, String password) {
        this.id = id;
        this.age = age;
        this.first = first;
        this.last = last;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    Boolean checkPassword(String password) {
        return password == this.password;
    }
}

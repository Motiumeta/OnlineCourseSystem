package core;

import entities.User;

public class Authentication {

    static User currentUser;

    static void authPage() {
        String choice = "-1";

        do {

            Utility.header("welcome to our course system");
            // Utility.println("1 - Manage Users");
            Utility.println("1 - Login");
            Utility.println("2 - Signup");
            Utility.println("0 - Exit");
            Utility.line();

            choice = Utility.getLine("> ");

            if (choice.equals("1")) {
                Authentication.login();
            } else if (choice.equals("2")) {
                Authentication.signup();
            } else if (choice.equals("0")) {
                Utility.clearScreen();
                Utility.println("Thanks For Using Our Service");
                break;
            } else {
                Utility.clearScreen();
                Utility.line();
                Utility.println("Incorrect Input " + choice);
            }
        } while (!choice.equals("0"));
    }

    static Boolean IsEmailAlreadyTaken(String email) {
        for (User u : DB.users) {
            if (u.email.equals(email)) {
                return true;
            }
        }
        return false;
    }

    static String getEmailForSignUp() {

        while (true) {
            String email = Utility.getLine("Email: ");
            if (!IsEmailAlreadyTaken(email)) {
                return email;
            }
            Utility.println("The Email is already taken please try again");
        }
    }

    static void login() {
        Utility.clearScreen();
        Utility.header("LOGIN");
        String email, password;
        Boolean found = false;
        if ((email = Utility.getLine("Email: ")) == null)
            return;
        if ((password = Utility.getLine("Password: ")) == null)
            return;
        Utility.println(email + " " + password);
        for (User u : DB.users) {
            Utility.println(u.email + " " + u.password);
            if (u.email.equals(email) && u.checkPassword(password)) {
                found = true;
                currentUser = u;
                Home.homePage();
                return;
            }
        }

        if (!found) {
            Utility.println("Account Not Found");
        }

    }

    static void signup() {
        Utility.clearScreen();
        Utility.header("LOGIN");
        String email, password;
        if ((email = getEmailForSignUp()) == null)
            return;
        if ((password = Utility.getLine("Password: ")) == null)
            return;
        DB.users.add(new User(email, password));
        Utility.clearScreen();
        Utility.line();
        Utility.println("You have created account successfully");
    }

    static void logout() {
        currentUser = null;
        return;
    }
}

package core;

public class App {
    static public void myApp() {
        if (Authentication.currentUser == null) {
            Authentication.authPage();
        } else {
            Home.homePage();
        }
    }
}

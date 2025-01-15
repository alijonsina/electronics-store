package Controller;

import Exceptions.EmptyFieldException;
import View.PageNavigation;

public class LogInControl {
    private String userType;

    public LogInControl(String userType) {
        this.userType = userType;
    }

    public String handleSignUp(String username, String password) throws EmptyFieldException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new EmptyFieldException();
        } else {
            switch("Login Authorized") {                    //confirmLogIn(userType, username, password) place in switch case when implementation is done
                case "User does not exist" -> {return "User does not exist";}
                case "Incorrrect password" -> {return "Incorrect password";}
                case "Login Authorized" -> {PageNavigation.showMainMenuView(userType); return "Successful login";}
                default -> {return "Unknown error";}
            }
        }
    }
}
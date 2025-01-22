package Controller;

import Exceptions.EmptyFieldException;
import DataAccessObject.UserFileAccess;

import java.io.IOException;

public class LogInControl {
    private String userType;
    private UserFileAccess dao = new UserFileAccess();

    public LogInControl(String userType) {
        this.userType = userType;
    }

    public String handleSignUp(String username, String password) throws EmptyFieldException, IOException, ClassNotFoundException {
        System.out.println(userType + " " + username + " " + password);
        if (username.isEmpty() || password.isEmpty()) {
            throw new EmptyFieldException();
        } else {
            System.out.println(dao.confirmLogIn(userType, username, password));
            switch(dao.confirmLogIn(userType, username, password)) {
                case "User does not exist" -> {return "User does not exist";}
                case "Incorrect password" -> {return "Incorrect password";}
                case "Login Authorized" -> {PageNavigation.showMainMenuView(userType, username); return "Successful login";}
                default -> {return "Unknown error";}
            }
        }
    }
}
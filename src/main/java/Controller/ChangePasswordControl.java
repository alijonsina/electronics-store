package Controller;

import Exceptions.EmptyFieldException;
import DataAccessObject.UserFileAccess;

import java.io.IOException;

public class ChangePasswordControl {

    private UserFileAccess dao = new UserFileAccess();

    public String handleConfirm(String userType, String username, String password, String confirmPassword) throws EmptyFieldException, IOException, ClassNotFoundException {
        if (confirmPassword.isEmpty() || password.isEmpty()) {
            throw new EmptyFieldException();
        } else if (!confirmPassword.equals(password)) {
            return "Passwords do not match";
        } else {
            switch(dao.confirmLogIn(userType, username, password)) {
                case "User does not exist" -> {return "Cannot change password";}
                case "Incorrect password" -> {return "Incorrect password";}
                case "Login Authorized" -> {SecondStageNavigator.showNewPasswordView(userType, username); return "Select new password";}
                default -> {return "Unknown error";}
            }
        }
    }
}


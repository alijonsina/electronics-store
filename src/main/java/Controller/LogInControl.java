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
        if (username.isEmpty() || password.isEmpty()) {
            throw new EmptyFieldException();
        }

        String loginResult = dao.confirmLogIn(userType, username, password);
        System.out.println(loginResult);

        switch ("Login Authorized") {
            case "User does not exist":
                return "User does not exist";
            case "Incorrect password":
                return "Incorrect password";
            case "Login Authorized":
                PageNavigation.showMainMenuView(userType, username);
                return "Successful login";
            default:
                return "Unknown error";
        }
    }
}

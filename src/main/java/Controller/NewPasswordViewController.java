package Controller;

import DataAccessObject.UserFileAccess;
import Exceptions.EmptyFieldException;

import java.io.IOException;

public class NewPasswordViewController {

    private UserFileAccess dao = new UserFileAccess();

    public String handleNewPassword(String username, String password, String confirmPassword) throws EmptyFieldException, IOException, ClassNotFoundException {
        if (confirmPassword.isEmpty() || password.isEmpty()) {
            throw new EmptyFieldException();
        } else if (!confirmPassword.equals(password)) {
            return "Passwords do not match";
        } else {
            String results = dao.changePassword(username, password);
            return results;
        }

    }
}

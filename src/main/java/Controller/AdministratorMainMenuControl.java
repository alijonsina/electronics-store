package Controller;

import Model.Administrator;
import Model.Manager;
import View.PageNavigation;
import DataAccessObject.UserFileAccess;
import java.io.IOException;

public class AdministratorMainMenuControl {
    private Administrator admin;
    private UserFileAccess dao = new UserFileAccess();

    public AdministratorMainMenuControl(String username) throws IOException, ClassNotFoundException {
        admin = (Administrator) dao.viewUserInfo(username);
    }

    public void handleLogOut() {
        PageNavigation.showMultiLogInView();
    }

    public void handleViewUserInfo() {
        PageNavigation.showAdministratorInfo(admin);
    }
}

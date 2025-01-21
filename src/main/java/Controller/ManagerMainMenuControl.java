package Controller;

import Model.Manager;
import View.PageNavigation;
import DataAccessObject.UserFileAccess;
import java.io.IOException;

public class ManagerMainMenuControl {
    private Manager manager;
    private UserFileAccess dao = new UserFileAccess();

    public ManagerMainMenuControl(String username) throws IOException, ClassNotFoundException {
        manager = (Manager) dao.viewUserInfo(username);
    }

    public void handleLogOut() {
        PageNavigation.showMultiLogInView();
    }

    public void handleViewUserInfo() {
        PageNavigation.showManagerInfo(manager);
    }
}

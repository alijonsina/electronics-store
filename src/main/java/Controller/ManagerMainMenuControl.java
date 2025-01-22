package Controller;

import Model.Manager;
import DataAccessObject.UserFileAccess;

import java.io.IOException;

public class ManagerMainMenuControl {
    private Manager manager;
    private UserFileAccess dao = new UserFileAccess();

    public ManagerMainMenuControl(String username) throws IOException, ClassNotFoundException {
        Object user = dao.viewUserInfo(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + username);
        }
        if (!(user instanceof Manager)) {
            throw new ClassCastException("User is not a Manager: " + username);
        }
        manager = (Manager) user;
    }

    public void handleLogOut() {
        PageNavigation.showMultiLogInView();
    }

    public void handleViewUserInfo() {
        PageNavigation.showManagerInfo(manager);
    }

    public void handleViewStock() {
        PageNavigation.showItemView(manager.getUsername());
    }
}
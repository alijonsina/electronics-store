package Controller;

import Model.Cashier;
import DataAccessObject.UserFileAccess;
import java.io.IOException;

public class CashierMainMenuControl {

    private Cashier cashier;
    private UserFileAccess dao = new UserFileAccess();

    public CashierMainMenuControl(String username) throws IOException, ClassNotFoundException {
        cashier = (Cashier) dao.viewUserInfo(username);
    }

    public void handleLogOut() {
        PageNavigation.showMultiLogInView();
    }

    public void handleViewUserInfo() {
        PageNavigation.showCashierInfo(cashier);
    }

    public void handleCreateBIll() {
        PageNavigation.showBillView(cashier.getUsername());
    }
}
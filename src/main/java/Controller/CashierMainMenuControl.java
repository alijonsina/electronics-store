package Controller;

import View.PageNavigation;

public class CashierMainMenuControl {

    private Cashier cashier;

    public CashierMainMenuControl() {
        cashier = getCashierInfo();
    }

    public void handleLogOut() {
        PageNavigation.showMultiLogInView();
    }

    public void handleViewUserInfo() {
        PageNavigation.showCashierInfo(cashier);
    }
}
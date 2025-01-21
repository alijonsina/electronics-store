package Controller;

import View.PageNavigation;

import java.io.IOException;

public class CashierInfoController {

    public void handleBackButton(String username) throws IOException, ClassNotFoundException {
        PageNavigation.showCashierMenuView(username);
    }

    public void handleChangePasswordButton() {

    }
}

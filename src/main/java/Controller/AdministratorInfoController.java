package Controller;

import View.PageNavigation;
import java.io.IOException;

public class AdministratorInfoController {

    public void handleBackButton(String username) throws IOException, ClassNotFoundException {
        PageNavigation.showManagerMenuView(username);
    }

    public void handleChangePasswordButton() {

    }
}

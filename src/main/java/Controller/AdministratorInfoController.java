package Controller;

import javafx.stage.Stage;
import java.io.IOException;

public class AdministratorInfoController {

    Stage changePasswordStage;

    public void handleBackButton(String username) throws IOException, ClassNotFoundException {
        PageNavigation.showAdministratorMenuView(username);
    }

    public void handleChangePasswordButton(String username) throws IOException, ClassNotFoundException {
        changePasswordStage = new Stage();
        changePasswordStage.setTitle("Change Password");
        changePasswordStage.setResizable(false);
        SecondStageNavigator.setSecondaryStage(changePasswordStage);
        SecondStageNavigator.showChangePasswordView("Admin", username);
    }
}

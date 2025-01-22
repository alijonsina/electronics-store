package Controller;

import View.ChangePasswordView;
import View.NewPasswordView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class SecondStageNavigator {
    private static Stage secondaryStage;

    public static void setSecondaryStage(Stage stage) {
        secondaryStage = stage;
    }

    public static void showChangePasswordView(String userType, String username) {
        ChangePasswordView passwordView = new ChangePasswordView(userType, username);
        Scene scene = passwordView.createScene();
        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Change Password");
        secondaryStage.show();
    }

    public static void showNewPasswordView(String userType, String username) {
        NewPasswordView passwordView = new NewPasswordView(userType, username);
        Scene scene = passwordView.createScene();
        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Change Password");
        secondaryStage.show();
    }
}

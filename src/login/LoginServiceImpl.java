package login;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginServiceImpl implements LoginService{
	@Override
	public void showLoginPage(Parent preRoot) {
		Stage showLoginPageStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		}catch(IOException e) { e.printStackTrace(); }
		Scene scene = new Scene(root);
		LoginController controller = loader.getController();
		controller.setRoot(preRoot, root);
		showLoginPageStage.setScene(scene);
		showLoginPageStage.initStyle(StageStyle.UNDECORATED);
		showLoginPageStage.show();
	}
}

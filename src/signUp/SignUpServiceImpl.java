package signUp;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SignUpServiceImpl implements SignUpService{
	@Override
	public void showSignUp(Parent preRoot) {
		Stage showSignUp = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		}catch(IOException e) { e.printStackTrace(); }
		Scene scene = new Scene(root);
		SignUpController controller = loader.getController();
		controller.setRoot(preRoot, root);
		showSignUp.setScene(scene);
		showSignUp.initStyle(StageStyle.UNDECORATED);
		showSignUp.show();
	}
}

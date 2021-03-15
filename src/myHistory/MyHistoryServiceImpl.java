package myHistory;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyHistoryServiceImpl implements MyHistoryService{
	@Override
	public void showMyHistory(Parent preRoot) {
		Stage showMyHistory = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("myHistory.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		}catch(IOException e) { e.printStackTrace(); }
		Scene scene = new Scene(root);
		MyHistoryController controller = loader.getController();
		controller.setRoot(preRoot, root);
		showMyHistory.setScene(scene);
		showMyHistory.initStyle(StageStyle.UNDECORATED);
		showMyHistory.show();
	}
}

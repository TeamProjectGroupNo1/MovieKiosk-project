package movieInfo;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MovieInfoImpl implements MovieInfo {

	@Override
	public void movieInfo(Parent preRoot ,String movieName) {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("movieInfoFXML.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {e.printStackTrace();}
		Scene scene = new Scene(root);
		MovieInfoController controller2 = loader.getController();
		controller2.setRoot(preRoot, root, movieName);
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}	
}

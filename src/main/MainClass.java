package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainClass extends Application {
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) { e.printStackTrace(); }
		Scene scene = new Scene(root);
		MainController controller = loader.getController();
		controller.setRoot(root);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

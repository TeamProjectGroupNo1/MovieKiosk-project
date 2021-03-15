package myTicket;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyTicketServiceImpl implements MyTicketService{
	@Override
	public void showMyTicket(Parent preRoot) {
		Stage showMyTicket = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("myTicket.fxml"));
		Parent root = null;
		try {
			root= loader.load();
		}catch(IOException e) { e.printStackTrace(); }
		Scene scene = new Scene(root);
		MyTicketController controller = loader.getController();
		controller.setRoot(preRoot, root);
		showMyTicket.setScene(scene);
		showMyTicket.initStyle(StageStyle.UNDECORATED);
		showMyTicket.show();
	}
}

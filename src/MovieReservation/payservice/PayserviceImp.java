package MovieReservation.payservice;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PayserviceImp implements Payservice{

	@Override
	public void payment() {
		// TODO Auto-generated method stub
		Stage payStage = new Stage();
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("Payment.fxml"));
		Parent root = null;
		
				try {
					root = loader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
		Scene scene = new Scene(root);
		
		PayserviceController controller3 = loader.getController();
		controller3.setRoot(root);
		payStage.setScene(scene);
		payStage.initStyle(StageStyle.UNDECORATED);
		payStage.show(); //
		
	}

}


package movieReservation.payservice;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import movieReservation.reservationCon;

public class payServiceImpl implements payservice{

	@Override
	public void payment() {
		System.out.println("클래스 멤버 동작");
		Stage payStage = new Stage();
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("payment.fxml"));
		Parent root = null;
		
				try {
					root = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		Scene scene = new Scene(root);
		
		payController controller = loader.getController();
		controller.setRoot(root);
		
		payStage.setScene(scene);
		payStage.show(); //
		
	}

}

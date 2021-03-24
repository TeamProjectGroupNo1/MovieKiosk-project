package MovieReservation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ReservationImp implements Reservation{
	
	@Override
	public void Reservationlist(Parent preRoot) {
		// TODO Auto-generated method stub
		Stage reStage = new Stage();
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("Rservationfxml.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		ReservationController controller1 = loader.getController();
		controller1.setRoot(preRoot, root);
		reStage.setScene(scene);
		reStage.initStyle(StageStyle.UNDECORATED);
		reStage.show();
	}
}


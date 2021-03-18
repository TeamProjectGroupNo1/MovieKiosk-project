package movieReservation.payservice;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class payController implements Initializable{

	private Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	} 
	public void payCancel() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		System.out.println("취소 버튼 클릭");
	}

}

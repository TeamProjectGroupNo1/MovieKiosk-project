package MovieReservation.payservice;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import login.LoginService;
import login.LoginServiceImpl;

public class PayserviceController implements Initializable{

	private Parent root;
	public void setRoot(Parent root) {
		this.root = root;}
	Payservice ps;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ps = new PayserviceImp();
	}
	public void payCancel() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public void clkComp() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		LoginService lsi = new LoginServiceImpl();
		lsi.showLoginPage(root);
	}
}

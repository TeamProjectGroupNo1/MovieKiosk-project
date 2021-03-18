package avengers;

import java.net.URL;
import java.util.ResourceBundle;

import avengers.media.Media01;
import avengers.media.Media01Imp;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class avengersCon implements Initializable{


	
	Parent root;
	Media01 ms;
	public void setRoot(Parent root) {
		this.root = root;
		ms.setMedia(root, "../../resources/media/avengersVideo.mp4");
		
		
	}
	
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new Media01Imp();
		
	}
	public void myPlay() {ms.myStart();}
	public void myStop() {ms.myStop();}
	public void myPause() {ms.myPause();}
	}


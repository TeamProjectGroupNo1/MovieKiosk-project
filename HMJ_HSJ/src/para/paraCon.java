package para;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import para.paraMedia.paramedia;
import para.paraMedia.paramediaImpl;

public class paraCon implements Initializable{
	
	Parent root;
	paramedia ms2;
	public void setRoot(Parent root) {
		this.root = root;
		ms2.setMedia(root, "../../resources/media/parasiteVideo.mp4");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ms2 = new paramediaImpl();
		
	}
	public void myPlay() {ms2.myStart();}
	public void myStop() {ms2.myStop();}
	public void myPause() {ms2.myPause();}
	
	
}

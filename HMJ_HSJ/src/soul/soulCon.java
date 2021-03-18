package soul;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import soul.soulMedia.soulMedia;
import soul.soulMedia.soulMediaImpl;

public class soulCon implements Initializable{
	
	Parent root;
	soulMedia ms3;
	public void setRoot(Parent root) {
		this.root = root;
		ms3.setMedia(root, "../../resources/media/soulVideo.mp4");
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ms3 = new soulMediaImpl();
		
	}
	public void myPlay() {ms3.myStart();}
	public void myStop() {ms3.myStop();}
	public void myPause() {ms3.myPause();}
}

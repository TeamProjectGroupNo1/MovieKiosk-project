package harry;

import java.net.URL;
import java.util.ResourceBundle;

import harry.media.harryMedia;
import harry.media.harryMediaImp;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class harryCon implements Initializable{
	
	Parent root;
	harryMedia ms1;
	public void setRoot(Parent root) {
		this.root = root;
		ms1.setMedia(root, "../../resources/media/HarryVideo.mp4");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ms1 = new harryMediaImp();
		
	}
	public void myPlay() {ms1.myStart();}
	public void myStop() {ms1.myStop();}
	public void myPause() {ms1.myPause();}
	
	}



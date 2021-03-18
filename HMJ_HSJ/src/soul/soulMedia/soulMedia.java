package soul.soulMedia;

import javafx.scene.Parent;

public interface soulMedia {

	
	public void myStart();
	public void myPause();
	public void myStop();
	
	public void setMedia(Parent root, String mediaName);
}

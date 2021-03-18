package soul.soulMedia;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class soulMediaImpl implements soulMedia{
	private MediaPlayer mediaPlayer;
	private MediaView soulMedia;
	private Button soulbtnPlay;
	private Button soulbtnStop;
	private Button soulbtnPause;
	private boolean endOfMedia;
	
	public void setController(Parent root) {
		soulMedia = (MediaView)root.lookup("#soulMedia");
		soulbtnPlay = (Button)root.lookup("#soulbtnPlay");
		soulbtnStop = (Button)root.lookup("#soulbtnStop");
		soulbtnPause = (Button)root.lookup("#soulbtnPause");
	
	}
	
	@Override
	public void setMedia(Parent root, String mediaName) {
		// TODO Auto-generated method stub
		setController(root);
		System.out.println(mediaName);
		Media media = new Media(getClass().getResource(mediaName).toString());
		mediaPlayer = new MediaPlayer(media);
		soulMedia.setMediaPlayer(mediaPlayer);
			
			
		}
	
	

	@Override
	public void myStart() {
		mediaPlayer.play();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myPause() {
		mediaPlayer.pause();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myStop() {
		mediaPlayer.stop();
		// TODO Auto-generated method stub
		
	}



}

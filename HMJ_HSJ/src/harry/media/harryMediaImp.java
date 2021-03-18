package harry.media;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class harryMediaImp implements harryMedia {
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;
	private Button harrybtnPlay;
	private Button harrybtnPause;
	private Button harrybtnStop;
	private boolean endOfMedia;
	public void setController(Parent root) {
		mediaView = (MediaView)root.lookup("#harryMedia");
		harrybtnPlay = (Button)root.lookup("#harrybtnPlay");
		harrybtnPause = (Button)root.lookup("#harrybtnPause");
		harrybtnStop = (Button)root.lookup("#harrybtnStop");
	}
	@Override
	public void setMedia(Parent root, String mediaName) {
		// TODO Auto-generated method stub
	setController(root);
	System.out.println(mediaName);
	Media media = new Media(getClass().getResource(mediaName).toString());
	mediaPlayer = new MediaPlayer(media);
	mediaView.setMediaPlayer(mediaPlayer);
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

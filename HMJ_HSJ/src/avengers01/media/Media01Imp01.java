package avengers.media;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Media01Imp implements Media01{
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;
	private Button btnPlay;
	private Button btnPause;
	private Button btnStop;
	private boolean endOfMedia;
	public void setController(Parent root) {
		mediaView = (MediaView)root.lookup("#avenMedia");
		btnPlay = (Button)root.lookup("#btnPlay");
		btnPause = (Button)root.lookup("#btnPause");
		btnStop = (Button)root.lookup("#btnStop");
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

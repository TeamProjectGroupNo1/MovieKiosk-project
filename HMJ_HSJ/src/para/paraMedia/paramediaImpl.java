package para.paraMedia;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class paramediaImpl implements paramedia {
	private MediaPlayer mediaPlayer;
	private MediaView paraMedia;
	private Button parabtnPlay;
	private Button parabtnStop;
	private Button parabtnPause;
	private boolean endOfMedia;
	
	
	public void setController(Parent root) {
		paraMedia = (MediaView)root.lookup("#paraMedia");
		parabtnPlay = (Button)root.lookup("#parabtnPlay");
		parabtnStop = (Button)root.lookup("#parabtnStop");
		parabtnPause = (Button)root.lookup("#parabtnPause");
		
		
	}

	@Override
	public void setMedia(Parent root, String mediaName) {
		// TODO Auto-generated method stub
	setController(root);
	System.out.println(mediaName);
	Media media = new Media(getClass().getResource(mediaName).toString());
	mediaPlayer = new MediaPlayer(media);
	paraMedia.setMediaPlayer(mediaPlayer);
		
		
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

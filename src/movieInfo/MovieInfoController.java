package movieInfo;

import java.net.URL;
import java.util.ResourceBundle;

import MovieReservation.Reservation;
import MovieReservation.ReservationImp;
import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import movieReview.MovieReviewService;
import movieReview.MovieReviewServiceImpl;

public class MovieInfoController implements Initializable{
	private MediaPlayer mediaPlayer;
	private MovieReviewService mrsi;
	private Reservation ra;
	private String movieName;
	@FXML MediaView mediaView;
	@FXML ImageView imgInfo;
	@FXML ImageView imgInfo2;
	@FXML Label labMovieName;
	@FXML Label labStory;
	Parent root;
	Parent preRoot;

	public void setRoot(Parent preRoot, Parent root, String movieName) {
		this.root = root;
		this.preRoot = preRoot;
		this.movieName = movieName;
		setControlls(movieName);
	}
	
	public void setControlls(String movieName) {
		mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/resources/media/info/"+movieName+".mp4").toString()));
		mediaView.setMediaPlayer(mediaPlayer);
		imgInfo.setImage(new Image("resources/img/info/"+movieName+"_image.png"));
		imgInfo2.setImage(new Image("resources/img/info/"+movieName+"_info.png"));
		labMovieName.setText(CommonService.getMovieName(movieName));
		String story="";
		switch(movieName) {
			case "Avengers_04": story = "인피니티 워 이후 절반만 살아남은 지구 마지막 희망이 된 어벤져스 먼저 떠난 그들을 위해 모든 것을 걸었다!"; break;
			case "HarryPotter_08": story = "모든 것을 끝낼 최후의 전투! 판타지의 역사가 드디어 마침표를 찍는다!"; break;
			case "Parasite": story = "살 길 막막하지만 사이좋은 기택 가족, 장남 기우 친구의 소개로 박사장 집으로 향하는데.."; break;
			case "Soul": story = "음악선생님 조, 최고의 밴드와 연주하게 된 그날, 사고로 영혼이 되어 태어나기 전 세상에 떨어진다."; break;
		}
		labStory.setText(story);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ra = new ReservationImp();
		mrsi = new MovieReviewServiceImpl();
	}

	public void myPlay() {
		if(mediaPlayer != null) mediaPlayer.play();
	}
	public void myStop() { mediaPlayer.pause(); }
	public void myPause() { mediaPlayer.stop(); }
	
	public void clkMovieReview() {
		mrsi.showMovieReviewPage(root, movieName);
		CommonService.closeRoot(root);
	}

	public void clkReservationInfo() {
		ra.Reservationlist(root);
		CommonService.closeRoot(root);
	}
	
	public void clkBack() {
		CommonService.back(preRoot, root);
	}
}
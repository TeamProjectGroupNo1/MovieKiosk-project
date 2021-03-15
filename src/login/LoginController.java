package login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import myHistory.MyHistoryService;
import myHistory.MyHistoryServiceImpl;
import myTicket.MyTicketServiceImpl;
import myTicket.MyTicketService;

public class LoginController implements Initializable{
	@FXML ImageView imgMoviePoster;
	private MyTicketService mtsi;
	private MyHistoryService mhsi;
	Parent root;
	Parent preRoot;
	private int moviePage;
	public void setRoot(Parent preRoot, Parent root) {
		this.root = root;
		this.preRoot = preRoot;
		moviePage = 0;
		clkRight(); //첫 화면 포스터, 영화제목 설정
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mtsi = new MyTicketServiceImpl();
		mhsi = new MyHistoryServiceImpl();
	}
	public void clkBack() {
		CommonService.back(preRoot, root);
		CommonService.closeRoot(root);
	}
	public void scaleEnter() {
		imgMoviePoster.setScaleX(1.1);
		imgMoviePoster.setScaleY(1.1);
	}
	public void scaleExit() {
		imgMoviePoster.setScaleX(1);
		imgMoviePoster.setScaleY(1);
	}
	public void clkRight() {
		imgMoviePoster.setImage(new Image("resources/img/movie/"+setMovieTitle(moviePage++)+".jpg"));
		if(moviePage > 3) moviePage = 0;
	}
	public void clkLeft() {
		imgMoviePoster.setImage(new Image("resources/img/movie/"+setMovieTitle(moviePage--)+".jpg"));
		if(moviePage < 0) moviePage = 3;
	}
	public String setMovieTitle(int page) {
		String movieName = "";
		String setTitle = "";
		Label labMovieName = (Label)root.lookup("#labMovieName");
		switch(page) {
			case 0: movieName = "Avengers_04"; setTitle = "어벤져스 엔드게임"; break;
			case 1:	movieName = "HarryPotter_08"; setTitle = "해리포터 죽음의 성물2"; break;
			case 2: movieName = "Parasite"; setTitle = "기생충"; break;
			case 3: movieName = "Soul"; setTitle = "소울"; break;
		}
		labMovieName.setText(setTitle);
		return movieName;
	}
	public void clkMyTicket() {
		mtsi.showMyTicket(root);
		CommonService.closeRoot(root);
	}
	public void clkMyHistory() {
		mhsi.showMyHistory(root);
		CommonService.closeRoot(root);
	}
	public void clkMovieInfo() {
		System.out.println("movie is clicked");
	}
}

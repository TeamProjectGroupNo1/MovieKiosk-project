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
import movieInfo.MovieInfo;
import movieInfo.MovieInfoImpl;
import myHistory.MyHistoryService;
import myHistory.MyHistoryServiceImpl;
import myTicket.MyTicketServiceImpl;
import myTicket.MyTicketService;

public class LoginController implements Initializable{
	@FXML ImageView imgMoviePoster;
	private MyTicketService mtsi;
	private MyHistoryService mhsi;
	private MovieInfo mii;
	Parent root;
	Parent preRoot;
	private int moviePage;
	private String movieName;
	public void setRoot(Parent preRoot, Parent root) {
		this.root = root;
		this.preRoot = preRoot;
		moviePage = 0;
		setMovieChart();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mtsi = new MyTicketServiceImpl();
		mhsi = new MyHistoryServiceImpl();
		mii = new MovieInfoImpl();
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
		moviePage++;
		if(moviePage > 3)
			moviePage = 0;
		setMovieChart();
	}
	public void clkLeft() {
		moviePage--;
		if(moviePage < 0)
			moviePage = 3;
		setMovieChart();
	}
	public void setMovieChart() {
		Label labMovieName = (Label)root.lookup("#labMovieName");
		switch(moviePage) {
			case 0: movieName = "Avengers_04"; break;
			case 1:	movieName = "HarryPotter_08"; break;
			case 2: movieName = "Parasite"; break;
			case 3: movieName = "Soul"; break;
		}
		labMovieName.setText(CommonService.getMovieName(movieName));
		imgMoviePoster.setImage(new Image("resources/img/movie/"+movieName+".jpg"));
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
		mii.movieInfo(root, movieName);
		CommonService.closeRoot(root);	
	}
}

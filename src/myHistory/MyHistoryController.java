package myHistory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import memberInfo.MemberInfoDAO;
import memberInfo.MemberInfoDTO;
import movieInfo.MovieInfo;
import movieInfo.MovieInfoImpl;
import movieReview.MovieReviewDAO;
import movieReview.MovieReviewDTO;
import movieReview.MovieReviewService;
import movieReview.MovieReviewServiceImpl;
import movieTicket.MovieTicketDAO;
import movieTicket.MovieTicketDTO;

public class MyHistoryController implements Initializable{
	ArrayList<MovieReviewDTO> review;
	@FXML AnchorPane apNoHistory;
	@FXML AnchorPane apHistory;
	ArrayList<MovieTicketDTO> list;
	int historyIndex;
	Parent root;
	Parent preRoot;
	public void setRoot(Parent preRoot, Parent root) {
		this.root = root;
		this.preRoot = preRoot;
		setItems();
		setProfile();
	}
	public void setProfile() {
		Label labMemberInfo = (Label)root.lookup("#labMemberInfo");
		MemberInfoDTO dto = (new MemberInfoDAO()).getMemberInfO(CommonService.getUserId());
		String gender = "";
		if(dto.getGender() == 0) gender = "남";
		else gender = "여";
		labMemberInfo.setText(dto.getId()+" ("+gender+", "+dto.getAge()+"세) ▸total: "+list.size());
	}
	public void setItems() {
		list = (new MovieTicketDAO()).getMovieHistoryList(CommonService.getUserId());
		if(list.size() == 0) {
			apNoHistory.setVisible(true);
			apHistory.setVisible(false);
		}else {
			apNoHistory.setVisible(false);
			apHistory.setVisible(true);
			historyIndex = 0;
			setHistory();
		}
	}
	public void setHistory() {
		ImageView imgUp = (ImageView)root.lookup("#imgUp");
		ImageView imgDown = (ImageView)root.lookup("#imgDown");
		setHistoryBox1();
		setHistoryBox2();
		setHistoryBox3();
		setHistoryBox4();
		if(historyIndex == 0)
			imgUp.setVisible(false);
		else
			imgUp.setVisible(true);
		if(historyIndex < list.size()-1) 
			imgDown.setVisible(true);
		else
			imgDown.setVisible(false);
	}
	public void setHistoryBox1() {
		AnchorPane apHistoryBox1 = (AnchorPane)root.lookup("#apHistoryBox1");
		ImageView imgMovie1 = (ImageView)root.lookup("#imgMovie1");
		Label labMovieTitle1 = (Label)root.lookup("#labMovieTitle1");
		Label labDatetime1 = (Label)root.lookup("#labDatetime1");
		Label labReview1 = (Label)root.lookup("#labReview1");
		ImageView imgStar1 = (ImageView)root.lookup("#imgStar1");
		if(historyIndex < list.size()) {
			apHistoryBox1.setVisible(true);
			labMovieTitle1.setText(CommonService.getMovieName(list.get(historyIndex).getMovieName()));
			imgMovie1.setImage(new Image("resources/img/movie/"+list.get(historyIndex).getMovieName()+".jpg"));
			labDatetime1.setText(list.get(historyIndex).getDateTime());
			review = (new MovieReviewDAO()).getMovieReview(CommonService.getUserId(), list.get(historyIndex).getMovieName());
			if(review != null) {
				labReview1.setDisable(true);
				imgStar1.setDisable(true);
				labReview1.setText(review.get(0).getMovieComment());
				double rate = review.get(0).getStarRate();
				String img="resources/img/icon/star_";
				if(rate < 2) img += 1;
				else if(rate < 3) img += 2;
				else if(rate < 4) img += 3;
				else if(rate < 5) img += 4;
				else if(rate == 5) img += 5;
				imgStar1.setImage(new Image(img+".png"));
			}else {
				labReview1.setDisable(false);
				imgStar1.setDisable(false);
				labReview1.setText("리뷰를 작성해주세요.");
				imgStar1.setImage(new Image("resources/img/icon/star_+.png"));
			}
		}else {
			apHistoryBox1.setVisible(false);
		}
	}
	public void setHistoryBox2() {
		AnchorPane apHistoryBox2 = (AnchorPane)root.lookup("#apHistoryBox2");
		ImageView imgMovie2 = (ImageView)root.lookup("#imgMovie2");
		Label labMovieTitle2 = (Label)root.lookup("#labMovieTitle2");
		Label labDatetime2 = (Label)root.lookup("#labDatetime2");
		Label labReview2 = (Label)root.lookup("#labReview2");
		ImageView imgStar2 = (ImageView)root.lookup("#imgStar2");
		if(historyIndex+1 < list.size()) {
			apHistoryBox2.setVisible(true);
			labMovieTitle2.setText(CommonService.getMovieName(list.get(historyIndex+1).getMovieName()));
			imgMovie2.setImage(new Image("resources/img/movie/"+list.get(historyIndex+1).getMovieName()+".jpg"));
			labDatetime2.setText(list.get(historyIndex+1).getDateTime());
			review = (new MovieReviewDAO()).getMovieReview(CommonService.getUserId(), list.get(historyIndex+1).getMovieName());
			if(review != null) {
				labReview2.setDisable(true);
				imgStar2.setDisable(true);
				labReview2.setText(review.get(0).getMovieComment());
				double rate = review.get(0).getStarRate();
				String img="resources/img/icon/star_";
				if(rate < 2) img += 1;
				else if(rate < 3) img += 2;
				else if(rate < 4) img += 3;
				else if(rate < 5) img += 4;
				else if(rate == 5) img += 5;
				imgStar2.setImage(new Image(img+".png"));
			}else {
				labReview2.setDisable(false);
				imgStar2.setDisable(false);
				labReview2.setText("리뷰를 작성해주세요.");
				imgStar2.setImage(new Image("resources/img/icon/star_+.png"));
			}
		}else {
			apHistoryBox2.setVisible(false);
		}	
	}
	public void setHistoryBox3() {
		AnchorPane apHistoryBox3 = (AnchorPane)root.lookup("#apHistoryBox3");
		ImageView imgMovie3 = (ImageView)root.lookup("#imgMovie3");
		Label labMovieTitle3 = (Label)root.lookup("#labMovieTitle3");
		Label labDatetime3 = (Label)root.lookup("#labDatetime3");
		Label labReview3 = (Label)root.lookup("#labReview3");
		ImageView imgStar3 = (ImageView)root.lookup("#imgStar3");
		if(historyIndex+2 < list.size()) {
			apHistoryBox3.setVisible(true);
			labMovieTitle3.setText(CommonService.getMovieName(list.get(historyIndex+2).getMovieName()));
			imgMovie3.setImage(new Image("resources/img/movie/"+list.get(historyIndex+2).getMovieName()+".jpg"));
			labDatetime3.setText(list.get(historyIndex+2).getDateTime());
			review = (new MovieReviewDAO()).getMovieReview(CommonService.getUserId(), list.get(historyIndex+2).getMovieName());
			if(review != null) {
				labReview3.setDisable(true);
				imgStar3.setDisable(true);
				labReview3.setText(review.get(0).getMovieComment());
				double rate = review.get(0).getStarRate();
				String img="resources/img/icon/star_";
				if(rate < 2) img += 1;
				else if(rate < 3) img += 2;
				else if(rate < 4) img += 3;
				else if(rate < 5) img += 4;
				else if(rate == 5) img += 5;
				imgStar3.setImage(new Image(img+".png"));	
			}else {
				labReview3.setDisable(false);
				imgStar3.setDisable(false);
				labReview3.setText("리뷰를 작성해주세요.");
				imgStar3.setImage(new Image("resources/img/icon/star_+.png"));
			}
		}else {
			apHistoryBox3.setVisible(false);
		}
	}
	public void setHistoryBox4() {
		AnchorPane apHistoryBox4 = (AnchorPane)root.lookup("#apHistoryBox4");
		ImageView imgMovie4 = (ImageView)root.lookup("#imgMovie4");
		Label labMovieTitle4 = (Label)root.lookup("#labMovieTitle4");
		Label labDatetime4 = (Label)root.lookup("#labDatetime4");
		Label labReview4 = (Label)root.lookup("#labReview4");
		ImageView imgStar4 = (ImageView)root.lookup("#imgStar4");
		if(historyIndex+3 < list.size()) {
			apHistoryBox4.setVisible(true);
			labMovieTitle4.setText(CommonService.getMovieName(list.get(historyIndex+3).getMovieName()));
			imgMovie4.setImage(new Image("resources/img/movie/"+list.get(historyIndex+3).getMovieName()+".jpg"));
			labDatetime4.setText(list.get(historyIndex+3).getDateTime());
			review = (new MovieReviewDAO()).getMovieReview(CommonService.getUserId(), list.get(historyIndex+3).getMovieName());
			if(review != null) {
				labReview4.setDisable(true);
				imgStar4.setDisable(true);
				labReview4.setText(review.get(0).getMovieComment());
				double rate = review.get(0).getStarRate();
				String img="resources/img/icon/star_";
				if(rate < 2) img += 1;
				else if(rate < 3) img += 2;
				else if(rate < 4) img += 3;
				else if(rate < 5) img += 4;
				else if(rate == 5) img += 5;
				imgStar4.setImage(new Image(img+".png"));
			}else {
				labReview4.setDisable(false);
				imgStar4.setDisable(false);
				labReview4.setText("리뷰를 작성해주세요.");
				imgStar4.setImage(new Image("resources/img/icon/star_+.png"));
			}
		}else {
			apHistoryBox4.setVisible(false);
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	public void clkBack() {
		CommonService.back(preRoot, root);
	}
	public void clkExit() {
		CommonService.exit(root);
	}
	public void clkUp() {
		if(historyIndex > 0) {
			--historyIndex;
			setHistory();
		}
	}
	public void clkDown() {
		if(historyIndex < list.size()) {
			++historyIndex;
			setHistory();
		}
	}
	
	public void clkInfo1() {
		clkMovieInfo(CommonService.getMovieName(list.get(historyIndex).getMovieName()));
	}
	public void clkInfo2() {
		clkMovieInfo(CommonService.getMovieName(list.get(historyIndex+1).getMovieName()));
	}
	public void clkInfo3() {
		clkMovieInfo(CommonService.getMovieName(list.get(historyIndex+2).getMovieName()));
	}
	public void clkInfo4() {
		clkMovieInfo(CommonService.getMovieName(list.get(historyIndex+3).getMovieName()));
	}
	public void clkReview1() {
		clkWriteReview(CommonService.getMovieName(list.get(historyIndex).getMovieName()));
	}
	public void clkReview2() {
		clkWriteReview(CommonService.getMovieName(list.get(historyIndex+1).getMovieName()));
	}
	public void clkReview3() {
		clkWriteReview(CommonService.getMovieName(list.get(historyIndex+2).getMovieName()));
	}
	public void clkReview4() {
		clkWriteReview(CommonService.getMovieName(list.get(historyIndex+3).getMovieName()));
	}
	public void clkMovieInfo(String movieName) {
		System.out.println(movieName);
		System.out.println(CommonService.getMovie(movieName));
		MovieInfo mii = new MovieInfoImpl();
		mii.movieInfo(root, CommonService.getMovie(movieName));
		CommonService.closeRoot(root);	
	}
	public void clkWriteReview(String movieName) {
		System.out.println(movieName);
		System.out.println(CommonService.getMovie(movieName));
		MovieReviewService mrsi = new MovieReviewServiceImpl();
		System.out.println(movieName);
		mrsi.showMovieReviewPage(root, CommonService.getMovie(movieName));
		CommonService.closeRoot(root);
	}
}

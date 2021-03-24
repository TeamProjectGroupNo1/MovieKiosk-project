package movieReview;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.util.ArrayList;

public class MovieReviewController implements Initializable{
	@FXML
	ImageView imgMovieScore;
	@FXML
	TextFlow reviewTextFlow;
	@FXML
	Label labMovieName;
	@FXML
	TextField tfReview;
	@FXML
	ComboBox cbScore;
	Parent root;
	Parent preRoot;
	MovieReviewDAO reviewDAO = null;
	String id, movieName;
	
	public void setRoot(Parent preRoot, Parent root) {
		this.root = root;
		this.preRoot = preRoot;
		CommonService.setMainRoot(root);
	}
	
	public void clkBack() {
		CommonService.back(preRoot, root);
		CommonService.closeRoot(root);
	}
	
	public void setProperty(String _movieName) {
		id = CommonService.getUserId();
		movieName = _movieName;
		labMovieName.setText(CommonService.getMovieName(movieName));
		imgMovieScore.setImage(new Image("resources/img/review/" + movieName + ".png"));
	}
	
	public void setReviewList(MovieReviewDAO dao) {
		reviewDAO = dao;
		ArrayList<MovieReviewDTO> reviewList = dao.getMovieReview(movieName);
		if (reviewList == null)
			return ;
		for (MovieReviewDTO review : reviewList)
			reviewTextFlow.getChildren().add(new Text(review.getMovieComment()));
	}
	
	public void clkReviewAdd() {
		reviewTextFlow.getChildren().add(new Text(tfReview.getText() + "\n\n"));
		MovieReviewDTO dto = new MovieReviewDTO();
		dto.setId(id);
		dto.setMovieName(movieName);
		dto.setMovieComment(tfReview.getText());
		dto.setStarRate(Double.parseDouble(cbScore.getValue().toString()));
		reviewDAO.setMovieReview(dto);
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbScore.getItems().addAll("5", "4", "3", "2", "1");
		cbScore.setValue("5");
	}
}

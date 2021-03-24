package movieReview;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MovieReviewServiceImpl implements MovieReviewService {
	public void showMovieReviewPage(Parent preRoot, String movieName)
	{
		Stage showMovieReviewPageState = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("movieReview.fxml"));
		MovieReviewDAO reviewDAO = new MovieReviewDAO();
		Parent root = null;
		try {
			root = loader.load();
		}catch(IOException e) { e.printStackTrace(); }
		Scene scene = new Scene(root);
		MovieReviewController controller = loader.getController();
		controller.setRoot(preRoot, root);
		controller.setProperty(movieName);
		controller.setReviewList(reviewDAO);
		showMovieReviewPageState.setScene(scene);
		showMovieReviewPageState.initStyle(StageStyle.UNDECORATED);
		showMovieReviewPageState.show();
	}
}

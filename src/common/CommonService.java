package common;

import java.util.HashMap;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {
	private static HashMap<String, String> movieTitle;
	private static Parent mainRoot;
	private static Alert alert;
	private static String userId;
	public CommonService(){
		setMovieTitle();
	}
	public static void setMainRoot(Parent root) {
		mainRoot = root;
	}
	public static void setUserId(String loginId) {
		userId = loginId;
	}
	public static String getUserId() {
		return userId;
	}
	public static void exit(Parent root) {
		showRoot(mainRoot); //main Page 열기
		closeRoot(root);	//현재 보고있던 page닫기
		setUserId("");
	}
	public static void back(Parent preRoot, Parent root) {
		showRoot(preRoot);	//이전 page 열기
		closeRoot(root);	//현재 보고있던 page닫기
	}
	public static void closeRoot(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public static void showRoot(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.show();
	}
	public static void alertInfoShow(String msg) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	public static void alertWarnShow(String msg) {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText(msg);
		alert.show();
	}
	public static void alertShowAndWait(String msg, Parent root) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.showAndWait();	// alert 창 닫기 대기
		exit(root);	// alert 창 닫히면 해당 page 닫고 main page 열기
	}
	
	private void setMovieTitle() {
		movieTitle = new HashMap<>();
		movieTitle.put("Avengers_01", "어벤져스");
		movieTitle.put("Avengers_02", "어벤져스 에이지 오브 울트론");
		movieTitle.put("Avengers_03", "어벤져스 인피니티 워");
		movieTitle.put("Avengers_04", "어벤져스 엔드게임");
		movieTitle.put("HarryPotter_08", "해리포터 죽음의 성물2");
		movieTitle.put("Parasite", "기생충");
		movieTitle.put("Soul", "소울");
	}
	
	public static String getMovieName(String movie) {
		return movieTitle.get(movie);
	}
	
	public static String getMovie(String movie) {
		for(String key: movieTitle.keySet()) {
			System.out.println(key);
			if(movieTitle.get(key).equals(movie)) {
				return key;
			}
		}
		return "";
	}
}

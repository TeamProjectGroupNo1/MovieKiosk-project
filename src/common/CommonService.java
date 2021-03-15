package common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {
	private static Parent mainRoot;
	private static Alert alert;
	private static String userId;
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
		alert.showAndWait();
		exit(root);
	}
}

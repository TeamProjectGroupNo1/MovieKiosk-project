package main;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.LoginService;
import login.LoginServiceImpl;
import memberInfo.MemberInfoDAO;
import signUp.SignUpService;
import signUp.SignUpServiceImpl;

public class MainController implements Initializable{
	private LoginService lsi;
	private SignUpService ssi;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		CommonService.setMainRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lsi = new LoginServiceImpl();
		ssi = new SignUpServiceImpl();
	}
	public void clkLogin() {
		TextField userID = (TextField)root.lookup("#userID");
		PasswordField userPwd = (PasswordField)root.lookup("#userPwd");
		CheckBox chkRemId = (CheckBox)root.lookup("#chkRemId");
		if(userID.getText().isEmpty()) {
			CommonService.alertWarnShow("ID를 입력하세요");
		}else if(userPwd.getText().isEmpty()) {
			CommonService.alertWarnShow("Password를 입력하세요");
		}else {
			MemberInfoDAO memberInfo = new MemberInfoDAO();
			String pwd = memberInfo.getPwd(userID.getText());
			if(pwd == null) {
				CommonService.alertWarnShow("존재하지 않는 ID 입니다.");
				if(!chkRemId.isSelected()) userID.clear();
				userPwd.clear();
			}else if(userPwd.getText().equals(pwd)) {	//login 성공
				lsi.showLoginPage(root);
				CommonService.setUserId(userID.getText());
				userID.clear();
				userPwd.clear();
				chkRemId.setSelected(false);
				CommonService.closeRoot(root);
			}else {
				CommonService.alertWarnShow("비밀번호가 틀렸습니다.");
				if(!chkRemId.isSelected()) userID.clear();
				userPwd.clear();
			}
		}
	}
	public void clkSignUp() {
		ssi.showSignUp(root);
		CommonService.closeRoot(root);
	}
}

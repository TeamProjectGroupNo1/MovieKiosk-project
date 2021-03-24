package signUp;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import memberInfo.MemberInfoDAO;
import memberInfo.MemberInfoDTO;

public class SignUpController implements Initializable {
	MemberInfoDAO memberDAO;
	@FXML TextField tfId;
	@FXML Button btnChkId;
	@FXML PasswordField pfPwd;
	@FXML PasswordField pfPwdConfirm;
	@FXML RadioButton rdoMale;
	@FXML RadioButton rdoFemale;
	@FXML ComboBox<Integer> cmbBirth;
	@FXML Button btnSubmit;
	private ObservableList<Integer> list;
	Parent root;
	Parent preRoot;
	boolean chkId;
	final int THIS_YEAR = (Calendar.getInstance()).get(Calendar.YEAR);
	public void setRoot(Parent preRoot, Parent root) {
		this.root = root;
		this.preRoot = preRoot;
		setList();
		chkId = false;
	}
	public void setList() {
		list = FXCollections.observableArrayList();
		for(int i=THIS_YEAR; i>1920; i--) {
			list.add(i);
		}
		cmbBirth.setItems(list);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		memberDAO = new MemberInfoDAO();
	}
	public void clkBack() {
		CommonService.back(preRoot, root);
	}
	public void keyPressId() {	//ID란 입력 check
		if(!tfId.getText().isEmpty()) {
			btnChkId.setDisable(false);	// 중복확인 버튼 활성화
		}else {
			btnChkId.setDisable(true);	// 중복확인 버튼 비활성화
			btnSubmit.setDisable(true);	// 가입하기 버튼 비활성화
			chkId = false;	//chkId false
		}
	}
	public void clkChkId() {
		if(tfId.getText().isEmpty()) {
			CommonService.alertWarnShow("ID를 입력하지 않았습니다.");
		}else if( memberDAO.getPwd(tfId.getText()) == null ) {	// 사용가능한 ID인지 확인
			CommonService.alertInfoShow("사용 가능한 ID 입니다.");
			btnSubmit.setDisable(false);	// 가입하기 버튼 활성화
			chkId = true;	// chkId true
		}else {
			CommonService.alertWarnShow("이미 존재하는 ID 입니다.");
			btnChkId.setDisable(true);	// 중복확인 비활성화
			tfId.clear();	// 입력한 Id 지움
			tfId.requestFocus();
		}
	}
	public void clkSubmit() {
		if(!chkId) {
			CommonService.alertWarnShow("ID 중복확인을 해주세요");
			tfId.requestFocus();
		}else if(pfPwd.getText().isEmpty()) {
			CommonService.alertWarnShow("Password를 입력하지 않았습니다.");
			pfPwd.requestFocus();
		}else if(pfPwdConfirm.getText().isEmpty()) {
			CommonService.alertWarnShow("Password Confirm을 입력하지 않았습니다.");
			pfPwdConfirm.requestFocus();
		}else if(!pfPwd.getText().equals(pfPwdConfirm.getText())) {
			CommonService.alertWarnShow("Password와 Password Confirm이 일치하지 않습니다.");
		}else if(!rdoMale.isSelected() && !rdoFemale.isSelected()) {
			CommonService.alertWarnShow("성별을 선택하지 않았습니다.");
			rdoMale.requestFocus();
		}else if(cmbBirth.getValue() == null) {
			CommonService.alertWarnShow("생년월일을 선택하지 않았습니다.");
			cmbBirth.requestFocus();
		}else {
			if(memberDAO.setMemberInfo(setMemberInfo()))
				CommonService.alertShowAndWait("가입되었습니다. 서비스를 이용하시려면 로그인 해주세요.", root);
			else 
				CommonService.alertWarnShow("error");
		}
	}
	public MemberInfoDTO setMemberInfo() {
		MemberInfoDTO member = new MemberInfoDTO();
		member.setId(tfId.getText());
		member.setPwd(pfPwd.getText());
		if( rdoMale.isSelected() ) 	member.setGender(0);
		else 						member.setGender(1);
		member.setAge(THIS_YEAR - cmbBirth.getValue() +1);
		return member;
	}
}

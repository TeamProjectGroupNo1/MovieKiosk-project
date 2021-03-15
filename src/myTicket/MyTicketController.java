package myTicket;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import movieTicket.MovieTicketDAO;
import movieTicket.MovieTicketDTO;

public class MyTicketController implements Initializable{
	@FXML AnchorPane apNoTicket;
	@FXML AnchorPane apTicket;
	@FXML ImageView imgMoviePoster;
	ArrayList<MovieTicketDTO> list;
	int ticketPage;
	Parent root;
	Parent preRoot;
	public void setRoot(Parent preRoot, Parent root) {
		this.root = root;
		this.preRoot = preRoot;
		ticketPage = -1;
		setItems();
	}
	public void setItems() {
		list = (new MovieTicketDAO()).getMovieTicketList(CommonService.getUserId());
		if(list.size() == 0) {
			apNoTicket.setVisible(true);
			apTicket.setVisible(false);
		}else
			setTicket(++ticketPage);
	}
	public void setTicket(int page) {
		Button btnCancelTicket = (Button)root.lookup("#btnCancelTicket");
		Label labMovieName = (Label)root.lookup("#labMovieName");
		Label labPosi = (Label)root.lookup("#labPosi");
		Label labDate = (Label)root.lookup("#labDate");
		Label labStartTime = (Label)root.lookup("#labStartTime");
		Label labEndTime = (Label)root.lookup("#labEndTime");
		Label labType = (Label)root.lookup("#labType");
		Label labSeat = (Label)root.lookup("#labSeat");
		ImageView imgUp = (ImageView)root.lookup("#imgUp");
		ImageView imgDown = (ImageView)root.lookup("#imgDown");
		apNoTicket.setVisible(false);
		apTicket.setVisible(true);
		switch(list.get(page).getMovieName()) {
			case "Avengers_04": labMovieName.setText("어벤져스 엔드게임"); break;
			case "HarryPotter_08": labMovieName.setText("해리포터 죽음의 성물2"); break;
			case "Parasite": labMovieName.setText("기생충"); break;
			case "Soul": labMovieName.setText("소울"); break;
		}
		imgMoviePoster.setImage(new Image("resources/img/movie/"+list.get(page).getMovieName()+".jpg"));
		labPosi.setText(list.get(page).getPlace());
		labDate.setText(list.get(page).getDate());
		labStartTime.setText(list.get(page).getStartTime());
		labEndTime.setText("~"+list.get(page).getEndTime());
		labType.setText(list.get(page).getCnt());
		labSeat.setText(list.get(page).getSeat());
		// 영화시작시간과 현재시간 yyyyMMddHHmm 형식으로 얻기
		String ticketDate =list.get(page).getDate().replace("-", "")
							+ list.get(page).getStartTime().replace(":", "");
		String now = (new SimpleDateFormat("yyyyMMddHHmm")).format(new Date());
		// 현재시간과 영화시작시간 비교하여 영화시작시간이 지났으면 예매취소 버튼 비활성화
		if( Long.parseLong(now) > Long.parseLong(ticketDate) ) 
			btnCancelTicket.setDisable(true);
		else
			btnCancelTicket.setDisable(false);
		if(page == 0 ) imgUp.setVisible(false);
		else		   imgUp.setVisible(true);
		if(list.size()-1 == page) imgDown.setVisible(false);
		else					  imgDown.setVisible(true);
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
	public void scaleEnter(MouseEvent e) {
		imgMoviePoster.setScaleX(1.2);
		imgMoviePoster.setScaleY(1.2);
	}
	public void scaleExit() {
		imgMoviePoster.setScaleX(1);
		imgMoviePoster.setScaleY(1);
	}
	public void clkMovieInfo() {
		System.out.println("movie info is clicked");
	}
	public void clkCancelTicket() {
		if (new MovieTicketDAO().delMovieTicket(CommonService.getUserId(), list.get(ticketPage).getMovieName())) {
			CommonService.alertInfoShow("정삭적으로 예매취소 되었습니다.");
			ticketPage = -1;
			setItems();
		}else {
			CommonService.alertWarnShow("예매취소 오류가 발생했습니다.");
		}
	}
	public void clkUp() {
		if(ticketPage >= 0)
			setTicket(--ticketPage);
	}
	public void clkDown() {
		if(ticketPage < list.size())
			setTicket(++ticketPage);
	}
}

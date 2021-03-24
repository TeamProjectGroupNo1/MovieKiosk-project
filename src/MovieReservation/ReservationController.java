package MovieReservation;

import java.net.URL;
import java.util.ResourceBundle;

import MovieReservation.payservice.Payservice;
import MovieReservation.payservice.PayserviceImp;
import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

public class ReservationController implements Initializable{
	@FXML private ListView<String> listviewMovie;
	@FXML 	private ListView<String> listviewDate;
	@FXML 	private ListView<String> listviewSeat;
	@FXML 	private ListView<String> listviewSeat2;
	@FXML 	private ListView<String> listviewTime;
	private Payservice ps;
	Parent root;
	Parent preRoot;
	Reservation rv;
	

	public void setRoot(Parent preRoot, Parent root) {
		this.root = root;
		this.preRoot = preRoot;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		setListView();
		rv = new ReservationImp();
		ps = new PayserviceImp();
	}
	ObservableList<String> MovieString;
	ObservableList<String> dateString;
	ObservableList<String> seatString1;
	ObservableList<String> seatString2;
	ObservableList<String> timeString;
	public void setListView() {
		MovieString  = FXCollections.observableArrayList();
		MovieString.add("해리포터-죽음의성물2");
		MovieString.add("어벤져스-엔드게임");
		MovieString.add("기생충");
		MovieString.add("소울");
		listviewMovie.setItems(MovieString);
		dateString = FXCollections.observableArrayList();
		dateString.add("3월 22일 월요일");
		dateString.add("3월 23일 화요일");
		dateString.add("3월 24일 수요일");
		dateString.add("3월 25일 목요일");
		dateString.add("3월 26일 금요일");
		dateString.add("3월 27일 토요일");
		listviewDate.setItems(dateString);
		timeString = FXCollections.observableArrayList();
		for(int i=10; i<22; i+=2)
			timeString.add(i+":00");
		listviewTime.setItems(timeString);
		
		seatString1 = FXCollections.observableArrayList();
		for(int i=65; i<77; i++)
			seatString1.add((char)i+"행");
		listviewSeat.setItems(seatString1);	
		
		seatString2 = FXCollections.observableArrayList();
		for(int i=1; i<12; i++)
			seatString2.add(i+"열");
		listviewSeat2.setItems(seatString2);	
	}
	public void clkok() {
		ps.payment();
	}
	public void clkBack() {
		CommonService.back(preRoot, root);
	}
}

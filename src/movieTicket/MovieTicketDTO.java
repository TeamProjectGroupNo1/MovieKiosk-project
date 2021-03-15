package movieTicket;

public class MovieTicketDTO {
	private String id;
	private String movieName;
	private String place;
	private String date;
	private String startTime;
	private String endTime;
	private String cnt;
	private String seat;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getMovieName() { return movieName; }
	public void setMovieName(String movieName) { this.movieName = movieName; }
	public String getPlace() { return place; }
	public void setPlace(String place) { this.place = place; }
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	public String getStartTime() { return startTime; }
	public void setStartTime(String startTime) { this.startTime = startTime; }
	public String getEndTime() { return endTime; }
	public void setEndTime(String endTime) { this.endTime = endTime; }
	public String getCnt() { return cnt; }
	public void setCnt(String cnt) { this.cnt = cnt; }
	public String getSeat() { return seat; }
	public void setSeat(String seat) { this.seat = seat; }
	public String getDateTime() {
		return date+" "+startTime+" - "+endTime;
	}
}

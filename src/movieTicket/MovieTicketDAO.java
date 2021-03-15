package movieTicket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieTicketDAO {
	private String account = "scott";	//계정 ID 입력
	private String password = "tiger";	//계정 Password 입력 
	private String dirver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private boolean connect() {
		try {
			Class.forName(dirver);
			con = DriverManager.getConnection(url, account, password);
			return true;
		}catch(Exception e) {
			System.out.println("connected failed: "+ e.getMessage());
		}
		return false;
	}
	private void disconnect() {
		try {
			if(rs != null) { rs.close();} 
			if(ps != null) { ps.close(); }
			if(con != null) { con.close(); }
		}catch(Exception e) { 
			System.out.println("disconnected failed: "+e.getMessage());
		}
	}
	public boolean setMovieTicket(MovieTicketDTO ticket) {
		boolean result = false;
		if(connect()) {
			try {
				String sql = "insert into movie_ticket values(?, ?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, ticket.getId());
				ps.setString(2, ticket.getMovieName());
				ps.setString(3, ticket.getPlace());
				ps.setString(4, ticket.getDate());
				ps.setString(5, ticket.getStartTime());
				ps.setString(6, ticket.getEndTime());
				ps.setString(7, ticket.getCnt());
				ps.setString(8, ticket.getSeat());
				int r = ps.executeUpdate();
				if(r>0) result = true;
				else System.out.println("sql insert fail");
				disconnect();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("db connected failed");
		}
		return result;
	}
	public ArrayList<MovieTicketDTO> getMovieTicketList(String userId) {
		ArrayList<MovieTicketDTO> list = null;
		MovieTicketDTO ticket = null;
		if(connect()) {
			try {
				String sql = "select * from movie_ticket where id = '"+userId+"' "
						+ "and ( ticket_date > to_char(SYSDATE, 'YYYY-MM-DD') "
						+ "or ( ticket_date = to_char(SYSDATE, 'YYYY-MM-DD') "
						+ "and END_TIME > to_char(SYSDATE, 'HH:MM') ) ) "
						+ "order by ticket_date, start_time";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				list = new ArrayList<>();
				while(rs.next()) {
					ticket = new MovieTicketDTO();
					ticket.setId(rs.getString(1));
					ticket.setMovieName(rs.getString(2));
					ticket.setPlace(rs.getString(3));
					ticket.setDate(rs.getString(4));
					ticket.setStartTime(rs.getString(5));
					ticket.setEndTime(rs.getString(6));
					ticket.setCnt(rs.getString(7));
					ticket.setSeat(rs.getString(8));
					list.add(ticket);
				}
				disconnect();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("db connected failed");
		}
		return list;
	}
	public ArrayList<MovieTicketDTO> getMovieHistoryList(String userId) {
		ArrayList<MovieTicketDTO> list = null;
		MovieTicketDTO ticket = null;
		if(connect()) {
			try {
				String sql = "select * from movie_ticket where id = '"+userId+"' "
						+ "and (ticket_date < to_char(SYSDATE, 'YYYY-MM-DD') "
						+ "or ( ticket_date = to_char(SYSDATE, 'YYYY-MM-DD') "
						+ "and END_TIME < to_char(SYSDATE, 'HH:MM') ) ) "
						+ "order by ticket_date desc, start_time desc";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				list = new ArrayList<>();
				while(rs.next()) {
					ticket = new MovieTicketDTO();
					ticket.setId(rs.getString(1));
					ticket.setMovieName(rs.getString(2));
					ticket.setPlace(rs.getString(3));
					ticket.setDate(rs.getString(4));
					ticket.setStartTime(rs.getString(5));
					ticket.setEndTime(rs.getString(6));
					ticket.setCnt(rs.getString(7));
					ticket.setSeat(rs.getString(8));
					list.add(ticket);
				}
				disconnect();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("db connected failed");
		}
		return list;
	}
	public int delMovieTicket(String userId) {
		int result = 0;
		if(connect()) {
			try {
				String sql = "delete from movie_ticket where id = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				result = ps.executeUpdate();
				disconnect();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("db connected failed");
		}
		return result;
	}
	
}

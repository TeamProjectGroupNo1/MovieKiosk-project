package movieReview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieReviewDAO {
	private String account = "scott";	//계정 ID 입력
	private String password = "tiger";	//계정 Password 입력 
	private String dirver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public boolean connect() {
		try {
			Class.forName(dirver);
			con = DriverManager.getConnection(url, account, password);
			return true;
		}catch(Exception e) {
			System.out.println("connected failed: "+ e.getMessage());
		}
		return false;
	}
	
	public void disconnect() {
		try {
			if(rs != null) { rs.close();} 
			if(ps != null) { ps.close(); }
			if(con != null) { con.close(); }
		}catch(Exception e) { 
			System.out.println("disconnected failed: "+e.getMessage());
		}
	}
	public boolean setMovieReview(MovieReviewDTO review) {
		boolean result = false;
		if(connect()) {
			try {
				String sql = "insert into movie_review values(?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, review.getId());
				ps.setString(2, review.getMovieName());
				ps.setDouble(3, review.getStarRate());
				ps.setString(4, review.getMovieComment());
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
	public ArrayList<MovieReviewDTO> getMovieReviewList(String userId) {
		ArrayList<MovieReviewDTO> list = null;
		MovieReviewDTO review = null;
		if(connect()) {
			try {
				String sql = "select * from movie_review where id = '"+userId+"'";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				list = new ArrayList<>();
				while(rs.next()) {
					review = new MovieReviewDTO();
					review.setId(rs.getString(1));
					review.setMovieName(rs.getString(2));
					review.setStarRate(rs.getDouble(3));
					review.setMovieComment(rs.getString(4));
					list.add(review);
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
	public ArrayList<MovieReviewDTO> getMovieReview(String userId, String movieName) {
		ArrayList<MovieReviewDTO> list = null;
		MovieReviewDTO review = null;
		if(connect()) {
			try {
				String sql = "select * from movie_review where id = '"+userId+"' and movie_name = '"+movieName+"'";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					list = new ArrayList<>();
					review = new MovieReviewDTO();
					review.setId(rs.getString(1));
					review.setMovieName(rs.getString(2));
					review.setStarRate(rs.getDouble(3));
					review.setMovieComment(rs.getString(4));
					list.add(review);
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
}

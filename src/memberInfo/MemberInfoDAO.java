package memberInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberInfoDAO {
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
	public boolean setMemberInfo(MemberInfoDTO member) {
		boolean result = false;
		if(connect()) {
			try {
				String sql = "insert into member_info values(?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getId());
				ps.setString(2, member.getPwd());
				ps.setInt(3, member.getGender());
				ps.setInt(4, member.getAge());
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
	public MemberInfoDTO getMemberInfO(String userId) {
		MemberInfoDTO member = null;
		if(connect()) {
			try {
				String sql = "select * from member_info where id = '"+userId+"'";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					member = new MemberInfoDTO();
					member.setId(userId);
					//member.setPwd(rs.getString(2));
					member.setGender(rs.getInt(3));
					member.setAge(rs.getInt(4));
				}
				disconnect();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("db connected failed");
		}
		return member;
	}
	public String getPwd(String userId) {
		String userPwd = null;
		if(connect()) {
			try {
				String sql = "select pwd from member_info where id ='"+userId+"'";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next())
					userPwd = rs.getString(1);
				disconnect();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("db connected failed");
		}
		return userPwd;
	}
}

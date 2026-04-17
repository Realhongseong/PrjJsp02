package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String dbuid = "sky";
	String dbpwd = "1234";
	
	// 회원추가
	public int addUser(String userid, String username, String email) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		String sql = "";
		sql += "INSERT INTO TUSER VALUES ( ?,?,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setString(2, username);
		pstmt.setString(3, email);
		
		int aftcnt = pstmt.executeUpdate();

		pstmt.close();
		conn.close();
		
		return aftcnt;
	}

}

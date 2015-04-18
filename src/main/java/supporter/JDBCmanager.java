package supporter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JDBCmanager {
	private static final Logger logger = LoggerFactory.getLogger(JDBCmanager.class);

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.info("Driver Loaded.");
		} catch (ClassNotFoundException e) {
			logger.info("Driver Error" + e.getMessage());
		}
		try {
			logger.info("Getting Connection.");
			String addr = ResourceAccesser.dbInfo.get("address");
			String user = ResourceAccesser.dbInfo.get("connectionId");
			String pw = ResourceAccesser.dbInfo.get("connectionPassWd");
			logger.info("addr: {}, user:{}, pw: {}", addr, user, pw);
			conn = DriverManager.getConnection(addr, user, pw);
			logger.info("Connection Successed.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs, PreparedStatement pm, Connection cn) {
		close(pm, cn);
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.toString();
		}
	}

	public static void close(PreparedStatement pm, Connection cn) {
		try {
			if (pm != null) {
				pm.close();
			}
			if (cn != null) {
				cn.close();
			}
		} catch (Exception e) {
			e.toString();
		}
	}
}
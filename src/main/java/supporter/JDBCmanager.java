package supporter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				logger.info("Connection closed.");
			}
		} catch (Exception e) {
			e.toString();
		}
	}
}
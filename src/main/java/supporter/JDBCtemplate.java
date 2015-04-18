package supporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.UserDao;

public abstract class JDBCtemplate extends JDBCmanager {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	public int jdbcUpdate(String qry) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int manipulationResult = 0;

		try {
			pstmt = conn.prepareStatement(qry);
			setPstmt(pstmt);
			logger.info(pstmt.toString());
			manipulationResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		logger.info("[{}] lows manipulated.", manipulationResult);
		return manipulationResult;
	}

	public abstract void setPstmt(PreparedStatement pstmt) throws SQLException;
}
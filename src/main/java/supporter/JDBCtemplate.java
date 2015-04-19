package supporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCtemplate {
	private static final Logger logger = LoggerFactory.getLogger(JDBCtemplate.class);

	public int jdbcUpdate(String qry, PreparedStatementSetter pss, Connection conn) {
		PreparedStatement pstmt = null;

		// return value
		int manipulationResult = 0;

		try {
			pstmt = conn.prepareStatement(qry);
			if (pss != null)
				pss.setPstmt(pstmt);
			logger.info(pstmt.toString());
			manipulationResult = pstmt.executeUpdate();
			logger.info("[{}] lows manipulated.", manipulationResult);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return manipulationResult;
	}

	public <T> T jdbcRetrieve(String qry, PreparedStatementSetter pss, RowMapper<T> rm, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// return value
		T retrievedObject = null;

		try {
			pstmt = conn.prepareStatement(qry);
			if (pss != null)
				pss.setPstmt(pstmt);
			logger.info(pstmt.toString());
			rs = pstmt.executeQuery();
			if (rs.next())
				retrievedObject = rm.mapRow(rs);
			if (retrievedObject != null)
				logger.info("retriev result: {}", retrievedObject.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return retrievedObject;
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				logger.info("ResultSet closed.");
			}
		} catch (Exception e) {
			e.toString();
		}
	}

	public static void close(PreparedStatement pm) {
		try {
			if (pm != null) {
				pm.close();
				logger.info("PreparedStatement closed.");
			}
		} catch (Exception e) {
			e.toString();
		}
	}
}
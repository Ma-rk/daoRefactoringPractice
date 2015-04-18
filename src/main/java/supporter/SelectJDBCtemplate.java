package supporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SelectJDBCtemplate extends JDBCmanager {
	private static final Logger logger = LoggerFactory.getLogger(SelectJDBCtemplate.class);

	public Object jdbcRetrieve(String qry) {
		Connection conn = getConnection();

		Object retrievedObject = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(qry);
			setParams(pstmt);
			logger.info(pstmt.toString());
			rs = pstmt.executeQuery();
			retrievedObject = mapRow(rs);
			if (retrievedObject != null)
				logger.info(retrievedObject.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return retrievedObject;
	}

	public abstract Object mapRow(ResultSet rs) throws SQLException;

	public abstract void setParams(PreparedStatement pstmt) throws SQLException;
}
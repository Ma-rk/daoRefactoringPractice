package supporter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	void setPstmt(PreparedStatement pstmt) throws SQLException;
}
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supporter.JDBCtemplate;
import supporter.PreparedStatementSetter;
import supporter.RowMapper;
import entity.TodoEntity;

public class TodoDao {
	public int insertTodo(final TodoEntity todo) {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, todo.getAssigner_id());
				pstmt.setString(2, todo.getTitle());
				pstmt.setString(3, todo.getContents());
				pstmt.setString(4, todo.getDueDate());
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("insert into todo(handler_id, title, contents, duedate) values (?, ?, ?, ?)", pss);
	}

	public long retrieveNewestTodoId() {
		RowMapper<Long> rm = new RowMapper<Long>() {
			public Long mapRow(ResultSet rs) throws SQLException {
				return rs.getLong("tid");
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcRetrieve("select max(tid) as 'tid' from todo", null, rm);
	}

	public int selectInsertTodoHistory() {
		String selectInsertQry = "insert into todo_history " 
				+ "select (select max(hid)+1 from todo_history) as hid"
				+ ", tid"
				+ ", handler_id"
				+ ", pid, title"
				+ ", contents"
				+ ", date_format(duedate, '%Y-%m-%d') as 'duedate'"
				+ ", status"
				+ ", now() as handled_time "
				+ "from todo where tid = (select max(tid) from todo)";
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate(selectInsertQry, null);
	}
}
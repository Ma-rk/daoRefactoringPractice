package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supporter.JDBCtemplate;
import supporter.PreparedStatementSetter;
import supporter.RowMapper;
import entity.TodoEntity;

public class TodoDao {
	public long getNewTodoId(Connection conn){
		RowMapper<Long> rm = new RowMapper<Long>() {
			@Override
			public Long mapRow(ResultSet rs) throws SQLException {
				return rs.getLong("newTodoId");
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcRetrieve("select max(tid) + 1 as 'newTodoId' from todo", null, rm, conn);
	}
	
	public int insertTodo(final TodoEntity todo, Connection conn) {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, todo.getTid());
				pstmt.setLong(2, todo.getAssigner_id());
				pstmt.setString(3, todo.getTitle());
				pstmt.setString(4, todo.getContents());
				pstmt.setString(5, todo.getDueDate());
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("insert into todo(tid, handler_id, title, contents, duedate) values (?, ?, ?, ?, ?)", pss, conn);
	}

	public int selectInsertTodoHistory(long newTodoId ,Connection conn) {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, newTodoId);
			}
		};
		String selectInsertQry = "insert into todo_history " 
				+ "select (select max(hid)+1 from todo_history) as hid"
				+ ", tid"
				+ ", handler_id"
				+ ", pid, title"
				+ ", contents"
				+ ", date_format(duedate, '%Y-%m-%d') as 'duedate'"
				+ ", status"
				+ ", now() as handled_time "
				+ "from todo where tid = ?";
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate(selectInsertQry, pss, conn);
	}
}
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import supporter.JDBCtemplate;
import supporter.RowMapper;
import entity.TodoEntity;

public class TodoDao {
	public long getNewTodoId(Connection conn) {
		RowMapper<Long> rm = new RowMapper<Long>() {
			@Override
			public Long mapRow(ResultSet rs) throws SQLException {
				return rs.getLong("newTodoId");
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcRetrieve("select max(tid) + 1 as 'newTodoId' from todo", rm, conn);
	}

	public int insertTodo(final TodoEntity todo, Connection conn) {
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("insert into todo(tid, handler_id, title, contents, duedate) values (?, ?, ?, ?, ?)", conn, todo.getTid(), todo.getHandlerId(), todo.getTitle(), todo.getContents(), todo.getDueDate());
	}

	public int selectInsertTodoHistory(long newTid, Connection conn) {
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
		return jdbct.jdbcUpdate(selectInsertQry, conn, newTid);
	}

	public int updateToto(TodoEntity todo, Connection conn) {
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("update todo set handler_id = ?, title = ?, contents = ?, duedate = ?, status = '110002' where tid = ?", conn, todo.getHandlerId(), todo.getTitle(), todo.getContents(), todo.getDueDate(), todo.getTid());
	}

	public int completeTodo(TodoEntity todo, Connection conn) {
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("update todo set handler_id = ?, status = '110003' where tid = ?", conn, todo.getHandlerId(), todo.getTid());
	}
	
	public int deleteTodo(TodoEntity todo, Connection conn) {
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("update todo set handler_id = ?, status = '110004' where tid = ?", conn, todo.getHandlerId(), todo.getTid());
	}
}
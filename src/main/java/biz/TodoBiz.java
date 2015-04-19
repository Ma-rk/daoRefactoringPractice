package biz;

import java.sql.Connection;

import supporter.JDBCmanager;
import dao.TodoDao;
import entity.TodoEntity;

public class TodoBiz extends JDBCmanager {

	public boolean insertTodoAndHistory(TodoEntity todo) {
		TodoDao tDao = new TodoDao();
		Connection conn = getConnection();
		boolean insertResult = false;

		long newTodoId = tDao.getNewTodoId(conn);
		todo.setTid(newTodoId);
		if (tDao.insertTodo(todo, conn) == 1 && tDao.selectInsertTodoHistory(newTodoId, conn) == 1)
			insertResult = true;
		close(conn);
		return insertResult;
	}

	public boolean updateTodoAndHistory(TodoEntity todo) {
		TodoDao tDao = new TodoDao();
		Connection conn = getConnection();
		boolean updateResult = false;
		
		if (tDao.updateDao(todo, conn) == 1 && tDao.selectInsertTodoHistory(todo.getTid(), conn) == 1)
			updateResult = true;
		close(conn);
		return updateResult;
	}
}
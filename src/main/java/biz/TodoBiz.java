package biz;

import dao.TodoDao;
import entity.TodoEntity;

public class TodoBiz {
	public boolean insertNewTodo(TodoEntity todo) {
		TodoDao tDao = new TodoDao();
		int insertTodoResult = tDao.insertTodo(todo);
		int selectInsertTodoHistoryResult = tDao.selectInsertTodoHistory();
		if (insertTodoResult == 1 && selectInsertTodoHistoryResult == 1)
			return true;
		return false;
	}
}
package controller;

import biz.TodoBiz;
import dao.TodoDao;
import entity.TodoEntity;

public class TodoController {
	public int insertTodoController(long handler_id, long pid, String title, String contents, String duedate) {
		TodoDao tDao = new TodoDao();
		return tDao.insertTodo(new TodoEntity(handler_id, pid, title, contents, duedate));
	}

	public long retrieveNewestTodoIdController() {
		TodoDao tDao = new TodoDao();
		return tDao.retrieveNewestTodoId();
	}

	public boolean insertTodoAndHistoryController(long handler_id, long pid, String title, String contents, String duedate) {
		TodoBiz tBiz = new TodoBiz();
		return tBiz.insertNewTodo(new TodoEntity(handler_id, pid, title, contents, duedate));
	}
}
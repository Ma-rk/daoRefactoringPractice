package controller;

import biz.TodoBiz;
import entity.TodoEntity;

public class TodoController {
	public boolean insertTodoAndHistoryController(long handler_id, long pid, String title, String contents, String duedate) {
		TodoBiz tBiz = new TodoBiz();
		return tBiz.insertTodoAndHistory(new TodoEntity(handler_id, pid, title, contents, duedate));
	}
}
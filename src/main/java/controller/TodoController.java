package controller;

import biz.TodoBiz;
import entity.TodoEntity;

public class TodoController {
	public boolean insertTodoAndHistoryController(long handlerId, long pid, String title, String contents, String duedate) {
		TodoBiz tBiz = new TodoBiz();
		return tBiz.insertTodoAndHistory(new TodoEntity(handlerId, pid, title, contents, duedate));
	}

	public boolean updateTodoAndHistoryController(long tId, long handlerId, long pid, String title, String contents, String duedate) {
		TodoBiz tBiz = new TodoBiz();
		return tBiz.updateTodoAndHistory(new TodoEntity(tId, handlerId, pid, title, contents, duedate));
	}
	
	public boolean completeTodoAndHistoryController(long tId, long handlerId) {
		TodoBiz tBiz = new TodoBiz();
		return tBiz.completeTodoAndHistory(new TodoEntity(tId, handlerId));
	}
	
	public boolean deleteTodoAndHistoryController(long tId, long handlerId) {
		TodoBiz tBiz = new TodoBiz();
		return tBiz.deleteTodoAndHistory(new TodoEntity(tId, handlerId));
	}
}
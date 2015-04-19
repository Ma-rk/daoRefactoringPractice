package controllerTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controller.TodoController;

public class TodoControllerTest {
	@Test
	public void insertTodoAndHistoryControllerTest() {
		TodoController tCont = new TodoController();
		assertTrue(tCont.insertTodoAndHistoryController(20l, -1l, "this is title.", "this is contents.", "2015-04-08"));
	}

	@Test
	public void updateTodoAndHistoryControllerTest() {
		TodoController tCont = new TodoController();
		assertTrue(tCont.updateTodoAndHistoryController(5l, 21l, -1l, "updated title.", "uppdated contents.", "1983-04-08"));
	}

	@Test
	public void completeTodoAndHistoryControllerTest() {
		TodoController tCont = new TodoController();
		assertTrue(tCont.completeTodoAndHistoryController(5l, 22l));
	}
	
	@Test
	public void deleteTodoAndHistoryControllerTest() {
		TodoController tCont = new TodoController();
		assertTrue(tCont.deleteTodoAndHistoryController(5l, 23l));
	}
}
package controllerTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controller.TodoController;

public class TodoControllerTest {
	@Test
	public void insertTodoAndHistoryControllerTest() {
		TodoController tCont = new TodoController();
		assertTrue(tCont.insertTodoAndHistoryController(1l, -1l, "2this is title.", "2this is contents.", "2015-04-08"));
	}

}
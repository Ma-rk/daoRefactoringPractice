package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controller.TodoController;

public class TodoControllerTest {

	@Test
	public void insertTodoControllerTest() {
		TodoController tCont = new TodoController();
		assertEquals(1, tCont.insertTodoController(3l, -1, "title", "contents", "2015-04-08"));
	}

	@Test
	public void insertTodoAndHistoryControllerTest() {
		TodoController tCont = new TodoController();
		assertTrue(tCont.insertTodoAndHistoryController(2l, 5l, "this is title.", "this is contents.", "2015-04-08"));
	}
}
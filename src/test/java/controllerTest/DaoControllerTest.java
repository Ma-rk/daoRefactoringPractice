package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import controller.DaoController;

public class DaoControllerTest {

	@Test
	public void insertUserController() {
		DaoController daoCont = new DaoController();
		assertEquals(1, daoCont.insertUserController("mark9", "k.mark9@gmail.com", "pwpw"));
	}

	@Test
	public void deleteUserController() {
		DaoController daoCont = new DaoController();
		assertEquals(1, daoCont.deleteUserController(17l));
	}

	@Test
	public void retrieveUserController() {
		DaoController daoCont = new DaoController();
		assertNotNull(daoCont.retrieveUserController(17l));
	}
	
	@Test
	public void updateUserController() {
		DaoController daoCont = new DaoController();
		assertEquals(1, daoCont.updateUserController(17l, "seo", "taiji17@", "com"));
	}
}

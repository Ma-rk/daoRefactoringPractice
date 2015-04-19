package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import controller.UserController;

public class UserControllerTest {

	@Test
	public void insertUserController() {
		UserController uCont = new UserController();
		assertEquals(1, uCont.insertUserController("mark2", "2@gmail.com", "pwpw"));
	}

	@Test
	public void deleteUserController() {
		UserController uCont = new UserController();
		assertEquals(1, uCont.deleteUserController(33l));
	}

	@Test
	public void retrieveUserController() {
		UserController uCont = new UserController();
		assertNotNull(uCont.retrieveUserController(31l));
	}

	@Test
	public void updateUserController() {
		UserController uCont = new UserController();
		assertEquals(1, uCont.updateUserController(31l, "seo", "2taiji13@", "com"));
	}
}
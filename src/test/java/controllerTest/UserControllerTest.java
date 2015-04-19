package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import controller.UserController;

public class UserControllerTest {

	@Test
	public void insertUserController() {
		UserController uCont = new UserController();
		assertEquals(1, uCont.insertUserController("33mark", "33@gmail.com", "pwpw"));
	}

	@Test
	public void retrieveUserController() {
		UserController uCont = new UserController();
		assertNotNull(uCont.retrieveUserController(3l));
	}

	@Test
	public void updateUserController() {
		UserController uCont = new UserController();
		assertEquals(1, uCont.updateUserController(3l, "3seo", "taiji13@", "com"));
	}
	
	@Test
	public void deleteUserController() {
		UserController uCont = new UserController();
		assertEquals(1, uCont.deleteUserController(3l));
	}
}
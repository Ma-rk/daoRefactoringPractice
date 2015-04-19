package controller;

import dao.UserDao;
import entity.UserEntity;

public class UserController {
	public int insertUserController(String name, String email, String passwd) {
		UserDao uDao = new UserDao();
		return uDao.insertUser(new UserEntity(name, email, passwd));
	}

	public int deleteUserController(long uid) {
		UserDao uDao = new UserDao();
		return uDao.deleteUser(new UserEntity(uid));
	}

	public int updateUserController(long uid, String name, String email, String passwd) {
		UserDao uDao = new UserDao();
		return uDao.updateUser(new UserEntity(uid, name, email, passwd));
	}

	public UserEntity retrieveUserController(long uid) {
		UserDao uDao = new UserDao();
		return uDao.retrieveUser(new UserEntity(uid));
	}
}
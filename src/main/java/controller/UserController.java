package controller;

import biz.UserBiz;
import entity.UserEntity;

public class UserController {
	public int insertUserController(String name, String email, String passwd) {
		UserBiz uBiz = new UserBiz();
		return uBiz.insertUser(new UserEntity(name, email, passwd));
	}

	public int deleteUserController(long uid) {
		UserBiz uBiz = new UserBiz();
		return uBiz.deleteUser(new UserEntity(uid));
	}

	public int updateUserController(long uid, String name, String email, String passwd) {
		UserBiz uBiz = new UserBiz();
		return uBiz.updateUser(new UserEntity(uid, name, email, passwd));
	}

	public UserEntity retrieveUserController(long uid) {
		UserBiz uBiz = new UserBiz();
		return uBiz.retrieveUser(new UserEntity(uid));
	}
}
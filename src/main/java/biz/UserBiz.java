package biz;

import dao.UserDao;
import entity.UserEntity;

public class UserBiz {

	public int insertUser(UserEntity userEntity) {
		 UserDao uDao = new UserDao();
		 return uDao.insertUser(userEntity);
	}

	public int deleteUser(UserEntity userEntity) {
		UserDao uDao = new UserDao();
		return uDao.deleteUser(userEntity);
	}

	public int updateUser(UserEntity userEntity) {
		UserDao uDao = new UserDao();
		return uDao.updateUser(userEntity);
	}

	public UserEntity retrieveUser(UserEntity userEntity) {
		UserDao uDao = new UserDao();
		return uDao.retrieveUser(userEntity);
	}

}

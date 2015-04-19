package biz;

import java.sql.Connection;

import supporter.JDBCmanager;
import dao.UserDao;
import entity.UserEntity;

public class UserBiz extends JDBCmanager {

	public int insertUser(UserEntity userEntity) {
		UserDao uDao = new UserDao();
		Connection conn = getConnection();
		int insertResult = uDao.insertUser(userEntity, conn);
		close(conn);
		return insertResult;
	}
	
	public UserEntity retrieveUser(UserEntity userEntity) {
		UserDao uDao = new UserDao();
		Connection conn = getConnection();
		UserEntity retrievedUser = uDao.retrieveUser(userEntity, conn);
		close(conn);
		return retrievedUser;
	}

	public int updateUser(UserEntity userEntity) {
		UserDao uDao = new UserDao();
		Connection conn = getConnection();
		int updateResult = uDao.updateUser(userEntity, conn);
		close(conn);
		return updateResult;
	}
	
	public int deleteUser(UserEntity userEntity) {
		UserDao uDao = new UserDao();
		Connection conn = getConnection();
		int deleteResult = uDao.deleteUser(userEntity, conn);
		close(conn);
		return deleteResult;
	}
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import supporter.JDBCmanager;
import entity.UserEntity;

public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	public int insertUser(UserEntity user) {
		JDBCmanager jdbc = new JDBCmanager();
		Connection conn = jdbc.getConnection();

		PreparedStatement pstmt = null;
		String qry = "insert into user(name, email, passwd) values (?, ?, ?)";

		int insertResult = 0;
		try {
			pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPasswd());
			logger.debug(pstmt.toString());
			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(pstmt, conn);
		}
		logger.info("[{}] lows inserted.", insertResult);
		return insertResult;
	}

	public int deleteUser(UserEntity user) {
		JDBCmanager jdbc = new JDBCmanager();
		Connection conn = jdbc.getConnection();

		PreparedStatement pstmt = null;
		String qry = "delete from user where uid = ?";

		int deleteResult = 0;
		try {
			pstmt = conn.prepareStatement(qry);
			pstmt.setLong(1, user.getUid());
			logger.debug(pstmt.toString());
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(pstmt, conn);
		}
		logger.info("[{}] lows deleted.", deleteResult);
		return deleteResult;
	}

	public UserEntity retrieveUser(UserEntity user) {
		JDBCmanager jdbc = new JDBCmanager();
		Connection conn = jdbc.getConnection();

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String qry = "select uid, name, email, passwd from user where uid = ?";

		try {
			pstmt = conn.prepareStatement(qry);
			pstmt.setLong(1, user.getUid());
			logger.debug(pstmt.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserEntity(rs.getLong("uid"), rs.getString("name"), rs.getString("email"), rs.getString("passwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(rs, pstmt, conn);
		}
		logger.info(user.toString());
		return user;
	}

	public int updateUser(long uid, String name, String email, String passwd) {
		JDBCmanager jdbc = new JDBCmanager();
		Connection conn = jdbc.getConnection();

		PreparedStatement pstmt = null;
		String qry = "update user set name = ?, email = ?, passwd = ? where uid = ?";

		int updateResult = 0;
		try {
			pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, passwd);
			pstmt.setLong(4, uid);
			logger.debug(pstmt.toString());
			updateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(pstmt, conn);
		}
		logger.info("[{}] lows updated.", updateResult);
		return updateResult;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import supporter.JDBCmanager;
import supporter.JDBCtemplate;
import entity.UserEntity;

public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	public int insertUser(final UserEntity user) {
		JDBCtemplate jdbct = new JDBCtemplate() {
			@Override
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPasswd());
			}
		};
		return jdbct.jdbcUpdate("insert into user(name, email, passwd) values (?, ?, ?)");
	}

	public int deleteUser(final UserEntity user) {
		JDBCtemplate jdbct = new JDBCtemplate() {
			@Override
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, user.getUid());
			}
		};
		return jdbct.jdbcUpdate("delete from user where uid = ?");
	}

	public int updateUser(final UserEntity user) {
		JDBCtemplate jdbct = new JDBCtemplate() {
			@Override
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPasswd());
				pstmt.setLong(4, user.getUid());
			}
		};
		return jdbct.jdbcUpdate("update user set name = ?, email = ?, passwd = ? where uid = ?");
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
}
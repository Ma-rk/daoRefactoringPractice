package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supporter.JDBCtemplate;
import supporter.SelectJDBCtemplate;
import entity.UserEntity;

public class UserDao {
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

	public UserEntity retrieveUser(final UserEntity user) {
		SelectJDBCtemplate jdbct=new SelectJDBCtemplate() {
			@Override
			public void setParams(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, user.getUid());
			}
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					UserEntity retrievedUser = new UserEntity(rs.getLong("uid"), rs.getString("name"), rs.getString("email"), rs.getString("passwd"));
					return retrievedUser;
				}
				return null;
			}
		};
		return (UserEntity)jdbct.jdbcRetrieve("select uid, name, email, passwd from user where uid = ?");
	}
}
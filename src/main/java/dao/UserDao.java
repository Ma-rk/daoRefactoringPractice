package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import supporter.JDBCtemplate;
import supporter.RowMapper;
import entity.UserEntity;

public class UserDao {
	public int insertUser(final UserEntity user, Connection conn) {
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("insert into user(name, email, passwd) values (?, ?, ?)", conn, user.getName(), user.getEmail(), user.getPasswd());
	}
	
	public UserEntity retrieveUser(final UserEntity user, Connection conn) {
		RowMapper<UserEntity> rm = new RowMapper<UserEntity>() {
			public UserEntity mapRow(ResultSet rs) throws SQLException {
				return new UserEntity(rs.getLong("uid"), rs.getString("name"), rs.getString("email"), rs.getString("passwd"));
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcRetrieve("select uid, name, email, passwd from user where uid = ?", rm, conn, user.getUid());
	}

	public int updateUser(final UserEntity user, Connection conn) {
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("update user set name = ?, email = ?, passwd = ? where uid = ?", conn, user.getName(), user.getEmail(), user.getPasswd(), user.getUid());
	}

	public int deleteUser(final UserEntity user, Connection conn) {
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("delete from user where uid = ?", conn, user.getUid());
	}
}
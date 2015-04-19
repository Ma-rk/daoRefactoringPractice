package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supporter.JDBCtemplate;
import supporter.PreparedStatementSetter;
import supporter.RowMapper;
import entity.UserEntity;

public class UserDao {
	public int insertUser(final UserEntity user) {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPasswd());
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("insert into user(name, email, passwd) values (?, ?, ?)", pss);
	}

	public int deleteUser(final UserEntity user) {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, user.getUid());
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("delete from user where uid = ?", pss);
	}

	public int updateUser(final UserEntity user) {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPasswd());
				pstmt.setLong(4, user.getUid());
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcUpdate("update user set name = ?, email = ?, passwd = ? where uid = ?", pss);
	}

	public UserEntity retrieveUser(final UserEntity user) {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, user.getUid());
			}
		};
		RowMapper<UserEntity> rm = new RowMapper<UserEntity>() {
			public UserEntity mapRow(ResultSet rs) throws SQLException {
				return new UserEntity(rs.getLong("uid"), rs.getString("name"), rs.getString("email"), rs.getString("passwd"));
			}
		};
		JDBCtemplate jdbct = new JDBCtemplate();
		return jdbct.jdbcRetrieve("select uid, name, email, passwd from user where uid = ?", pss, rm);
	}
}
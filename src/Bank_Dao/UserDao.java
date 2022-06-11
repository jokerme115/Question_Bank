package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Bank_model.User;

/**
 * 用户Dao类
 * 用户和数据库的交互
 * @author HeTao
 *
 */
public class UserDao {
	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con, User user) throws Exception {
		User resultUser = null;
		
		String sql = "select * from user where userName = ? and userPassWord = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("Id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setUserPassword(rs.getString("userPassWord"));
		}
		
		pstmt.close();
		rs.close();
		return resultUser;
	}
	
	/**
	 * 注册
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean SignIn(Connection conn, User user) throws Exception {
		
		String sql = "insert into user values(null,?,?,?,?, null)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		pstmt.setInt(3, user.getStatus());
		pstmt.setString(4, user.getTelephone());
		
		int rs = pstmt.executeUpdate();
		
		pstmt.close();
		
		if (rs == 0) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 删除用户
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean deleteUser(Connection conn, User user) throws Exception {
		String sql = "DELETE FROM user WHERE Id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		
		int a = pstmt.executeUpdate();
		
		pstmt.close();
		
		if (a > 0) {
			return true;
		}else {
			return false;			
		}
	}
	
	/**
	 * 更改账户
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(Connection conn, User user) throws Exception {
		String sql = "UPDATE user SET userName = ?, userPassWord = ?, Telephone = ? WHERE Id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		pstmt.setString(3, user.getTelephone());
		pstmt.setInt(4, user.getId());
		
		int rs = pstmt.executeUpdate();
		
		pstmt.close();
		
		if (rs == 0) {
			return false;
		}else {
			return true;
		}
	}

}

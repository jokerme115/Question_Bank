package Test_Model;

import java.sql.Connection;

import Bank_Dao.UserDao;
import Bank_model.User;
import Bank_util.jdbc_util;

/**
 * 测试更改用户
 * @author HeTao
 *
 */
public class TestUpdateUser {
	public static void main(String[] args) throws Exception {
		int Id = 7;
		String userName = "魏骊臻1";
		String userPassword = "123456";
		int status = 2;
		String Telephone = "110";
		
		jdbc_util util = new jdbc_util();
		Connection conn = null;
		UserDao userdao = new UserDao();
		User user = new User();
		
		
		conn = util.getCon();
		
		user.setUserName(userName);
		user.setTelephone(Telephone);
		user.setStatus(status);
		user.setUserPassword(userPassword);
		user.setId(Id);
		
		boolean a = userdao.updateUser(conn, user);
		System.out.println(a);
	}
	
}

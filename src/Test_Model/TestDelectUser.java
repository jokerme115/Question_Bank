package Test_Model;

import java.sql.Connection;

import Bank_Dao.UserDao;
import Bank_model.User;
import Bank_util.jdbc_util;

/**
 * 删除用户数据 
 * @author HeTao
 *
 */
public class TestDelectUser {
	public static void main(String[] args) throws Exception {
			int Id = 8;
			
			jdbc_util util = new jdbc_util();
			Connection conn = null;
			UserDao userdao = new UserDao();
			User user = new User();
			
			user.setId(Id);
			
			conn = util.getCon();
			
			boolean a = userdao.deleteUser(conn, user);
			System.out.println(a);
	}
}

package Test_Model;

import java.sql.Connection;

import Bank_Dao.UserDao;
import Bank_model.User;
import Bank_util.jdbc_util;

public class TestDelectUser {
	public static void main(String[] args) throws Exception {
			int Id = 5;
			
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

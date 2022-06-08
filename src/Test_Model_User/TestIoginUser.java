package Test_Model_User;

import java.sql.Connection;

import Bank_Dao.UserDao;
import Bank_model.User;
import Bank_util.jdbc_util;

public class TestIoginUser {
	public static void main(String[] args) throws Exception {
				//ID自动分配
				String userName = "魏骊臻";
				String userPassword = "123456";
				int status = 2;
				String Telephone = "110";
				//创建四件套 连接-对象-发送给sql
				jdbc_util util = new jdbc_util();
				Connection conn = null;
				UserDao userdao = new UserDao();
				User user = new User();
				
				conn = util.getCon();
				
				user.setUserName(userName);
				user.setTelephone(Telephone);
				user.setStatus(status);
				user.setUserPassword(userPassword);
				
				boolean a = userdao.SignIn(conn, user);
				System.out.println(a);
	}
}

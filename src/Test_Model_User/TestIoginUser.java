package Test_Model_User;

import java.sql.Connection;

import Bank_Dao.UserDao;
import Bank_model.User;
import Bank_util.jdbc_util;

public class TestIoginUser {
	public static void main(String[] args) throws Exception {
				//ID�Զ�����
				String userName = "κ����";
				String userPassword = "123456";
				int status = 2;
				String Telephone = "110";
				//�����ļ��� ����-����-���͸�sql
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

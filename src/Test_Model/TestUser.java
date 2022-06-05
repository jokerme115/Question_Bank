package Test_Model;

import java.sql.Connection;

import org.junit.Test;

import Bank_Dao.UserDao;
import Bank_model.User;
import Bank_util.jdbc_util;

public class TestUser {
	@Test
	public  void TestInsertUser() throws Exception {
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
	
	
	@Test
	public void TestDeleteUser() throws Exception {
		int Id = 4;
		
		jdbc_util util = new jdbc_util();
		Connection conn = null;
		UserDao userdao = new UserDao();
		User user = new User();
		
		conn = util.getCon();
		user.setId(Id);
		boolean a = userdao.deleteUser(conn, user);
		System.out.println(a);
	}
}

package Test_Model_Grades;

import java.sql.Connection;

import Bank_Dao.GradesDao;
import Bank_model.User;
import Bank_util.jdbc_util;

/**
 * �����û��������ܴ���
 * @author 19797
 *
 */
public class TestUpdateGradesNum {

	public static void main(String[] args) throws Exception {
		String UserName="κ����";
		
		Bank_model.User user =new User();
		jdbc_util util = new jdbc_util();
		
		Connection conn = null;
		conn = util.getCon();
		
		user.setUserName(UserName);
		GradesDao grades_dao= new GradesDao();
		boolean a = grades_dao.updateGrades_num(conn, user);
		System.out.println(a);
	}

}

package Test_Model_Grades;

import java.sql.Connection;

import Bank_Dao.GradesDao;
import Bank_model.User;
import Bank_util.jdbc_util;

/**
 * ¼��һ�γɼ�
 * @author 19797
 *
 */
public class TestUpdateGrades {

	public static void main(String[] args) throws Exception {
		int grades_num=4;
		double score=100;
		String user_name="κ����";
		
		Bank_model.User user =new User();
		jdbc_util util = new jdbc_util();
		
		Connection conn = null;
		conn = util.getCon();
		
		user.setGrades_num(grades_num);
		user.setUserName(user_name);
		GradesDao grades_dao= new GradesDao();
		boolean a = grades_dao.updateGrades(conn, user,score);
		System.out.println(a);
	}

}

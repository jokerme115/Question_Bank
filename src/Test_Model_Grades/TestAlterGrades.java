package Test_Model_Grades;

import java.sql.Connection;

import Bank_Dao.GradesDao;
import Bank_model.User;
import Bank_util.jdbc_util;

/**
 * 加入新的一列
 * @author 19797
 *
 */
public class TestAlterGrades {

	public static void main(String[] args) throws Exception {
		int grades_num=4;
		Bank_model.User user =new User();
		jdbc_util util = new jdbc_util();
		
		Connection conn = null;
		conn = util.getCon();
		user.setGrades_num(grades_num);
		GradesDao grades_dao= new GradesDao();
		boolean a = grades_dao.addGrades_n(conn, user);
		System.out.println(a);
	}
}

package Test_Model_Grades;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import Bank_model.User;
import Bank_util.grades_util;
import Bank_util.jdbc_util;

public class TestShowUserGrades {
	@Test
	public static void main(String[] args) {
		jdbc_util util = new jdbc_util();
		Connection conn = null;
		User user = new User();
		
		conn = util.getCon();
		grades_util.selectAllGrades(Connection conn,User user)
	}

}

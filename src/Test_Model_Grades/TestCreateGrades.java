package Test_Model_Grades;

import java.sql.Connection;
import java.util.ArrayList;

import Bank_Dao.GradesDao;
import Bank_Dao.UserDao;
import Bank_model.Topic;
import Bank_model.User;
import Bank_util.jdbc_util;

/**
 * 测试创建成绩表
 * @author 19797
 *
 */
public class TestCreateGrades {

	public static void main(String[] args) throws Exception {
		ArrayList<Topic> topic = new ArrayList<>();
		jdbc_util util1 = new jdbc_util();
		Connection conn = null;
		conn = util1.getCon();
		User user = new User();
		UserDao userdao = new UserDao();
		GradesDao g = new GradesDao();
		
		String userName = "舞姬秀武技";
		String userPassword = "110";
		
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user = userdao.login(conn, user);
	
//		g.createUserGrades(conn,user);
		g.addUserGrades(conn, user);
	}

}

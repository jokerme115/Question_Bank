package Bank_util;

import java.sql.Connection;

import Bank_Dao.GradesDao;
//import Bank_Dao.UserDao;
import Bank_model.User;

public class grades_util {
	/**
	 * 将做完后的成绩导入
	 * @author 19797
	 * @throws Exception 
	 *
	 */
	public static boolean addUserGrades(Connection conn, double score,User user) throws Exception{
		//更新做题总次数
		GradesDao gradesdao = new GradesDao();
		user.setGrades_num(user.getGrades_num()+1);
		if (gradesdao.updateGrades_num(conn, user)) {
			user.setGrades_num(user.getGrades_num()+1);
			//插入题目分数
			try {
				//
				gradesdao.updateGrades(conn,user, score);
				System.out.println(1);
			} catch (Exception e) {
				//
				System.out.println(2);
				System.out.println(user.getGrades_num());
				gradesdao.addGrades_n(conn, user);
				gradesdao.updateGrades(conn,user, score);
			}
			return true;			
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		String userName = "魏骊臻";
		String userPassword = "123456";
		int status = 2;
		String Telephone = "110";
		double score = 1.1;
		//创建四件套 连接-对象-发送给sql
		jdbc_util util = new jdbc_util();
		Connection conn = null;
//		UserDao userdao = new UserDao();
		User user = new User();
		
		conn = util.getCon();
		
		user.setUserName(userName);
		user.setTelephone(Telephone);
		user.setStatus(status);
		user.setUserPassword(userPassword);
		user.setGrades_num(3);
		boolean a = addUserGrades(conn, score,user);
		System.out.println(a);
	}	
	
	
	
}

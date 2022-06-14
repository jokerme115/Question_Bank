package Bank_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import Bank_Dao.GradesDao;
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
		user.setGrades_num(user.getGrades_num()+1);//mysql中做题次数+1
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
	
	/**
	 * 查询所有成绩
	 * @return
	 * @throws SQLException 
	 */
	
	public static String[] selectAllGrades(Connection conn,User user) throws Exception {
		String sql="SELECT * FROM user_grades WHERE userName=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		//处理结果
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();//获取表结构
		int columnsNumber = rsmd.getColumnCount();//获取列数
		
		String [] str = new String[columnsNumber];
		System.out.println();
		int i=0;
		while(rs.next()) {
			str[i] = rs.getString(i+1);
		}
//		for (int i = 0; i < columnsNumber; i++) {
//			str[i] = rs.getString(i);
//			rs.next();
//		}
		
		
		//释放资源
		pstmt.close();
		return str;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		String userName = "魏骊臻";
		String userPassword = "123456";
		int status = 2;
		String Telephone = "110";
//		double score = 1.1;
		//创建四件套 连接-对象-发送给sql
		jdbc_util util = new jdbc_util();
		Connection conn = null;
		User user = new User();
		
		conn = util.getCon();
		
		user.setUserName(userName);
		user.setTelephone(Telephone);
		user.setStatus(status);
		user.setUserPassword(userPassword);
		user.setGrades_num(2);
		String [] str = new String[selectAllGrades(conn, user).length];
		for(int i=1;i<str.length+1;i++) {
			System.out.println(str[i]);
		}
		
	}	
	
	
	
}

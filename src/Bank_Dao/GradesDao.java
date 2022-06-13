package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bank_model.User;

/**
 * 成绩录入功能
 * @author Wei LiZhen
 *
 */
public class GradesDao {
	/**
	 * 创造用户成绩表
	 * 最开始使用
	 * @throws Exception 
	 */
	public void createUserGrades(Connection conn,User user) throws Exception {
		String sql = "CREATE TABLE `user_grades`(\r\n" + 
				"	`userName` VARCHAR(20) NOT NULL,\r\n" + 
				"	`grades_num` INT NOT NULL DEFAULT '0'\r\n" + 
				");";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (pstmt.executeUpdate() > 0) {
			System.out.println("创建成功");	
		}
		
		//释放资源
		pstmt.close();	
	}
	
	/**
	 * 注册用户时使用
	 * 添加用户成绩表内初次注册时候信息
	 * 刚开始注册用户时使用此方法(?参数能都这样设置)
	 * @throws Exception 
	 */
	public boolean addUserGrades(Connection conn,User user) throws Exception {
		String sql ="INSERT INTO user_grades VALUES(? , 0);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		

		//处理结果
		int n = pstmt.executeUpdate();
		//释放资源
		pstmt.close();

		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 更新用户的总次数
	 * 先更新用户做题总次数 再插入新的一列
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean updateGrades_num(Connection conn,User user) throws Exception {
		String sql1 ="UPDATE user_grades SET grades_num = grades_num + 1 WHERE userName= ?;";
		String sql2	="UPDATE user SET grades_num = grades_num + 1 WHERE userName= ?;";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		user.setGrades_num(user.getGrades_num() + 1);
		pstmt1.setString(1,user.getUserName());
		pstmt2.setString(1,user.getUserName());
		//处理结果
		int n = pstmt1.executeUpdate();
		int m = pstmt2.executeUpdate();
		//释放资源
		pstmt1.close();
		pstmt2.close();
		if (n == 1&&m==1) {
			return true;
		}else {
			return false;
		}
	}	
	
	/**
	 * 如果没有下一列就添加额外一列记录此次成绩
	 * 添加完后再更新最新成绩
	 * @param conn
	 * @param usersGrades
	 * @throws Exception 
	 */ 

	public boolean addGrades_n(Connection conn,User user) throws Exception {
		String sql = "ALTER TABLE user_grades ADD grade_? Double;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getGrades_num());
		
		//处理结果
		int n = pstmt.executeUpdate();
		//释放资源
		pstmt.close();
 
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 每次用户做完后更新用户成绩表的最新数据
	 * @throws Exception 
	 */

	public boolean updateGrades(Connection conn,User user, double score) throws Exception {
		String sql ="update user_grades SET grade_?=? WHERE userName=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getGrades_num());
		pstmt.setDouble(2, score);
		pstmt.setString(3, user.getUserName());
		//处理结果
		int n = pstmt.executeUpdate();
		//释放资源
		pstmt.close();

		if (n == 1) {
			return true;
		}else {
			return false;
		}	
	}
}

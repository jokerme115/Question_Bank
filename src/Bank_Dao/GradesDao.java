package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bank_model.User;
import Bank_model.UsersGrades;

public class GradesDao {
	/**
	 * 创造用户成绩表
	 * 最开始使用
	 * @throws Exception 
	 */
	public void createUserGrades(Connection conn,UsersGrades usersGrades) throws Exception {
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
		conn.close();	
	}
	/**
	 * 注册用户时使用
	 * 添加用户成绩表内初次注册时候信息
	 * 刚开始注册用户时使用此方法(?参数能都这样设置)
	 * @throws Exception 
	 */
	public void addUserGrades(Connection conn,UsersGrades usersGrades,User user) throws Exception {
		String sql ="INSERT INTO user_grades VALUES(? , 0);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		//释放资源
		pstmt.close();
		conn.close();
	}
	
	
	/**
	 * 更新用户的总次数
	 * 先更新用户做题总次数 再插入新的一列
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public void updateGrades_num(Connection conn,User user) throws Exception {
		String sql ="UPDATE user_grades SET grades_num = grades_num + 1 WHERE userName= ? ;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		//释放资源
		pstmt.close();
		conn.close();
	}	
	
	/**
	 * 如果没有下一列就添加额外一列记录此次成绩
	 * 添加完后再更新最新成绩
	 * @param conn
	 * @param usersGrades
	 * @throws Exception 
	 */
	public void addGrades_n(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql = "ALTER TABLE user_grades ADD grade_? INT;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, usersGrades.getGrades_num());
		//释放资源
		pstmt.close();
		conn.close(); 
	}
	
	/**
	 * 每次用户做完后更新用户成绩表的最新数据
	 * @throws Exception 
	 */
	public void updateGrades(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql ="INSERT INTO grade_? VALUES(  ) WHERE userName=?;";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, usersGrades.getGrades_num());
		pstmt.setString(2, usersGrades.getUserName());
		//释放资源
		pstmt.close();
		conn.close();		
	}
}

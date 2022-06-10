package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;import java.sql.SQLException;

import Bank_model.User;
import Bank_model.UsersGrades;

public class GradesDao {
	/**
	 * �����û��ɼ���
	 * �ʼʹ��
	 * @throws Exception 
	 */
	public void createUserGrades(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql = "CREATE TABLE `user_grades`(\r\n" + 
				"	`userName` VARCHAR(20) NOT NULL,\r\n" + 
				"	`grades_num` INT NOT NULL DEFAULT '0'\r\n" + 
				");";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (pstmt.executeUpdate() > 0) {
			System.out.println("�����ɹ�");	
		}
		
		//�ͷ���Դ
		pstmt.close();
		conn.close();	
		
	}
	/**
	 * ע���û�ʱʹ��
	 * ����û��ɼ����ڳ���ע��ʱ����Ϣ
	 * �տ�ʼע���û�ʱʹ�ô˷���(?�����ܶ���������)
	 * @throws Exception 
	 */
	public boolean addUserGrades(Connection conn,UsersGrades usersGrades,User user) throws Exception {
		String sql ="INSERT INTO user_grades VALUES(? , 0);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		

		//������
		int n = pstmt.executeUpdate();
		//�ͷ���Դ
		pstmt.close();
		conn.close();
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * �����û����ܴ���
	 * �ȸ����û������ܴ��� �ٲ����µ�һ��
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception 
	 */
<<<<<<< Updated upstream
	public void updateGrades_num(Connection conn,User user) throws Exception {
		String sql ="UPDATE user_grades SET grades_num = grades_num + 1 WHERE userName= ? ;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
=======
	public boolean updateGrades_num(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql ="UPDATE user_grades SET grades_num =? WHERE userName='?';";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (usersGrades.getGrades_num()+1));
		pstmt.setString(2,usersGrades.getUserName());
		//������
		int n = pstmt.executeUpdate();
>>>>>>> Stashed changes
		//�ͷ���Դ
		pstmt.close();
		conn.close();
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}	
	
	/**
	 * ���û����һ�о���Ӷ���һ�м�¼�˴γɼ�
	 * �������ٸ������³ɼ�
	 * @param conn
	 * @param usersGrades
	 * @throws Exception 
	 */
<<<<<<< Updated upstream
	public void addGrades_n(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql = "ALTER TABLE user_grades ADD grade_? INT;";
=======
	public boolean addGrades_n(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql = "ALTER TABLE user_grades ADD grade_'?' INT;";
>>>>>>> Stashed changes
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, usersGrades.getGrades_num());
		
		//������
		int n = pstmt.executeUpdate();
		//�ͷ���Դ
		pstmt.close();
<<<<<<< Updated upstream
		conn.close(); 
=======
		conn.close();
		if (n == 1) {
			return true;
		}else {
			return false;
		}
>>>>>>> Stashed changes
	}
	
	/**
	 * ÿ���û����������û��ɼ������������
	 * @throws Exception 
	 */
<<<<<<< Updated upstream
	public void updateGrades(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql ="INSERT INTO grade_? VALUES(  ) WHERE userName=?;";

=======
	public boolean updateGrades(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql ="INSERT INTO grade_? VALUES(  ) WHERE userName='?';";
>>>>>>> Stashed changes
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, usersGrades.getGrades_num());
		pstmt.setString(2, usersGrades.getUserName());
		//������
		int n = pstmt.executeUpdate();
		//�ͷ���Դ
		pstmt.close();
		conn.close();
		if (n == 1) {
			return true;
		}else {
			return false;
		}	
	}
}

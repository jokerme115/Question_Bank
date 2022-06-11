package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	public void addUserGrades(Connection conn,UsersGrades usersGrades,User user) throws Exception {
		String sql ="INSERT INTO user_grades VALUES(? , 0);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		//�ͷ���Դ
		pstmt.close();
		conn.close();
	}
	
	
	/**
	 * �����û����ܴ���
	 * �ȸ����û������ܴ��� �ٲ����µ�һ��
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public void updateGrades_num(Connection conn,User user) throws Exception {
		String sql ="UPDATE user_grades SET grades_num = grades_num + 1 WHERE userName= ? ;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		//�ͷ���Դ
		pstmt.close();
		conn.close();
	}	
	
	/**
	 * ���û����һ�о���Ӷ���һ�м�¼�˴γɼ�
	 * �������ٸ������³ɼ�
	 * @param conn
	 * @param usersGrades
	 * @throws Exception 
	 */
	public void addGrades_n(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql = "ALTER TABLE user_grades ADD grade_? INT;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, usersGrades.getGrades_num());
		//�ͷ���Դ
		pstmt.close();
		conn.close(); 
	}
	
	/**
	 * ÿ���û����������û��ɼ������������
	 * @throws Exception 
	 */
	public void updateGrades(Connection conn,UsersGrades usersGrades) throws Exception {
		String sql ="INSERT INTO grade_? VALUES(  ) WHERE userName=?;";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, usersGrades.getGrades_num());
		pstmt.setString(2, usersGrades.getUserName());
		//�ͷ���Դ
		pstmt.close();
		conn.close();		
	}
}

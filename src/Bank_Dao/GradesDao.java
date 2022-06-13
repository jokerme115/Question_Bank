package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bank_model.User;

/**
 * �ɼ�¼�빦��
 * @author Wei LiZhen
 *
 */
public class GradesDao {
	/**
	 * �����û��ɼ���
	 * �ʼʹ��
	 * @throws Exception 
	 */
	public void createUserGrades(Connection conn,User user) throws Exception {
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
	}
	
	/**
	 * ע���û�ʱʹ��
	 * ����û��ɼ����ڳ���ע��ʱ����Ϣ
	 * �տ�ʼע���û�ʱʹ�ô˷���(?�����ܶ���������)
	 * @throws Exception 
	 */
	public boolean addUserGrades(Connection conn,User user) throws Exception {
		String sql ="INSERT INTO user_grades VALUES(? , 0);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		

		//������
		int n = pstmt.executeUpdate();
		//�ͷ���Դ
		pstmt.close();

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
	public boolean updateGrades_num(Connection conn,User user) throws Exception {
		String sql1 ="UPDATE user_grades SET grades_num = grades_num + 1 WHERE userName= ?;";
		String sql2	="UPDATE user SET grades_num = grades_num + 1 WHERE userName= ?;";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		user.setGrades_num(user.getGrades_num() + 1);
		pstmt1.setString(1,user.getUserName());
		pstmt2.setString(1,user.getUserName());
		//������
		int n = pstmt1.executeUpdate();
		int m = pstmt2.executeUpdate();
		//�ͷ���Դ
		pstmt1.close();
		pstmt2.close();
		if (n == 1&&m==1) {
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

	public boolean addGrades_n(Connection conn,User user) throws Exception {
		String sql = "ALTER TABLE user_grades ADD grade_? Double;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getGrades_num());
		
		//������
		int n = pstmt.executeUpdate();
		//�ͷ���Դ
		pstmt.close();
 
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ÿ���û����������û��ɼ������������
	 * @throws Exception 
	 */

	public boolean updateGrades(Connection conn,User user, double score) throws Exception {
		String sql ="update user_grades SET grade_?=? WHERE userName=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getGrades_num());
		pstmt.setDouble(2, score);
		pstmt.setString(3, user.getUserName());
		//������
		int n = pstmt.executeUpdate();
		//�ͷ���Դ
		pstmt.close();

		if (n == 1) {
			return true;
		}else {
			return false;
		}	
	}
}

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
	 * �������ĳɼ�����
	 * @author 19797
	 * @throws Exception 
	 *
	 */
	public static boolean addUserGrades(Connection conn, double score,User user) throws Exception{
		//���������ܴ���
		GradesDao gradesdao = new GradesDao();
		user.setGrades_num(user.getGrades_num()+1);//mysql���������+1
		if (gradesdao.updateGrades_num(conn, user)) {
			user.setGrades_num(user.getGrades_num()+1);
			//������Ŀ����
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
	 * ��ѯ���гɼ�
	 * @return
	 * @throws SQLException 
	 */
	
	public static String[] selectAllGrades(Connection conn,User user) throws Exception {
		String sql="SELECT * FROM user_grades WHERE userName=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		//������
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();//��ȡ��ṹ
		int columnsNumber = rsmd.getColumnCount();//��ȡ����
		
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
		
		
		//�ͷ���Դ
		pstmt.close();
		return str;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		String userName = "κ����";
		String userPassword = "123456";
		int status = 2;
		String Telephone = "110";
//		double score = 1.1;
		//�����ļ��� ����-����-���͸�sql
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

package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bank_model.Topic;

/**
 * ��ĿDao��
 * ���ں����ݿ���ϵ
 * @author Wei LiZhen
 *
 */
public class TopicDao {

	/**������Ŀ
	 * 
	 * @param conn
	 * @param topic
	 * @return
	 * @throws Exception
	 */
	public boolean storeTopic (Connection conn, Topic topic) throws Exception {
		String sql = "insert into topic values(null, ?,?,?,?,?,?,?);";//����ע�ⲻ����'?'���򱨴�Parameter index out of bounds.��
		
		
		PreparedStatement pstm =  conn.prepareStatement(sql);
		pstm.setInt(1, topic.getType());
		pstm.setString(2, topic.getTopic());
		pstm.setString(3, topic.getOption_A());
		pstm.setString(4, topic.getOption_B());
		pstm.setString(5, topic.getOption_C());
		pstm.setString(6, topic.getOption_D());
		pstm.setString(7, topic.getCorrect_Option());

		//������
		int n = pstm.executeUpdate();
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**ɾ����Ŀ
	 * 
	 * @param conn
	 * @param topic
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTopic (Connection conn, Topic topic) throws Exception {
		//����sql���
		String sql = "delete from topic where id = ? ;" +
					"select * from topic where id = ? ;";
 		
		PreparedStatement pstm =  conn.prepareStatement(sql);
		pstm.setInt(1, topic.getID());
		pstm.setInt(2, topic.getID());
		
		
		
		int n = pstm.executeUpdate();
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**�޸���Ŀ
	 * 
	 * @param conn
	 * @param topic
	 * @throws Exception 
	 */
	public void updateTopic(Connection conn, Topic topic) throws Exception {
		//����sql���
		String sql="update topic \r\n" + 
				"Type=?,\r\n" + 
				"Topic=?,\r\n" + 
				"Option_A=?,\r\n" + 
				"Option_B=?,\r\n" + 
				"Option_C=?,\r\n" + 
				"Option_D=?,\r\n" + 
				"Correct_Option=?\r\n" + 
				"where id = ?;";
		//��ȡpstmt����
		PreparedStatement pstm =  conn.prepareStatement(sql);
		//���ò���
		pstm.setInt(1,topic.getType());
		pstm.setString(2,topic.getTopic());
		pstm.setString(3, topic.getOption_A());
		pstm.setString(4, topic.getOption_B());
		pstm.setString(5, topic.getOption_C());
		pstm.setString(6, topic.getOption_D());
		pstm.setString(7, topic.getCorrect_Option());
		pstm.setInt(8,topic.getID());
		//ִ��sql
		int count = pstm.executeUpdate(sql);
		if(count>0) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
	}
	
	/**��ѯȫ����Ŀ
	 * 
	 * @param conn
	 * @param topic
	 * @throws Exception
	 */
	public ArrayList<Topic> selectAllTopic (Connection conn) throws Exception {
		//����sql���
		String sql = "select * from topic;";
		
		//��ȡpstmt����
		PreparedStatement pstm =  conn.prepareStatement(sql);
		
		//ִ��sql
		ResultSet rs =pstm.executeQuery();
		
		Topic alltopic = null;
		ArrayList<Topic> topics=new ArrayList<>();
		
		while(rs.next()) {
			//��ȡ����
			int id =rs.getInt("ID");
			int Type = rs.getInt("Type");
			String Topic = rs.getString("Topic");
			String Option_A = rs.getString("Option_A");
			String Option_B = rs.getString("Option_B");
			String Option_C = rs.getString("Option_C");
			String Option_D = rs.getString("Option_D");
			String Correct_Option = rs.getString("Correct_Option");
			
			
			//��װTopic���� Jun.6�޸�
			alltopic = new Topic(Type, id, Topic, Option_A, Option_B, Option_C, Option_D,Correct_Option);
			
			//װ�ؼ���
			topics.add(alltopic);
			
		}
		//�ͷ���Դ
		rs.close();
		return topics;

	}
}

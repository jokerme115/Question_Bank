package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bank_model.Topic;

/**
 * 题目Dao类
 * 用于和数据库联系
 * @author Wei LiZhen
 *
 */
public class TopicDao {

	/**增加题目
	 * 
	 * @param conn
	 * @param topic
	 * @return
	 * @throws Exception
	 */
	public boolean storeTopic (Connection conn, Topic topic) throws Exception {
		String sql = "insert into topic values(null, ?,?,?,?,?,?,?);";//这里注意不能是'?'否则报错“Parameter index out of bounds.”
		
		
		PreparedStatement pstm =  conn.prepareStatement(sql);
		pstm.setInt(1, topic.getType());
		pstm.setString(2, topic.getTopic());
		pstm.setString(3, topic.getOption_A());
		pstm.setString(4, topic.getOption_B());
		pstm.setString(5, topic.getOption_C());
		pstm.setString(6, topic.getOption_D());
		pstm.setString(7, topic.getCorrect_Option());

		//处理结果
		int n = pstm.executeUpdate();
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**删除题目
	 * 
	 * @param conn
	 * @param topic
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTopic (Connection conn, Topic topic) throws Exception {
		//设置sql语句
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
	
	
	/**修改题目
	 * 
	 * @param conn
	 * @param topic
	 * @throws Exception 
	 */
	public void updateTopic(Connection conn, Topic topic) throws Exception {
		//设置sql语句
		String sql="update topic \r\n" + 
				"Type=?,\r\n" + 
				"Topic=?,\r\n" + 
				"Option_A=?,\r\n" + 
				"Option_B=?,\r\n" + 
				"Option_C=?,\r\n" + 
				"Option_D=?,\r\n" + 
				"Correct_Option=?\r\n" + 
				"where id = ?;";
		//获取pstmt对象
		PreparedStatement pstm =  conn.prepareStatement(sql);
		//设置参数
		pstm.setInt(1,topic.getType());
		pstm.setString(2,topic.getTopic());
		pstm.setString(3, topic.getOption_A());
		pstm.setString(4, topic.getOption_B());
		pstm.setString(5, topic.getOption_C());
		pstm.setString(6, topic.getOption_D());
		pstm.setString(7, topic.getCorrect_Option());
		pstm.setInt(8,topic.getID());
		//执行sql
		int count = pstm.executeUpdate(sql);
		if(count>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	
	/**查询全部题目
	 * 
	 * @param conn
	 * @param topic
	 * @throws Exception
	 */
	public ArrayList<Topic> selectAllTopic (Connection conn) throws Exception {
		//设置sql语句
		String sql = "select * from topic;";
		
		//获取pstmt对象
		PreparedStatement pstm =  conn.prepareStatement(sql);
		
		//执行sql
		ResultSet rs =pstm.executeQuery();
		
		Topic alltopic = null;
		ArrayList<Topic> topics=new ArrayList<>();
		
		while(rs.next()) {
			//获取数据
			int id =rs.getInt("ID");
			int Type = rs.getInt("Type");
			String Topic = rs.getString("Topic");
			String Option_A = rs.getString("Option_A");
			String Option_B = rs.getString("Option_B");
			String Option_C = rs.getString("Option_C");
			String Option_D = rs.getString("Option_D");
			String Correct_Option = rs.getString("Correct_Option");
			
			
			//封装Topic对象 Jun.6修改
			alltopic = new Topic(Type, id, Topic, Option_A, Option_B, Option_C, Option_D,Correct_Option);
			
			//装载集合
			topics.add(alltopic);
			
		}
		//释放资源
		rs.close();
		return topics;

	}
}

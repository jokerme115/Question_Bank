package Bank_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Bank_model.Topic;

/**
 * 题目Dao类
 * 用于和数据库联系
 * @author HeTao
 *
 */
public class TopicDao {

	
	public boolean storeTopic (Connection conn, Topic topic) throws Exception {
		String sql = "INSERT INTO topic VALUES(null, ?,?,?,?,?,?,?);";//这里注意不能是'?'否则报错“Parameter index out of bounds.”
		
		
		PreparedStatement pstm =  conn.prepareStatement(sql);
		pstm.setInt(1, topic.getType());
		pstm.setString(2, topic.getTopic());
		pstm.setString(3, topic.getOption_A());
		pstm.setString(4, topic.getOption_B());
		pstm.setString(5, topic.getOption_C());
		pstm.setString(6, topic.getOption_D());
		pstm.setString(7, topic.getCorrect_Option());

		
		int n = pstm.executeUpdate();
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	
}

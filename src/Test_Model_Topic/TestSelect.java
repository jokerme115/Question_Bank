package Test_Model_Topic;

import java.sql.Connection;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

public class TestSelect {

	public static void main(String[] args) throws Exception {
		jdbc_util util = new jdbc_util();
		Connection conn = util.getCon();
		Topic topic = new Topic();
		int id = 1;
		
		topic = TopicDao.selectOneTopic(conn, id);
		System.out.println(topic);
	}
}

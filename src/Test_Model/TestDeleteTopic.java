package Test_Model;

import java.sql.Connection;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

public class TestDeleteTopic {

	public static void main(String[] args)throws Exception {
		int ID=14;//������ID����Id ��Ҫ����
		
		jdbc_util util = new jdbc_util();
		Connection conn = null;
		TopicDao topicdao = new TopicDao();
		Topic topic = new Topic();
		
		topic.setID(ID);
		
		conn = util.getCon();
		
		boolean a = topicdao.deleteTopic(conn, topic);
		System.out.println(a);
	}

}

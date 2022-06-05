package Test_Model;

import java.sql.Connection;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;
/**
 * 测试题目的添加
 * @author HeTao
 *
 */
public class TestAdd {
	public static void main(String[] args) throws Exception {
	
		int Type = 1; 					
		String Topic = "题目"; 				
		String Option_A = "选项A"; 				
		String Option_B = "选项B"; 				
		String Option_C = "选项C"; 				
		String Option_D = "选项D"; 				
		String Correct_Option = "D";
		
		
		Bank_model.Topic topic = new Topic();
		jdbc_util util = new jdbc_util();
		
		Connection conn = null;
		conn = util.getCon();
		
		topic.setTopic(Topic);
		topic.setOption_A(Option_A);
		topic.setOption_B(Option_B);
		topic.setOption_C(Option_C);
		topic.setOption_D(Option_D);
		topic.setCorrect_Option(Correct_Option);
		topic.setType(Type);
		
		TopicDao topic_dao = new TopicDao();
		
		boolean a = topic_dao.storeTopic(conn, topic);
		System.out.println(a);
	}
	
	
}

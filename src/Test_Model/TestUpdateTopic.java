package Test_Model;

import java.sql.Connection;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

/**
 * 测试修改题目
 * @author 19797
 *
 */
public class TestUpdateTopic {
	public static void main(String[] args) throws Exception {
		int Type =1;
		String Topic ="Demo";
		String Option_A="you";
		String Option_B="can";
		String Option_C="dismiss";
		String Option_D="this";
		String Correct_Option="C";
		int ID=5;
		jdbc_util util = new jdbc_util();
		Connection conn = null;
		TopicDao topicdao = new TopicDao();
		Topic topic = new Topic();
		
		topic.setID(ID);
		topic.setType(Type);
		topic.setTopic(Topic);
		topic.setOption_A(Option_A);
		topic.setOption_B(Option_B);
		topic.setOption_C(Option_C);
		topic.setOption_D(Option_D);
		topic.setCorrect_Option(Correct_Option);
		//38行有疑问
		topicdao.updateTopic(conn, topic);
		
	}
}

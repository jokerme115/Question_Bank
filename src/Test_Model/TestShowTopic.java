package Test_Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

/**
 * 展示所有题目数据
 * @author HeTao
 *
 */
public class TestShowTopic {
	public static void main(String[] args) throws Exception {
		jdbc_util util = new jdbc_util();
		Connection conn = null;
		TopicDao userdao = new TopicDao();
		ArrayList<String> list = null;
		
		
		conn = util.getCon();
		
		list = userdao.selectAllTopic(conn);
		
		Iterator<Topic> it =  list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}

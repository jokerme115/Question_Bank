package Test_Model_Topic;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Bank_model.Topic;
import Bank_util.jdbc_util;
import Bank_util.topic_util;

public class Main_Topic {
	public static void main(String[] args) throws Exception {
		//输入题目类型和题目数量以及设置题目分数(分数使用集合存储)
		int Type = 1;
		int Count = 5;
		int score1 = 5;
		int score2 = 3;
		int sum = 0;
		
		int [] totalScore = new int[Count];
		ArrayList<Topic> Topic = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		jdbc_util util2 = new jdbc_util();
		Connection conn = util2.getCon();
		
		
		Topic = topic_util.getRandomTopic(conn, 1, topic_util.getDateTopic(Type).size(), Count);
		//每次从List中显示一道题
		Iterator<Topic> ItTopic=  Topic.iterator();
		int n = 0;
		

		while (ItTopic.hasNext()) {
			Topic topic = ItTopic.next();
			System.out.println("第" + (n+1) +"题:"  + topic.getTopic());
			System.out.println("A:" + topic.getOption_A());
			System.out.println("B:" + topic.getOption_B());
			System.out.println("C:" + topic.getOption_C());
			System.out.println("D:" + topic.getOption_D());
			
			int result = scan.nextInt();
			totalScore[n] =  topic_util.jugementOption(result, topic);
			System.out.println(totalScore[n]);
			n++;
		}
		//答题后记录分数(0: 0分 1:半对 2:满分)
		for (int e : totalScore) {
			if (e == 1) {
				e = score2;
			}else if (e == 2) {
				e = score1;
			}
			sum += e;
		}
		//答题结束显示分数以及保存分数
		
		System.out.println("您的成绩为:" + sum);
		scan.close();
	}
}

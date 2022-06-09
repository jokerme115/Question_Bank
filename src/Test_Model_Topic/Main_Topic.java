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
		//������Ŀ���ͺ���Ŀ�����Լ�������Ŀ����(����ʹ�ü��ϴ洢)
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
		//ÿ�δ�List����ʾһ����
		Iterator<Topic> ItTopic=  Topic.iterator();
		int n = 0;
		

		while (ItTopic.hasNext()) {
			Topic topic = ItTopic.next();
			System.out.println("��" + (n+1) +"��:"  + topic.getTopic());
			System.out.println("A:" + topic.getOption_A());
			System.out.println("B:" + topic.getOption_B());
			System.out.println("C:" + topic.getOption_C());
			System.out.println("D:" + topic.getOption_D());
			
			int result = scan.nextInt();
			totalScore[n] =  topic_util.jugementOption(result, topic);
			System.out.println(totalScore[n]);
			n++;
		}
		//������¼����(0: 0�� 1:��� 2:����)
		for (int e : totalScore) {
			if (e == 1) {
				e = score2;
			}else if (e == 2) {
				e = score1;
			}
			sum += e;
		}
		//���������ʾ�����Լ��������
		
		System.out.println("���ĳɼ�Ϊ:" + sum);
		scan.close();
	}
}

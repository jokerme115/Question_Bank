package Bank_util;

import java.util.ArrayList;
import Bank_model.Topic;

public class topic_util {
	public static ArrayList<Integer> topicRandom(int digit, int total) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < digit; i++) {
			Math.random();
		}
		return list;
		
	}
	
	public static int totalInformation() {
		int ret = 0;
		
		
		return ret;
	}
	/**
	 * 
	 * �ж��ҵ�ѡ���Ƿ���ȷ(�����ѡ)��ѡ����sting������AB�����пո�
	 * @param Option��ѡѡ�� A=1 B=2 C=3 D=4 
	 * ��ѡѡ��  A=1000 B=0100 C=0010 D=0001
	 * @param topic��������Ϣ
	 * @return
	 */
	public static int jugementOption(int Option, Topic topic) {
		int flag=0;//0Ϊ����1Ϊ�������һ����û�д���2Ϊȫ�ԣ�
		String str=topic.getCorrect_Option();//δ�����׼��
		int currentOption= 0;//���ͱ�׼��
		//����ת����ȷ��
		for(int index=0;index < str.length();index++) {
			if(str.charAt(index)=='A') {
				currentOption+=1000;
			}else if(str.charAt(index)=='B') {
				currentOption+=100;
			}else if(str.charAt(index)=='C') {
				currentOption+=10;
			}else if(str.charAt(index)=='D') {
				currentOption+=1;
			}
		}
		//�жϴ�
		//��ѡ���
		if(topic.getType()==1) {
			if(Option==1000) {
				flag=2;
			}else if(Option==100) {
				flag=2;
			}else if(Option==10) {
				flag=2;
			}else if(Option==1) {;
				flag=2;
			}
		}
//		��ѡ���
		else if(topic.getType()==2){
			//���ѡ�����
			@SuppressWarnings("unused")
			int Option_num=0;
			int temp=Option;
			while(Option>0) {
				Option_num+=Option%10;
				Option/=10;
			}
			Option=temp;
			@SuppressWarnings("unused")
			int currentOption_num=0;
			int temp1=currentOption;
			while(currentOption>0) {
				currentOption_num+=currentOption%10;
				currentOption/=10;
			}
			currentOption=temp1;
			//�ȱȽ�ѡ�����
			//���ѡ����������ȷ��ѡ����� ȫ��
			if(Option_num>currentOption_num) {
				flag=0;
			}
			//���ѡ����������ȷ�𰸸��� ���==��ô�� ����ȫ��			
			else if(Option_num==currentOption_num){
				if(Option==currentOption) {
					flag=2;
				}else {
					flag=0;
				}			
			}
			//���ѡ�����С����ȷ�𰸸���
			else {
				//�����������һ��
				flag=1;
				for(int i=0;i<4;i++) {
					if(Option%10>currentOption%10) {
						flag=0;
						break;
						}
					Option/=10;
					currentOption/=10;
					}
				}
			}				
		return flag;
	}

	/**��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Topic test = new Topic();
		
		test.setCorrect_Option("ABC");
		test.setType(2);
		
		int test1 = 1000;
		System.out.println(jugementOption(test1, test));
	}

}

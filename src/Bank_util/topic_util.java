package Bank_util;

import java.util.ArrayList;

import Bank_model.Topic;

public class topic_util {
	/**
	 * ��Ŀ�����ȡ��ArrayList��
	 * @param digit��Ŀ����
	 * @param total���������
	 * @return
	 */
	public static ArrayList<Integer> topicRandom(int digit, int total) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < digit; i++) {
			Math.random();
		}
		return list;
		
	}
	
	/**
	 * ������Ŀ��������ͬ���͵ĸ�����ѡ����ѡ���ݶ����ü��� ��ֹ�Ժ�������͸��������С�ñ�
	 * @param Topic�������ͼ���
	 * @return
	 */
	public static ArrayList<Integer> totalInformation(Topic topic) {
		ArrayList<Integer> ret = new ArrayList<>();//1:��ѡ 2:��ѡ
		
		
		return ret;
	}
	/**
	 * �ж��ҵ�ѡ���Ƿ���ȷ(������ѡ)��ѡ����sting������AB�����пո�
	 * @param Optionѡ��1A 2B 3C 4D
	 * @param topic��������Ϣ
	 * @return
	 */
	public static boolean jugementOption(int Option, Topic topic) {
		
		return false;
		
	}
}

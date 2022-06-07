package Bank_util;

import java.util.ArrayList;

import Bank_model.Topic;

public class topic_util {
	/**
	 * 题目随机抽取到ArrayList中
	 * @param digit题目类型
	 * @param total随机数个数
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
	 * 返回题目总数，不同题型的个数单选，多选（暂定）用集合 防止以后更改类型个数数组大小得变
	 * @param Topic所有题型集合
	 * @return
	 */
	public static ArrayList<Integer> totalInformation(Topic topic) {
		ArrayList<Integer> ret = new ArrayList<>();//1:单选 2:多选
		
		
		return ret;
	}
	/**
	 * 判断我的选项是否正确(包括多选)多选答案是sting类型如AB可能有空格
	 * @param Option选项1A 2B 3C 4D
	 * @param topic这道题的信息
	 * @return
	 */
	public static boolean jugementOption(int Option, Topic topic) {
		
		return false;
		
	}
}

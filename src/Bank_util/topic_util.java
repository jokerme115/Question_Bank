package Bank_util;

import java.util.ArrayList;
import Bank_model.Topic;

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

	 * 
	 * 判断我的选项是否正确(包括多选)多选答案是sting类型如AB可能有空格
	 * @param Option单选选项 A=1 B=2 C=3 D=4 
	 * 多选选项  A=1000 B=0100 C=0010 D=0001
	 * @param topic这道题的信息
	 * @return
	 */
	public static int jugementOption(int Option, Topic topic) {
		int flag=0;//0为错误，1为至少做对一个且没有错误，2为全对；
		String str=topic.getCorrect_Option();//未处理标准答案
		int currentOption= 0;//整型标准答案
		//遍历转化正确答案
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
		
		//判断答案
		//单选情况
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
//		多选情况
		else if(topic.getType()==2){
			//获得选项个数
			@SuppressWarnings("unused")
			int Option_num=0;
			while(Option>0) {
				Option_num+=Option%10;
				Option/=10;
			}
			@SuppressWarnings("unused")
			int currentOption_num=0;
			while(currentOption>0) {
				currentOption_num+=currentOption%10;
				currentOption/=10;
			}
			//先比较选项个数
			//如果选项个数大于正确答案选项个数 全错
			if(Option_num>currentOption_num) {
				flag=0;
			}
			//如果选项个数等于正确答案个数 如果==那么对 否则全错			
			else if(Option_num==currentOption_num){
				if(Option==currentOption) {
					flag=2;
				}else {
					flag=0;
				}
			
			}
			//如果选项个数小于正确答案个数
			else {
				//这种情况最多对一个
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
		}
		return flag;
	}
}

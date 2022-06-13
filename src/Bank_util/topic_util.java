package Bank_util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Bank_Dao.TopicDao;
import Bank_model.Topic;




public class topic_util {
/**
 * 
 * @param nums
 * @param start
 * @param end
 * @return
 */
	public static ArrayList<Integer> randomSet(int nums,int start,int end){
        //1.创建集合容器对象
		ArrayList<Integer> list = new ArrayList<>();

        //2.创建Random对象
        Random r = new Random();
        //循环将得到的随机数进行判断，如果随机数不存在于集合中，则将随机数放入集合中，如果存在，则将随机数丢弃不做操作，进行下一次循环，直到集合长度等于nums
        while(list.size() != nums){
            int num = r.nextInt(end-start) + start;//细节nextInt是[0,x)不包含x!
            if(!list.contains(num)){
                list.add(num);
            }
        }

        return list;
	}


	/**
	 * 随机出题功能
	 * @param conn
	 * @param begin 开始序号
	 * @param end	结束序号
	 * @param total	总数
	 * @return	返回一个Topic类型的集合
	 * @throws Exception
	 */
	public static ArrayList<Topic> getRandomTopic(Connection conn , int begin, int end, int total, int type) throws Exception{
		ArrayList<Integer> random = new ArrayList<Integer>();
		random = randomSet(total, begin, end);
		
		ArrayList<Topic> randomTopic= new ArrayList<>();//创建一个集合包含了随机题目的全部信息
		
		ArrayList<Topic> allTopic = getDateTopic(type);//提取所有题目信息到集合allTopic中
		
		Iterator<Integer> ITrandom = random.iterator();//利用迭代器遍历所有随机数集合
		
		while (ITrandom.hasNext()) {
			randomTopic.add(allTopic.get(ITrandom.next())) ;//把allTopic中随机数所对应的Topic放入集合randomTopic中
		}
		return randomTopic;
		
	}
	
	
	/**
	 * 得到同类型的集合
	 * @param topic
	 * @param Type
	 * @return
	 * @throws Exception 
	 */
	public static ArrayList<Topic> getDateTopic(int Type) throws Exception {
		ArrayList<Topic> ret = new ArrayList<>();
		
		jdbc_util util = new jdbc_util();
		Connection conn = util.getCon();
		ArrayList<Topic> topic = TopicDao.selectAllTopic(conn);
		
		for (int i = 0; i < topic.size(); i++) {
			if (topic.get(i).getType() == Type) {
				ret.add(topic.get(i));
			}
		}
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
	public static double jugementOption(double Option, Topic topic) {
		int flag=0;//0为错误，1为至少做对一个且没有错误，2为全对；
		String str=topic.getCorrect_Option();//未处理标准答案
		int currentOption= 0;//整型标准答案
		//遍历转化正确答案
		for(int index=0;index < str.length();index++) {
			if(str.charAt(index)=='A'||str.charAt(index)=='a') {
				currentOption+=1000;
			}else if(str.charAt(index)=='B'||str.charAt(index)=='b') {
				currentOption+=100;
			}else if(str.charAt(index)=='C'||str.charAt(index)=='c') {
				currentOption+=10;
			}else if(str.charAt(index)=='D'||str.charAt(index)=='d') {
				currentOption+=1;
			}
		}
		//判断答案
		//单选情况
		if(topic.getType()==1) {
			if(Option==currentOption) {
				flag=2;
			}else {
				flag=0;
			}
		}
//		多选情况
		else if(topic.getType()==2){
			//获得选项个数
			int Option_num=0;
			double temp=Option;
			while(Option>0) {
				Option_num+=Option%10;
				Option/=10;
			}
			Option=temp;
			int currentOption_num=0;
			int temp1=currentOption;
			while(currentOption>0) {
				currentOption_num+=currentOption%10;
				currentOption/=10;
			}
			currentOption=temp1;
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
		return flag;
	}
	/**测试用例
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Topic test = new Topic();
		int type = 1;
		
		test.setCorrect_Option("ABC");
		test.setType(2);
		
		int test1 = 0111;
		System.out.println(jugementOption(test1, test));
		
		System.out.println("--------------------------------------");
		
		jdbc_util util = new jdbc_util();
		Connection conn = util.getCon();
		int begin = 1;
		int end = getDateTopic(1).size();
		int total = 5;
		
		ArrayList<Integer> random = new ArrayList<Integer>();
		random = randomSet(total, begin, end);
		System.out.println(random.size());
		
		ArrayList<Topic> topics = new ArrayList<>();
		topics = getRandomTopic(conn ,begin, end, total, type);
		
		Iterator<Topic> Ittopics = topics.iterator();
		
		while (Ittopics.hasNext()) {
			System.out.println(Ittopics.next());
		}
	}
}

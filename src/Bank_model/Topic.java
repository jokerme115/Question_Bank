package Bank_model;

/**
 * ��Ŀʵ��
 * @author HeTao
 *
 */

public class Topic { 					
	private int Type; 	
	private int ID;
	private String Topic; 				
	private String Option_A; 				
	private String Option_B; 				
	private String Option_C; 				
	private String Option_D; 				
	private String Correct_Option;
	

	public Topic() {
		super();
	}
	
	public Topic(int type, int iD, String topic, String option_A, String option_B, String option_C, String option_D,
			String correct_Option) {
		super();
		Type = type;
		ID = iD;
		Topic = topic;
		Option_A = option_A;
		Option_B = option_B;
		Option_C = option_C;
		Option_D = option_D;
		Correct_Option = correct_Option;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public String getOption_A() {
		return Option_A;
	}
	public void setOption_A(String option_A) {
		Option_A = option_A;
	}
	public String getOption_B() {
		return Option_B;
	}
	public void setOption_B(String option_B) {
		Option_B = option_B;
	}
	public String getOption_C() {
		return Option_C;
	}
	public void setOption_C(String option_C) {
		Option_C = option_C;
	}
	public String getOption_D() {
		return Option_D;
	}
	public void setOption_D(String option_D) {
		Option_D = option_D;
	}
	public String getCorrect_Option() {
		return Correct_Option;
	}
	public void setCorrect_Option(String correct_Option) {
		Correct_Option = correct_Option;
	}

	@Override
	public String toString() {
		return "Topic [Type=" + Type + ", ID=" + ID + ", Topic=" + Topic + ", Option_A=" + Option_A + ", Option_B="
				+ Option_B + ", Option_C=" + Option_C + ", Option_D=" + Option_D + ", Correct_Option=" + Correct_Option
				+ "]";
	}
}

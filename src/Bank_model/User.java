package Bank_model;

/**
 * �û�ʵ��
 * @author HeTao
 *
 */
public class User {
	private int id;
	private String userName;
	private String userPassword;
	private int status;
	private String Telephone;
	private int grades_num;
//	private ArrayList<Integer> score = new ArrayList<>();
	
	
	public int getGrades_num() {
		return grades_num;
	}

	public void setGrades_num(int grades_num) {
		this.grades_num = grades_num;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getTelephone() {
		return Telephone;
	}


	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	
	
	
	public User() {
		super();
	}
	
	
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}

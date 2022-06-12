package Bank_view;

import java.util.ArrayList;

import Bank_model.Topic;
import Bank_model.User;

public class mainTest {
	public static void main(String[] args) {
		User user = new User();//此次登录的用户
		mainf Main = new mainf();
		SetTopic settopic = new SetTopic();
		ArrayList<Topic> topic  = new ArrayList<>();
		//打开登录界面,已经连接了注册界面和主菜单界面
		LogOnFrm logonfrm = null;
		try {
			logonfrm = new LogOnFrm();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logonfrm.main(null);
		user = logonfrm.getUser(); //获得用户
		
		//主菜单界面
		Main = logonfrm.getMain();//获得主菜单
		
		
	}
}

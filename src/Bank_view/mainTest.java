package Bank_view;

import java.util.ArrayList;

import Bank_model.Topic;
import Bank_model.User;

public class mainTest {
	public static void main(String[] args) {
		User user = new User();//�˴ε�¼���û�
		mainf Main = new mainf();
		SetTopic settopic = new SetTopic();
		ArrayList<Topic> topic  = new ArrayList<>();
		//�򿪵�¼����,�Ѿ�������ע���������˵�����
		LogOnFrm logonfrm = null;
		try {
			logonfrm = new LogOnFrm();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logonfrm.main(null);
		user = logonfrm.getUser(); //����û�
		
		//���˵�����
		Main = logonfrm.getMain();//������˵�
		
		
	}
}

package Bank_view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 题目修改类
 * @author HeTao
 *
 */
public class function_modify extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTextField Boption;
	private JTextField Coption;
	private JTextField Doption;
	private JTextField Aoption;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private int Id = function.id;
	TopicDao topicdao = new TopicDao();

	


	jdbc_util util = new jdbc_util();
	Connection conn = null;
	Topic topic = new Topic();
	private JTextField Correct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					function_modify frame = new function_modify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public function_modify() throws Exception {
		conn = util.getCon();
		topic = TopicDao.selectOneTopic(conn, Id);
		
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4FEE\u6539\u9898\u76EE");
		setBounds(100, 100, 772, 535);
		
		Aoption = new JTextField(topic.getOption_A());
		Aoption.setFont(new Font("宋体", Font.PLAIN, 18));
		Aoption.setColumns(10);
		
		Boption = new JTextField(topic.getOption_B());
		Boption.setFont(new Font("宋体", Font.PLAIN, 18));
		Boption.setColumns(10);
		
		Coption = new JTextField(topic.getOption_C());
		Coption.setFont(new Font("宋体", Font.PLAIN, 18));
		Coption.setColumns(10);
		
		Doption = new JTextField(topic.getOption_A());
		Doption.setFont(new Font("宋体", Font.PLAIN, 18));
		Doption.setColumns(10);

		btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updataInformation(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 exit();

			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		
		Correct = new JTextField(topic.getCorrect_Option());
		Correct.setFont(new Font("宋体", Font.PLAIN, 18));
		Correct.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(111))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(95, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Correct, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(Doption, Alignment.LEADING)
								.addComponent(Coption, Alignment.LEADING)
								.addComponent(Boption, Alignment.LEADING)
								.addComponent(Aoption, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
							.addGap(63))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(Aoption, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Boption, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Coption, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Doption, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(Correct, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea(topic.getTopic());
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
		

	}
	protected void exit() {
		this.dispose();
		function fun = new function();
		fun.main(null);
	}

	private void updataInformation(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		topic.setTopic(textArea.getText());
		topic.setOption_A(Aoption.getText());
		topic.setOption_B(Boption.getText());
		topic.setOption_C(Coption.getText());
		topic.setOption_D(Doption.getText());
		topic.setCorrect_Option(Correct.getText());
		
		if (topicdao.updateTopic(conn, topic)) {
			JOptionPane.showMessageDialog(null, "修改成功");
			this.dispose();
			function fun = new function();
			fun.main(null);
		}else {
			JOptionPane.showMessageDialog(null, "修改失败");
		}
	}

	public void setId(int id) {
		Id = id;
	}
}

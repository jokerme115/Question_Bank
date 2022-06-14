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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 题目修改类
 * @author HeTao
 *
 */
public class function_modify2 extends JInternalFrame {
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
	private JComboBox<String> comboBox;

	TopicDao topicdao = new TopicDao();
	jdbc_util util = new jdbc_util();
	Connection conn = null;
	Topic topic = null;
	private JTextField Correct;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					function_modify2 frame = new function_modify2();
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
	public function_modify2() throws Exception {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4FEE\u6539\u9898\u76EE");
		setBounds(100, 100, 772, 535);
		
		Aoption = new JTextField();
		Aoption.setFont(new Font("宋体", Font.PLAIN, 18));
		Aoption.setColumns(10);
		
		Boption = new JTextField();
		Boption.setFont(new Font("宋体", Font.PLAIN, 18));
		Boption.setColumns(10);
		
		Coption = new JTextField();
		Coption.setFont(new Font("宋体", Font.PLAIN, 18));
		Coption.setColumns(10);
		
		Doption = new JTextField();
		Doption.setFont(new Font("宋体", Font.PLAIN, 18));
		Doption.setColumns(10);

		btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddTopic(e);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		
		Correct = new JTextField((String) null);
		Correct.setFont(new Font("宋体", Font.PLAIN, 18));
		Correct.setColumns(10);
		
		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"\u9898\u578B\u9009\u62E9", "\u5355\u9009", "\u591A\u9009"}));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(121)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(113))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(95, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Correct, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(84)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
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
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Correct, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
		

	}

	private void AddTopic(ActionEvent e) throws Exception {
		topic.setID(comboBox.getItemCount());
		topic.setTopic(textArea.getText());
		topic.setOption_A(Aoption.getText());
		topic.setOption_B(Boption.getText());
		topic.setOption_C(Coption.getText());
		topic.setOption_D(Doption.getText());
		topic.setCorrect_Option(Correct.getText());
		
		if (topicdao.storeTopic(conn, topic)) {
			JOptionPane.showMessageDialog(null, "添加成功");
			this.dispose();
			function fun = new function();
			fun.main(null);
		}else {
			JOptionPane.showMessageDialog(null, "添加失败");
		}
		
	}
}

package Bank_view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetTopic{

	private JFrame frame;
	protected static JTextField TopicCount;
	protected static JTextField TopicScore;
	protected static JComboBox<String> comboBox;
	private JTextField score2;
	private JLabel TXT;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetTopic window = new SetTopic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetTopic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setTitle("\u8003\u8BD5\u9898\u76EE\u9009\u62E9");
		frame.setBounds(100, 100, 371, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\u9898\u76EE\u9009\u62E9");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 2) {
					TXT.setVisible(true);
					score2.setVisible(true);
				}
				showOther(e);
			}
		});
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		String item1 = "题目类型";
		String item2 = "单选题";
		String item3 = "多选题";
		comboBox.addItem(item1);
		comboBox.addItem(item2);
		comboBox.addItem(item3);
		
		
		JLabel lblNewLabel_1 = new JLabel("\u9898\u578B\u9009\u62E9");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u9898\u76EE\u6570\u91CF");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("\u5C0F\u9898\u5206\u6570");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		TopicCount = new JTextField();
		TopicCount.setFont(new Font("宋体", Font.PLAIN, 16));
		TopicCount.setColumns(10);
		
		TopicScore = new JTextField();
		TopicScore.setFont(new Font("宋体", Font.PLAIN, 16));
		TopicScore.setColumns(10);
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					diliverInformation(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		submit.setFont(new Font("宋体", Font.PLAIN, 16));
		
		score2 = new JTextField();
		score2.setFont(new Font("宋体", Font.PLAIN, 16));
		score2.setColumns(10);
		score2.setVisible(false);
		
		TXT = new JLabel("\u534A\u5BF9\u5206\u6570");
		TXT.setFont(new Font("宋体", Font.PLAIN, 16));
		TXT.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(TXT, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(TopicCount)
								.addComponent(TopicScore, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
								.addComponent(score2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(139, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(120))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(submit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(118))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(TopicCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(TopicScore, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(score2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(TXT, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(submit)
					.addGap(42))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void showOther(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void diliverInformation(ActionEvent e) throws Exception {
		if (comboBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "请选择题型");
		}else if (TopicScore.getText() == null) {
			JOptionPane.showMessageDialog(null, "小题成绩不能为空");
		}else if (TopicCount.getText() == null) { 
			JOptionPane.showMessageDialog(null, "题目数量不能为空");
		}else {
			System.out.println(TopicScore.getText());
			System.out.println(TopicCount.getText());
			AnswerFrm.main(null);
			frame.dispose();
		}
	}
}

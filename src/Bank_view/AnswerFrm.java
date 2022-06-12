package Bank_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Bank_model.Topic;
import Bank_util.jdbc_util;
import Bank_util.topic_util;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AnswerFrm {

	private JFrame frame;
	private int type;
	private int score;
	private int count;
	private int Index = 1;
	
	JLabel Topictxt;
	JRadioButton Aoption;
	JRadioButton Boption;
	JRadioButton Coption;
	JRadioButton Doption;
//	private int [] totalScore = new int[count];
	private ArrayList<Topic> topic = new ArrayList<>();
	private jdbc_util util2 = new jdbc_util();
	private Connection conn = null;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerFrm window = new AnswerFrm();
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
	public AnswerFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u7B54\u9898\u754C\u9762");
		frame.setBounds(100, 100, 1170, 702);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel Main = new JPanel();
		Main.setBounds(29, 31, 780, 597);
		frame.getContentPane().add(Main);
		
		JLabel lblNewLabel = new JLabel("A:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		Aoption = new JRadioButton("New radio button");
		Aoption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("B:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("C:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("D:");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		Boption = new JRadioButton("New radio button");
		Boption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		Coption = new JRadioButton("New radio button");
		Coption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		Doption = new JRadioButton("New radio button");
		Doption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton up = new JButton("\u4E0A\u4E00\u9898");
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up(e);
			}
		});
		up.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton down = new JButton("\u4E0A\u4E00\u9898");
		down.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton up_1 = new JButton("\u5F00\u59CB\u7B54\u9898");
//		up_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Begin(e);
//			}
//		});
		up_1.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_Main = new GroupLayout(Main);
		gl_Main.setHorizontalGroup(
			gl_Main.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Main.createSequentialGroup()
					.addGroup(gl_Main.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Main.createSequentialGroup()
							.addGap(165)
							.addGroup(gl_Main.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Main.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Boption, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Main.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Aoption, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Main.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Doption, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Main.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Coption, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Main.createSequentialGroup()
							.addGap(99)
							.addGroup(gl_Main.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Main.createSequentialGroup()
									.addGap(25)
									.addComponent(up, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(up_1)
									.addGap(88)
									.addComponent(down, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(94)))))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_Main.setVerticalGroup(
			gl_Main.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Main.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_Main.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(Aoption))
					.addGap(27)
					.addGroup(gl_Main.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(Boption, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_Main.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(Coption, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Main.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(Doption, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_Main.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Main.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_Main.createParallelGroup(Alignment.BASELINE)
								.addComponent(down, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(up, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Main.createSequentialGroup()
							.addGap(18)
							.addComponent(up_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		Topictxt = new JLabel("New label");
		scrollPane_1.setViewportView(Topictxt);
		Main.setLayout(gl_Main);
		
		JPanel AnswerCard = new JPanel();
		AnswerCard.setBounds(836, 36, 299, 263);
		frame.getContentPane().add(AnswerCard);
		AnswerCard.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		AnswerCard.add(scrollPane);
		
		JLabel Name = new JLabel("New label");
		Name.setBounds(847, 387, 299, 66);
		frame.getContentPane().add(Name);
		
		JButton submit = new JButton("New button");
		submit.setBounds(847, 574, 299, 54);
		frame.getContentPane().add(submit);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(847, 474, 299, 66);
		frame.getContentPane().add(lblNewLabel_1);
	}
//	private void Begin(ActionEvent e) {
//		try {
//			System.out.println(type);
//			System.out.println(count);
//			System.out.println(topic.isEmpty());
//			showInformation();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//			System.out.println(topic.size());
//			JOptionPane.showMessageDialog(null, "错误");
//		}
//		
//	}


	private void up(ActionEvent e) {
//		
		
	}
	
	private void showInformation(ArrayList<Topic> topic2) throws Exception {
		this.Topictxt.setText(topic2.get(Index).getTopic());
		this.Aoption.setText(topic2.get(Index).getOption_A());
		this.Boption.setText(topic2.get(Index).getOption_B());
		this.Coption.setText(topic2.get(Index).getOption_C());
		this.Doption.setText(topic2.get(Index).getOption_D());
		this.Topictxt.setText("111");
	}
	/**
	 * 获得随机的Topic集合
	 * @param Type
	 * @param Count
	 * @return 
	 * @return
	 * @throws Exception
	 */
	void getInformation() throws Exception{
		conn = util2.getCon();
		this.topic = topic_util.getRandomTopic(conn, 1, topic_util.getDateTopic(type).size(), count);
		System.out.println(type);
		System.out.println(count);
		System.out.println(topic.isEmpty());
		showInformation(topic);
	}
	/**
	 * 得到SetTopic中的值
	 * @return
	 */
	
	public int getType() {
		return type;
	}
	public int getIndex() {
		return Index;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

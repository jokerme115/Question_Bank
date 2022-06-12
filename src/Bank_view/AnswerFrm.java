package Bank_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.ButtonGroup;

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
	
	private int [] totalScore = new int[count];
	private ArrayList<Topic> topic = new ArrayList<>();
	private jdbc_util util2 = new jdbc_util();
	private Connection conn = null;
	private int result = 0;
	

	/**
	 * Launch the application.
	 */
	public void main(String[] args){
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
	 * @throws Exception 
	 */
	public AnswerFrm() throws Exception {
		getInformation();
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
		
		
		Aoption = new JRadioButton("");
		Aoption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = 1000;
			}
		});
		Aoption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("B:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("C:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("D:");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		Boption = new JRadioButton("");
		Boption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = 100;
			}
		});
		Boption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		Coption = new JRadioButton("");
		Coption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = 10;
			}
		});
		Coption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		Doption = new JRadioButton("");
		Doption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = 1;
			}
		});
		Doption.setFont(new Font("宋体", Font.PLAIN, 20));
		
		if (type == 1) {			
			ButtonGroup group = new ButtonGroup();
			group.add(Aoption);
			group.add(Boption);
			group.add(Coption);
			group.add(Doption);
		}
		
		final JButton up = new JButton("\u4E0A\u4E00\u9898");
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up(e);
			}
		});
		up.setFont(new Font("宋体", Font.PLAIN, 16));
		
		final JButton down = new JButton("\u4E0B\u4E00\u9898");
		down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					down(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		down.setFont(new Font("宋体", Font.PLAIN, 16));
		down.setVisible(false);
		
		final JButton up_1 = new JButton("\u5F00\u59CB\u7B54\u9898");
		up.setVisible(false);
		up_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Begin(e);
				up.setVisible(true);
				down.setVisible(true);
				up_1.setVisible(false);
			}
		});
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
					.addGap(18)
					.addGroup(gl_Main.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Main.createParallelGroup(Alignment.BASELINE)
							.addComponent(down, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(up, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(up_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		
		Topictxt = new JLabel("");
		Topictxt.setFont(new Font("宋体", Font.PLAIN, 18));
		scrollPane_1.setViewportView(Topictxt);
		Main.setLayout(gl_Main);
		
		JPanel AnswerCard = new JPanel();
		AnswerCard.setBounds(836, 36, 299, 263);
		frame.getContentPane().add(AnswerCard);
		AnswerCard.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		AnswerCard.add(scrollPane);
		
		JLabel Name = new JLabel();
		Name.setBounds(847, 387, 299, 66);
		frame.getContentPane().add(Name);
		
		
		JButton submit = new JButton("");
		submit.setBounds(847, 550, 299, 54);
		frame.getContentPane().add(submit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(847, 474, 299, 66);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	//上一题键
	private void up(ActionEvent e) {
		Index -=1;
		if (totalScore[Index] == 1000) {
			Aoption.doClick();
		}
	}
	
	//下一题键
	private void down(ActionEvent e) throws Exception {
		totalScore [Index] = result;
		result = 0;
		Index += 1;
		this.showInformation(topic);
	}


	//开始答题键
	private void Begin(ActionEvent e) {
		try {
			this.showInformation(topic);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(topic.size());
			JOptionPane.showMessageDialog(null, "错误");
			SetTopic.main(null);
			this.frame.dispose();
		}
		
	}

	
	
	private void showInformation(ArrayList<Topic> topic2) throws Exception {
		this.Topictxt.setText(topic2.get(Index).getTopic());
		this.Aoption.setText(topic2.get(Index).getOption_A());
		this.Boption.setText(topic2.get(Index).getOption_B());
		this.Coption.setText(topic2.get(Index).getOption_C());
		this.Doption.setText(topic2.get(Index).getOption_D());
	}
	/**
	 * 获得随机的Topic集合
	 * @param Type
	 * @param Count
	 * @return 
	 * @return
	 * @throws Exception
	 */
	public void getInformation() throws Exception{
		setScore(Integer.parseInt(SetTopic.TopicScore.getText()));
		setCount(Integer.parseInt(SetTopic.TopicCount.getText()));
		setType(SetTopic.comboBox.getSelectedIndex());
		
		System.out.println(type);
		System.out.println(count);
		conn = util2.getCon();
		this.topic = topic_util.getRandomTopic(conn, 1, topic_util.getDateTopic(type).size(), count);

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

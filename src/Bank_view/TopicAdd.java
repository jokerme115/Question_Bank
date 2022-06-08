package Bank_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class TopicAdd {

	private JFrame frame;
	private JTextField textTopic;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtD;
	private JTextField textCorrectOption;
	
	
	private int value = 1;
	private Topic topic = new Topic();
	private jdbc_util util = new jdbc_util();
	private JLabel lblNewLabel;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopicAdd window = new TopicAdd();
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
	public TopicAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u9898\u76EE\u6DFB\u52A0");
		frame.setBounds(100, 100, 592, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{75, 0, 327, 225, 0};
		gridBagLayout.rowHeights = new int[]{60, 0, 60, 35, 21, 70, 47, 0, 21, 21, 23, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		GridBagConstraints gbc_rdbtnmntmNewRadioItem = new GridBagConstraints();
		gbc_rdbtnmntmNewRadioItem.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnmntmNewRadioItem.gridx = 0;
		gbc_rdbtnmntmNewRadioItem.gridy = 0;
		frame.getContentPane().add(rdbtnmntmNewRadioItem, gbc_rdbtnmntmNewRadioItem);
		
		textTopic = new JTextField();
		textTopic.setColumns(10);
		GridBagConstraints gbc_textTopic = new GridBagConstraints();
		gbc_textTopic.gridheight = 5;
		gbc_textTopic.gridwidth = 2;
		gbc_textTopic.fill = GridBagConstraints.BOTH;
		gbc_textTopic.insets = new Insets(0, 0, 5, 5);
		gbc_textTopic.gridx = 1;
		gbc_textTopic.gridy = 1;
		frame.getContentPane().add(textTopic, gbc_textTopic);
		
		txtA = new JTextField();
		txtA.setColumns(10);
		GridBagConstraints gbc_txtA = new GridBagConstraints();
		gbc_txtA.fill = GridBagConstraints.BOTH;
		gbc_txtA.insets = new Insets(0, 0, 5, 5);
		gbc_txtA.gridx = 2;
		gbc_txtA.gridy = 6;
		frame.getContentPane().add(txtA, gbc_txtA);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		GridBagConstraints gbc_txtB = new GridBagConstraints();
		gbc_txtB.anchor = GridBagConstraints.NORTH;
		gbc_txtB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtB.insets = new Insets(0, 0, 5, 5);
		gbc_txtB.gridx = 2;
		gbc_txtB.gridy = 7;
		frame.getContentPane().add(txtB, gbc_txtB);
		
		lblNewLabel = new JLabel("\u9009\u9879C");
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		GridBagConstraints gbc_txtC = new GridBagConstraints();
		gbc_txtC.anchor = GridBagConstraints.NORTH;
		gbc_txtC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtC.insets = new Insets(0, 0, 5, 5);
		gbc_txtC.gridx = 2;
		gbc_txtC.gridy = 8;
		frame.getContentPane().add(txtC, gbc_txtC);
		
		txtD = new JTextField();
		txtD.setColumns(10);
		GridBagConstraints gbc_txtD = new GridBagConstraints();
		gbc_txtD.anchor = GridBagConstraints.NORTH;
		gbc_txtD.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtD.insets = new Insets(0, 0, 5, 5);
		gbc_txtD.gridx = 2;
		gbc_txtD.gridy = 9;
		frame.getContentPane().add(txtD, gbc_txtD);
		
		textCorrectOption = new JTextField();
		textCorrectOption.setColumns(10);
		GridBagConstraints gbc_textCorrectOption = new GridBagConstraints();
		gbc_textCorrectOption.anchor = GridBagConstraints.NORTH;
		gbc_textCorrectOption.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCorrectOption.insets = new Insets(0, 0, 5, 5);
		gbc_textCorrectOption.gridx = 2;
		gbc_textCorrectOption.gridy = 10;
		frame.getContentPane().add(textCorrectOption, gbc_textCorrectOption);
		
		JButton Add = new JButton("1");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					submit(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		rdbtnNewRadioButton = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 11;
		frame.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		GridBagConstraints gbc_Add = new GridBagConstraints();
		gbc_Add.anchor = GridBagConstraints.SOUTH;
		gbc_Add.insets = new Insets(0, 0, 5, 5);
		gbc_Add.gridx = 2;
		gbc_Add.gridy = 12;
		frame.getContentPane().add(Add, gbc_Add);
		
		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton_1);
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 13;
		frame.getContentPane().add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
	}

	private void submit(ActionEvent e) throws Exception {
		topic.setTopic(textTopic.getText());
		topic.setOption_A(txtA.getText());
		topic.setOption_B(txtB.getText());
		topic.setOption_C(txtC.getText());
		topic.setOption_D(txtD.getText());
		topic.setCorrect_Option(textCorrectOption.getText());
		topic.setType(value);
		
		Connection conn = null;
		conn = util.getCon();
		
		TopicDao topicdao = new TopicDao();
		
		if (topicdao.storeTopic(conn, topic)) {
			JOptionPane.showMessageDialog(null, "添加成功");
		}else{
			JOptionPane.showMessageDialog(null, "添加失败");
		}
	}
}

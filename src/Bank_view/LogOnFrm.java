package Bank_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import Bank_Dao.UserDao;
import Bank_model.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import Bank_util.String_util;
import Bank_util.jdbc_util;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LogOnFrm {

	private JFrame frame;
	private JTextField LoginUserName;
	private JPasswordField LoginPassWord;
	private jdbc_util util = new jdbc_util();
	private UserDao userdao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm window = new LogOnFrm();
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
	public LogOnFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("新宋体", Font.PLAIN, 14));
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LogOnFrm.class.getResource("/images/8666783_book_education_icon.png")));
		frame.setTitle("\u9898\u5E93\u7BA1\u7406\u7CFB\u7EDF1.0");
		frame.setBounds(100, 100, 809, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\u9898\u5E93\u7BA1\u7406\u7CFB\u7EDF\r\n");
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/8666691_home_icon.png")));
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(30f));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/8666609_user_icon.png")));
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801:");
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/3401822_essential_key_web_icon.png")));
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 21));
		
		LoginUserName = new JTextField();
		LoginUserName.setFont(new Font("幼圆", Font.PLAIN, 18));
		LoginUserName.setColumns(10);
		
		LoginPassWord = new JPasswordField();
		LoginPassWord.setEchoChar('*');
		LoginPassWord.setFont(new Font("幼圆", Font.PLAIN, 18));
		LoginPassWord.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/8666656_check_circle_icon.png")));
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/8666729_rotate_cw_icon.png")));
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(272, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addGap(261))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(LoginPassWord, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
								.addComponent(LoginUserName, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(232)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(95)
							.addComponent(btnNewButton_1)))
					.addGap(218))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(LoginUserName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoginPassWord, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(72))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	
	/**
	 * 登录button 事件
	 */
	protected void logActionPerformed(ActionEvent event) {
		String userName = this.LoginUserName.getText();
		String passWord = new String(this.LoginPassWord.getPassword());
		
		//使用String_util工具类判断是否 
		if (String_util.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (String_util.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user = new User(userName, passWord);
		
		Connection conn = null;
		
		try {
			conn = util.getCon();
			User currentUser = userdao.login(conn, user);
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "登录成功");;
			}else {
				JOptionPane.showMessageDialog(null, "账号或者密码错误");
				resetValueActionPerformed(event);
			}
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			
		}
	}

	/**
	 * 重置button 事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent event) {
		this.LoginUserName.setText("");
		this.LoginPassWord.setText("");
		
	}
}

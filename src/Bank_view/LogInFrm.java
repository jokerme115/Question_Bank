package Bank_view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;

import Bank_model.User;
import Bank_util.String_util;
import Bank_util.jdbc_util;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;

import Bank_Dao.GradesDao;
import Bank_Dao.UserDao;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

/**
 * 注册界面
 * @author Li ChenYang
 *
 */
public class LogInFrm {

	private JFrame FrmLogOn;
	private JTable table;
	private JTextField textUserName;
	private JTextField textNumber;
	private JTextField textE_Mail;
	private JPasswordField passwordField;
	//创建四件套 连接-对象-发送给sql
	jdbc_util util = new jdbc_util();
	Connection conn = null;
	UserDao userdao = new UserDao();
	User user = new User();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrm window = new LogInFrm();
					window.FrmLogOn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrmLogOn = new JFrame();
		FrmLogOn.setResizable(false);
		FrmLogOn.setBackground(Color.WHITE);
		FrmLogOn.setFont(new Font("Dialog", Font.BOLD, 18));
		FrmLogOn.getContentPane().setForeground(Color.MAGENTA);
		FrmLogOn.setTitle("\u6CE8\u518C\u754C\u9762");
		FrmLogOn.setBounds(100, 100, 991, 656);
		FrmLogOn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrmLogOn.getContentPane().setLayout(null);
		
		JButton Return = new JButton("\u8FD4\u56DE");
		Return.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/9041755_jump_left_icon.png")));
		Return.setFont(new Font("宋体", Font.PLAIN, 21));
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Order = JOptionPane.showConfirmDialog(null, "是否关闭窗口");
				if(Order == 0) {
					ReturnToLogin(e);
				}
			}
		});
		Return.setBounds(85, 541, 187, 47);
		FrmLogOn.getContentPane().add(Return);
		
		JButton Reset = new JButton("\u91CD\u7F6E");
		Reset.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/8111405_reset_reload_refresh_sync_arrow_icon.png")));
		Reset.setFont(new Font("宋体", Font.PLAIN, 21));
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		Reset.setBounds(385, 541, 170, 47);
		FrmLogOn.getContentPane().add(Reset);
		
		JButton Submit = new JButton("\u6CE8\u518C\u63D0\u4EA4");
		Submit.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/9025753_hand_waving_icon (1).png")));
		Submit.setFont(new Font("宋体", Font.PLAIN, 21));
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					submitPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Submit.setBounds(683, 541, 187, 47);
		FrmLogOn.getContentPane().add(Submit);
		
		table = new JTable();
		table.setBounds(0, 108, 0, 0);
		FrmLogOn.getContentPane().add(table);
		
		FrmLogOn.getContentPane();
		
		textUserName = new JTextField();
		textUserName.setFont(new Font("宋体", Font.PLAIN, 18));
		textUserName.setBounds(335, 164, 377, 40);
		FrmLogOn.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		textNumber = new JTextField();
		textNumber.setFont(new Font("宋体", Font.PLAIN, 18));
		textNumber.setColumns(10);
		textNumber.setBounds(335, 345, 377, 40);
		FrmLogOn.getContentPane().add(textNumber);
		
		textE_Mail = new JTextField();
		textE_Mail.setFont(new Font("宋体", Font.PLAIN, 18));
		textE_Mail.setColumns(10);
		textE_Mail.setBounds(335, 438, 377, 40);
		FrmLogOn.getContentPane().add(textE_Mail);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 18));
		passwordField.setBounds(335, 252, 377, 40);
		FrmLogOn.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Password :");
		lblNewLabel.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/2931164_clef_key_lock_unlock_password_icon.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 31));
		lblNewLabel.setBounds(93, 233, 212, 66);
		FrmLogOn.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/8666609_user_icon.png")));
		lblUsername.setFont(new Font("宋体", Font.PLAIN, 31));
		lblUsername.setBounds(81, 145, 212, 66);
		FrmLogOn.getContentPane().add(lblUsername);
		
		JLabel lblPhonenumber = new JLabel("Number   :");
		lblPhonenumber.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/172517_phone_icon.png")));
		lblPhonenumber.setFont(new Font("宋体", Font.PLAIN, 31));
		lblPhonenumber.setBounds(93, 319, 212, 80);
		FrmLogOn.getContentPane().add(lblPhonenumber);
		
		JLabel lblemail = new JLabel("E-Mail   :");
		lblemail.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/8666664_at_sign_icon.png")));
		lblemail.setFont(new Font("宋体", Font.PLAIN, 31));
		lblemail.setBounds(93, 412, 212, 80);
		FrmLogOn.getContentPane().add(lblemail);
		
		JLabel lblNewLabel_1 = new JLabel("\uFF08\u8981\u6C42\u5927\u4E8E6\u7B49\u4E8E\u516D\u4F4D\u6570\uFF09");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(739, 248, 199, 40);
		FrmLogOn.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u9898\u5E93\u7F51\u6CE8\u518C\u7CFB\u7EDF");
		lblNewLabel_2.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/8666783_book_education_icon.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 33));
		lblNewLabel_2.setBounds(289, 51, 304, 73);
		FrmLogOn.getContentPane().add(lblNewLabel_2);
	}

	private void submitPerformed(ActionEvent event) throws Exception {
		//ID自动分配
				String userName = this.textUserName.getText();
				String userPassword = new String(this.passwordField.getPassword());
				int status = 1;
				String Telephone = this.textNumber.getText();
				
				FrmLogOn.setAlwaysOnTop(false);
				if (String_util.isEmpty(userName)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
				}else if (String_util.isEmpty(userPassword))
				{
					JOptionPane.showMessageDialog(null, "密码不能为空");
				}else if (userPassword.trim().length() < 6) 
				{
					JOptionPane.showMessageDialog(null, "密码不能少于6个字符");
				}else if (String_util.isEmpty(Telephone))
				{
					JOptionPane.showMessageDialog(null, "电话号码不能为空");
				}else {
					conn = util.getCon();
					
					user.setUserName(userName);
					user.setTelephone(Telephone);
					user.setStatus(status);
					user.setUserPassword(userPassword);
					
					
					boolean a = userdao.SignIn(conn, user);
					if (a) {
						JOptionPane.showMessageDialog(null, "注册成功");
						GradesDao.addUserGrades(conn, user);
						FrmLogOn.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "注册失败");
					}
				}

				
		
	}

	private void ReturnToLogin(ActionEvent event) {
		FrmLogOn.dispose();
		LogOnFrm.main(null);
	}
	
	
	private void resetValueActionPerformed(ActionEvent event) {
		this.textUserName.setText("");
		this.textNumber.setText("");
		this.textE_Mail.setText("");
		this.passwordField.setText("");
		
	}
	
	
}


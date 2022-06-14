package Bank_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

public class mainf {

<<<<<<< Updated upstream
	private JFrame frame;
	private JDesktopPane table = null;
=======
	static JFrame frame;
	static JDesktopPane table = null;
	jdbc_util util = new jdbc_util();
	Connection conn = null;
	TopicDao topicdao = new TopicDao();
	static String[][] str= null;
	
	
>>>>>>> Stashed changes
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainf window = new mainf();
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
	public mainf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7B54\u9898\u754C\u9762");
		frame.setBounds(100, 100, 556, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237");
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4FEE\u6539");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify modify = new modify();
				modify.setVisible(true);
				table.add(modify);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9898\u76EE");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					str = showAllTopic();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				function function = new function();
				function.setVisible(true);
				table.add(function);
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem Start = new JMenuItem("\u5F00\u59CB\u8003\u8BD5");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				begin(e);
			}
		});
		menuBar.add(Start);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void begin(ActionEvent e) {
		SetTopic.main(null);
	}

<<<<<<< Updated upstream
	private void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub
		
=======
	private String[][] showAllTopic() throws Exception {
		conn = util.getCon();
		ArrayList<Topic> list = null;

		list = TopicDao.selectAllTopic(conn);
		String[][] Data = (String[] []) list.toArray(new String[7][]);
		return Data;
	}
	private void setExtendedState(int maximizedBoth) throws Exception {

>>>>>>> Stashed changes
	}
}

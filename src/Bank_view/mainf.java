package Bank_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class mainf {

	static JFrame frame;
	static JDesktopPane table = null;
	
	
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainf.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @wbp.parser.entryPoint
	 */
	public mainf() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
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

	private void setExtendedState(int maximizedBoth) throws Exception {

	}
}

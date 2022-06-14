package Bank_view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class function extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTextField Id;
	public static int id = 0;
	jdbc_util util = new jdbc_util();
	Connection conn = null;
	TopicDao topicdao = new TopicDao();
	Topic topic = new Topic();
	private JTable table;


	
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					function frame = new function();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public function() {
		setIconifiable(true);
		setClosable(true);
		setTitle("管理");
		setBounds(100, 100, 450, 418);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("增加");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					add(e);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "是否删除") == 0) {
					try {
						DeleteTopic(e);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						if (Id.getText() != "") {
							id = Integer.parseInt(Id.getText());
						}else {
							JOptionPane.showMessageDialog(null, "请输入ID");
						}
						function_modify function_modify = new function_modify();
						function_modify.setVisible(true);
						mainf.table.add(function_modify);
						function.this.setVisible(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					


			}
		});
		
		JLabel lblNewLabel = new JLabel("id:");
		
		Id = new JTextField();
		Id.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(58, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(button)
							.addGap(27)))
					.addGap(51))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(57, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(47))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}

	private void add(ActionEvent e) throws Exception {
		function_modify2 function_modify2 = new function_modify2();
		function_modify2.setVisible(true);
		mainf.table.add(function_modify2);
		this.dispose();
		
	}

	private void DeleteTopic(ActionEvent e) throws Exception {
		int ID=Integer.parseInt(Id.getText());
		topic.setID(ID);
		conn = util.getCon();
		
		boolean a = topicdao.deleteTopic(conn, topic);
		if (a) {
			JOptionPane.showMessageDialog(null, "删除成功");
		}else {
			JOptionPane.showMessageDialog(null, "删除失败");
		}
	}
}

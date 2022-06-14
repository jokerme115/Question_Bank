package Bank_view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
<<<<<<< Updated upstream
=======
import javax.swing.table.DefaultTableModel;

import Bank_Dao.TopicDao;
import Bank_model.Topic;
import Bank_util.jdbc_util;

>>>>>>> Stashed changes
import javax.swing.JLabel;
import javax.swing.JTextField;


public class function extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< Updated upstream
	private JTextField textField;
=======
	private  JTextField Id;
	public static int id = 0;
	jdbc_util util = new jdbc_util();
	Connection conn = null;
	TopicDao topicdao = new TopicDao();
	Topic topic = new Topic();
	private JTable allTopic;


>>>>>>> Stashed changes

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JButton btnNewButton_1 = new JButton("删除");
		
		JButton button = new JButton("修改");
		
		JLabel lblNewLabel = new JLabel("id:");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(58, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(47))
		);
<<<<<<< Updated upstream
		getContentPane().setLayout(groupLayout);

	}
=======
		

		allTopic = new JTable();
		allTopic.setModel(new DefaultTableModel(
			mainf.str,
			new String[] {
				"\u7F16\u53F7", "\u9898\u76EE\u7C7B\u578B (1\u4E3A\u5355\u9009 2\u4E3A\u591A\u9009)", "\u9898\u76EE", "\u9009\u9879A", "\u9009\u9879B", "\u9009\u9879C", "\u9009\u9879D"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(allTopic);

		getContentPane().setLayout(groupLayout);

	}

	private void add(ActionEvent e) throws Exception {
		try {
			function_modify2 function_modify2 = new function_modify2();
			function_modify2.setVisible(true);
			mainf.table.add(function_modify2);
			this.dispose();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
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

>>>>>>> Stashed changes
}

package Bank_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class AnswerFrm {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JPanel AnswerCard = new JPanel();
		AnswerCard.setBounds(847, 32, 299, 263);
		frame.getContentPane().add(AnswerCard);
		AnswerCard.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		AnswerCard.add(scrollPane);
		
		JLabel Name = new JLabel("New label");
		Name.setBounds(847, 387, 299, 66);
		frame.getContentPane().add(Name);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(847, 574, 299, 54);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(847, 474, 299, 66);
		frame.getContentPane().add(lblNewLabel_1);
	}


	
}

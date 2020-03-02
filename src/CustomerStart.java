import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class CustomerStart extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerStart frame = new CustomerStart();
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
	public CustomerStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 767);
		contentPane = new JPanel();
		contentPane.setLocation(0, -530);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1176, 471);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(0, 530, 1186, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel login_label = new JLabel("LOGIN");
		login_label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		login_label.setHorizontalAlignment(SwingConstants.CENTER);
		login_label.setBounds(834, 23, 38, 17);
		panel_1.add(login_label);
		
		JLabel id_label = new JLabel("\uD68C\uC6D0 \uC544\uC774\uB514 :");
		id_label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_label.setBounds(721, 60, 71, 17);
		panel_1.add(id_label);
		
		JLabel pw_label = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		pw_label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pw_label.setHorizontalAlignment(SwingConstants.CENTER);
		pw_label.setBounds(737, 99, 55, 17);
		panel_1.add(pw_label);
		
		JTextField id_txt = new JTextField();
		id_txt.setBounds(804, 59, 116, 21);
		panel_1.add(id_txt);
		id_txt.setColumns(10);
		
		JPasswordField pw_txt = new JPasswordField();
		pw_txt.setBounds(804, 98, 116, 21);
		panel_1.add(pw_txt);
		
		JButton login_btn = new JButton("\uB85C\uADF8\uC778");
		login_btn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		login_btn.setBackground(Color.WHITE);
		login_btn.setBounds(943, 56, 90, 60);
		panel_1.add(login_btn);
		
		JButton search_idpw = new JButton("ID/PW \uCC3E\uAE30");
		search_idpw.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		search_idpw.setBackground(Color.WHITE);
		search_idpw.setBounds(759, 129, 97, 25);
		panel_1.add(search_idpw);
		
		JButton join_btn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		join_btn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		join_btn.setBackground(Color.WHITE);
		join_btn.setBounds(889, 129, 81, 25);
		panel_1.add(join_btn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\hellow.jpeg"));
		
		lblNewLabel.setBounds(100, 28, 500, 153);
		panel_1.add(lblNewLabel);
		
	
	}
}

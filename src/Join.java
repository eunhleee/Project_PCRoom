import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField id;
	private JPasswordField pass;
	private JTextField birth;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
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
	public Join() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lajoin = new JLabel("\uAC1C\uC778 \uC815\uBCF4 \uC785\uB825");
		lajoin.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lajoin.setHorizontalAlignment(SwingConstants.CENTER);
		lajoin.setBounds(12, 10, 350, 51);
		panel.add(lajoin);
		
		JLabel la1 = new JLabel("\uC774\uB984");
		la1.setHorizontalAlignment(SwingConstants.CENTER);
		la1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la1.setBounds(40, 90, 68, 37);
		panel.add(la1);
		
		JLabel la2 = new JLabel("\uC544\uC774\uB514");
		la2.setHorizontalAlignment(SwingConstants.CENTER);
		la2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la2.setBounds(40, 137, 68, 37);
		panel.add(la2);
		
		JLabel la3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		la3.setHorizontalAlignment(SwingConstants.CENTER);
		la3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la3.setBounds(40, 184, 68, 37);
		panel.add(la3);
		
		JLabel la4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		la4.setHorizontalAlignment(SwingConstants.CENTER);
		la4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la4.setBounds(40, 224, 68, 37);
		panel.add(la4);
		
		JLabel la5 = new JLabel("\uC804\uD654\uBC88\uD638");
		la5.setHorizontalAlignment(SwingConstants.CENTER);
		la5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la5.setBounds(40, 271, 68, 37);
		panel.add(la5);
		
		JLabel la6 = new JLabel("\uC8FC\uC18C");
		la6.setHorizontalAlignment(SwingConstants.CENTER);
		la6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la6.setBounds(40, 325, 68, 37);
		panel.add(la6);
		
		name = new JTextField();
		name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBounds(144, 95, 186, 27);
		panel.add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		id.setColumns(10);
		id.setBounds(144, 142, 186, 27);
		panel.add(id);
		
		pass = new JPasswordField();
		pass.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pass.setColumns(10);
		pass.setBounds(144, 189, 186, 27);
		panel.add(pass);
		
		birth = new JTextField();
		birth.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		birth.setColumns(10);
		birth.setBounds(144, 236, 186, 27);
		panel.add(birth);
		
		phone = new JTextField();
		phone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		phone.setColumns(10);
		phone.setBounds(144, 283, 186, 27);
		panel.add(phone);
		
		JTextArea address = new JTextArea();
		address.setBorder(new LineBorder(Color.GRAY));
		address.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		address.setBounds(144, 325, 186, 51);
		panel.add(address);
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String idTxt = id.getText();
				String passTxt = pass.getText();
				String addressTxt = address.getText();
				if(nameTxt.equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하여 주십시오.");
					return;
				} if(idTxt.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하여 주십시오.");
					return;
				} if(passTxt.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하여 주십시오..");
					return;
				} if(birth.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "생년월일을 입력하여 주십시오..");
					return;
				} if(phone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력하여 주십시오..");
					return;
				} if(addressTxt.equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 입력하여 주십시오.");
					return;
				}
				JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!");
				dispose();
				int birthTxt =Integer.parseInt(birth.getText());
				int phoneTxt = Integer.parseInt(phone.getText());
				try {
				DB.insertMember(idTxt,nameTxt,passTxt,birthTxt,phoneTxt,addressTxt);
				dispose();
				}catch(NumberFormatException e1) {
					 JOptionPane.showMessageDialog(null, "숫자만 입력하세요!");
				}
			}
		});
//		JScrollPane scrollpane = new JScrollPane(address,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		address.add(scrollpane);
		
		JButton btnNewButton1 = new JButton("회원가입");
		btnNewButton1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton1.setBackground(new Color(255, 222, 173));
		btnNewButton1.setBorder(null);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String idTxt = id.getText();
				String passTxt = pass.getText();
				int birthTxt =Integer.parseInt( birth.getText());
				int phoneTxt = Integer.parseInt(phone.getText());
				String addressTxt = address.getText();
				if(name.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하여 주십시오.");
					return;
				} if(id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하여 주십시오.");
					return;
				} if(pass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하여 주십시오..");
					return;
				} if(birth.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "생년월일을 입력하여 주십시오..");
					return;
				} if(phone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력하여 주십시오..");
					return;
				} if(address.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 입력하여 주십시오.");
					return;
				}
				try {
				DB.insertMember(idTxt,nameTxt,passTxt,birthTxt,phoneTxt,addressTxt);
				dispose();
				}catch(NumberFormatException e1) {
					 JOptionPane.showMessageDialog(null, "숫자만 입력하세요!");
				}
			}
		});
		btnNewButton1.setBounds(40, 396, 135, 45);
		panel.add(btnNewButton1);
		
		JButton btnNewButton_1 = new JButton("\uB2EB\uAE30");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(211, 396, 135, 45);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNewLabel.setBounds(22, 68, 327, 318);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*\uC22B\uC790\uB9CC \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel_1.setFont(new Font("굴림", Font.ITALIC, 10));
		lblNewLabel_1.setBounds(50, 258, 95, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("*\uC22B\uC790\uB9CC \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.ITALIC, 10));
		lblNewLabel_1_1.setBounds(50, 300, 95, 15);
		panel.add(lblNewLabel_1_1);
	}
}
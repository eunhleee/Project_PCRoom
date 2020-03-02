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
		setTitle("ȸ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lajoin = new JLabel("\uD68C\uC6D0\uAC00\uC785 \uD398\uC774\uC9C0");
		lajoin.setFont(new Font("���� ���", Font.BOLD, 20));
		lajoin.setHorizontalAlignment(SwingConstants.CENTER);
		lajoin.setBounds(12, 10, 350, 51);
		panel.add(lajoin);
		
		JLabel la1 = new JLabel("\uC774\uB984");
		la1.setFont(new Font("���� ���", Font.PLAIN, 15));
		la1.setBounds(40, 74, 68, 37);
		panel.add(la1);
		
		JLabel la2 = new JLabel("\uC544\uC774\uB514");
		la2.setFont(new Font("���� ���", Font.PLAIN, 15));
		la2.setBounds(40, 121, 68, 37);
		panel.add(la2);
		
		JLabel la3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		la3.setFont(new Font("���� ���", Font.PLAIN, 15));
		la3.setBounds(40, 168, 68, 37);
		panel.add(la3);
		
		JLabel la4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		la4.setFont(new Font("���� ���", Font.PLAIN, 15));
		la4.setBounds(40, 215, 68, 37);
		panel.add(la4);
		
		JLabel la5 = new JLabel("\uC804\uD654\uBC88\uD638");
		la5.setFont(new Font("���� ���", Font.PLAIN, 15));
		la5.setBounds(40, 262, 68, 37);
		panel.add(la5);
		
		JLabel la6 = new JLabel("\uC8FC\uC18C");
		la6.setFont(new Font("���� ���", Font.PLAIN, 15));
		la6.setBounds(40, 309, 68, 37);
		panel.add(la6);
		
		name = new JTextField();
		name.setFont(new Font("���� ���", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBounds(120, 76, 135, 37);
		panel.add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setFont(new Font("���� ���", Font.PLAIN, 15));
		id.setColumns(10);
		id.setBounds(120, 123, 135, 37);
		panel.add(id);
		
		pass = new JPasswordField();
		pass.setFont(new Font("���� ���", Font.PLAIN, 15));
		pass.setColumns(10);
		pass.setBounds(120, 170, 135, 37);
		panel.add(pass);
		
		birth = new JTextField();
		birth.setFont(new Font("���� ���", Font.PLAIN, 15));
		birth.setColumns(10);
		birth.setBounds(120, 217, 135, 37);
		panel.add(birth);
		
		phone = new JTextField();
		phone.setFont(new Font("���� ���", Font.PLAIN, 15));
		phone.setColumns(10);
		phone.setBounds(120, 264, 135, 37);
		panel.add(phone);
		
		JTextArea address = new JTextArea();
		address.setBorder(new LineBorder(Color.GRAY));
		address.setFont(new Font("���� ���", Font.PLAIN, 15));
		address.setBounds(120, 318, 135, 68);
		panel.add(address);
//		JScrollPane scrollpane = new JScrollPane(address,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		address.add(scrollpane);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String idTxt = id.getText();
				String passTxt = pass.getText();
				int birthTxt =Integer.parseInt( birth.getText());
				int phoneTxt = Integer.parseInt(phone.getText());
				String addressTxt = address.getText();
				if(name.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է��Ͽ� �ֽʽÿ�.");
					return;
				} if(id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��Ͽ� �ֽʽÿ�.");
					return;
				} if(pass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��Ͽ� �ֽʽÿ�..");
					return;
				} if(birth.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��������� �Է��Ͽ� �ֽʽÿ�..");
					return;
				} if(phone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� �Է��Ͽ� �ֽʽÿ�..");
					return;
				} if(address.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�ּҸ� �Է��Ͽ� �ֽʽÿ�.");
					return;
				}
				try {
				DB.insertMember(idTxt,nameTxt,passTxt,birthTxt,phoneTxt,addressTxt);
				dispose();
				}catch(NumberFormatException e1) {
					 JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���!");
				}
			}
		});
		btnNewButton.setBounds(40, 396, 135, 45);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB2EB\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(211, 396, 135, 45);
		panel.add(btnNewButton_1);
	}
}
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FoodFrame_1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private int sum=0;
	private JLabel la_total;
	private DefaultTableModel model;
	private int row;
	private JTextField txt_seat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodFrame_1 frame = new FoodFrame_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Add(String name,int num,int price,int pId) {
		String[] food= {name,num+"",price+""};
		sum+=4000;
		la_total.setText("���� : "+sum);
		model.addRow(food);
		//db�� ����
	}

	/**
	 * Create the frame.
	 */

	
	public FoodFrame_1() {
		setTitle("\uC74C\uC2DD \uC8FC\uBB38");
		
		setBounds(100, 100, 1013, 671);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(-117, 433, 1102, 187);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton btn_num = new JButton("-");
		
		btn_num.setBounds(883, 26, 39, 23);
		panel_1.add(btn_num);
		
		la_total = new JLabel("���� : "+sum);
		la_total.setHorizontalAlignment(SwingConstants.CENTER);
		la_total.setBounds(899, 46, 191, 15);
		panel_1.add(la_total);
		
		JButton btn_payment = new JButton("\uACB0\uC81C");
		btn_payment.setBorder(null);
		btn_payment.setBackground(Color.ORANGE);
		
		btn_payment.setFont(new Font("���� ���", Font.BOLD, 18));
		btn_payment.setBounds(899, 106, 191, 45);
		panel_1.add(btn_payment);
		
		JLabel lblNewLabel = new JLabel("\uC88C\uC11D\uBC88\uD638 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(909, 74, 75, 15);
		panel_1.add(lblNewLabel);
		
		txt_seat = new JTextField(MainFrame.seat+"");
		txt_seat.setEnabled(false);
		txt_seat.setHorizontalAlignment(SwingConstants.CENTER);
		txt_seat.setBounds(996, 71, 86, 21);
		panel_1.add(txt_seat);
		txt_seat.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(158, 20, 716, 157);
		panel_1.add(scrollPane);
		
		String[][] data = {  };
		String[]  headers = { "�ֹ� ����" , "����", "����"}; 
		 model = new DefaultTableModel(data, headers);
		
		JTable table_2 = new JTable(model);
		table_2.setBackground(Color.WHITE);
		scrollPane.setViewportView(table_2);
		
		table_2.setFont(new Font("���� ���", Font.PLAIN, 18));
		table_2.setRowHeight(30);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 row= table_2.rowAtPoint(e.getPoint());
				
			}
		});
		
		btn_payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "�ֹ� �Ϸ� �Ǿ����ϴ�",null, JOptionPane.WARNING_MESSAGE);
				for(int i=0;i<table_2.getRowCount();i++){
					DB.insertOrder(MainFrame.seat, table_2.getValueAt(i, 0).toString(), table_2.getValueAt(i, 1).toString(),Integer.parseInt(table_2.getValueAt(i,2).toString()),"�̿Ϸ�");
				}
				model.setNumRows(0);
			}
		});
		btn_num.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(row>=0) {
					//JOptionPane.showMessageDialog(null, row+","+col);
					sum-=Integer.parseInt(table_2.getValueAt(row,2).toString());
					((DefaultTableModel) table_2.getModel()).removeRow(row);
					la_total.setText("���� : "+sum);
				}
				}
				catch(ArrayIndexOutOfBoundsException e1) {
					 JOptionPane.showMessageDialog(null, "������ ��ǰ�� �����ϴ�", "���", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JPanel ricePanel = new JPanel();
		ricePanel.setBackground(Color.WHITE);
		ricePanel.setBounds(0, 23, 997, 400);
		ricePanel.setLayout(null);
		
		JButton btn_rice1 = new JButton("\uC74C\uC2DD1");
		btn_rice1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_rice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="Ȳ���ᳪ�����屹��";
				int price=4000;
				Add(name,1,price,1);
			}
		});
		btn_rice1.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\rice1.jpg"));
		btn_rice1.setBounds(12, 0, 218, 160);
		ricePanel.add(btn_rice1);
		
		JPanel drinkPanel = new JPanel();
		drinkPanel.setBackground(Color.WHITE);
		drinkPanel.setBounds(131, -165, 836, 245);
		//contentPane.add(drinkPanel);
		drinkPanel.setLayout(null);
		JButton btn_drink1 = new JButton("");
		btn_drink1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_drink1.setBackground(Color.WHITE);
		btn_drink1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="����";
				int price=2000;
				Add(name,1,price,8);
			}
		});
		btn_drink1.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\drink.jpeg"));
		btn_drink1.setBounds(12, 22, 212, 300);
		drinkPanel.add(btn_drink1);
		
		JButton btn_drink2 = new JButton("\uC74C\uB8CC2");
		btn_drink2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_drink2.setBackground(Color.WHITE);
		btn_drink2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="�ƾ�";
				int price=3000;
				Add(name,1,price,9);
			}
		});
		btn_drink2.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\drink1.jpeg"));
		btn_drink2.setBounds(236, 22, 192, 300);
		drinkPanel.add(btn_drink2);
		
		JButton btn_drink3 = new JButton("\uC74C\uB8CC3");
		btn_drink3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_drink3.setBackground(Color.WHITE);
		btn_drink3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="���̵�";
				int price=3000;
				Add(name,1,price,10);
			}
		});
		btn_drink3.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\drink2.jpeg"));
		btn_drink3.setBounds(440, 22, 192, 300);
		drinkPanel.add(btn_drink3);
		
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(12, 10, 973, 413);
		contentPane.add(tabbedPane);
		tabbedPane.add(ricePanel,"������");
		
		JButton btn_rice2 = new JButton("\uC74C\uC2DD1");
		btn_rice2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_rice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="���Ѽ���̿�����";
				int price=4000;
				Add(name,1,price,2);
			}
		});
		btn_rice2.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\rice6.jpg"));
		btn_rice2.setBounds(260, 0, 218, 160);
		ricePanel.add(btn_rice2);
		
		JButton btn_rice3 = new JButton("\uC74C\uC2DD1");
		btn_rice3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_rice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="��巹����������";
				int price=4000;
				Add(name,1,price,3);
			}
		});
		btn_rice3.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\rice3.jpg"));
		btn_rice3.setBounds(499, 0, 218, 160);
		ricePanel.add(btn_rice3);
		
		JButton btn_rice4 = new JButton("\uC74C\uC2DD1");
		btn_rice4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_rice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="����ļ���������";
				int price=4000;
				Add(name,1,price,4);
			}
		});
		btn_rice4.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\rice4.jpg"));
		btn_rice4.setBounds(750, 0, 218, 160);
		ricePanel.add(btn_rice4);
		
		JButton btn_rice5 = new JButton("\uC74C\uC2DD1");
		btn_rice5.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_rice5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="��������������";
				int price=4000;
				Add(name,1,price,5);
			}
		});
		btn_rice5.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\rice5.jpg"));
		btn_rice5.setBounds(12, 195, 218, 160);
		ricePanel.add(btn_rice5);
		
		JButton btn_rice6 = new JButton("\uC74C\uC2DD1");
		btn_rice6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_rice6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="���Ŀ¹�";
				int price=4000;
				Add(name,1,price,6);
			}
		});
		btn_rice6.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\rice2.jpg"));
		btn_rice6.setBounds(260, 195, 218, 160);
		ricePanel.add(btn_rice6);
		
		JLabel la_rice1 = new JLabel("4000\uC6D0");
		la_rice1.setBounds(80, 170, 57, 15);
		ricePanel.add(la_rice1);
		
		JButton btn_rice7 = new JButton("\uC74C\uC2DD1");
		btn_rice7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn_rice7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="�̱����ֲٹ̵���";
				int price=4000;
				Add(name,1,price,7);
			}
		});
		btn_rice7.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\rice7.jpg"));
		btn_rice7.setBounds(511, 195, 218, 160);
		ricePanel.add(btn_rice7);
		
		JLabel la_rice2 = new JLabel("4000\uC6D0");
		la_rice2.setHorizontalAlignment(SwingConstants.CENTER);
		la_rice2.setBounds(330, 170, 57, 15);
		ricePanel.add(la_rice2);
		
		JLabel la_rice3 = new JLabel("4000\uC6D0");
		la_rice3.setHorizontalAlignment(SwingConstants.CENTER);
		la_rice3.setBounds(580, 170, 57, 15);
		ricePanel.add(la_rice3);
		
		JLabel la_rice4 = new JLabel("4000\uC6D0");
		la_rice4.setHorizontalAlignment(SwingConstants.CENTER);
		la_rice4.setBounds(835, 170, 57, 15);
		ricePanel.add(la_rice4);
		
		JLabel la_rice5 = new JLabel("4000\uC6D0");
		la_rice5.setHorizontalAlignment(SwingConstants.CENTER);
		la_rice5.setBounds(80, 359, 57, 15);
		ricePanel.add(la_rice5);
		
		JLabel la_rice6 = new JLabel("4000\uC6D0");
		la_rice6.setHorizontalAlignment(SwingConstants.CENTER);
		la_rice6.setBounds(330, 359, 57, 15);
		ricePanel.add(la_rice6);
		
		JLabel la_rice7 = new JLabel("3000\uC6D0");
		la_rice7.setHorizontalAlignment(SwingConstants.CENTER);
		la_rice7.setBounds(580, 359, 57, 15);
		ricePanel.add(la_rice7);
		tabbedPane.add(drinkPanel,"�����");
		
		JLabel la_drink1 = new JLabel("\uB530\uC544 2000\uC6D0");
		la_drink1.setHorizontalAlignment(SwingConstants.CENTER);
		la_drink1.setBounds(41, 332, 141, 15);
		drinkPanel.add(la_drink1);
		
		JLabel la_drink2 = new JLabel("\uC544\uC544 2500\uC6D0");
		la_drink2.setHorizontalAlignment(SwingConstants.CENTER);
		la_drink2.setBounds(260, 332, 141, 15);
		drinkPanel.add(la_drink2);
		
		JLabel lblNewLabel_2 = new JLabel("\uC5D0\uC774\uB4DC 3000\uC6D0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(462, 332, 141, 15);
		drinkPanel.add(lblNewLabel_2);
		
	
	
	
	}
}

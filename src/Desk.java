import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;





public class Desk extends JFrame{
	
	private JPanel contentPane;
	public static int time_price;
	private Socket socket;
	private BufferedWriter bw;
	JTextArea textarea = new JTextArea();
	JTextField sendMsgTf = new JTextField();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desk frame = new Desk();
					
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
	
	public Desk() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		panel_1.setBounds(0, 0, 1067, 646);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(683, 30, 356, 165);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel la_timer = new JLabel("New label");
		la_timer.setForeground(Color.WHITE);
		la_timer.setFont(new Font("���� ���", Font.BOLD, 20));
		la_timer.setBounds(194, 41, 84, 29);
		panel.add(la_timer);
		TimerRunnable runnable = new TimerRunnable(la_timer);
		
		JLabel lblNewLabel = new JLabel("\uC0AC\uC6A9\uC2DC\uAC04 :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel.setBounds(75, 38, 105, 34);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\uC0AC\uC6A9\uC885\uB8CC");
		btnNewButton_1.setBackground(Color.WHITE);
		
		btnNewButton_1.setFont(new Font("���� ���", Font.BOLD, 20));
		btnNewButton_1.setBounds(179, 82, 152, 54);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel(MainFrame.seat+"");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(50, 21, 57, 15);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\uCC44\uD305");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame();

				textarea.setEditable(false);// ���⸦ ������ edit �� �� ���� ����

				JScrollPane scrollPane = new JScrollPane(textarea);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				// As needed �� �ʿ信���ؼ� ������ �������� ��ũ�� �ٰ� �����
				scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				// ���� ��ũ���� �ȸ����

				j.setSize(500, 700);
				j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				j.setVisible(true);
				j.setTitle("chatting");

				sendMsgTf.addKeyListener(new MsgSendListener());
				// �ؽ�Ʈ �ʵ忡 Ű �����ʸ� ���
				// �ؽ�Ʈ �ʵ带 ���Ѻ��� �ִٰ� Ư�� ��Ȳ�� ����
				// �̺�Ʈ �����ʿ� ���ǵ� ���� ����
				j.add(scrollPane, BorderLayout.CENTER);// �����ӿ� ���̱�
				// add(textarea,BorderLayout.CENTER);//�����ӿ� ���̱�
				j.add(sendMsgTf, BorderLayout.SOUTH);// �����ӿ� ���̱�
				try {
					// ���� ������ , ��Ʈ��ȣ -> ���� ���� -> ���� ��û
					Socket socket = new Socket("127.0.0.1", 7777);
					// ���� ��ü ����
					
					setSocket(socket);// ���ο��� ������ ����
					TcpClientReceiveThread th1 = new TcpClientReceiveThread(socket);
					// TcpClientReceiveThread�� ���� Ŭ������ ����Ǿ� �ֱ� ������
					// cf�� �����ؼ� socket�� �����Ѵ�
					new Thread(th1).start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				
			}
		});
		btnNewButton.setBounds(41, 102, 97, 23);
		panel.add(btnNewButton);
		Thread th=new Thread(runnable);
		setVisible(true);
		th.start();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				dispose();
			}
		});
		JButton btnorder = new JButton("\uC74C\uC2DD\uC8FC\uBB38");
		btnorder.setForeground(Color.WHITE);
		btnorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodFrame_1.main(null);
			}
		});
		btnorder.setBackground(new Color(216, 191, 216));
		btnorder.setFont(new Font("���� ���", Font.BOLD, 30));
		btnorder.setBounds(429, 30, 162, 47);
		panel_1.add(btnorder);
		
		JLabel la1 = new JLabel("");
		la1.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uAC8C\uC784.jpg"));
		la1.setBounds(35, 374, 220, 176);
		panel_1.add(la1);
		
		JLabel la2 = new JLabel("");
		la2.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uBA54\uC2E0\uC800.png"));
		la2.setBounds(279, 374, 220, 176);
		panel_1.add(la2);
		
		JLabel la3 = new JLabel("");
		la3.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uBB38\uC11C.jpg"));
		la3.setBounds(529, 374, 220, 176);
		panel_1.add(la3);
		
		JLabel la4 = new JLabel("");
		la4.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uC778\uD130\uB137.png"));
		la4.setBounds(797, 374, 220, 176);
		panel_1.add(la4);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC8C\uC784");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(59, 564, 162, 47);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBA54\uC2E0\uC800");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(294, 564, 162, 47);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uBB38\uC11C");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(552, 564, 162, 47);
		panel_1.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC778\uD130\uB137");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(822, 564, 162, 47);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		
		
		
		
	}
	  //���� ������ ���� ����
    //���� �����ӵ� ������ ������ ������ �Ǿ���
	class MsgSendListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {// Ű�� ���ȴٰ� ����������
			// ����Ű�� ���ȴٰ� �������� �ؽ�Ʈ �ʵ忡 �ִ� ������ �ؽ�Ʈ ���� ��Ÿ����
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {// ������ Ű���� ������ �ִ� �ڵ� ���� ��Ÿ����
				// VK_ENTER = ��� , ���� Ű�� ���� Ű���� �ǹ��Ѵ�
				String msg = sendMsgTf.getText();
				System.out.println(msg);
				textarea.append("[��]: " + msg + "\n");
				sendMsgTf.setText("");
				try {
					bw.write(msg + "\n");
					bw.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // �ѹ����� �����ٴ� ���� �˸��� ���ؼ� bufferedWriter�� "\n"�� ���δ�

			}

		}
	}

	// ���� Ŭ������ ���� ������ �ۼ�
	class TcpClientReceiveThread implements Runnable {
		private Socket socket;

		public TcpClientReceiveThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// �����κ��� ���� �޼����� �о
			// �ؽ�Ʈ ���� �߰��ϱ�
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					String msg = br.readLine();// �޼��� ���� �о����
					textarea.append("[����ũ]" + msg + "\n");
				}
			} catch (Exception e) {
				textarea.append("������ ����Ǿ����ϴ�.");
				// System.out.println("������ ����Ǿ����ϴ�.");
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();// �� �� ���� �ݱ�
					}
				} catch (Exception e2) {

				}
			}
		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
		try {
			OutputStream out = socket.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(out));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}



	class TimerRunnable implements Runnable{
		private JLabel timerlabel;
		
	
		public TimerRunnable(JLabel timerlabel) {
			this.timerlabel=timerlabel;
			
			
		}
	public void run() {
		
		int second=0;
		int minute=0;
		int hour=0;
		while(true) {
			if(second>59) {
				minute++;
				second=0;
			}
			if(minute>59) {
					hour++;
					minute=0;
			}
			
			timerlabel.setText(Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second));
			second++;
		
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				
				if(minute>=0  || second>=0)
					Desk.time_price+=1000;
				Desk.time_price += hour*1000;
				DB.insertOrder(MainFrame.seat,"null","0",Desk.time_price,"�̿Ϸ�");
				return ;
			}
		}
		}
	}

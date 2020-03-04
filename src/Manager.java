import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Manager {

	private JFrame Mainframe;
	private JTextField id;
	private JPasswordField pass;
	private JTable table = new JTable();
	private int row;
	private JScrollPane scrollPane = new JScrollPane();
	static JButton order;
	private JTextField Maid;
	private JTextField MaPass;
	private Thread th;
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
					Manager window = new Manager();
					window.Mainframe.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	/**
	 * Create the application.
	 */
	public Manager() {

		initialize();
		AddTable add = new AddTable(table, scrollPane);
		th = new Thread(add);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Mainframe = new JFrame();
		Mainframe.getContentPane().setBackground(Color.WHITE);
		Mainframe.setTitle("PC\uBC29");
		Mainframe.setResizable(false);
		Mainframe.setBounds(100, 100, 1192, 767);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.getContentPane().setLayout(null);

		// scrollPane.add(table);
		// Mainframe.add(scrollPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBounds(0, 0, 1200, 500);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 1200, 500);
		label.setIcon(new ImageIcon("C:\\자바학습\\Project _1\\image\\dd.jpg"));
		panel.add(label);
		Mainframe.getContentPane().add(panel);
		JPanel MSeatPanel = new JPanel();
		MSeatPanel.setBounds(0, 30, 1186, 461);
		MSeatPanel.setBackground(Color.WHITE);
		Mainframe.getContentPane().add(MSeatPanel);
		MSeatPanel.setLayout(new GridLayout(4, 4, 30, 30));
		MSeatPanel.setVisible(false);
		JButton seat1 = new JButton("1");
		seat1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DB.payment(1);

				DB.deleteLogin(1);
				DB.updateStateToSeat(1);
				if (seat1.getBackground() == Color.GRAY)
					seat1.setBackground(Color.PINK);
			}
		});
		seat1.setForeground(Color.WHITE);
		seat1.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat1.setBackground(Color.PINK);
		MSeatPanel.add(seat1);

		JButton seat2 = new JButton("2");
		seat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(2);
				DB.deleteLogin(2);
				DB.updateStateToSeat(2);
				if (seat2.getBackground() == Color.GRAY)
					seat2.setBackground(Color.PINK);
			}
		});
		seat2.setForeground(Color.WHITE);
		seat2.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat2.setBackground(Color.PINK);
		MSeatPanel.add(seat2);

		JButton seat3 = new JButton("3");
		seat3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(3);
				DB.deleteLogin(3);
				DB.updateStateToSeat(3);
				if (seat3.getBackground() == Color.GRAY)
					seat3.setBackground(Color.PINK);
			}
		});
		seat3.setForeground(Color.WHITE);
		seat3.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat3.setBackground(Color.PINK);
		MSeatPanel.add(seat3);

		JButton seat4 = new JButton("4");
		seat4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(4);
				DB.deleteLogin(4);
				DB.updateStateToSeat(4);
				if (seat4.getBackground() == Color.GRAY)
					seat4.setBackground(Color.PINK);
			}
		});
		seat4.setForeground(Color.WHITE);
		seat4.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat4.setBackground(Color.PINK);
		MSeatPanel.add(seat4);

		JButton seat5 = new JButton("5");
		seat5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(5);
				DB.deleteLogin(5);
				DB.updateStateToSeat(5);
				if (seat5.getBackground() == Color.GRAY)
					seat5.setBackground(Color.PINK);
			}
		});
		seat5.setForeground(Color.WHITE);
		seat5.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat5.setBackground(Color.PINK);
		MSeatPanel.add(seat5);

		JButton seat6 = new JButton("6");
		seat6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(6);
				DB.deleteLogin(6);
				DB.updateStateToSeat(6);
				if (seat6.getBackground() == Color.GRAY)
					seat6.setBackground(Color.PINK);
			}
		});
		seat6.setForeground(Color.WHITE);
		seat6.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat6.setBackground(Color.PINK);
		MSeatPanel.add(seat6);

		JButton seat7 = new JButton("7");
		seat7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(7);
				DB.deleteLogin(7);
				DB.updateStateToSeat(7);
				if (seat7.getBackground() == Color.GRAY)
					seat7.setBackground(Color.PINK);
			}
		});
		seat7.setForeground(Color.WHITE);
		seat7.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat7.setBackground(Color.PINK);
		MSeatPanel.add(seat7);

		JButton seat8 = new JButton("8");
		seat8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(8);
				DB.deleteLogin(8);
				DB.updateStateToSeat(8);
				if (seat8.getBackground() == Color.GRAY)
					seat8.setBackground(Color.PINK);
			}
		});
		seat8.setForeground(Color.WHITE);
		seat8.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat8.setBackground(Color.PINK);
		MSeatPanel.add(seat8);

		JButton seat9 = new JButton("9");
		seat9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(9);
				DB.deleteLogin(9);
				DB.updateStateToSeat(9);
				if (seat9.getBackground() == Color.GRAY)
					seat9.setBackground(Color.PINK);
			}
		});
		seat9.setForeground(Color.WHITE);
		seat9.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat9.setBackground(Color.PINK);
		MSeatPanel.add(seat9);

		JButton seat10 = new JButton("10");
		seat10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(10);
				DB.deleteLogin(10);
				DB.updateStateToSeat(10);
				if (seat10.getBackground() == Color.GRAY)
					seat10.setBackground(Color.PINK);
			}
		});
		seat10.setForeground(Color.WHITE);
		seat10.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat10.setBackground(Color.PINK);
		MSeatPanel.add(seat10);

		JButton seat11 = new JButton("11");
		seat11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(11);
				DB.deleteLogin(11);
				DB.updateStateToSeat(11);
				if (seat11.getBackground() == Color.GRAY)
					seat11.setBackground(Color.PINK);
			}
		});
		seat11.setForeground(Color.WHITE);
		seat11.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat11.setBackground(Color.PINK);
		MSeatPanel.add(seat11);

		JButton seat12 = new JButton("12");
		seat12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(12);
				DB.deleteLogin(12);
				DB.updateStateToSeat(12);
				if (seat12.getBackground() == Color.GRAY)
					seat12.setBackground(Color.PINK);
			}
		});
		seat12.setForeground(Color.WHITE);
		seat12.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat12.setBackground(Color.PINK);
		MSeatPanel.add(seat12);

		JButton seat13 = new JButton("13");
		seat13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(13);
				DB.deleteLogin(13);
				DB.updateStateToSeat(13);
				if (seat13.getBackground() == Color.GRAY)
					seat13.setBackground(Color.PINK);
			}
		});
		seat13.setForeground(Color.WHITE);
		seat13.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat13.setBackground(Color.PINK);
		MSeatPanel.add(seat13);

		JButton seat14 = new JButton("14");
		seat14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(14);
				DB.deleteLogin(14);
				DB.updateStateToSeat(14);
				if (seat14.getBackground() == Color.GRAY)
					seat14.setBackground(Color.PINK);
			}
		});
		seat14.setForeground(Color.WHITE);
		seat14.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat14.setBackground(Color.PINK);
		MSeatPanel.add(seat14);

		JButton seat15 = new JButton("15");
		seat15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(15);
				DB.deleteLogin(15);
				DB.updateStateToSeat(15);
				if (seat15.getBackground() == Color.GRAY)
					seat15.setBackground(Color.PINK);
			}
		});
		seat15.setForeground(Color.WHITE);
		seat15.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat15.setBackground(Color.PINK);
		MSeatPanel.add(seat15);

		JButton seat16 = new JButton("16");
		seat16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.payment(16);
				DB.deleteLogin(16);
				DB.updateStateToSeat(16);
				if (seat16.getBackground() == Color.GRAY)
					seat16.setBackground(Color.PINK);
			}
		});
		seat16.setForeground(Color.WHITE);
		seat16.setBorder(new LineBorder(SystemColor.controlHighlight));
		seat16.setBackground(Color.PINK);
		MSeatPanel.add(seat16);
		// scrollPane.setViewportView(table);

		JPanel MLoginPanel = new JPanel();
		MLoginPanel.setBounds(0, 530, 1186, 208);
		MLoginPanel.setBackground(new Color(245, 245, 245));
		Mainframe.getContentPane().add(MLoginPanel);
		MLoginPanel.setLayout(null);
		JButton log = new JButton("\uB85C\uADF8\uC778");

		log.setBounds(907, 64, 97, 64);
		MLoginPanel.add(log);

		Maid = new JTextField();
		Maid.setBounds(725, 65, 116, 21);
		MLoginPanel.add(Maid);
		Maid.setColumns(10);

		MaPass = new JTextField();
		MaPass.setColumns(10);
		MaPass.setBounds(725, 107, 116, 21);
		MLoginPanel.add(MaPass);

		JLabel laId = new JLabel("\uC544\uC774\uB514");
		laId.setBounds(656, 68, 57, 15);
		MLoginPanel.add(laId);

		JLabel lapass = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lapass.setBounds(656, 110, 57, 15);
		MLoginPanel.add(lapass);

		JButton btnNewButton = new JButton("\uCC44\uD305");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFrame j = new JFrame();

				textarea.setEditable(false);// 쓰기를 금지함 edit 할 수 없는 상태

				scrollPane = new JScrollPane(textarea);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				// As needed 즉 필요에의해서 내용이 많아지면 스크롤 바가 생긴다
				scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				// 가로 스크롤은 안만든다

				j.setSize(500, 700);
				j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				j.setVisible(true);
				j.setTitle("chatting");

				sendMsgTf.addKeyListener(new MsgSendListener());
				// 텍스트 필드에 키 리스너를 등록
				// 텍스트 필드를 지켜보고 있다가 특정 상황이 오면
				// 이벤트 리스너에 정의된 내용 실행
				j.add(scrollPane, BorderLayout.CENTER);// 프레임에 붙이기
				// add(textarea,BorderLayout.CENTER);//프레임에 붙이기
				j.add(sendMsgTf, BorderLayout.SOUTH);// 프레임에 붙이기
				try {
					// 서버 아이피 , 포트번호 -> 소켓 생성 -> 연결 요청
					Socket socket = new Socket("127.0.0.1", 7777);
					// 소켓 객체 생성
				
					setSocket(socket);// 메인에서 프레임 생성
					TcpClientReceiveThread th1 = new TcpClientReceiveThread(socket);
					// TcpClientReceiveThread가 내부 클래스로 선언되어 있기 때문에
					// cf로 접근해서 socket을 전달한다
					new Thread(th1).start();
				} catch (Exception e) {
					e.printStackTrace();
				}

				
			}
		});
		btnNewButton.setBounds(1023, 35, 97, 23);
		

		JPanel ManagerPanel = new JPanel();
		ManagerPanel.setBounds(0, 530, 1186, 208);
		ManagerPanel.setBackground(new Color(245, 245, 245));
		Mainframe.getContentPane().add(ManagerPanel);
		ManagerPanel.setLayout(null);

		order = new JButton("\uC8FC\uBB38\uC644\uB8CC");
		order.setBounds(996, 78, 122, 42);
		order.setBackground(new Color(176, 224, 230));

		ManagerPanel.add(order);
		ManagerPanel.add(btnNewButton);
		JButton total = new JButton("\uB9E4\uCD9C\uD604\uD669");
		total.setBounds(996, 140, 122, 42);
		total.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Total.main(null);
			}
		});
		total.setBackground(new Color(176, 196, 222));
		ManagerPanel.add(total);
		scrollPane.setBounds(14, 12, 854, 184);
		ManagerPanel.add(scrollPane);
		ManagerPanel.setVisible(false);
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DB.mlogin(Maid.getText(), MaPass.getText());
				if (DB.ma) {
					MLoginPanel.setVisible(false);
					ManagerPanel.setVisible(true);
					MSeatPanel.setVisible(true);
					panel.setVisible(false);
					th.start();

				}

			}
		});

		/*
		 * String[][] data = DB.getOrder(); String[] headers = new String[] { "주문번호",
		 * "좌석번호", "상품명", "수량", "가격", "완료여부" }; DefaultTableModel model = new
		 * DefaultTableModel(data, headers); table = new JTable(model);
		 * model.setRowCount(0);
		 * 
		 * 
		 * for (int i = 0; i < data.length; i++) { model.addRow(data[i]);
		 * System.out.println(data[i][0].toString()); }
		 * 
		 */

		/*
		 * new Object[][] { DB.getOrder(); }, new String[] { "좌석번호", "상품명", "갯수", "완료여부"
		 * } ));
		 */

		ArrayList<String> a = DB.getCustomers();// 버튼색상바꾸는거 생성
		for (int i = 0; i < a.size(); i++)// 버튼색상바꾸기
		{
			switch (a.get(i)) {
			case "1":
				seat1.setBackground(Color.gray);
				break;
			case "2":
				seat2.setBackground(Color.gray);
				break;
			case "3":
				seat3.setBackground(Color.gray);
				break;
			case "4":
				seat4.setBackground(Color.gray);
				break;
			case "5":
				seat5.setBackground(Color.gray);
				break;
			case "6":
				seat6.setBackground(Color.gray);
				break;
			case "7":
				seat7.setBackground(Color.gray);
				break;
			case "8":
				seat8.setBackground(Color.gray);
				break;
			case "9":
				seat9.setBackground(Color.gray);
				break;
			case "10":
				seat10.setBackground(Color.gray);
				break;
			case "11":
				seat11.setBackground(Color.gray);
				break;
			case "12":
				seat12.setBackground(Color.gray);
				break;
			case "13":
				seat13.setBackground(Color.gray);
				break;
			case "14":
				seat14.setBackground(Color.gray);
				break;
			case "15":
				seat15.setBackground(Color.gray);
				break;
			case "16":
				seat16.setBackground(Color.gray);
				break;
			}
		}

	}

	class MsgSendListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {// 키가 눌렸다가 떼어졌을때
			// 엔터키가 눌렸다가 떼어지면 텍스트 필드에 있는 내용이 텍스트 에어리어에 나타나게
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {// 각각의 키들이 가지고 있는 코드 값이 나타난다
				// VK_ENTER = 상수 , 엔터 키에 대한 키값을 의미한다
				String msg = sendMsgTf.getText();
				System.out.println(msg);
				textarea.append("[나]: " + msg + "\n");
				sendMsgTf.setText("");
				try {
					bw.write(msg + "\n");
					bw.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 한문장이 끝났다는 것을 알리기 위해서 bufferedWriter에 "\n"을 붙인다

			}

		}
	}

	// 내부 클래스로 수신 스레드 작성
	class TcpClientReceiveThread implements Runnable {
		private Socket socket;

		public TcpClientReceiveThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// 서버로부터 오는 메세지를 읽어서
			// 텍스트 에어리어에 추가하기
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					String msg = br.readLine();// 메세지 한줄 읽어오기
					textarea.append("["+MainFrame.seat+"]" + msg + "\n");
				}
			} catch (Exception e) {
				textarea.append("연결이 종료되었습니다.");
				// System.out.println("연결이 종료되었습니다.");
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();// 다 쓴 소켓 닫기
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

	class AddTable implements Runnable {
		JTable table;
		JScrollPane scrollPane;
		int row;
		int cou;
		int del;
		Object value;

		public AddTable(JTable table, JScrollPane scrollPane) {
			this.table = table;
			this.scrollPane = scrollPane;
		}

		public void run() {
			while (true) {
				String[][] data = DB.getOrder();
				String[] headers = new String[] { "주문번호", "좌석번호", "상품명", "수량", "가격", "완료여부" };
				DefaultTableModel model = new DefaultTableModel(data, headers);
				table = new JTable(model);
				model.setRowCount(0);
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
				}
				scrollPane.setViewportView(table);

				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						cou = 1;
						row = table.rowAtPoint(e.getPoint());
						System.out.println("cou2" + cou);

						value = table.getValueAt(row, 0);
						del = Integer.parseInt(value.toString());
						System.out.println(row);
						System.out.println(del);
					}
				});
				Manager.order.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (cou == 1) {
								// JOptionPane.showMessageDialog(null, row+","+col);
								// sum-=Integer.parseInt(table.getValueAt(row,2).toString());
								// String[] headers = new String[] { "주문번호", "좌석번호", "상품명", "수량", "가격", "완료여부"
								// };
								((DefaultTableModel) table.getModel()).removeRow(row);
								DB.updateState(del, "완료");

								// la_total.setText("총합 : "+sum);
							}
						} catch (ArrayIndexOutOfBoundsException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "삭제할 상품이 없습니다", "경고", JOptionPane.WARNING_MESSAGE);
						}
					}
				});

				try {

					Thread.sleep(5000);
					model.setNumRows(0);

				} catch (Exception e) {
					// TODO: handle exception
					return;
				}
			}
		}
	}
}

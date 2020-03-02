import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DB {
	static boolean result;
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      getConnection();
     createOrderTable();
    createTotalTable();
      //getseat();
   }
   //DB����
   public static Connection getConnection() {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
      String user = "root";
      String pass = "1234";
      
      try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url,user,pass);
         System.out.println("DB ���� �Ϸ�!");
         return conn;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public static void createMemberTable() {                      //ȸ�� ���̺� ����
      try {
         Connection conn=getConnection(); //db���� conn ��ü
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"member(Mid varchar(15) not null ,"             //ȸ�� ���̵�
                     +"name varchar(20) not null,"            //ȸ�� �̸�
                     +"pass varchar(20) not null, "            //ȸ�� ��й�ȣ
                     +"birth varchar(8) not null, "            //ȸ�� �������(yyyymmdd)
                     +"phone varchar(11) not null, "            //ȸ�� �޴��� ��ȣ
                     +"address varchar(30) not null,"
                     + "primary key(Mid)) ");            //ȸ�� �ּ�(�������� ���)                  //ȸ�� ���̵� �⺻Ű�� ����
               
               create.execute();
               System.out.println("ȸ�� ���̺� ���� �Ϸ�");
               
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   
   public static void createProductTable() {                        //��ǰ ���̺� ����
      try {
         Connection conn=getConnection(); //db���� conn ��ü
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"product(prodid int not null auto_increment,"
                     +"name varchar(40) not null,"
                     +"price varchar(15) not null, "
                     +"num varchar(10) not null, "
                     +"primary key(prodid))");
               
               create.execute();
               System.out.println("��ǰ ���̺� ���� �Ϸ�");
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   

   
   public static void createOrderTable() {                   //�ֹ� ���̺�
      try {
         Connection conn=getConnection(); //db���� conn ��ü
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"orderT(rownum int not null AUTO_INCREMENT,"
               		+ "seat int(3) not null,"          //ȸ�� �¼� ��ȣ 
                     +"foodname varchar(40) not null, "       //���ĸ�
                     +"num int(3) not null, "
                     + "mon int, "             //�ֹ�����
                     +"state varchar(10) not null,"
                     + "primary key(rownum)) "         //��� �Ϸ�/�̿Ϸ� ��Ÿ����
                     );
         
               create.execute();
               System.out.println("�ֹ� ���̺� ���� �Ϸ�");
               
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   
   
   
   public static void createTotalTable(){                    //���� ���̺�
      try {
         Connection conn=getConnection(); //db���� conn ��ü
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"total(num int not null auto_increment,"      //���� ��ȣ
                     +"date datetime not null,"         //�ð�
                     +"price int(15) not null, "            //�����ݾ�
                     +"primary key(num))");               //�����ȣ �⺻Ű
               
               create.execute();
               System.out.println("���� ���̺� ���� �Ϸ�");
               
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void createLoginTable(){                       //���� ���̺�
      try {
         Connection conn=getConnection(); //db���� conn ��ü
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"login(id varchar(15) not null, "               //ȸ�� ���̵�
                     +"seat int(3) not null,"               //�¼� ��ȣ
                     +"date datetime not null,"
                     + "primary key(seat))"               //�α����� �ð�
                  );
                  
               
               create.execute();
               System.out.println("�α��� ���̺� ���� �Ϸ�");
               
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

   
   public static void login(String id, String pass,int seat) {  //�α���(id/pass ��ȸ)
      
	   try {
         Connection conn = getConnection(); //DB���� conn��ü 
         PreparedStatement statement = conn.prepareStatement(
               "SELECT * FROM member WHERE Mid=? AND pass=?");
         statement.setString(1, id);
         statement.setString(2, pass);
         ResultSet results = statement.executeQuery();
         if(results.next()) { 
           if(seat!=0) {
            insertInfo(id,seat); //login db�� ���̵�� �¼���ȣ ����
            // ���� �ִ� â dispose , �������� 
            insertOrder (seat,"0","0",1000,"�Ϸ�");
            result=true;
           }
         } else {
            JOptionPane.showMessageDialog(null, "���̵� �н����尡 Ʋ���ϴ�");
            result=false;
         }
   
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void insertInfo(String id,int seat) {            //�α��� ������ login db�� ���̵�� �¼���ȣ �ð� ����
      //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      //Date date = new Date();
      
      try {
         Connection conn = getConnection(); //DB���� conn��ü 
         PreparedStatement insert = conn.prepareStatement(
               "insert into login(id,seat,date) "
                     + "values ('"+ id+"',"+seat+",now())");
         insert.execute();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
 

	//ȸ�������� ������� �������� ����
	public static void insertMember(String id, String name, String pass, int birth, int phone, String address) {
		try {
			Connection conn = getConnection(); // DB���� conn��ü
			PreparedStatement insert = conn.prepareStatement("INSERT INTO member (Mid,name,pass,birth,phone,address)"
					+ "SELECT '" + id + "','" + name + "','" + pass + "'," + birth + "," + phone + ",'" + address
					+ "' FROM DUAL" + " WHERE NOT EXISTS (SELECT * FROM member WHERE Mid='" + id + "'and phone=" + phone
					+ ");");

			insert.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

   public static void insertOrder(int seat,String name,String num,int mon,String state) {             //�α��� ������ login db�� ���̵�� �¼���ȣ �ð� ����
      
      try {
         Connection conn = getConnection(); //DB���� conn��ü 
         PreparedStatement insert = conn.prepareStatement(
               "insert into ordert(seat,foodname,num,mon,state) "
                     + "values ('"+seat+"','"+name+"',"+Integer.parseInt(num)+","+mon+",'"+state+"')");
         insert.execute();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void insertTotal(int price){
	   try {
	         Connection conn = getConnection(); //DB���� conn��ü 
	         PreparedStatement insert = conn.prepareStatement(
	               "insert into total(date,price) "
	                     + "values (now(),"+price+")");
	         insert.execute();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
   }
   
   public static void createMLoginTable(){                       //���� ���̺�
      try {
         Connection conn=getConnection(); //db���� conn ��ü
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"manager(mid varchar(15) not null, "               //ȸ�� ���̵�
                     +"mpass varchar(15) not null,"               //�¼� ��ȣ
                     + "primary key(mid))"               //�α����� �ð�
                  );
                  
               
               create.execute();
               System.out.println("�����α��� ���̺� ���� �Ϸ�");
               
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   public static String[][] getOrder() {
	      try {
	         Connection conn = getConnection(); //DB���� conn��ü 
	         PreparedStatement statement = conn.prepareStatement(
	               "SELECT * FROM ordert");
	         ResultSet results = statement.executeQuery();
	         ArrayList<String[]> list = new ArrayList<String[]>();
	         while(results.next()) {
	           if(results.getString("state").equals("�̿Ϸ�")) {
	            list.add(new String[] {
	                   results.getString("rownum"),
	                  results.getString("seat"),
	                  results.getString("foodname"),
	                  results.getString("num"),
	                  results.getString("mon"),
	                  results.getString("state"),
	            });            
	         }}
	         System.out.println("�˻��Ǿ����ϴ�.");
	         String [][] arr = new String[list.size()][5];
	         return list.toArray(arr);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         return null;
	      }
	   }
   public static void mlogin(String mid, String mpass) {        //�α���(id/pass ��ȸ)
      try {
         Connection conn = getConnection(); //DB���� conn��ü 
         PreparedStatement statement = conn.prepareStatement(
               "SELECT * FROM manger WHERE mid=? AND mpass=?");
         statement.setString(1, mid);
         statement.setString(2, mpass);
         ResultSet results = statement.executeQuery();
         if(results.next()) { 
            JOptionPane.showMessageDialog(null, "�α��� ����!");
         } else {
            JOptionPane.showMessageDialog(null, "���̵� �н����尡 Ʋ���ϴ�");
         }
   
      } catch (Exception e) {
         e.printStackTrace();
      }
      
         
   }
   public static ArrayList<String> getCustomers(){
      try{
         Connection con = getConnection();
         PreparedStatement statement = con.prepareStatement("Select seat FROM login");
         ResultSet results = statement.executeQuery();
         ArrayList<String> list = new ArrayList<String>();
         while(results.next()){
            list.add(results.getString("seat"));
         }
         System.out.println("The data has been fetched");
         return list;
         
      }catch(Exception e){
         System.out.println(e.getMessage());
         return null;
      }
   }
   

//�ֹ��� ������ ��޵��� ��� �ֹ� ���̺��� ����(state)�� �Ϸ�� �ٲ��ִ� �޼ҵ�
public static void updateState(int row, String text) {
	try {
		Connection conn = getConnection();// db���� conn��ü
		PreparedStatement update = conn
				.prepareStatement("UPDATE  ordert set state='" + text + "' WHERE rownum='" +row+"'");


		update.execute();
		System.out.println("�����Ϸ�");

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();

	}
}

public static String[][] getTotal() {
    try {
       Connection conn = getConnection(); //DB���� conn��ü 
       PreparedStatement statement = conn.prepareStatement(
             "SELECT * FROM total");
       ResultSet results = statement.executeQuery();
       ArrayList<String[]> list = new ArrayList<String[]>();
       while(results.next()) {
      
          list.add(new String[] {
                results.getString("num"),
                results.getString("date"),
                results.getString("price"),
          });            }
       
       System.out.println("�˻��Ǿ����ϴ�.");
       String [][] arr = new String[list.size()][3];
       return list.toArray(arr);
       
    } catch (Exception e) {
       e.printStackTrace();
       return null;
    }
 }




//id�� pw ã�� �޼ҵ� �Ű������� ��(num)�� 0�̸� ���̵� ���, 1�̸� ��й�ȣ�� ���
public static void searchMember(String name, int birth, int phone, int num) {
	String id = "", pass = "";
	try {
		Connection conn = getConnection();// db���� conn��ü
		PreparedStatement select = conn
				.prepareStatement("select Mid,pass from member where name=? and birth=? and phone=?");
		select.setString(1, name);
		select.setLong(2, birth);
		select.setLong(3, phone);

		select.execute();
		System.out.println("���̵� ã��");
		ResultSet rs = select.executeQuery();

		ArrayList<ArrayList<String>> data_arr = new ArrayList<ArrayList<String>>();

		if (rs.next()) {
			do {
				ArrayList<String> imsi = new ArrayList<String>();

				imsi.add(rs.getString("Mid"));

				imsi.add(rs.getString("pass"));

				data_arr.add(imsi);

			} while (rs.next());

			String[][] data = new String[data_arr.size()][2];

			for (int i = 0; i < data_arr.size(); i++) {

				ArrayList<String> al = data_arr.get(i);

				for (int j = 0; j < 2; j++) {

					data[i][j] = al.get(j);
				}
			}
			if( data[0][num].toString()==null) 	JOptionPane.showMessageDialog(null, "�����ϴ� ������ �����ϴ�.");
			JOptionPane.showMessageDialog(null, "ȸ���� ������ " + data[0][num].toString() + "�Դϴ�");
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();

	}
}

//�� �����ϴ� �ý���(����� �ֹ����̺� �ִ� ���ݸ� ���Ǽ� ���)
public static void payment(int seat) {
	int total=0;
		try {
			Connection conn = getConnection();// db���� conn��ü
			PreparedStatement select = conn
					.prepareStatement("select o.seat, o.foodname, ifnull(sum(o.mon),0) sum from ordert o  where o.seat=? group by o.seat");
			select.setLong(1, seat);
			select.execute();
			
			ResultSet rs = select.executeQuery();

			ArrayList<ArrayList<String>> data_arr = new ArrayList<ArrayList<String>>();

			if (rs.next()) {
				do {
					ArrayList<String> imsi = new ArrayList<String>();

					imsi.add(rs.getString("seat"));

					imsi.add(rs.getString("foodname"));

					imsi.add(rs.getString("sum"));
					
					
					data_arr.add(imsi);

				} while (rs.next());

				String[][] data = new String[data_arr.size()][3];

				for (int i = 0; i < data_arr.size(); i++) {

					ArrayList<String> al = data_arr.get(i);

					for (int j = 0; j < 3; j++) {

						data[i][j] = al.get(j);
					}
				}
				 total=Integer.parseInt(data[0][2].toString());
				
			}
			JOptionPane.showMessageDialog(null, "ȸ���� ������ " + total + "�� �Դϴ�");
			if(total!=0) {
			insertTotal(total);
			deleteOrder(seat);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	}
}


public static void deleteLogin(int seat) {
	try {
		Connection conn = getConnection();// db���� conn��ü
		PreparedStatement delete = conn
				.prepareStatement("delete from login where seat=? ");
		delete.setLong(1, seat);
		delete.execute();
		
		int results = delete.executeUpdate();
		System.out.println("���� �Ϸ�");
	} catch(Exception e) {
		e.printStackTrace();
	}
}

public static void deleteOrder(int seat){
	try {
		Connection conn = getConnection();// db���� conn��ü
		PreparedStatement delete = conn
				.prepareStatement("delete from ordert where seat=? ");
		delete.setLong(1, seat);
		delete.execute();
		
		int results = delete.executeUpdate();
		System.out.println("���� �Ϸ�");
	} catch(Exception e) {
		e.printStackTrace();
	}
}

public static void updateStateToSeat(int seat) {
	try {
		Connection conn = getConnection();// db���� conn��ü
		PreparedStatement update = conn
				.prepareStatement("UPDATE  ordert set state='�Ϸ�' WHERE rownum='" +seat+"'");


		update.execute();
		System.out.println("�����Ϸ�");

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();

	}
}
public static ArrayList<String> getseat(){
	   try{
	      Connection con = getConnection();
	      PreparedStatement statement = con.prepareStatement("Select price FROM total");
	      ResultSet results = statement.executeQuery();
	      ArrayList<String> list = new ArrayList<String>();

	      while(results.next()){
	          list.add(results.getString("price"));
	       }

	      return list;
	   }catch(Exception e){
	      System.out.println(e.getMessage());
	      return null;
	   }
	}

}





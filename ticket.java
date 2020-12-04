package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultComboBoxModel;
public class ticket {

	private JFrame frame;
	private JTextField subtotal;
	private JTextField balance;
	private JTextField pay;
	private JTable table;
	FileOutputStream outstream = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ticket window = new ticket();
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
	public ticket() {
		initialize();
	}
	
	DefaultTableModel model=new DefaultTableModel();
	Connection con;
	PreparedStatement pa1;
	PreparedStatement pa2;
	private JTextField name;
	private JTextField num;
	private JTextField account;
	private JTextField textField;
	
	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public void initialize()  {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 860, 533);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(10, 10, 826, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TICKET BOOKING");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblNewLabel.setBounds(186, 10, 466, 95);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ticket.main(null);
			}
		});
		btnNewButton.setBounds(693, 84, 85, 21);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(261, 326, 249, 134);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chodc = new JCheckBox("ODC");
		chodc.setFont(new Font("Tahoma", Font.BOLD, 12));
		chodc.setBounds(6, 6, 143, 29);
		panel_1.add(chodc);
		
		JCheckBox chbalco = new JCheckBox("BALCONY");
		chbalco.setFont(new Font("Tahoma", Font.BOLD, 12));
		chbalco.setBounds(6, 37, 143, 29);
		panel_1.add(chbalco);
		
		JCheckBox chbox = new JCheckBox("BOX");
		chbox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chbox.setBounds(6, 68, 143, 29);
		panel_1.add(chbox);
		
		JCheckBox chsuperbal = new JCheckBox("SUPERBALCONY");
		chsuperbal.setFont(new Font("Tahoma", Font.BOLD, 12));
		chsuperbal.setBounds(6, 99, 143, 29);
		panel_1.add(chsuperbal);
		
		JSpinner spinner1 = new JSpinner();
		spinner1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner1.setBounds(155, 6, 79, 23);
		panel_1.add(spinner1);
		
		JSpinner spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner2.setBounds(155, 37, 79, 23);
		panel_1.add(spinner2);
		
		JSpinner spinner3 = new JSpinner();
		spinner3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner3.setBounds(155, 68, 79, 23);
		panel_1.add(spinner3);
		
		JSpinner spinner4 = new JSpinner();
		spinner4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner4.setBounds(155, 99, 79, 23);
		panel_1.add(spinner4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 132, 819, 148);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox timebox = new JComboBox();
		timebox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		timebox.setModel(new DefaultComboBoxModel(new String[] {"11:30", "1:30", "4:30", "7:30"}));
		timebox.setBounds(102, 398, 101, 26);
		frame.getContentPane().add(timebox);
		
		JComboBox datebox = new JComboBox();
		datebox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datebox.setModel(new DefaultComboBoxModel(new String[] {"18 April 2020", "22 April 2020", "23 April 2020", "24 April 2020", "25 April 2020", "26 April 2020", "27 April 2020"}));
		datebox.setBounds(102, 434, 149, 26);
		frame.getContentPane().add(datebox);

		JComboBox commovie = new JComboBox();
		commovie.setBounds(102, 364, 149, 26);
		frame.getContentPane().add(commovie);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "1234");
			String query="Select *from movieeeee ";
			PreparedStatement pa3=(PreparedStatement) conn.prepareStatement(query);
			ResultSet rs=pa3.executeQuery();
			while(rs.next()) {
			String	temp=rs.getString("movie_name");
				commovie.addItem(temp);	
				
			}
			
		}catch(Exception e) {}
	
		
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBounds(10, 10, 799, 128);
		panel_2.add(table);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ACCOUNT", "NAME", "PHONE NO", "MOVIE", "TIME", "DATE", "SEAT TYPE", "PRICE", "QUANTITY", "TOTAL"
			}
		));
		
		JButton addbutton = new JButton("ADD");
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum=0;
				int price;
				int quantity;
				int tot;
				String accountnom =account.getText();
				String nameo =name.getText();
				String phoneno= num.getText();
				String time=timebox.getSelectedItem().toString();
				String date=datebox.getSelectedItem().toString();
				String movie=commovie.getSelectedItem().toString();
				
				if(chodc.isSelected())
				{
					String odc =chodc.getText();
					price= 300;
				 quantity=Integer.parseInt(spinner1.getValue().toString());
				 tot=price * quantity;
				 model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {
					accountnom,
					nameo,
					phoneno,
					movie,
					time,
					date,
					odc,
					price,
					quantity,
					tot
					
					
				 });
				 
				}
				
				if(chbalco.isSelected())
				{
					String balcony =chbalco.getText();
					price= 400;
				 quantity=Integer.parseInt(spinner2.getValue().toString());
				 tot=price * quantity;
				 model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {
						 accountnom,
						 nameo,
							phoneno,
							 movie,
								time,
								date,
							balcony,
				 price,
					quantity,
					tot
					
				 });
				 
				}
				if(chbox.isSelected())
				{
					String box =chbox.getText();
					price= 450;
				 quantity=Integer.parseInt(spinner3.getValue().toString());
				 tot=price * quantity;
				 model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {
						 accountnom,
						 nameo,
							phoneno,
							 movie,
								time,
								date,
							box,
						
					price,
					quantity,
					tot
					
				 });
				 
				}
				if(chsuperbal.isSelected())
				{
					String superbalcony=chsuperbal.getText();
					price= 300;
				 quantity=Integer.parseInt(spinner4.getValue().toString());
				 tot=price * quantity;
				 model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {
						 
						 accountnom,
						 nameo,
							phoneno,
							movie,
							time,
							date,
							superbalcony,
						 
					price,
					quantity,
					tot
					
				 });
				 
				}
				
				for(int i=0;i<table.getRowCount();i++)
				{
					sum=sum+Integer.parseInt(table.getValueAt(i, 9).toString());
				}
				subtotal.setText(String.valueOf(sum));
				
			}
		});
		addbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		addbutton.setBounds(494, 290, 101, 33);
		frame.getContentPane().add(addbutton);
		
		
		
		JButton printbutton = new JButton("BOOK");
		printbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sub=Integer.parseInt(subtotal.getText());
				int pays=Integer.parseInt(pay.getText());
				int bal=pays-sub;
				sales();
				balance.setText(String.valueOf(bal));
				
			}
		

			public void sales() {
				// TODO Auto-generated method stub
				
				String tickettype;
				String accounts;
				String movies;
				String times;
				String dates;
				int price;
				int quantity;
				int total=0;
				try {
					int lastid=0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "1234");
					String query="insert into saleticket(nameo,phoneno,subtotal,pay,balance,accountno) values(?,?,?,?,?,?)";
					PreparedStatement pa1=(PreparedStatement)con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pa1.setString(1,name.getText());
					pa1.setString(2,num.getText());
					pa1.setString(3,subtotal.getText());
					pa1.setString(4,pay.getText());
					pa1.setString(5,balance.getText());
					pa1.setString(6,account.getText());
					pa1.executeUpdate();
					ResultSet rs=pa1.getGeneratedKeys();
					if(rs.next())
					{
						lastid=rs.getInt(1);
					}
					Class.forName("com.mysql.jdbc.Driver");
					
					
					String query1="insert into info(accountno,name,phoneno,movie,time,date,ticketid,tickettype,quantity,price,total) values(?,?,?,?,?,?,?,?,?,?,?)";
					Connection cone=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "1234");
					PreparedStatement pa2=(PreparedStatement)cone.prepareStatement(query1);
					String name;
					String num;
					for(int p=0;p<table.getRowCount();p++)
					{
						accounts=(String)table.getValueAt(p,0);
						name=(String)table.getValueAt(p,1);
						num=(String)table.getValueAt(p,2);
						movies=(String)table.getValueAt(p,3);
						times=(String)table.getValueAt(p,4);
						dates=(String)table.getValueAt(p,5);
						tickettype=(String)table.getValueAt(p,6);
						price=(int)table.getValueAt(p,7);
						quantity=(int)table.getValueAt(p,8);
						total=(int)table.getValueAt(p,9);
						pa2.setString(1, accounts);
						pa2.setString(2, name);
						pa2.setString(3, num);
						pa2.setString(4, movies);
						pa2.setString(5, times);
						pa2.setString(6, dates);
						pa2.setInt(7, lastid);
						pa2.setString(8, tickettype);
						pa2.setInt(10, price);
						pa2.setInt(9, quantity);
						pa2.setInt(11, total);
						pa2.execute();
											
						File file =new File("C:\\Users\\Stuti\\Desktop\\output.txt");
						FileWriter fw;
					
					try {
						
						fw = new FileWriter(file);
						BufferedWriter bw=new BufferedWriter(fw);
						for(int i=0;i<table.getRowCount();i++) {
							for (int j=0;j<table.getColumnCount();j++) {
								bw.write(table.getValueAt(i,j).toString()+ "/");
							}
							bw.newLine();
						}
						JOptionPane.showMessageDialog(null, "booked!!");
						bw.close();
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
				
					}
					}catch(ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "error");	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
							
		});
		printbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		printbutton.setBounds(569, 453, 112, 33);
		frame.getContentPane().add(printbutton);
		
		JLabel lblNewLabel_1 = new JLabel("SUB TOTAL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(520, 326, 95, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBalance.setBounds(520, 406, 95, 26);
		frame.getContentPane().add(lblBalance);
		
		JLabel lblPay = new JLabel("PAY *");
		lblPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPay.setBounds(520, 370, 52, 26);
		frame.getContentPane().add(lblPay);
		
		subtotal = new JTextField();
		subtotal.setBounds(625, 326, 161, 26);
		frame.getContentPane().add(subtotal);
		subtotal.setColumns(10);
		
		balance = new JTextField();
		balance.setColumns(10);
		balance.setBounds(625, 406, 161, 26);
		frame.getContentPane().add(balance);
		
		pay = new JTextField();
		pay.setColumns(10);
		pay.setBounds(625, 373, 161, 26);
		frame.getContentPane().add(pay);
		
		JLabel lblNewLabel_2 = new JLabel("NAME *");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 290, 85, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO *");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNo.setBounds(10, 326, 121, 26);
		frame.getContentPane().add(lblPhoneNo);
		
		name = new JTextField();
		name.setBounds(102, 290, 121, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		num = new JTextField();
		num.setColumns(10);
		num.setBounds(102, 326, 121, 26);
		frame.getContentPane().add(num);
		
		JLabel lblMovie = new JLabel("MOVIE *");
		lblMovie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMovie.setBounds(10, 362, 121, 26);
		frame.getContentPane().add(lblMovie);
		
		JLabel lbltime = new JLabel("TIME *");
		lbltime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltime.setBounds(10, 398, 121, 26);
		frame.getContentPane().add(lbltime);
		
		
		JLabel datelbl = new JLabel("DATE *");
		datelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		datelbl.setBounds(10, 437, 121, 26);
		frame.getContentPane().add(datelbl);
		
		JLabel lblAccountNo = new JLabel("ACCOUNT NO *");
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccountNo.setBounds(261, 290, 121, 26);
		frame.getContentPane().add(lblAccountNo);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(383, 290, 101, 26);
		frame.getContentPane().add(account);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				booking.main(null);
			}
		});
		btnNewButton_1.setBounds(734, 461, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("MONEY DETAILS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(651, 290, 149, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("enter below the amount you want to pay\r\n");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(520, 354, 266, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NOTE : Enter the account no carefully, it will be matched with the transaction account no. ");
		lblNewLabel_5.setForeground(new Color(51, 102, 0));
		lblNewLabel_5.setBounds(10, 465, 500, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("The amount can be payed using PayPal, UPI , Google Pay or Paytm at the number +919380106136");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(10, 479, 549, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
	}
	}
		
		
	
		
		
		
	
	
	


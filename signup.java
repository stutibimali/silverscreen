package loginpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.sql.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.exceptions.*;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.SwingConstants;

public class signup  {

	private JFrame frame;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField username;

	private JTextField number;
	private JPasswordField password;
	private JPasswordField repassword;

	
	private JTextField address;

	private JTextField email;
	private JTextField gender;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
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
	public signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 void initialize() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 370, 450);
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 370,450);
		frame.getContentPane().setLayout(null);
		
		JLabel first = new JLabel("first name: *");
		first.setBounds(20, 88, 109, 24);
		first.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(first);
		
		JLabel lblLastName = new JLabel("last name: *");
		lblLastName.setBounds(20, 122, 109, 24);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("email: *");
		lblEmail.setBounds(20, 155, 109, 24);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("username: *");
		lblUsername.setBounds(20, 189, 109, 24);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password: *");
		lblPassword.setBounds(20, 223, 109, 24);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRepassword = new JLabel("re-password: *");
		lblRepassword.setBounds(20, 257, 109, 24);
		lblRepassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblRepassword);
		
		
		
		JLabel lblPhone = new JLabel("phoneno: *");
		lblPhone.setBounds(20, 291, 109, 24);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblPhone);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(68, 513, 258, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel image4 = new JLabel("");
		image4.setBounds(20, 6, 97, 72);
		Image img4=new ImageIcon(this.getClass().getResource("/handshake.png")).getImage();
		image4.setIcon(new ImageIcon(img4));
		image4.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(image4);
		
		firstname = new JTextField();
		firstname.setBounds(155, 88, 191, 24);
		firstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(155, 122, 191, 24);
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lastname.setColumns(10);
		frame.getContentPane().add(lastname);
		
		email = new JTextField();
		email.setToolTipText("");
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(155, 155, 191, 24);
		frame.getContentPane().add(email);
		
		username = new JTextField();
		username.setBounds(155, 190, 191, 24);
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setColumns(10);
		frame.getContentPane().add(username);
		
		number = new JTextField();
		number.setBounds(155, 292, 191, 24);
		number.setFont(new Font("Tahoma", Font.PLAIN, 14));
		number.setColumns(10);
		frame.getContentPane().add(number);
		
		password = new JPasswordField();
		password.setBounds(155, 224, 191, 24);
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(password);
		
		repassword = new JPasswordField();
		repassword.setBounds(155, 258, 191, 24);
		repassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(repassword);		
	
		JLabel signinlo = new JLabel("SIGNIN");
		signinlo.setForeground(new Color(128, 0, 0));
		signinlo.setBounds(141, 6, 132, 49);
		signinlo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		frame.getContentPane().add(signinlo);
		
		JLabel lblGender = new JLabel("gender: *");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(20, 325, 109, 24);
		frame.getContentPane().add(lblGender);
		
		gender = new JTextField();
		gender.setToolTipText("");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setColumns(10);
		gender.setBounds(155, 326, 191, 24);
		frame.getContentPane().add(gender);
	
		
		JButton register = new JButton("REGISTER");
		register.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String pass=password.getText();
				String repass=repassword.getText();
				String first=firstname.getText();
				String last=lastname.getText();
				String user=username.getText();
				String emai=email.getText();
				String num=number.getText();
				String gen=gender.getText();
				if(pass.compareTo(repass)==0 )
					{
					SaveToDatabase();			
				}
			
				else {
					JOptionPane.showMessageDialog(null,"invalid entry");
					
					

				}	
				
			}
		});
		register.setBounds(20, 363, 147, 40);
		register.setFont(new Font("Tahoma", Font.BOLD, 14));
	
		frame.getContentPane().add(register);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				signup.main(null);
			}
		});
		btnReset.setBounds(201, 363, 121, 40);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("enter details carefully");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblNewLabel_1.setBounds(127, 48, 207, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
	
		
	}

	private void setFrame(JFrame jFrame) {
		// TODO Auto-generated method stub
			this.frame = frame;
		}
	private JFrame getFrame() {
		return frame;
	}
	
static Connection con() {
	try {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/userdetails";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, "root", "1234");
		return con;
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,"invalid");
		}
	return null;
	}


private void SaveToDatabase() {
Connection con=con();
try {
	String query="insert into userinfo(firstname,lastname,email,username,password,phoneno,gender) values(?,?,?,?,?,?,?)";
	PreparedStatement pa=con.prepareStatement(query);
	pa.setString(1,firstname.getText());
	pa.setString(2,lastname.getText());
	pa.setString(3,email.getText());
	pa.setString(4,username.getText());
	pa.setString(5,password.getText());
	pa.setString(6,number.getText());
	pa.setString(7,gender.getText());
	pa.execute();
	JOptionPane.showMessageDialog(null, "saved login!!");
	frame.setVisible(false);
	login.main(null);
}
catch(Exception e) {
	JOptionPane.showMessageDialog(null,"signup not successfull..");
	frame.setVisible(false);
	signup.main(null);
	
	
}
}
}
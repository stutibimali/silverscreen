package loginpage;

import java.awt.EventQueue;
import main.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField nameuser;
	private JPasswordField passworduser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		intt();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void intt()  {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 421, 258);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel.setBounds(302, 36, 92, 24);
		frame.getContentPane().add(lblNewLabel);
		
		nameuser = new JTextField();
		nameuser.setBounds(201, 62, 193, 24);
		frame.getContentPane().add(nameuser);
		nameuser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setBounds(302, 96, 92, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		passworduser = new JPasswordField();
		passworduser.setBounds(201, 118, 193, 24);
		frame.getContentPane().add(passworduser);
		
		JLabel linkdes = new JLabel("Don't have any account?? CLICK HERE->");
		linkdes.setBounds(20, 194, 250, 17);
		frame.getContentPane().add(linkdes);
		
		JLabel siginlink = new JLabel("SIGN IN");
		siginlink.setFont(new Font("Tahoma", Font.BOLD, 14));
		siginlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signup.main(null);
			}
		});
		siginlink.setForeground(Color.RED);
		siginlink.setBounds(276, 191, 84, 18);
		frame.getContentPane().add(siginlink);
		
		
		JButton userlog = new JButton("LOGIN");
		userlog.setFont(new Font("Tahoma", Font.BOLD, 14));
		userlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c=0;
				String pass=passworduser.getText();
				String driver="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/userdetails";
				
				try {
					Class.forName(driver);
					Connection con=DriverManager.getConnection(url, "root", "1234");
					String query="Select username,password from userinfo where username='"+nameuser.getText()+"'";
					PreparedStatement pa=con.prepareStatement(query);
					ResultSet rs=pa.executeQuery();
					while(rs.next()) {
					if(pass.contentEquals(rs.getString("password"))) {
					JOptionPane.showMessageDialog(null,"WELCOME TO SILVERSCREEN");
					 c=1;
					frame.setVisible(false);
					
					booking.main(null);
					
					
					}
					}
					if(c==0)
					{
						JOptionPane.showMessageDialog(null,"login not successfull.. try again");
					}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null,"login not successfull");
					}
				
			}
		});

		userlog.setBounds(201, 148, 92, 36);
		frame.getContentPane().add(userlog);
		
		JLabel image9 = new JLabel("");
		Image img9=new ImageIcon(this.getClass().getResource("/enter.png")).getImage();
		image9.setIcon(new ImageIcon(img9));
		image9.setBounds(10, 36, 181, 148);
		frame.getContentPane().add(image9);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c=0;
				String pass=passworduser.getText();
				String driver="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/userdetails";
				
				try {
					Class.forName(driver);
					Connection con=DriverManager.getConnection(url, "root", "1234");
					String query="Select idADMIN,VIPPASSS from admin where idADMIN='"+nameuser.getText()+"'";
					PreparedStatement pa=con.prepareStatement(query);
					ResultSet rs=pa.executeQuery();
					while(rs.next()) {
					if(pass.contentEquals(rs.getString("VIPPASSS"))) {
					JOptionPane.showMessageDialog(null,"WELCOME TO SILVERSCREEN");
					 c=1;
					frame.setVisible(false);
					admin.main(null);
					
					
					}
					}
					if(c==0)
					{
						JOptionPane.showMessageDialog(null,"admin login error");
					}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null,"login not successfull");
					}	
					}	
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(303, 148, 91, 36);
		frame.getContentPane().add(btnNewButton);
	}
}

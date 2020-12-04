package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import loginpage.login;
import loginpage.signup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFormattedTextField;
public class admin extends login{

	public JFrame frame;
	private JTextField NAMEM;
	private JTextField DATE;
	private JTextField DESC;
	Connection con=null;
	
	PreparedStatement pat=null;
	ResultSet rs=null;
	private JTextField RATE;
	private JTextField id;
	private JTextField pass;
	private JTextField dir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				
			}
		});
	}
public admin()
{
	initialize();
}
	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public void initialize() {
		 frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 711,469);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		getFrame().getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel image4 = new JLabel("");
		image4.setBounds(10, 0, 144, 128);
		Image img4=new ImageIcon(this.getClass().getResource("/movie-projector.png")).getImage();
		layeredPane.setLayout(null);
		image4.setIcon(new ImageIcon(img4));
		layeredPane.add(image4);
		
		JLabel image5 = new JLabel("");
		image5.setBounds(143, 29, 72, 88);
		Image img5=new ImageIcon(this.getClass().getResource("/s.png")).getImage();
		image5.setIcon(new ImageIcon(img5));
		layeredPane.add(image5);
		
		JLabel lblilver = new JLabel("ILVER");
		lblilver.setBounds(199, 44, 89, 30);
		lblilver.setFont(new Font("Ink Free", Font.BOLD, 24));
		layeredPane.add(lblilver);
		
		JLabel lblCreen = new JLabel("CREEN");
		lblCreen.setBounds(209, 75, 89, 30);
		lblCreen.setFont(new Font("Ink Free", Font.BOLD, 24));
		layeredPane.add(lblCreen);
		Image img6=new ImageIcon(this.getClass().getResource("/system-administrator-male.png")).getImage();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 127, 710, 2);
		layeredPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 137, 677, 285);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		NAMEM = new JTextField();
		NAMEM.setBounds(128, 10, 189, 31);
		panel.add(NAMEM);
		NAMEM.setColumns(10);
		
		DATE = new JTextField();
		DATE.setColumns(10);
		DATE.setBounds(128, 51, 189, 31);
		panel.add(DATE);
		
		DESC = new JTextField();
		DESC.setBounds(128, 92, 189, 31);
		panel.add(DESC);
		DESC.setColumns(10);
		

		RATE = new JTextField();
		RATE.setColumns(10);
		RATE.setBounds(128, 133, 189, 31);
		panel.add(RATE);
		id = new JTextField();
		id.setBounds(393, 10, 133, 23);
		layeredPane.add(id);
		id.setColumns(10);
		pass = new JTextField();
		pass.setBounds(536, 10, 133, 23);
		layeredPane.add(pass);
		pass.setColumns(10);
		
		
		JButton btnNewButton = new JButton("ADD MOVIES");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "1234");
					String query2="insert into movieeeee(movie_name,release_date,director,rate,description) values(?,?,?,?,?)";
					PreparedStatement pa=con.prepareStatement(query2);
					pa.setString(1,NAMEM.getText());
					pa.setString(2,DATE.getText());
					pa.setString(3,dir.getText());
					pa.setString(5,DESC.getText());
					pa.setString(4,RATE.getText());
					pa.executeUpdate();
					
					File file=new File("C:\\Users\\Stuti\\Desktop\\table.txt.txt");
					FileWriter fw=new FileWriter(file,true);
					PrintWriter pw= new PrintWriter(fw);
					pw.println();
					pw.print(NAMEM.getText() +" / ");
					pw.print(" " +DATE.getText() +" / ");
					pw.print(" " +dir.getText()+ " / ");
					pw.print(" " +RATE.getText()+ " / ");
					pw.print(" " +DESC.getText());
					pw.println();
					pw.close();
					fw.close();
					
					
					JOptionPane.showMessageDialog(null, "movie added!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
			}
		});
		btnNewButton.setBounds(10, 223, 148, 39);
		panel.add(btnNewButton);
		
		JButton btnDeleteMovies = new JButton("DELETE MOVIES");
		btnDeleteMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "1234");
					String query="Delete from movieeeee where movie_name=?";
					pat=con.prepareStatement(query);
					pat.setString(1,NAMEM.getText());
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "deletion successfull");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} 
				
			}
		});
		btnDeleteMovies.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteMovies.setBounds(168, 223, 160, 39);
		panel.add(btnDeleteMovies);
		
		JButton btnEditTime = new JButton("UPDATE");
		btnEditTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				
				try {
				
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "1234");
					
					String query2="update movieeeee set  release_date=?, director=?, rate=?, description=? where movie_name=?";
					PreparedStatement pa=con.prepareStatement(query2);
					pa.setString(5,NAMEM.getText());
					pa.setString(1,DATE.getText());
					pa.setString(2,dir.getText());
					pa.setString(4,DESC.getText());
					pa.setString(3,RATE.getText());
					pa.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"UPDATED");
						}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} 
			}
		});
		btnEditTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditTime.setBounds(338, 223, 148, 39);
		panel.add(btnEditTime);
		
		JLabel lblNewLabel_1 = new JLabel("MOVIE NAME :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 10, 131, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("DATE :");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(10, 51, 131, 39);
		panel.add(lblDate);
		
		JLabel lblDescription = new JLabel("DESCRIPTION :");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 92, 131, 39);
		panel.add(lblDescription);
		
		JLabel label = new JLabel("");
		label.setBounds(327, 0, 194, 198);
		panel.add(label);
		label.setIcon(new ImageIcon(img6));
		
		JLabel lblRating = new JLabel("RATING:");
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRating.setBounds(10, 133, 131, 39);
		panel.add(lblRating);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin.main(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(496, 223, 148, 39);
		panel.add(btnReset);
		
		JLabel lblOnlyForOfficial = new JLabel("ONLY FOR OFFICIAL USE : )");
		lblOnlyForOfficial.setForeground(Color.WHITE);
		lblOnlyForOfficial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOnlyForOfficial.setBounds(338, 174, 219, 39);
		panel.add(lblOnlyForOfficial);
		
		JButton btnNewButton_2 = new JButton("latest user login ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				info.main(null);
			}
		});
		btnNewButton_2.setBounds(524, 77, 143, 46);
		panel.add(btnNewButton_2);
		
		JLabel lblDirector = new JLabel("DIRECTOR :");
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDirector.setBounds(10, 174, 131, 39);
		panel.add(lblDirector);
		
		dir = new JTextField();
		dir.setColumns(10);
		dir.setBounds(128, 174, 189, 31);
		panel.add(dir);
		
		JButton btnNewButton_3 = new JButton("LOGOUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login.main(null);
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBounds(524, 144, 118, 21);
		panel.add(btnNewButton_3);
		
		
		
		JLabel lblNewLabel = new JLabel("ADMIN PAGE");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 49));
		lblNewLabel.setBounds(341, 70, 337, 54);
		layeredPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("change password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "1234");
					String query3="update admin set VIPPASSS=? where idADMIN=?";
					PreparedStatement pas=con.prepareStatement(query3);
					pas.setString(2,id.getText());
					pas.setString(1,pass.getText());
					pas.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"YOU HAVE CHANGED THE PASSWORD");
					frame.setVisible(false);
					login.main(null);
						}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setBounds(464, 39, 133, 21);
		layeredPane.add(btnNewButton_1);
		
		
		
	}
	
	private void setFrame(JFrame jFrame) {
		// TODO Auto-generated method stub
			this.frame = frame;
		}
	private JFrame getFrame() {
		return frame;
	}
}


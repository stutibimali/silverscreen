package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.Panel;
import java.awt.Scrollbar;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import java.awt.Point;
import javax.swing.JTabbedPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Label;

public class booking extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking window = new booking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  booking() {
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
	public void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 860, 514);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Panel panel = new Panel();
		panel.setBounds(10, 10, 826, 109);
		panel.setBackground(new Color(47, 79, 79));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO SILVERSCREEN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 618, 89);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BOOK NOW");
		btnNewButton.setBounds(656, 26, 160, 44);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ticket.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(0, 0, 128));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				movies.main(null);
			}
		});
		panel_1.setBounds(20, 125, 616, 232);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(20, 10, 574, 212);
		Image img4=new ImageIcon(this.getClass().getResource("/now.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img4));
		panel_1.add(lblNewLabel_1);
		
		JButton btnMovieDetails = new JButton("MOVIE DETAILS");
		btnMovieDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				details.main(null);
			}
		});
		btnMovieDetails.setForeground(new Color(0, 0, 128));
		btnMovieDetails.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnMovieDetails.setBounds(502, 360, 334, 29);
		frame.getContentPane().add(btnMovieDetails);
		
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setBackground(new Color(25, 25, 112));
		txtrWelcomeToThe.setForeground(new Color(255, 215, 0));
		txtrWelcomeToThe.setText("WELCOME TO THE CONVENIENT WAY OF BOOKING......BOOK YOUR FAVOURITE MOVIES BY KNOWING WHAT IS IT ABOUT \r\nBE WITH US IN THIS WONDERFUL EXPERIENCE...HURRY UP SEATS ARE LIMITED...\r\n\r\nif trouble message us at stutibimali@gmail.com  OR  contact us at +91 9380106136 (WhatsApp OR  Viber)");
		txtrWelcomeToThe.setBounds(10, 391, 826, 76);
		frame.getContentPane().add(txtrWelcomeToThe);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(676, 281, 121, 76);
		Image img5=new ImageIcon(this.getClass().getResource("/pppp.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img5));
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea txtrClik = new JTextArea();
		txtrClik.setText("CLICK HERE TO SEE \r\nNOW SHOWING MOVIES");
		txtrClik.setBounds(689, 116, 147, 41);
		frame.getContentPane().add(txtrClik);
		
		JLabel side = new JLabel("");
		side.setBounds(637, 103, 183, 168);
		Image img6=new ImageIcon(this.getClass().getResource("/side.png")).getImage();
		side.setIcon(new ImageIcon(img6));
		frame.getContentPane().add(side);
		
		JTextArea txtrKnowAboutYour = new JTextArea();
		txtrKnowAboutYour.setBackground(Color.LIGHT_GRAY);
		txtrKnowAboutYour.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrKnowAboutYour.setText("KNOW ABOUT YOUR MOVIES HERE -->");
		txtrKnowAboutYour.setBounds(104, 360, 388, 29);
		frame.getContentPane().add(txtrKnowAboutYour);
		
	}
	}


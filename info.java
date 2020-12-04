package main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.mysql.jdbc.PreparedStatement;

import loginpage.login;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class info {

	JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					info window = new info();
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
	public info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 928, 590);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 894, 313);
		frame.getContentPane().add(scrollPane);
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		btnNewButton = new JButton("PRESS HERE TO GET INFO");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			
			public void actionPerformed(ActionEvent e) {
				String filepath="C:\\Users\\Stuti\\Desktop\\output.txt";
				File file=new File(filepath);
					try {
						BufferedReader br=new BufferedReader(new FileReader(file));
						String firstLine=br.readLine().trim();
						String[] columnsName=firstLine.split(" , ");
						
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						model.setColumnIdentifiers(columnsName);
						for(int i=1;i<5;i++)  
				        {    
				            try  
				            {  
				                Thread.sleep(200);  
				            }catch(InterruptedException e2){}    
				                
				        }    
						
						Object[] tableLines =br.lines().toArray();
						for(int i=0;i < tableLines.length;i++) {
							String line=tableLines[i].toString().trim();
							String[] dataRow = line.split(" / ");
							model.addRow(dataRow);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						br.close();
						
					} catch (FileNotFoundException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBounds(536, 140, 339, 65);
		frame.getContentPane().add(btnNewButton);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("BOOKING DETAILS OF USER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 50));
		lblNewLabel.setBackground(new Color(230, 230, 250));
		lblNewLabel.setBounds(56, 28, 819, 93);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("click here and wait for the result to be processed -->");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(198, 159, 339, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin.main(null);
			}
		});
		btnNewButton_1.setBounds(38, 138, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
				
			}
}

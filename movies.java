package main;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class movies {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movies window = new movies();
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
	public movies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 1278, 801);
		frame.getContentPane().setLayout(null);
		Image img5=new ImageIcon(this.getClass().getResource("/1.png")).getImage();
		Image img6=new ImageIcon(this.getClass().getResource("/2.png")).getImage();
		Image img7=new ImageIcon(this.getClass().getResource("/3.png")).getImage();
		Image img9=new ImageIcon(this.getClass().getResource("/5.png")).getImage();
		Image img10=new ImageIcon(this.getClass().getResource("/6.png")).getImage();
		Image img11=new ImageIcon(this.getClass().getResource("/7.png")).getImage();
		Image img12=new ImageIcon(this.getClass().getResource("/8.png")).getImage();
		Image img13=new ImageIcon(this.getClass().getResource("/9.png")).getImage();
		Image img14=new ImageIcon(this.getClass().getResource("/emo.png")).getImage();
		
		JLabel label = new JLabel("");
		label.setBounds(291, 22, 270, 389);
		frame.getContentPane().add(label);
		label.setIcon(new ImageIcon(img6));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 22, 276, 389);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(img5));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(811, 22, 277, 389);
		frame.getContentPane().add(label_2);
		label_2.setIcon(new ImageIcon(img7));
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(10, 421, 266, 340);
		frame.getContentPane().add(label_3);
		label_3.setIcon(new ImageIcon(img9));
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(571, 22, 230, 389);
		frame.getContentPane().add(label_4);
		label_4.setIcon(new ImageIcon(img10));
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(564, 422, 266, 340);
		frame.getContentPane().add(label_5);
		label_5.setIcon(new ImageIcon(img11));
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(840, 421, 248, 340);
		frame.getContentPane().add(label_6);
		label_6.setIcon(new ImageIcon(img12));
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(284, 421, 270, 340);
		frame.getContentPane().add(label_7);
		label_7.setIcon(new ImageIcon(img13));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1098, 290, 156, 164);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img14));
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				booking.main(null);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(1098, 637, 157, 54);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ticket.main(null);
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBook.setBackground(Color.GRAY);
		btnBook.setBounds(1098, 73, 157, 54);
		frame.getContentPane().add(btnBook);
		
	}

}

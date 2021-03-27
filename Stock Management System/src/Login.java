import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.sql.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.Label;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("login.jpg")).getImage();
		
		Label label_1 = new Label("Stock Management System");
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(80, 10, 674, 60);
		panel.add(label_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPassword.setBounds(10, 225, 163, 21);
		panel.add(lblPassword);
		
		JButton btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					try{
						   
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?serverTimezone=UTC","root","");
						Statement stmt=con.createStatement();
					String sql="Select * from login where uname='"+t1.getText()+"'  and pass='"+t2.getText().toString()+"'";
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next())
						  {
							JOptionPane.showMessageDialog(null,"Login Sucessfully");
					        setVisible(false);
							new StockAnalysis().main(null);
						   
							
						  }
						else {
						JOptionPane.showMessageDialog(null,"Invalid Login");
						t1.setText("");
						t2.setText("");
												
			 			}
						con.close();
						}
						catch(Exception ex){System.out.println(ex);}
						

			}
			
		});
		btnSubmit.setBounds(167, 270, 82, 25);
		panel.add(btnSubmit);
		
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setBackground(UIManager.getColor("Table.selectionBackground"));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUserName.setBounds(20, 172, 143, 21);
		panel.add(lblUserName);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(167, 175, 196, 23);
		panel.add(t1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				
			}
		});
		btnReset.setBounds(258, 270, 94, 25);
		panel.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frmLogin = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLogin,"Confirm If you want to exit","Login",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{	System.exit(0);	
				}
			}
		});
		btnExit.setBounds(258, 308, 94, 25);
		panel.add(btnExit);
		
		t2 = new JPasswordField();
		t2.setBounds(167, 221, 196, 25);
		panel.add(t2);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("LOGIN.jpg")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(0, 0, 849, 428);
		panel.add(label);
	
	}
}

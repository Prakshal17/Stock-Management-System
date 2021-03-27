import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.sql.*;
import java.awt.Label;

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTextField P1;
	private JTextField P2;
	private JTextField S4;
	private JTextField S1;
	private JTextField S2;
	private JTextField S3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
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
	public Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_1 = new Label("Edit");
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setAlignment(Label.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 45));
		label_1.setBounds(230, 32, 153, 52);
		contentPane.add(label_1);
		
		P1 = new JTextField();
		P1.setColumns(10);
		P1.setBounds(168, 143, 114, 21);
		contentPane.add(P1);
		
		JLabel lblProductname = new JLabel("Product_Name");
		lblProductname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblProductname.setBounds(294, 148, 128, 16);
		contentPane.add(lblProductname);
		
		JLabel label_2 = new JLabel("Stock_Sold:");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_2.setBounds(32, 190, 114, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Stock_left:");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_3.setBounds(309, 190, 98, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Stock_required:");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_4.setBounds(12, 236, 153, 16);
		contentPane.add(label_4);
		
		JLabel Price = new JLabel("Stock_price:");
		Price.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Price.setBounds(309, 234, 114, 21);
		contentPane.add(Price);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("com.mysql.jdbc.Driver");

				String sql="INSERT INTO Stockanal"+"(`Product_id`, `Product_Name`, `Stock_Sold`, `Stock_Left`, `Stock_required`,`Price`)"+" VALUES (?,?,?,?,?,?)";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?serverTimezone=UTC","root","");

				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, P1.getText());
				pst.setString(2, P2.getText());
				pst.setString(3, S1.getText());
				pst.setString(4, S2.getText());
				pst.setString(5, S3.getText());
				pst.setString(6, S4.getText());


				
				pst.executeUpdate();

				JOptionPane.showMessageDialog(null, "Added Sucessfully");


				}

				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnUpdate.setBounds(440, 297, 128, 25);
		contentPane.add(btnUpdate);
		
		P2 = new JTextField();
		P2.setColumns(10);
		P2.setBounds(434, 143, 134, 22);
		contentPane.add(P2);
		
		S4 = new JTextField();
		S4.setColumns(10);
		S4.setBounds(435, 235, 133, 22);
		contentPane.add(S4);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockAnalysis().main(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(440, 335, 128, 25);
		contentPane.add(btnBack);
		
		JLabel lblProductid = new JLabel("Product_id:");
		lblProductid.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblProductid.setBounds(12, 142, 143, 21);
		contentPane.add(lblProductid);
		
		S1 = new JTextField();
		S1.setBounds(168, 190, 116, 20);
		contentPane.add(S1);
		S1.setColumns(10);
		
		S2 = new JTextField();
		S2.setBounds(435, 190, 133, 20);
		contentPane.add(S2);
		S2.setColumns(10);
		
		S3 = new JTextField();
		S3.setBounds(183, 236, 86, 20);
		contentPane.add(S3);
		S3.setColumns(10);
		
		JLabel lbl = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("edit2.jpg")).getImage();
		lbl.setIcon(new ImageIcon(img));
		lbl.setBounds(0, 0, 675, 405);
		contentPane.add(lbl);
		
		
	}
}

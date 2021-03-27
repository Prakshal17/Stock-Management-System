import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class Newstock extends JFrame {

	private JPanel contentPane;
	private JTextField P1;
	private JLabel lblProductname;
	private JLabel lblProducttype;
	private JLabel lblQuantity;
	private JLabel lblDateofArrival;
	private JTextField P2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newstock frame = new Newstock();
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
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	private JTextField textField;
	private JLabel label;
	private Label label_1;
	
	public Newstock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_1 = new Label("New Stock");
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 45));
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(236, 67, 328, 60);
		contentPane.add(label_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(245, 262, 158, 22);
		contentPane.add(dateChooser);
		
		
		textField = new JTextField();
		textField.setBounds(249, 333, 154, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		P1 = new JTextField();
		P1.setBounds(625, 202, 154, 25);
		contentPane.add(P1);
		P1.setColumns(10);
		
		lblProductname = new JLabel("Product_Name:");
		lblProductname.setForeground(Color.BLACK);
		lblProductname.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductname.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblProductname.setBounds(46, 200, 187, 21);
		contentPane.add(lblProductname);
		
		lblProducttype = new JLabel("Category:");
		lblProducttype.setForeground(Color.BLACK);
		lblProducttype.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducttype.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblProducttype.setBounds(475, 263, 138, 29);
		contentPane.add(lblProducttype);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.BLACK);
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblQuantity.setBounds(105, 330, 128, 26);
		contentPane.add(lblQuantity);
		
		lblDateofArrival = new JLabel("Date_of_Arrival:");
		lblDateofArrival.setForeground(Color.BLACK);
		lblDateofArrival.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateofArrival.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDateofArrival.setBounds(49, 262, 184, 21);
		contentPane.add(lblDateofArrival);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Books", "Sports", "Furniture", "Medical Supplies", "Food  Essentials", "Personal Essentials"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setBounds(625, 258, 154, 26);
		contentPane.add(comboBox);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		
		JButton btnAddToStocklist = new JButton("Add To Stocklist");
		btnAddToStocklist.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddToStocklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
				Class.forName("com.mysql.jdbc.Driver");

				String sql="INSERT INTO newstock"+"(`Product_Name`, `Product_id`, `Category`, `Quantity`,`date`)"+" VALUES (?,?,?,?,?)";
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?serverTimezone=UTC","root","");

				pst=con.prepareStatement(sql);
				pst.setString(1, P2.getText());
				pst.setString(2, P1.getText());
				pst.setString(3, (String)comboBox.getSelectedItem());
				pst.setString(4, textField.getText());

				
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String date=sdf.format(dateChooser.getDate());
				pst.setString(5,date);

				pst.executeUpdate();

				JOptionPane.showMessageDialog(null, "Added Sucessfully");


				}

				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null, e);
				}
				

			}
		});
		btnAddToStocklist.setBounds(550, 395, 138, 25);
		contentPane.add(btnAddToStocklist);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockAnalysis().main(null);
				setVisible(false);
			}
		});
		button.setBounds(550, 433, 138, 22);
		contentPane.add(button);
		
		JLabel lblProductid = new JLabel("Product_ID:");
		lblProductid.setForeground(Color.BLACK);
		lblProductid.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductid.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblProductid.setBounds(457, 200, 143, 21);
		contentPane.add(lblProductid);
		
		P2 = new JTextField();
		P2.setColumns(10);
		P2.setBounds(245, 203, 158, 22);
		contentPane.add(P2);
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("newstock.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(-71, 0, 901, 583);
		contentPane.add(label);
		
		
		

	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Color;

public class Sellquantity extends JFrame {

	private JPanel contentPane;
	private JTextField P1;
	private JTextField P2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sellquantity frame = new Sellquantity();
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
	public Sellquantity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductid = new JLabel("Product_Id:");
		lblProductid.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblProductid.setBounds(39, 247, 246, 47);
		contentPane.add(lblProductid);
		
		P1 = new JTextField();
		P1.setColumns(10);
		P1.setBounds(338, 258, 199, 36);
		contentPane.add(P1);
		
		JLabel lblSellQuantity_1 = new JLabel("Sell_Quantity:");
		lblSellQuantity_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblSellQuantity_1.setBounds(39, 320, 288, 53);
		contentPane.add(lblSellQuantity_1);
		
		P2 = new JTextField();
		P2.setColumns(10);
		P2.setBounds(339, 327, 198, 36);
		contentPane.add(P2);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new StockAnalysis().main(null);
			setVisible(false);
			}
		});
		button.setBounds(338, 475, 180, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Add to Sold");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setBounds(337, 427, 180, 36);
		contentPane.add(button_1);
		
		Label label = new Label("Sell Quantity");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 60));
		label.setBackground(Color.LIGHT_GRAY);
		label.setAlignment(Label.CENTER);
		label.setBounds(12, 35, 505, 78);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("sell2.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(0, 0, 968, 680);
		contentPane.add(label_1);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Statement statement=null;
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?serverTimezone=UTC","root","");
 
                    Statement stmt=con.createStatement();
                    String query="insert into sell(Product_id,Sell_Quantity) values (?,?)";
                    PreparedStatement preparedStmt=con.prepareStatement(query);
                    preparedStmt.setString(1, P1.getText());
                    preparedStmt.setString(2, P2.getText());
                    JOptionPane.showMessageDialog(null,"Saved");
                    
                    preparedStmt.executeUpdate();
                    String sql = "SELECT Product_id,Sell_Quantity FROM sell";
					ResultSet rs = stmt.executeQuery(sql);
					int Product_id  = rs.getInt("Product_id");
			         int Sell_Quantity = rs.getInt("Sell_Quantity");
                    System.out.print("Product_id: " +Product_id);
                    System.out.print(",Sell_Quantity: " +Sell_Quantity);
                   
					
				}catch(Exception e1) {
					System.out.print(e1);
				}
			}
		});

				
			
		
		/*JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("sellquantity.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(-157, 45, 792, 442);
		contentPane.add(label);*/
	}
}

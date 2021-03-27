import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class stk extends JFrame {

private JPanel contentPane;
private JTextField P2;
private JLabel lblStockprice;
private JTextField S4;
private JTextField P1;
private JTextField S1;
private JTextField S2;
private JTextField S3;
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				stk frame = new stk();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}


/**
* Create the frame.
* @throws ClassNotFoundException
*/
public stk(){
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 637, 441);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

Label label = new Label("Stock Requirement");
label.setForeground(Color.BLACK);
label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
label.setBackground(Color.LIGHT_GRAY);
label.setAlignment(Label.CENTER);
label.setBounds(167, 10, 330, 41);
contentPane.add(label);

P2 = new JTextField();
P2.setColumns(10);
P2.setBounds(480, 93, 128, 22);
contentPane.add(P2);

JLabel lblProductid = new JLabel("Product_Name:");
lblProductid.setForeground(Color.YELLOW);
lblProductid.setFont(new Font("Times New Roman", Font.BOLD, 25));
lblProductid.setBounds(307, 92, 179, 23);
contentPane.add(lblProductid);

JLabel lblStocksold = new JLabel("Stock_Sold:");
lblStocksold.setForeground(Color.YELLOW);
lblStocksold.setFont(new Font("Times New Roman", Font.BOLD, 25));
lblStocksold.setBounds(12, 142, 137, 22);
contentPane.add(lblStocksold);

JLabel lblStockleft = new JLabel("Stock_left:");
lblStockleft.setForeground(Color.YELLOW);
lblStockleft.setFont(new Font("Times New Roman", Font.BOLD, 25));
lblStockleft.setBounds(340, 145, 128, 22);
contentPane.add(lblStockleft);

JLabel lblStockrequired = new JLabel("Stock_required:");
lblStockrequired.setForeground(Color.YELLOW);
lblStockrequired.setFont(new Font("Times New Roman", Font.BOLD, 25));
lblStockrequired.setBounds(12, 242, 192, 22);
contentPane.add(lblStockrequired);

lblStockprice = new JLabel("Stock_price:");
lblStockprice.setForeground(Color.YELLOW);
lblStockprice.setFont(new Font("Times New Roman", Font.BOLD, 25));
lblStockprice.setBounds(12, 193, 153, 29);
contentPane.add(lblStockprice);

S4 = new JTextField();
S4.setColumns(10);
S4.setBounds(167, 193, 128, 22);
contentPane.add(S4);

JButton btnAddNewStock = new JButton("Edit");
btnAddNewStock.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
new Edit().main(null);
setVisible(false);
}
});
btnAddNewStock.setBounds(443, 297, 128, 25);
contentPane.add(btnAddNewStock);

JButton button = new JButton("Back");
button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	new StockAnalysis().main(null);
	setVisible(false);
	}
});
button.setBounds(447, 335, 124, 25);
contentPane.add(button);

JLabel lblProductid_1 = new JLabel("Product_Id:");
lblProductid_1.setForeground(Color.YELLOW);
lblProductid_1.setHorizontalAlignment(SwingConstants.CENTER);
lblProductid_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
lblProductid_1.setBounds(12, 88, 143, 21);
contentPane.add(lblProductid_1);

P1 = new JTextField();
P1.setColumns(10);
P1.setBounds(167, 93, 128, 20);
contentPane.add(P1);
S1 = new JTextField();
S1.setBounds(167, 142, 128, 25);
contentPane.add(S1);
S1.setColumns(10);
S2 = new JTextField();
S2.setBounds(480, 145, 128, 20);
contentPane.add(S2);
S2.setColumns(10);
S3 = new JTextField();
S3.setBounds(205, 247, 128, 20);
contentPane.add(S3);
S3.setColumns(10);
JButton Submit = new JButton("Submit");
Submit.addActionListener(new ActionListener() {
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
Submit.setBounds(307, 298, 126, 23);
contentPane.add(Submit);
JLabel label_1 = new JLabel("");
Image img = new ImageIcon(this.getClass().getResource("stkinfo.jpg")).getImage();
label_1.setIcon(new ImageIcon(img));
label_1.setBounds(0, 0, 626, 415);
contentPane.add(label_1);



}
}
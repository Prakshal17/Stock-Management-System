import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class StockAnalysis extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
StockAnalysis frame = new StockAnalysis();
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
public StockAnalysis(){
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 718, 541);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnRequestNewStock = new JButton("Add New Stock");
btnRequestNewStock.setFont(new Font("Times New Roman", Font.BOLD, 13));
btnRequestNewStock.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
new Newstock().main(null);
setVisible(false);
}
});
Label label = new Label("Stock Analysis");
label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
label.setBackground(Color.LIGHT_GRAY);
label.setAlignment(Label.CENTER);
label.setBounds(230, 127, 328, 60);
contentPane.add(label);
btnRequestNewStock.setBounds(0, 0, 128, 41);
contentPane.add(btnRequestNewStock);

JButton btnBack = new JButton("Logout");
btnBack.setFont(new Font("Times New Roman", Font.BOLD, 13));
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
new Login().main(null);
setVisible(false);
}
});
btnBack.setBounds(368, 0, 95, 41);
contentPane.add(btnBack);

JButton btnSellQuantity = new JButton("Sell Quantity");
btnSellQuantity.setFont(new Font("Times New Roman", Font.BOLD, 13));
btnSellQuantity.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
new Sellquantity().main(null);
setVisible(false);
}
});
btnSellQuantity.setBounds(127, 0, 111, 41);
contentPane.add(btnSellQuantity);
JButton btnStockAnalysis = new JButton("Stock Requirement");
btnStockAnalysis.setFont(new Font("Times New Roman", Font.BOLD, 13));
btnStockAnalysis.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		new stk().main(null);
		setVisible(false);
	}
});
btnStockAnalysis.setBounds(230, 0, 140, 41);
contentPane.add(btnStockAnalysis);
JLabel label_1 = new JLabel("");
Image img = new ImageIcon(this.getClass().getResource("stkan1.jpg")).getImage();
label_1.setIcon(new ImageIcon(img));
label_1.setBounds(-19, -77, 846, 601);
contentPane.add(label_1);
 

}
}

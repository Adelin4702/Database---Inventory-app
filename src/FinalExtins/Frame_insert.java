package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Frame_insert extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/** 
	 * Create the frame.
	 */
	public Frame_insert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(169, 98, 154, 20);
		contentPane.add(textField_1);
		
		JLabel lblCuloare = new JLabel("idp : ");
		lblCuloare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuloare.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuloare.setBounds(92, 97, 82, 20);
		contentPane.add(lblCuloare);
		
		Label label = new Label("INSERT PIESA ");
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		label.setAlignment(Label.CENTER);
		label.setBounds(10, 38, 414, 27);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(169, 135, 154, 20);
		contentPane.add(textField_2);
		
		JLabel lblNumep_1 = new JLabel("numep : ");
		lblNumep_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumep_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumep_1.setBounds(92, 134, 82, 20);
		contentPane.add(lblNumep_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(169, 173, 154, 20);
		contentPane.add(textField_3);
		
		JLabel lblCuloare_2 = new JLabel("culoare : ");
		lblCuloare_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuloare_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuloare_2.setBounds(92, 172, 82, 20);
		contentPane.add(lblCuloare_2);
		
		btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "admin");
						Statement st = con.createStatement();) {
					String query = "insert into piese(idp, numep, culoare) values (" + textField_1.getText() + ", '" + textField_2.getText() + "', '" + textField_3.getText() + "');"; 
					int count = st.executeUpdate(query);
					
					if( count == 0 ) {
						System.out.println("Record not inserted");
					} else {
						System.out.println("record inserted");
					}

					JOptionPane.showMessageDialog(null,"Piesa introdusa cu succes","Successful insertion",1);
					//ft.getscro
				} catch (SQLException se) {
					System.out.println(se.getMessage());
					se.printStackTrace();
					JOptionPane.showMessageDialog(null,se,"Error",1);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1,"Error",1);
				} 
			}
		});
		btnNewButton.setBounds(170, 217, 102, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrameAltele_();
			}
		});
		btnNewButton_1.setBounds(364, 238, 70, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public void putFrameAltele_() {
		this.dispose();
		Frame_altele fa = new Frame_altele(); 
		fa.setVisible(true);
	}
}

package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Frame_delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/** 
	 * Create the frame.
	 */
	public Frame_delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Delete piesa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 39, 414, 26);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(206, 118, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("idp");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(139, 118, 57, 20);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "admin");
						Statement st = con.createStatement();) {
					String query = "Delete from piese where idp = " + textField.getText();
					int count = 9;
					count = st.executeUpdate(query);

					if (count == 0) {
						Exception c0 = new Exception("Nu exista piesa ");
						JOptionPane.showMessageDialog(null, c0, "Error", 1);
						System.out.println(c0.getMessage());
						c0.printStackTrace();
					} else {

						JOptionPane.showMessageDialog(null, "Piesa stearsa cu succes", "Successful deletion", 1);
					}

				} catch (SQLException se) {
					System.out.println(se.getMessage());
					se.printStackTrace();
					JOptionPane.showMessageDialog(null, se, "Error", 1);
				} catch (Exception c) {
					System.out.println(c.getMessage());
					c.printStackTrace();
					JOptionPane.showMessageDialog(null, c, "Error", 1);
				}
			}
		});
		btnNewButton.setBounds(184, 189, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				putFrameAltele_();
			}

		});
		btnNewButton_1.setBounds(366, 238, 68, 23);
		contentPane.add(btnNewButton_1);
	}

	public void putFrameAltele_() {
		this.dispose();
		Frame_altele fa = new Frame_altele();
		fa.setVisible(true);
	}
}

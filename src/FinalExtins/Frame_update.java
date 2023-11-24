package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frame_update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public Frame_update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(82, 113, 21, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(82, 151, 21, 23);
		contentPane.add(chckbxNewCheckBox_1);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(174, 76, 154, 20);
		contentPane.add(textField);

		JLabel lblCuloare = new JLabel("idp : ");
		lblCuloare.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuloare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuloare.setBounds(97, 75, 82, 20);
		contentPane.add(lblCuloare);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(174, 113, 154, 20);
		contentPane.add(textField_1);

		JLabel lblNumep_1 = new JLabel("numep : ");
		lblNumep_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumep_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumep_1.setBounds(97, 112, 82, 20);
		contentPane.add(lblNumep_1);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(174, 151, 154, 20);
		contentPane.add(textField_2);

		JLabel lblCuloare_2 = new JLabel("culoare : ");
		lblCuloare_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuloare_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuloare_2.setBounds(97, 150, 82, 20);
		contentPane.add(lblCuloare_2);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "admin");
						Statement st = con.createStatement();) {
					String query = "";
					if (chckbxNewCheckBox.isSelected() || chckbxNewCheckBox_1.isSelected()) {
						query = "update piese set ";
						if (chckbxNewCheckBox.isSelected() && chckbxNewCheckBox_1.isSelected()) {
							query = query + " numep = '" + textField_1.getText() + "' " + " , culoare = '"
									+ textField_2.getText() + "' ";
						} else {
							if (chckbxNewCheckBox.isSelected()) {
								query = query + " numep = '" + textField_1.getText() + "' ";
							}
							if (chckbxNewCheckBox_1.isSelected()) {
								query = query + " culoare = '" + textField_2.getText() + "' ";
							}
						}
						query = query + "where idp = '" + textField.getText() + "'"; 
					}
					int count = 0;
					if (!query.equals("")) {
						count = st.executeUpdate(query);
					}

					if (count == 0) {
						Exception c0 = new Exception("Nu se poate modifica ");
						JOptionPane.showMessageDialog(null, c0, "Error", 1);
						System.out.println(c0.getMessage());
						c0.printStackTrace();
					} else {

						JOptionPane.showMessageDialog(null, "Piesa modificata cu succes", "Successful update", 1);
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
		btnUpdate.setBounds(175, 195, 102, 33);
		contentPane.add(btnUpdate);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrameAltele_();
			}
		});
		btnNewButton_1.setBounds(364, 238, 70, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Update piesa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(0, 11, 434, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("**selectati campurile pe care  doriti sa le actualizati");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(0, 242, 271, 19);
		contentPane.add(lblNewLabel_1);
	}

	public void putFrameAltele_() {
		this.dispose();
		Frame_altele fa = new Frame_altele();
		fa.setVisible(true);
	}
}

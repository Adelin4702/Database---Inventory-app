package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Frame_3a extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/** 
	 * Create the frame.
	 */
	public Frame_3a() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Excercitiul 3 a)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 33, 414, 37);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 414, 45);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Să se găsească numele pieselor și culoarea pentru piesele al căror nume conține litera ’...’ pe a doua poziție, ordonat crescător după nume și descrescător după culoare.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putIntroFrame();
			}
		});
		btnNewButton.setBounds(366, 238, 68, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cautati");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String query = "SELECT numep, culoare FROM Piese  WHERE upper(numep) LIKE upper('_" + textField.getText() +"%') ORDER BY numep, culoare DESC ";
				createTable(query);
			}
		});
		btnNewButton_1.setBounds(168, 198, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(291, 156, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduceti litera de pe a doua pozitie");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(26, 155, 255, 20);
		contentPane.add(lblNewLabel_2);
	}
	
	void putIntroFrame() {
		Frame_intro fi = new Frame_intro();
		fi.setVisible(true);
		this.dispose();
	}
	
	public void createTable(String query) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "admin");
				Statement st = con.createStatement();) {
			Frame_tabel ft = new Frame_tabel("Să se găsească numele pieselor și culoarea pentru piesele al căror nume conține litera ’...’ pe a doua poziție, ordonat crescător după nume și descrescător după culoare. ");
			ft.setVisible(true);
			this.dispose();

			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			DefaultTableModel model = (DefaultTableModel) ft.getTable().getModel();

			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i + 1);  
			}
			model.setColumnIdentifiers(colName);  
			
			String[] columns_data = new String[cols];
			
			while(rs.next()) {
				for(int i = 0; i < cols; i++) {
					columns_data[i] = rs.getString(i+1); 
				} 
				model.addRow(columns_data);
			} 
			JLabel NewLabel = new JLabel("");
			NewLabel.setText("Să se găsească numele pieselor și culoarea pentru piesele al căror nume conține litera ’....’ pe a doua poziție, ordonat crescător după nume și descrescător după culoare."); 
			//ft.getscro
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}

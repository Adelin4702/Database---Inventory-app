package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_4a extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/** 
	 * Create the frame.
	 */
	public Frame_4a() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExcercitiulA = new JLabel("Excercitiul 4 a)");
		lblExcercitiulA.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcercitiulA.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblExcercitiulA.setBounds(10, 33, 414, 37);
		contentPane.add(lblExcercitiulA);
		
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
				String query = "SELECT numef, numep, pret, moneda, cantitate FROM Comenzi C JOIN Furnizori F ON (C.idf = F.idf)  JOIN Piese P ON (C.idp = P.idp)  JOIN Catalog CAT ON (CAT.idf = C.idf AND CAT.idp = C.idp)  WHERE ((pret*cantitate > "+ textField.getText() + " AND moneda = 'EUR') or (pret*cantitate > "+ textField.getText() + "*5 AND moneda = 'RON') or (pret*cantitate > "+ textField.getText() + "*1.05 AND moneda = 'USD')) ";
				System.out.println(query);
				createTable(query);
			}
		});
		btnNewButton_1.setBounds(168, 198, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(236, 156, 120, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Introduceti suma minima ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(26, 155, 231, 20);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 414, 54);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Să se găsească numef, numep, pret, cantitate pentru comenzile de piese cu pret mai mare decât ... EUR.");
		scrollPane.setViewportView(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EUR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(366, 159, 46, 14);
		contentPane.add(lblNewLabel_1);
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
			Frame_tabel ft = new Frame_tabel("Să se găsească numef, numep, pret, cantitate pentru comenzile de piese cu pret mai mare decât ... EUR.");
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
			JLabel NewLabel = new JLabel("Să se găsească numef, numep, pret, cantitate pentru comenzile de piese cu pret mai mare decât ... EUR."); 
			//ft.getscro
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	void putIntroFrame() {
		Frame_intro fi = new Frame_intro();
		fi.setVisible(true);
		this.dispose();
	}

}

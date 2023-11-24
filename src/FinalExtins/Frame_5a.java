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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_5a extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/** 
	 * Create the frame.
	 */
	public Frame_5a() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExcercitiulA_1 = new JLabel("Excercitiul 5 a)");
		lblExcercitiulA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcercitiulA_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblExcercitiulA_1.setBounds(10, 33, 414, 37);
		contentPane.add(lblExcercitiulA_1);
		
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
				String query = "call Ex_13_05_A( '" + textField.getText() + "' )";
				createTable(query);
			}
		});
		btnNewButton_1.setBounds(168, 198, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(251, 156, 152, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Introduceti numele furnizorului ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(26, 155, 231, 20);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 414, 56);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Să se găsească numele furnizorilor care apar pe aceleași comenzi cu furnizorul cu numele ’.....’");
		scrollPane.setViewportView(lblNewLabel);
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

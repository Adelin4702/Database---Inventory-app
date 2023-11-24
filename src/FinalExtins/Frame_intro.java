package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JMenuItem;

public class Frame_intro extends JFrame {
	private static String query;
	private static String labelText;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Frame_intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 313);
		getContentPane().setLayout(null);
 
		JLabel lblNewLabel = new JLabel("Proiectul nr. 13 ~ Pricop Petru Adelin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 31, 414, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Alegeti exercitiul al carui rezultat  sa se afiseze : ");
		lblNewLabel_1.setBounds(9, 84, 343, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Ex.  3 b)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrame3b();
			}
		});
		btnNewButton_1.setBounds(9, 172, 89, 46);
		getContentPane().add(btnNewButton_1);

		JButton btnExercitiulA = new JButton("Ex. 3 a)");
		btnExercitiulA.setBounds(9, 109, 89, 48);
		btnExercitiulA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrame3a();
			}
		});
		getContentPane().add(btnExercitiulA);

		JButton btnNewButton_1_1 = new JButton("Ex.  4 b)");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelText("Să se găsească perechile de coduri de furnizori (idf1, idf2) care oferă piese cu nume diferit de aceeași culoare cu același preț. O pereche este unică în rezultat.");
				setQuery( "SELECT CONCAT('( ',F1.idf,', ',F2.idf,' )') AS PERECHI_Furnizori FROM Catalog C1 CROSS JOIN Catalog C2 JOIN Furnizori F1 ON (C1.idf = F1.idf) JOIN Furnizori F2 ON (C2.idf = F2.idf) JOIN Piese P1 ON (C1.idp = P1.idp) JOIN Piese P2 ON (C2.idp = P2.idp) WHERE C1.idf < C2.idf AND P1.numep != P2.numep AND P1.culoare = P2.culoare AND C1.moneda = C2.moneda AND C1.pret = C2.pret");
				createTable(getQuery());
			}
		});
		btnNewButton_1_1.setBounds(117, 172, 89, 46);
		getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_2_1 = new JButton("Ex.  4 a)");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrame4a();
			}
		});
		btnNewButton_2_1.setBounds(117, 109, 89, 48);
		getContentPane().add(btnNewButton_2_1);

		JButton btnNewButton_1_2 = new JButton("Ex.  5 b)");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelText("Să se găsească numele piesei comandată în cantitatea cea mai mică.");
				setQuery(
						"SELECT numep, cantitate FROM Comenzi C JOIN Piese P ON (C.idp = P.idp) WHERE C.cantitate <= ALL (SELECT cantitate FROM Comenzi);");
				createTable(getQuery());
			}
		});
		btnNewButton_1_2.setBounds(228, 172, 89, 46);
		getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton_2_2 = new JButton("Ex.  5 a)");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrame5a();
			}
		});
		btnNewButton_2_2.setBounds(228, 109, 89, 48);
		getContentPane().add(btnNewButton_2_2);

		JButton btnNewButton_1_3 = new JButton("Ex.  6 b)");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelText("Să se găsească pentru fiecare idf și idp numărul total de piese comandate.");
				setQuery("SELECT idp, idf, SUM(cantitate) FROM Comenzi  GROUP BY idp, idf ORDER BY idp ");
				createTable(getQuery());
			}
		});
		btnNewButton_1_3.setBounds(334, 172, 89, 46);
		getContentPane().add(btnNewButton_1_3);

		JButton btnNewButton_2_3 = new JButton("Ex.  6 a)");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelText("Să se găsească pentru fiecare comandă și fiecare monedă prețul minim, prețul mediu și prețul maxim al pieselor comandate.");
				setQuery(
						"SELECT MIN(pret) Pret_minim , round(AVG(pret), 2) Pret_mediu, MAX(pret) Pret_maxim , moneda, IDC FROM Comenzi C JOIN Catalog CAT ON (C.idf = CAT.idf AND C.idp = CAT.idp) GROUP BY C.IDC, CAT.moneda ORDER BY C.IDC;");
				createTable(getQuery());
			}
		});
		btnNewButton_2_3.setBounds(334, 109, 89, 48);
		getContentPane().add(btnNewButton_2_3);
		
		JButton btnNewButton = new JButton("Altele");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrameAltele();
			}
		});
		btnNewButton.setBounds(9, 229, 415, 23);
		getContentPane().add(btnNewButton);
	}

	public static String getLabelText() {
		return labelText;
	}

	public static void setLabelText(String labelText) {
		Frame_intro.labelText = labelText;
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
			Frame_tabel ft = new Frame_tabel(this.getLabelText());
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
			JLabel NewLabel = new JLabel(this.getLabelText());
			NewLabel.setText(labelText); 
			//ft.getscro
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public static String getQuery() {
		return query;
	}

	public static void setQuery(String query) {
		Frame_intro.query = query;
	}
	
	public void putFrameAltele() {
		this.dispose();
		Frame_altele fa = new Frame_altele(); 
		fa.setVisible(true);
	}
	
	public void putFrame3a() {
		this.dispose();
		Frame_3a fa = new Frame_3a(); 
		fa.setVisible(true);
	}
	
	public void putFrame3b() {
		this.dispose();
		Frame_3b fa = new Frame_3b(); 
		fa.setVisible(true);
	}
	
	public void putFrame4a() {
		this.dispose();
		Frame_4a fa = new Frame_4a(); 
		fa.setVisible(true);
	}
	
	public void putFrame5a() {
		this.dispose();
		Frame_5a fa = new Frame_5a(); 
		fa.setVisible(true);
	}
}

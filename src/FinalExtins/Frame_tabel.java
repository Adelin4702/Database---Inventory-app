package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

public class Frame_tabel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Frame_tabel(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Revenire la meniul principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_intro fi = new Frame_intro();
				fi.setVisible(true);
				dispose_frame();
			}
		});
		btnNewButton.setBounds(237, 370, 192, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 650, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 650, 52);
		contentPane.add(scrollPane_1);
		
		JLabel lblNewLabel = new JLabel(s);
		scrollPane_1.setViewportView(lblNewLabel);

	} 

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void dispose_frame() {
		this.dispose();
	}

	public void populateWith_data(ResultSetMetaData rsmd) throws SQLException {
		

	}

	public TableModel getTableModel() {
		return table.getModel();
	}
	public void setTableModel(TableModel model) {
		table.setModel(model);
	}
}

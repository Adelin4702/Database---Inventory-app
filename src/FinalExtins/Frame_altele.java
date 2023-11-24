package FinalExtins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_altele extends JFrame {

	private JPanel contentPane;

	/** 
	 * Create the frame.
	 */
	public Frame_altele() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Altele : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 52, 414, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putInsertFrame();
			}
		});
		btnNewButton.setBounds(37, 142, 114, 40);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrame_update();
			}
		});
		btnUpdate.setBounds(161, 142, 114, 40);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrame_delete();
			}
		});
		btnDelete.setBounds(285, 142, 114, 40);
		contentPane.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFrameIntro();
			}
		});
		btnNewButton_1.setBounds(368, 238, 66, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public void putInsertFrame() {
		this.dispose();
		Frame_insert fi = new Frame_insert();
		fi.setVisible(true);
	}
	
	public void putFrameIntro() {
		this.dispose();
		Frame_intro frame = new Frame_intro();
		frame.setVisible(true);
	}
	
	public void putFrame_delete() {
		this.dispose();
		Frame_delete frame = new Frame_delete();
		frame.setVisible(true);
	}
	
	public void putFrame_update() {
		this.dispose();
		Frame_update frame = new Frame_update();
		frame.setVisible(true);
	}
}

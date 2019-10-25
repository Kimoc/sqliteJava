import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class interfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConectores = new JLabel("Conectores");
		lblConectores.setBounds(12, 12, 109, 26);
		contentPane.add(lblConectores);
		JLabel lblDriverDb = new JLabel("Driver DB");
		lblDriverDb.setBounds(67, 55, 66, 15);
		contentPane.add(lblDriverDb);
		
		JLabel lblOnChangeItem = new JLabel("No conectado");
		lblOnChangeItem.setBounds(33, 172, 114, 15);
		contentPane.add(lblOnChangeItem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblOnChangeItem.setText(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sqlite", "H2", "ApacheDerby", "MySql"}));
		comboBox.setBounds(163, 49, 205, 26);
		contentPane.add(comboBox);
		
		
	}
}

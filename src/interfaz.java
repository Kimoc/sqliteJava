import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfaz extends JFrame {

	private JPanel contentPane;
	private static  JTextField tfIdCliente;
	private static JTextField tfIdProducto;
	private static JTextField tfCantidad;
	private static JTextField tfId;
	
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
	public static void insertarSqlite() {
		String urlSqlite="./empresas.db";
		try {
		
			Connection conexionToSqlite = DriverManager.getConnection("jdbc:sqlite:" + urlSqlite);
			PreparedStatement statement = conexionToSqlite.prepareStatement("INSERT INTO ventas values(" 
					+ Integer.parseInt(tfId.getText())+","
					+ "CURRENT_TIMESTAMP"+","
					+ Integer.parseInt(tfIdCliente.getText()) +","
					+ Integer.parseInt(tfIdProducto.getText()) +","
					+ Integer.parseInt(tfCantidad.getText()) +")");
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se ha insertado el registro");
			
			conexionToSqlite.close();
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al insrter el registro");
			sqle.printStackTrace();
		}
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
		lblOnChangeItem.setBounds(223, 18, 114, 15);
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
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarSqlite();
			}
		});
		btnInsertar.setBounds(324, 236, 114, 25);
		contentPane.add(btnInsertar);
		
		
		
		
		
		
	
		tfIdCliente = new JTextField();
		tfIdCliente.setBounds(163, 164, 124, 19);
		contentPane.add(tfIdCliente);
		tfIdCliente.setColumns(10);
		
		tfIdProducto = new JTextField();
		tfIdProducto.setBounds(163, 204, 124, 19);
		contentPane.add(tfIdProducto);
		tfIdProducto.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(163, 239, 124, 19);
		contentPane.add(tfCantidad);
		tfCantidad.setColumns(10);
		
		JLabel lblIdProducto = new JLabel("ID CLIENTE");
		lblIdProducto.setBounds(67, 166, 124, 15);
		contentPane.add(lblIdProducto);
		
		JLabel lblNewLabel = new JLabel("ID PRODUCTO");
		lblNewLabel.setBounds(67, 206, 109, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(67, 241, 88, 15);
		contentPane.add(lblCantidad);
		
		tfId = new JTextField();
		tfId.setBounds(163, 133, 124, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(67, 135, 66, 15);
		contentPane.add(lblId);
		
		
	}
}

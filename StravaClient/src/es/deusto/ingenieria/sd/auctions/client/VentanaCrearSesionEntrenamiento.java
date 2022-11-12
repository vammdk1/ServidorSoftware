package es.deusto.ingenieria.sd.auctions.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class VentanaCrearSesionEntrenamiento extends JFrame {

	private JPanel contentPane;
	private JTextField titulo;
	private JTextField DiaIni;
	private JTextField MesIni;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_1_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearSesionEntrenamiento frame = new VentanaCrearSesionEntrenamiento();
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
	public VentanaCrearSesionEntrenamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creacion de sesion de entrenamiento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, 11, 543, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(129, 81, 139, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha y hora");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(129, 276, 139, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Distancia");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(129, 211, 139, 51);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Deporte");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(129, 149, 139, 51);
		contentPane.add(lblNewLabel_1_5);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		volver.setBounds(10, 394, 126, 51);
		contentPane.add(volver);
		
		titulo = new JTextField();
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setBounds(292, 94, 210, 32);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		DiaIni = new JTextField();
		DiaIni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DiaIni.setBounds(292, 286, 86, 32);
		contentPane.add(DiaIni);
		DiaIni.setColumns(10);
		
		MesIni = new JTextField();
		MesIni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MesIni.setColumns(10);
		MesIni.setBounds(416, 286, 86, 32);
		contentPane.add(MesIni);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(292, 221, 210, 32);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(292, 159, 210, 32);
		contentPane.add(textField_1);
		
		JButton crear = new JButton("Crear");
		crear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crear.setBounds(598, 394, 126, 51);
		contentPane.add(crear);
		
		lblNewLabel_1_2 = new JLabel("Duracion");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(128, 335, 139, 51);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(291, 345, 210, 32);
		contentPane.add(textField_2);
		
		lblNewLabel_1_3 = new JLabel("(dd/mm)   (hh:mm)");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(129, 298, 139, 51);
		contentPane.add(lblNewLabel_1_3);
	}
}

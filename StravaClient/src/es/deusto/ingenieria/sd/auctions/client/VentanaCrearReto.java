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

public class VentanaCrearReto extends JFrame {

	private JPanel contentPane;
	private JTextField titulo;
	private JTextField DiaIni;
	private JTextField DiaFin;
	private JTextField MesIni;
	private JTextField MesFin;
	private JTextField AñoIni;
	private JTextField AñoFin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearReto frame = new VentanaCrearReto();
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
	public VentanaCrearReto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creacion de reto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(203, 11, 344, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(109, 94, 139, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha inicio");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(109, 156, 139, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha fin");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(109, 218, 139, 51);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Objetivo");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(109, 342, 139, 51);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Deporte");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(109, 404, 139, 51);
		contentPane.add(lblNewLabel_1_5);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		volver.setBounds(10, 394, 126, 51);
		contentPane.add(volver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Distancia", "Tiempo"}));
		comboBox.setBounds(317, 289, 119, 40);
		contentPane.add(comboBox);
		
		titulo = new JTextField();
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setBounds(272, 107, 210, 32);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		DiaIni = new JTextField();
		DiaIni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DiaIni.setBounds(272, 169, 67, 32);
		contentPane.add(DiaIni);
		DiaIni.setColumns(10);
		
		DiaFin = new JTextField();
		DiaFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DiaFin.setColumns(10);
		DiaFin.setBounds(272, 231, 67, 32);
		contentPane.add(DiaFin);
		
		MesIni = new JTextField();
		MesIni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MesIni.setColumns(10);
		MesIni.setBounds(349, 169, 67, 32);
		contentPane.add(MesIni);
		
		MesFin = new JTextField();
		MesFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MesFin.setColumns(10);
		MesFin.setBounds(349, 231, 67, 32);
		contentPane.add(MesFin);
		
		AñoIni = new JTextField();
		AñoIni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AñoIni.setColumns(20);
		AñoIni.setBounds(426, 169, 67, 32);
		contentPane.add(AñoIni);
		
		AñoFin = new JTextField();
		AñoFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AñoFin.setColumns(20);
		AñoFin.setBounds(426, 231, 67, 32);
		contentPane.add(AñoFin);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(272, 352, 210, 32);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(272, 414, 210, 32);
		contentPane.add(textField_1);
		
		JButton crear = new JButton("Crear");
		crear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crear.setBounds(598, 394, 126, 51);
		contentPane.add(crear);
	}
}

package es.deusto.ingenieria.sd.auctions.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class VentanaCrearSesionEntrenamiento {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	VentanaCrearSesionEntrenamiento()
	{
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		VPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creacion de sesion de entrenamiento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(90, 11, 543, 59);
		VPrincipal.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(129, 81, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha y hora");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(129, 276, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Distancia");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(129, 211, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_6 = new JLabel("(km)");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_6.setBounds(236, 252, 32, 14);
		VPrincipal.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_5 = new JLabel("Deporte");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(129, 149, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_5);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		volver.setBounds(10, 394, 126, 51);
		VPrincipal.getContentPane().add(volver);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(292, 94, 210, 32);
		VPrincipal.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(292, 286, 86, 32);
		VPrincipal.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(416, 286, 86, 32);
		VPrincipal.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(292, 221, 210, 32);
		VPrincipal.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(292, 159, 210, 32);
		VPrincipal.getContentPane().add(textField_4);
		
		JButton crear = new JButton("Crear");
		crear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crear.setBounds(598, 394, 126, 51);
		VPrincipal.getContentPane().add(crear);
		
		JLabel lblNewLabel_1_2 = new JLabel("Duracion");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(128, 335, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_7 = new JLabel("(min)");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_7.setBounds(129, 358, 139, 40);
		VPrincipal.getContentPane().add(lblNewLabel_1_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(291, 345, 210, 32);
		VPrincipal.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_3 = new JLabel("(dd/mm)   (hh:mm)");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(129, 298, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_3);
		VPrincipal.setVisible(true);
		
		volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				new VentanaUsuario();
			}
		});
		
		crear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				new VentanaUsuario();
			}
		});
	}
}

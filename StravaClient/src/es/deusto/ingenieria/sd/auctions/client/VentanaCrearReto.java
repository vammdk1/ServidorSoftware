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

public class VentanaCrearReto {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	private JTextField titulo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	VentanaCrearReto()
	{
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		VPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creacion de reto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblNewLabel.setBounds(203, 11, 344, 59);
		VPrincipal.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(109, 94, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha inicio");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(109, 156, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("(dd/mm/aaaa) ");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(109, 180, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha fin");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(109, 218, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_6 = new JLabel("(dd/mm/aaaa) ");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_6.setBounds(109, 241, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_4 = new JLabel("Objetivo");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(109, 342, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Deporte");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(109, 404, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_5);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		volver.setBounds(10, 394, 126, 51);
		VPrincipal.getContentPane().add(volver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Distancia", "Tiempo"}));
		comboBox.setBounds(317, 289, 119, 40);
		VPrincipal.getContentPane().add(comboBox);
		
		JButton crear = new JButton("Crear");
		crear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crear.setBounds(598, 394, 126, 51);
		VPrincipal.getContentPane().add(crear);
		
		titulo = new JTextField();
		titulo.setBounds(272, 107, 210, 32);
		VPrincipal.getContentPane().add(titulo);
		titulo.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(272, 169, 67, 32);
		VPrincipal.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(272, 231, 67, 32);
		VPrincipal.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(349, 169, 67, 32);
		VPrincipal.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(349, 231, 67, 32);
		VPrincipal.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(20);
		textField_4.setBounds(426, 169, 67, 32);
		VPrincipal.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(20);
		textField_5.setBounds(426, 231, 67, 32);
		VPrincipal.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(272, 352, 210, 32);
		VPrincipal.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(272, 414, 210, 32);
		VPrincipal.getContentPane().add(textField_7);
		VPrincipal.setVisible(true);
	}
}

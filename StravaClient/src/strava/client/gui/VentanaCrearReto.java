package strava.client.gui;


import java.awt.Dimension; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import strava.client.controller.RetoController;
import strava.client.remote.ServiceLocator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VentanaCrearReto {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	private JTextField titulo;
	private JTextField tfInicioDia;
	private JTextField tfFinDia;
	private JTextField tfInicioMes;
	private JTextField tfFinMes;
	private JTextField tfInicioAno;
	private JTextField tfFinAno;
	private JTextField tfObjetivo;
	private JTextField tfDeporte;
	
	private RetoController controller;
	
	public VentanaCrearReto(RetoController reto)
	{
		this.controller = reto;

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
		
		tfInicioDia = new JTextField();
		tfInicioDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfInicioDia.setColumns(10);
		tfInicioDia.setBounds(272, 169, 67, 32);
		VPrincipal.getContentPane().add(tfInicioDia);
		
		tfFinDia = new JTextField();
		tfFinDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfFinDia.setColumns(10);
		tfFinDia.setBounds(272, 231, 67, 32);
		VPrincipal.getContentPane().add(tfFinDia);
		
		tfInicioMes = new JTextField();
		tfInicioMes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfInicioMes.setColumns(10);
		tfInicioMes.setBounds(349, 169, 67, 32);
		VPrincipal.getContentPane().add(tfInicioMes);
		
		tfFinMes = new JTextField();
		tfFinMes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfFinMes.setColumns(10);
		tfFinMes.setBounds(349, 231, 67, 32);
		VPrincipal.getContentPane().add(tfFinMes);
		
		tfInicioAno = new JTextField();
		tfInicioAno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfInicioAno.setColumns(20);
		tfInicioAno.setBounds(426, 169, 67, 32);
		VPrincipal.getContentPane().add(tfInicioAno);
		
		tfFinAno = new JTextField();
		tfFinAno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfFinAno.setColumns(20);
		tfFinAno.setBounds(426, 231, 67, 32);
		VPrincipal.getContentPane().add(tfFinAno);
		
		tfObjetivo = new JTextField();
		tfObjetivo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfObjetivo.setColumns(10);
		tfObjetivo.setBounds(272, 352, 210, 32);
		VPrincipal.getContentPane().add(tfObjetivo);
		
		tfDeporte = new JTextField();
		tfDeporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDeporte.setColumns(10);
		tfDeporte.setBounds(272, 414, 210, 32);
		VPrincipal.getContentPane().add(tfDeporte);
		VPrincipal.setVisible(false);
		
		volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				VentanaUsuario.VPrincipal.setVisible(true);
			}
		});
		
		crear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
				try {
					Date fechaInicio = format.parse(tfInicioDia.getText() + "-" + tfInicioMes.getText() + "-" + tfInicioAno.getText());
					Date fechaFin = format.parse(tfFinDia.getText() + "-" + tfFinMes.getText() + "-" + tfFinAno.getText());
					controller.crearReto(null, titulo.getText(), tfDeporte.getText(), fechaInicio, fechaFin, y, x);
					VPrincipal.setVisible(false);
					VentanaUsuario.VPrincipal.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					System.out.println("Formato de fecha incorrecto " + e);
				}
			}
		});
		
		
	}
}

package strava.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import strava.client.controller.SesionEntrenamientoController;
import strava.client.remote.ServiceLocator;
import strava.server.data.domain.User;
import strava.server.data.dto.DeportesDTO;

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
	private JTextField tfTitulo;
	private JTextField tfFecha;
	private JTextField tfHora;
	private JTextField tfDistancia;
	private JTextField tfDeporte;
	private JTextField tfDuracion;
	public static DeportesDTO tDeportes;
	
	private SesionEntrenamientoController controller;
	
	public VentanaCrearSesionEntrenamiento(SesionEntrenamientoController controller)
	{
		this.controller = controller;
		
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
		
		tfTitulo = new JTextField();
		tfTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(292, 94, 210, 32);
		VPrincipal.getContentPane().add(tfTitulo);
		
		tfFecha = new JTextField();
		tfFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfFecha.setColumns(10);
		tfFecha.setBounds(292, 286, 114, 32);
		VPrincipal.getContentPane().add(tfFecha);
		
		tfHora = new JTextField();
		tfHora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfHora.setColumns(10);
		tfHora.setBounds(416, 286, 86, 32);
		VPrincipal.getContentPane().add(tfHora);
		
		tfDistancia = new JTextField();
		tfDistancia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDistancia.setColumns(10);
		tfDistancia.setBounds(292, 221, 210, 32);
		VPrincipal.getContentPane().add(tfDistancia);
		
		
		JComboBox CbDeporte = new JComboBox();
		CbDeporte.setModel(new DefaultComboBoxModel(tDeportes.values()));
		CbDeporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CbDeporte.setBounds(292, 159, 210, 32);
		VPrincipal.getContentPane().add(CbDeporte);
		
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
		
		tfDuracion = new JTextField();
		tfDuracion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDuracion.setColumns(10);
		tfDuracion.setBounds(291, 345, 210, 32);
		VPrincipal.getContentPane().add(tfDuracion);
		
		JLabel lblNewLabel_1_3 = new JLabel("(dd/mm/yyyy)   (hh:mm)");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(129, 298, 139, 51);
		VPrincipal.getContentPane().add(lblNewLabel_1_3);
		VPrincipal.setVisible(false);
		
		
		
		volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("boton volver pulsado");
				VPrincipal.setVisible(false);
				VentanaUsuario.VPrincipal.setVisible(true);
				VentanaUsuario.actualizaSesiones();
			}
		});
		
		crear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date format;
				System.out.println("boton crear sesion pulsado");
				try {
					format = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(tfFecha.getText() + " " + tfHora.getText());
					System.out.println("intentando crear sesion con titulo: " + tfTitulo.getText() + " deporte " + " distancia: " + Float.parseFloat(tfDistancia.getText())+ " hora: " + format.toString() + " duracion " + Float.parseFloat(tfDuracion.getText()));
					DeportesDTO[] a = DeportesDTO.values();
					controller.crearSesionEntrenamiento(VentanaUsuario.getToken(), tfTitulo.getText(), a[CbDeporte.getSelectedIndex()], Float.parseFloat(tfDistancia.getText()), format, Float.parseFloat(tfDuracion.getText()));
					System.out.println(format.toString());
					VPrincipal.setVisible(false);
					VentanaUsuario.VPrincipal.setVisible(true);
					VentanaUsuario.actualizaSesiones();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					System.out.println("Formato de fecha y hora erróneos. Utilice el formato 'DD/MM/YYYY HH:MM'");
				}
			}
		});
	}
}

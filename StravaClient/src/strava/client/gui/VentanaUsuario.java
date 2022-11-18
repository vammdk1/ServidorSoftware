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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import strava.client.controller.LoginController;
import strava.client.remote.ServiceLocator;
import strava.server.data.domain.User;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaUsuario {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	
	private LoginController controller;
	private static User usuario;
	private JTable table;
	
	public VentanaUsuario(LoginController login)
	{
		this.controller = login;
		
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		VPrincipal.getContentPane().setLayout(null);
		
		JLabel lblPanelDeUsuario = new JLabel("Panel de usuario");
		lblPanelDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblPanelDeUsuario.setBounds(214, 10, 306, 51);
		VPrincipal.getContentPane().add(lblPanelDeUsuario);
		
		JButton CrearSesionEntrenamiento = new JButton("Crear sesion de entrenamiento");
		CrearSesionEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CrearSesionEntrenamiento.setBounds(416, 119, 295, 51);
		VPrincipal.getContentPane().add(CrearSesionEntrenamiento);
		
		JButton CrearReto = new JButton("Crear un reto");
		CrearReto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CrearReto.setBounds(473, 211, 178, 51);
		VPrincipal.getContentPane().add(CrearReto);
		
		JButton ConsultarReto = new JButton("Consultar un reto");
		ConsultarReto.setFont(new Font("Tahoma", Font.PLAIN, 18));	
		ConsultarReto.setBounds(473, 294, 178, 51);
		VPrincipal.getContentPane().add(ConsultarReto);
		
		JButton CerrarSesion = new JButton("Cerrar sesion");
		CerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CerrarSesion.setBounds(589, 407, 135, 43);
		VPrincipal.getContentPane().add(CerrarSesion);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 131, 345, 330);
		VPrincipal.getContentPane().add(panel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Titulo", "Deporte", "Distancia", "Duracion", "Fecha inicio"
			}
		));
		panel.add(table);
		VPrincipal.setVisible(false);
	
		CrearSesionEntrenamiento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton crear sesion de entrenamiento pulsado");
				VPrincipal.setVisible(false);
				VentanaCrearSesionEntrenamiento.VPrincipal.setVisible(true);
			}
		});
		
		CrearReto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton crear reto pulsado");
				VPrincipal.setVisible(false);
				VentanaCrearReto.VPrincipal.setVisible(true);
			}
		});

		ConsultarReto.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton consultar reto pulsado");
				VPrincipal.setVisible(false);
				VentanaRetosAceptados.VPrincipal.setVisible(true);
			}
		});

		CerrarSesion.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton cerrar sesion pulsado");
				controller.logout();
				VPrincipal.setVisible(false);
				VentanaLogin.VPrincipal.setVisible(true);
				System.exit(0);
			}
		});
	}

	public static User getUsuario() {
		return usuario;
	}

	public static void setUsuario(User usuario) {
		VentanaUsuario.usuario = usuario;
	}
}

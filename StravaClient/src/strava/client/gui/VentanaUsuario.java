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

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class VentanaUsuario {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	
	private LoginController controller;
	
	public VentanaUsuario(LoginController login)
	{
		this.controller = login;
		VPrincipal.setVisible(false);
		
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
		CrearSesionEntrenamiento.setBounds(214, 119, 295, 51);
		VPrincipal.getContentPane().add(CrearSesionEntrenamiento);
		
		JButton CrearReto = new JButton("Crear un reto");
		CrearReto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CrearReto.setBounds(270, 204, 178, 51);
		VPrincipal.getContentPane().add(CrearReto);
		
		JButton ConsultarReto = new JButton("Consultar un reto");
		ConsultarReto.setFont(new Font("Tahoma", Font.PLAIN, 18));	
		ConsultarReto.setBounds(270, 293, 178, 51);
		VPrincipal.getContentPane().add(ConsultarReto);
		
		JButton CerrarSesion = new JButton("Cerrar sesion");
		CerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CerrarSesion.setBounds(589, 407, 135, 43);
		VPrincipal.getContentPane().add(CerrarSesion);
		VPrincipal.setVisible(true);
	
		CrearSesionEntrenamiento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				VentanaCrearSesionEntrenamiento.VPrincipal.setVisible(true);
			}
		});
		
		CrearReto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				VentanaCrearReto.VPrincipal.setVisible(true);
			}
		});

		ConsultarReto.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				VentanaRetosAceptados.VPrincipal.setVisible(true);
			}
		});

		CerrarSesion.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logout();
				System.exit(0);
			}
		});
	}
}

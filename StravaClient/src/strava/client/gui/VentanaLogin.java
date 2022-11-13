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
import strava.client.controller.RegisterController;
import strava.client.remote.ServiceLocator;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class VentanaLogin {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	
	private LoginController controller;
	
	public VentanaLogin(LoginController login) {
		this.controller = login;
		
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		JPanel PanelGlobal = new JPanel();
		PanelGlobal.setLayout(null);
		
			//
		VPrincipal.getContentPane().setLayout((new BorderLayout()));
		
		JPanel panelInferior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelInferior.getLayout();
		VPrincipal.getContentPane().add(panelInferior, BorderLayout.SOUTH);
		
		//botones
		JPanel PBotones = new JPanel();
		panelInferior.add(PBotones);
		JPanel PBotones1 = new JPanel();
		JButton BRegistro = new JButton();
		BRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BRegistro.setText("Registrarme");
		JButton BInicioSecion = new JButton();
		BInicioSecion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BInicioSecion.setText("Iniciar Sesion");
		JPanel PBotones2 = new JPanel();
		JButton BGoogle = new JButton();
		BGoogle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BGoogle.setText("Iniciar con Google");
		JButton BFacebook = new JButton();
		BFacebook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BFacebook.setText("Iniciar con Facebook");
		PBotones1.add(BInicioSecion);
		PBotones1.add(BRegistro);
		PBotones2.add(BGoogle);
		PBotones2.add(BFacebook);
		PBotones.setLayout(new BorderLayout());
		PBotones.add(PBotones1,BorderLayout.NORTH);
		PBotones.add(PBotones2,BorderLayout.SOUTH);
		PBotones.setSize(x, y);
		VPrincipal.getContentPane().add(PanelGlobal,BorderLayout.CENTER);
		JTextArea Correo = new JTextArea();
		Correo.setFont(new Font("Monospaced", Font.PLAIN, 20));
		Correo.setBounds(37, 80, 663, 43);
		PanelGlobal.add(Correo);
		JPasswordField Contrasenna = new JPasswordField();
		Contrasenna.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Contrasenna.setBounds(37, 195, 663, 55);
		PanelGlobal.add(Contrasenna);
		
		JLabel lblCorreo = new JLabel("Correo electonico");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreo.setBounds(37, 24, 289, 50);
		PanelGlobal.add(lblCorreo);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasena.setBounds(37, 134, 163, 50);
		PanelGlobal.add(lblContrasena);
		
		JPanel panelSuperior = new JPanel();
		VPrincipal.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("STRAVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panelSuperior.add(lblTitulo);
		VPrincipal.setVisible(true);	
		
		BInicioSecion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				System.out.println("boton inicio de sesion pulsado");
				System.out.println("intentando Iniciar con correo: " + Correo.getText() + " y contrasena: " + Contrasenna.getText());
				if (controller.login(Correo.getText(), Contrasenna.getText())) {
					VentanaUsuario.VPrincipal.setVisible(true);
				}
			}
		});
		
		BRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				System.out.println("boton registro pulsado");
				VentanaRegistro.VPrincipal.setVisible(true);
			}
		});
		
	}
}

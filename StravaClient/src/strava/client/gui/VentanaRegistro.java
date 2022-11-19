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

import strava.client.controller.RegisterController;
import strava.client.remote.ServiceLocator;
import strava.server.data.dto.ProveedorDTO;
import strava.server.data.dto.UserDTO;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class VentanaRegistro {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	public static ProveedorDTO p;
	
	private RegisterController controller;
	
	public VentanaRegistro(RegisterController register){
		
		this.controller = register;
		
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
		BRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BRegistro.setText("Registrarme");
		JPanel PBotones2 = new JPanel();
		JButton BGoogle = new JButton();
		BGoogle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BGoogle.setText("Registrar con Google");
		JButton BFacebook = new JButton();
		BFacebook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BFacebook.setText("Registrar con Facebook");
		PBotones1.add(BRegistro);
		PBotones2.add(BGoogle);
		PBotones2.add(BFacebook);
		PBotones.setLayout(new BorderLayout());
		PBotones.add(PBotones1,BorderLayout.NORTH);
		PBotones.add(PBotones2,BorderLayout.SOUTH);
		PBotones.setSize(x, y);
		VPrincipal.getContentPane().add(PanelGlobal,BorderLayout.CENTER);
		JTextArea correo = new JTextArea();
		correo.setFont(new Font("Monospaced", Font.PLAIN, 20));
		correo.setBounds(37, 179, 663, 31);
		PanelGlobal.add(correo);
		JPasswordField contrasena = new JPasswordField();
		contrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contrasena.setBounds(37, 240, 663, 31);
		PanelGlobal.add(contrasena);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(37, 11, 289, 38);
		PanelGlobal.add(lblNombre);
		
		JTextArea nombre = new JTextArea();
		nombre.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nombre.setBounds(37, 122, 663, 31);
		PanelGlobal.add(nombre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaDeNacimiento.setBounds(37, 83, 289, 37);
		PanelGlobal.add(lblFechaDeNacimiento);
		
		JTextArea fecha = new JTextArea();
		fecha.setFont(new Font("Monospaced", Font.PLAIN, 20));
		fecha.setBounds(37, 53, 663, 31);
		PanelGlobal.add(fecha);
		
		JLabel lblCorreo = new JLabel("Correo electonico");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCorreo.setBounds(37, 150, 289, 31);
		PanelGlobal.add(lblCorreo);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasena.setBounds(37, 208, 163, 31);
		PanelGlobal.add(lblContrasena);
		
		JPanel panelSuperior = new JPanel();
		VPrincipal.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("STRAVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panelSuperior.add(lblTitulo);
		VPrincipal.setVisible(false);
	
		BRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				System.out.println("boton registro pulsado");
				UserDTO usuario = new UserDTO();
				//nombre.getText(), correo.getText(), fecha.getText(), 0f, 0, 0, 0, p.LOCAL
				usuario.setNombre(nombre.getText());
				usuario.setEmail(correo.getText());
				usuario.setFechancto(fecha.getText());
				System.out.println("creando usuario: " + usuario);
				VentanaRegistro2.setUsuario(usuario);
				VentanaRegistro2.setPassword(new String(contrasena.getPassword()));
				VentanaRegistro2.VPrincipal.setVisible(true);
			}
		});
	}
}

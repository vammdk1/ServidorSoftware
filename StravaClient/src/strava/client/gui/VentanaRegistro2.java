package strava.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

import strava.client.controller.RegisterController;
import strava.server.data.dto.UserDTO;

import javax.swing.JLabel;


public class VentanaRegistro2 {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	
	private RegisterController controller;
	private static UserDTO usuario;
	private static String password;
	
	public VentanaRegistro2(RegisterController register){
		
		this.controller = register;
		
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		JPanel PanelGlobal = new JPanel();
		PanelGlobal.setLayout(null);
		
			//
		VPrincipal.getContentPane().setLayout((new BorderLayout()));
		
		JPanel panelInferior = new JPanel();
		VPrincipal.getContentPane().add(panelInferior, BorderLayout.SOUTH);
		
		//botones
		JPanel PBotones = new JPanel();
		panelInferior.add(PBotones);
		JPanel PBotones1 = new JPanel();
		JButton BRegistro = new JButton();
		BRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BRegistro.setText("Continuar");
		PBotones1.add(BRegistro);
		PBotones.setLayout(new BorderLayout());
		PBotones.add(PBotones1,BorderLayout.NORTH);
		PBotones.setSize(x, y);
		VPrincipal.getContentPane().add(PanelGlobal,BorderLayout.CENTER);
		
		JTextField peso = new JTextField("0");
		peso.setFont(new Font("Monospaced", Font.PLAIN, 20));
		peso.setBounds(120, 70, 500, 31);
		PanelGlobal.add(peso);
		
		JLabel lblInfo = new JLabel("Esta informacion es opcional, si no quieres a\u00F1adirla pulsa en continuar.");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInfo.setBounds(86, 0, 560, 25);
		PanelGlobal.add(lblInfo);
		
		JLabel lblPeso = new JLabel("Peso(kg)");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPeso.setBounds(115, 30, 289, 38);
		PanelGlobal.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Frecuencia cardiaca maxima");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltura.setBounds(115, 100, 505, 38);
		PanelGlobal.add(lblAltura);
		
		JTextField frecMax = new JTextField("0");
		frecMax.setFont(new Font("Monospaced", Font.PLAIN, 20));
		frecMax.setBounds(120, 140, 500, 31);
		PanelGlobal.add(frecMax);
		
		JLabel lblAltura_1 = new JLabel("Frecuencia cardiaca en reposo");
		lblAltura_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltura_1.setBounds(115, 170, 505, 38);
		PanelGlobal.add(lblAltura_1);
		
		JTextField frecRep = new JTextField("0");
		frecRep.setFont(new Font("Monospaced", Font.PLAIN, 20));
		frecRep.setBounds(120, 210, 500, 31);
		PanelGlobal.add(frecRep);
		
		JLabel lblAltura_1_1 = new JLabel("Altura(cm)");
		lblAltura_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltura_1_1.setBounds(115, 240, 163, 38);
		PanelGlobal.add(lblAltura_1_1);
		
		JTextField altura = new JTextField("0");
		altura.setFont(new Font("Monospaced", Font.PLAIN, 20));
		altura.setBounds(120, 280, 500, 31);
		PanelGlobal.add(altura);
		
		JPanel panelSuperior = new JPanel();
		VPrincipal.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("STRAVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panelSuperior.add(lblTitulo);
		VPrincipal.setVisible(false);	
		
		BRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(getUsuario().getProveedor());
				System.out.println("Boton registro pulsado");
				VPrincipal.setVisible(false);
				try {
					getUsuario().setPeso(Float.parseFloat(peso.getText()));
					getUsuario().setAltura(Integer.parseInt(altura.getText()));
					getUsuario().setPulsoxMinuto(Integer.parseInt(frecMax.getText()));
					getUsuario().setPulsoReposo(Integer.parseInt(frecRep.getText()));
					System.out.println("intentando anadir al usuario el peso: " + Float.parseFloat(peso.getText()) + " la altura: " + Integer.parseInt(altura.getText()) + " el pulso max: " +  Integer.parseInt(frecMax.getText()) + " el pulso rep: " + Integer.parseInt(frecRep.getText()));
					controller.register(getUsuario().getNombre(), getUsuario().getEmail(), getUsuario().getFechancto(), getUsuario().getPeso(), getUsuario().getAltura(), getUsuario().getPulsoxMinuto(), getUsuario().getPulsoReposo(), getPassword(), getUsuario().getProveedor());
				} catch (Exception e2) {
					System.out.println("# Error en el registro "+ e2);
				}
				VentanaLogin.VPrincipal.setVisible(true);
			}
		});
	}

	public static UserDTO getUsuario() {
		return usuario;
	}

	public static void setUsuario(UserDTO usuario2) {
		VentanaRegistro2.usuario = usuario2;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		VentanaRegistro2.password = password;
	}
}

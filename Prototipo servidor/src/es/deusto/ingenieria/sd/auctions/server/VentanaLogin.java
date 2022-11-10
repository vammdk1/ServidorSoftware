package es.deusto.ingenieria.sd.auctions.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class VentanaLogin {
	static JFrame VPrincipal = new JFrame("Loggin");
	static int x = 500;
	static int y = 300;
	
	public static void main (String[] args) {
		
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(x,y));
		JPanel PanelGlobal = new JPanel();
			
		//botones
		JPanel PBotones = new JPanel();
			JPanel PBotones1 = new JPanel();
		JButton BRegistro = new JButton();
		BRegistro.setText("Registrarme");
		JButton BInicioSecion = new JButton();
		BInicioSecion.setText("Iniciar Seción");
			JPanel PBotones2 = new JPanel();
		JButton BGoogle = new JButton();
		BGoogle.setText("Iniciar con Google");
		JButton BFacebook = new JButton();
		BFacebook.setText("Iniciar con Facebook");
			
		//lineas de texto
		JPanel PTexto = new JPanel();
		PTexto.setLayout(new BorderLayout());
		JTextArea Correo = new JTextArea();
		JPasswordField Contrasenna = new JPasswordField();
		PTexto.add(Correo,BorderLayout.NORTH);
		PTexto.add(Contrasenna);
			
		//distribucion de botones
		PanelGlobal.setLayout(new BorderLayout());
		PanelGlobal.add(PTexto, BorderLayout.CENTER);
		PBotones1.add(BInicioSecion);
		PBotones1.add(BRegistro);
		PBotones2.add(BGoogle);
		PBotones2.add(BFacebook);
		PBotones.setLayout(new BorderLayout());
		PBotones.add(PBotones1,BorderLayout.NORTH);
		PBotones.add(PBotones2,BorderLayout.SOUTH);
		PBotones.setSize(x, y);
		PanelGlobal.add(PBotones, BorderLayout.SOUTH);
		
			//
		VPrincipal.setLayout((new BorderLayout()));
		VPrincipal.add(PanelGlobal,BorderLayout.CENTER);
		VPrincipal.setVisible(true);	
		
	}

}

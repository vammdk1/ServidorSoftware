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
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class VentanaRegistro2 {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	
	public VentanaRegistro2(){
		
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
		BRegistro.setText("Continuar");
		PBotones1.add(BRegistro);
		PBotones.setLayout(new BorderLayout());
		PBotones.add(PBotones1,BorderLayout.NORTH);
		PBotones.setSize(x, y);
		VPrincipal.getContentPane().add(PanelGlobal,BorderLayout.CENTER);
		
		JTextArea nombre = new JTextArea();
		nombre.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nombre.setBounds(120, 70, 500, 31);
		PanelGlobal.add(nombre);
		
		JLabel lblInfo = new JLabel("Esta informacion es opcional, si no quieres a\u00F1adirla pulsa en continuar.");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInfo.setBounds(86, 0, 560, 25);
		PanelGlobal.add(lblInfo);
		
		JLabel lblPeso = new JLabel("Peso(kg)");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPeso.setBounds(115, 30, 289, 38);
		PanelGlobal.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura(cm)");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltura.setBounds(115, 100, 163, 38);
		PanelGlobal.add(lblAltura);
		
		JTextArea nombre_1 = new JTextArea();
		nombre_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nombre_1.setBounds(120, 140, 500, 31);
		PanelGlobal.add(nombre_1);
		
		JLabel lblAltura_1 = new JLabel("Altura(cm)");
		lblAltura_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltura_1.setBounds(115, 170, 163, 38);
		PanelGlobal.add(lblAltura_1);
		
		JTextArea nombre_1_1 = new JTextArea();
		nombre_1_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nombre_1_1.setBounds(120, 210, 500, 31);
		PanelGlobal.add(nombre_1_1);
		
		JLabel lblAltura_1_1 = new JLabel("Altura(cm)");
		lblAltura_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltura_1_1.setBounds(115, 240, 163, 38);
		PanelGlobal.add(lblAltura_1_1);
		
		JTextArea nombre_1_1_1 = new JTextArea();
		nombre_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nombre_1_1_1.setBounds(120, 280, 500, 31);
		PanelGlobal.add(nombre_1_1_1);
		
		JPanel panelSuperior = new JPanel();
		VPrincipal.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("STRAVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panelSuperior.add(lblTitulo);
		VPrincipal.setVisible(true);	
		
		BRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				new VentanaUsuario();
			}
		});
	}
}

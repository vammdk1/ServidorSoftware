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

public class VentanaRetosAceptados {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	
	VentanaRetosAceptados()
	{
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		VPrincipal.getContentPane().setLayout(null);
		
		JPanel Retos = new JPanel();
		Retos.setBounds(29, 72, 684, 318);
		VPrincipal.getContentPane().add(Retos);
		
		JLabel lblNewLabel = new JLabel("Retos aceptados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(5, 5, 724, 49);
		VPrincipal.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 401, 107, 49);
		VPrincipal.getContentPane().add(btnNewButton);
		VPrincipal.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.setVisible(false);
				new VentanaUsuario();
			}
		});
	}
}

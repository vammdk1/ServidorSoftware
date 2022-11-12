package es.deusto.ingenieria.sd.auctions.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class VentanaRetosAceptados extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRetosAceptados frame = new VentanaRetosAceptados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRetosAceptados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Retos = new JPanel();
		Retos.setBounds(29, 72, 684, 318);
		contentPane.add(Retos);
		
		JLabel lblNewLabel = new JLabel("Retos aceptados");
		lblNewLabel.setBounds(5, 5, 724, 49);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(10, 401, 107, 49);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}

}

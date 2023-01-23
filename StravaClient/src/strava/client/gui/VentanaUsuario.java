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
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

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
import strava.client.controller.RetoController;
import strava.client.controller.RetosAceptadosController;
import strava.client.controller.SesionEntrenamientoController;
import strava.client.remote.ServiceLocator;
import strava.server.data.dto.RetoDTO;
import strava.server.data.dto.SesionEntrenamientoDTO;

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
	private static SesionEntrenamientoController sController;
	private static RetosAceptadosController rAController;
	private JTable table;
	private static JTable tabla;
	
	private static long token;
	
	private static DefaultTableModel model;
	private static DefaultTableModel model1;
	private JTable table_1;
	
	public VentanaUsuario(LoginController login, SesionEntrenamientoController ses, RetosAceptadosController ret)
	{
		this.controller = login;
		this.sController = ses;
		this.rAController = ret;
		
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		VPrincipal.getContentPane().setLayout(null);
		
		JLabel lblPanelDeUsuario = new JLabel("Panel de usuario");
		lblPanelDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblPanelDeUsuario.setBounds(175, 10, 397, 51);
		VPrincipal.getContentPane().add(lblPanelDeUsuario);
		
		JButton CrearSesionEntrenamiento = new JButton("Crear sesion de entrenamiento");
		CrearSesionEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CrearSesionEntrenamiento.setBounds(416, 119, 295, 51);
		VPrincipal.getContentPane().add(CrearSesionEntrenamiento);
		
		JButton CrearReto = new JButton("Crear un reto");
		CrearReto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CrearReto.setBounds(473, 191, 178, 51);
		VPrincipal.getContentPane().add(CrearReto);
		
		JButton ConsultarReto = new JButton("Todos los retos");
		ConsultarReto.setFont(new Font("Tahoma", Font.PLAIN, 18));	
		ConsultarReto.setBounds(473, 268, 178, 51);
		VPrincipal.getContentPane().add(ConsultarReto);
		
		JButton CerrarSesion = new JButton("Cerrar sesion");
		CerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CerrarSesion.setBounds(589, 407, 135, 43);
		VPrincipal.getContentPane().add(CerrarSesion);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 131, 385, 319);
		VPrincipal.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Area de entrenamientos
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new String[][] {
				{"Titulo", "Deporte", "Distancia", "Duracion", "Fecha inicio"},
			},
			new String[] {
				"Titulo", "Deporte", "Distancia", "Duracion", "Fecha inicio"
			}
		));
		panel.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre", "Fecha Inicio", "Fecha Fin", "Objetivo", "Deporte", "Porcentaje"},
			},
			new String[] {
				"Nombre", "Fecha Inicio", "Fecha Fin", "Objetivo", "Deporte", "Porcentaje"
			}
		));
		panel.add(table_1);
		
		JButton MisRetos = new JButton("MisRetos");
		MisRetos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MisRetos.setBounds(473, 345, 178, 51);
		//VPrincipal.getContentPane().add(MisRetos);
		
		model = (DefaultTableModel) table.getModel();
		model1 = (DefaultTableModel) table_1.getModel();
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
				System.out.println("Boton consultar reto pulsado \n");
				//TODO solicitar retos y mandarlos a la ventana ?
				VPrincipal.setVisible(false);
				//VentanaRetosActivos.VPrincipal.();
				VentanaRetosActivos.ActualizaReto();
				VentanaRetosActivos.VPrincipal.setVisible(true);
			}
		});
		
		
		MisRetos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton mirar mis retos pulsado");
				//TODO solicitar retos y mandarlos a la ventana ?
				VPrincipal.setVisible(false);
				//VentanaRetosActivos.VPrincipal.();
				VentanaRetosAceptados.ActualizaReto();
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


	public static long getToken() {
		return token;
	}


	public static void setToken(long token) {
		VentanaUsuario.token = token;
	}
	
	public static void actualizaSesiones() {
        List<SesionEntrenamientoDTO> sesiones = sController.getSesiones(token);
        try {
            model.setNumRows(1);
            for (SesionEntrenamientoDTO sesion : sesiones) {
                //"Titulo", "Deporte", "Distancia", "Duracion", "Fecha inicio"
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //No funciona bien el día
                model.addRow(new String[]{sesion.getTitulo(), sesion.getDeporte()+"", sesion.getDistancia()+"", sesion.getDuracion()+"", sdf.format(sesion.getFechaHoraInicio())});
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("no hay sesiones de entrenamiento");
        }

    }
	
	public static void actualizaRetos() {
        System.out.println("actualizando Retos");
        Map<RetoDTO, Float> retos = rAController.getRetos(token);
        System.out.println("p1");
        try {
            model1.setNumRows(1);
            for(RetoDTO reto : retos.keySet()) 
            {
                //"nombre", "fecha", "objetivo", "deporte", "duracion"
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                model1.addRow(new String[] {reto.getNombre(),sdf.format(reto.getFechaIni()), sdf.format(reto.getFechaFin()), reto.getDistanciaObjetivo()+"",reto.getDeporte()+"",retos.get(reto)+""});
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("no hay retos");
        }

    }
}

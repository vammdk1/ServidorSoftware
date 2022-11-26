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

import strava.client.controller.RetosAceptadosController;
import strava.client.remote.ServiceLocator;
import strava.server.data.dto.RetoDTO;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class VentanaRetosAceptados {
	static JFrame VPrincipal = new JFrame("STRAVA");
	static int x = 500;
	static int y = 300;
	
	private static RetosAceptadosController controller;
	static JComboBox SelectorDeRetos;
	public VentanaRetosAceptados(RetosAceptadosController reto)
	{
		this.controller = reto;
		
		VPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VPrincipal.setSize(new Dimension(750, 500));
		VPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Retos aceptados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(5, 5, 724, 49);
		VPrincipal.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 401, 107, 49);
		VPrincipal.getContentPane().add(btnNewButton);
		
		JPanel Retos = new JPanel();
		Retos.setLayout(null);
		Retos.setBounds(29, 72, 684, 318);
		VPrincipal.getContentPane().add(Retos);
		
		SelectorDeRetos = new JComboBox();
		SelectorDeRetos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SelectorDeRetos.setBounds(211, 11, 239, 31);
		Retos.add(SelectorDeRetos);
		
		JLabel lbl = new JLabel("Fecha Inicio");
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl.setBounds(98, 70, 136, 31);
		Retos.add(lbl);
		
		JLabel FechaIni = new JLabel("00/00");
		FechaIni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FechaIni.setBounds(318, 70, 277, 31);
		Retos.add(FechaIni);
		
		JLabel lbl_1 = new JLabel("Fecha Fin");
		lbl_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_1.setBounds(98, 123, 136, 31);
		Retos.add(lbl_1);
		
		JLabel FechaFin = new JLabel("00/00");
		FechaFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FechaFin.setBounds(318, 123, 277, 31);
		Retos.add(FechaFin);
		
		JLabel lbl_2 = new JLabel("Distancia Objetivo");
		lbl_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_2.setBounds(-66, 176, 208, 31);
		Retos.add(lbl_2);
		
		JLabel DistObj = new JLabel("0");
		DistObj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DistObj.setBounds(226, 176, 119, 31);
		Retos.add(DistObj);
		
		JLabel lbl_3 = new JLabel("Tiempo Objetivo");
		lbl_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_3.setBounds(-42, 227, 184, 31);
		Retos.add(lbl_3);
		
		JLabel TiObj = new JLabel("0");
		TiObj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TiObj.setBounds(226, 227, 119, 31);
		Retos.add(TiObj);
		
		JLabel lbl_4 = new JLabel("Deporte");
		lbl_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_4.setBounds(303, 165, 136, 31);
		Retos.add(lbl_4);
		
		JLabel Deporte = new JLabel("Null");
		Deporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Deporte.setBounds(523, 165, 151, 31);
		Retos.add(Deporte);
		
		JLabel lbl_4_1 = new JLabel("Porcentaje");
		lbl_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_4_1.setBounds(303, 227, 136, 31);
		Retos.add(lbl_4_1);
		
		JLabel Porcentaje = new JLabel("0");
		Porcentaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Porcentaje.setBounds(523, 227, 151, 31);
		Retos.add(Porcentaje);
		VPrincipal.setVisible(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton volver pulsado");
				VPrincipal.setVisible(false);
				VentanaUsuario.VPrincipal.setVisible(true);
			}
		});
		
		SelectorDeRetos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String a = (String) SelectorDeRetos.getSelectedItem();
				Map<RetoDTO,Float> todosRetos = controller.getRetos();
				RetoDTO ret = new RetoDTO();
				for (RetoDTO reto : todosRetos.keySet()) {
					if (reto.getNombre().equals(a)) {
						ret = reto;
						break;
					}
				}
				FechaIni.setText(sdf.format(ret.getFechaIni()));
				FechaFin.setText(sdf.format(ret.getFechaFin()));
				DistObj.setText(ret.getDistanciaObjetivo()+"");
				TiObj.setText(ret.getTiempoObjetivo()+"");
				Deporte.setText(ret.getDeporte().toString());
				Porcentaje.setText(todosRetos.get(ret)*100+"");
				/*
				int i = SelectorDeRetos.getSelectedIndex();
				Map<RetoDTO,Float> todosRetos = controller.getRetos();
				List<RetoDTO> retos = (List<RetoDTO>) todosRetos.keySet();
				
				FechaIni.setText(sdf.format(retos.get(i).getFechaIni()));
				FechaFin.setText(sdf.format(retos.get(i).getFechaFin()));
				DistObj.setText(retos.get(i).getDistanciaObjetivo()+"");
				TiObj.setText(retos.get(i).getTiempoObjetivo()+"");
				Deporte.setText(retos.get(i).getDeporte().toString());
				Porcentaje.setText(todosRetos.get(retos.get(i))+"");
				*/
			}
		});
	}
	
	
	public static void ActualizaReto() {
		try {
			System.out.println("Obteniendo retos . . .");
			Map<RetoDTO, Float> retos = controller.getRetos();
			SelectorDeRetos.removeAllItems();
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			for (RetoDTO reto : retos.keySet()) {
				System.out.println("prueba . . .");
				
				System.out.println(reto.getNombre() + " " +
						reto.getDeporte() + " " +
						reto.getDistanciaObjetivo() + " " +
						reto.getTiempoObjetivo() + " " +
						reto.getFechaIni() + " " +
						reto.getFechaFin());
				SelectorDeRetos.addItem(reto.getNombre());
			}
		} catch (Exception e) {
			System.out.println("Error actualizando");
		}
		
	}
}

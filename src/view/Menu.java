package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 769);
		panelMenu = new JPanel();
		panelMenu.setBackground(Color.LIGHT_GRAY);
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelMenu);
		panelMenu.setLayout(new MigLayout("", "[20][210][20]", "[69.00][][57.00][][57.00][][57.00][][grow][57.00][]"));
		
		JLabel lblimage_Menu = new JLabel("New label");
		panelMenu.add(lblimage_Menu, "cell 1 0");
		
		JButton btnInventario_Menu = new JButton("INVENTARIO");
		btnInventario_Menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInventario_Menu.addActionListener(listener);
		btnInventario_Menu.setActionCommand("menu_inventario");
		panelMenu.add(btnInventario_Menu, "cell 1 2,grow");
		
		JButton btnHistorial_Menu = new JButton("HISTORIAL");
		btnHistorial_Menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHistorial_Menu.addActionListener(listener);
		btnHistorial_Menu.setActionCommand("menu_historial");
		panelMenu.add(btnHistorial_Menu, "cell 1 4,grow");
		
		JButton btnCrearProducto_Menu = new JButton("CREAR PRODUCTO");
		btnCrearProducto_Menu.addActionListener(listener);
		btnCrearProducto_Menu.setActionCommand("menu_crear");
		btnCrearProducto_Menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelMenu.add(btnCrearProducto_Menu, "cell 1 6,grow");
		
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.addActionListener(listener);
		btnCerrarSesion.setActionCommand("menu_cerrar");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelMenu.add(btnCerrarSesion, "cell 1 9,grow");
	}

}

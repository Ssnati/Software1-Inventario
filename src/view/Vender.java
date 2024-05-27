package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Shape;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class Vender extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldPrecioVenta;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldCantidadEnStock;
	private JTextField textFieldMarca;
	private JTextArea txtDescripcion;
	private JTextField cantidad;
	private JLabel lblAviso;
	private JButton btnSell;
	private JTextField textFieldProfit;
	private JFrame jf;

	public Vender(JFrame frame, boolean modal,ActionListener listener) {
		super(frame, modal);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		jf=new JFrame();
		jf.setAlwaysOnTop(true);
		setAlwaysOnTop(true);
		
		double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setUndecorated(true);
		Shape forma = new RoundRectangle2D.Double(0, 0, ancho*0.55, alto*0.8, 30, 30);
		this.setShape(forma);
		this.setLocationRelativeTo(null);
		
		JPanel seePane = new JPanel();
		seePane.setBorder(new RoundBorder(new Color(0, 0, 0), 1, true,30,30));
		setBounds((int)(ancho/2-(ancho*0.55)/2), (int)(alto/2-(alto*0.7)/2),(int)(ancho*0.55),(int)(alto*0.8));
		setContentPane(seePane);
		seePane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSuperior = new JLabel("VENDER PRODUCTO");
		lblSuperior.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		lblSuperior.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperior.setFont(new Font("Tahoma", Font.PLAIN, 40));
		seePane.add(lblSuperior, BorderLayout.NORTH);
		
		JPanel panelInferior = new JPanel();
		seePane.add(panelInferior, BorderLayout.SOUTH);
		//new MigLayout("", "["+(ancho*0.5-445)+"][210][210][25.00]", "[57px][15.00]"));
		//new MigLayout("", "["+(ancho/4)+"]["+(ancho/4)+"]["+(ancho/4)+"]["+(ancho/4)+"]", "[57px][15.00]"));
		panelInferior.setLayout(new MigLayout("", "["+(ancho/4)+"]["+(ancho/4)+"]["+(ancho/4)+"]["+(ancho/4)+"]", "[10.00][57.00px][10.00]"));
		
		JPanel panelCentral = new JPanel();
		seePane.add(panelCentral, BorderLayout.CENTER);
		//new MigLayout("", "[40.00]["+((ancho*0.5/2)-70)+"][50.00]["+((ancho*0.5/2)-70)+"][40.00]", "[][][][][40.00][][][40.00][][][fill]"));
		panelCentral.setLayout(new MigLayout("", "[40.00]["+((ancho*0.5/2)-70)+"][50.00]["+((ancho*0.5/2)-70)+"][40.00]", "[][][][40.00][][][40.00][][][][][][40.00][][40]"));
		
		JSeparator separator = new JSeparator();
		panelCentral.add(separator, "cell 1 0 3 1,growx");
		
		lblAviso = new JLabel("Ingrese la cantidad de productos a vender, colocar números enteros positivos");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAviso.setForeground(new Color(204, 0, 0));
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(lblAviso, "cell 1 1 3 1,alignx center");
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel, "cell 1 2");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1, "cell 3 2");
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);

		textFieldCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCodigo.setToolTipText("Este campo no puede ser editado");
		panelCentral.add(textFieldCodigo, "cell 1 3,grow");
		textFieldCodigo.setColumns(10);
		
		textFieldNombre = new JTextField();

		textFieldNombre.setEditable(false);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNombre.setToolTipText("Este campo no puede ser editado");
		panelCentral.add(textFieldNombre, "cell 3 3,grow");
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Porcentaje de Utilidad");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1_1_1_1, "cell 1 5");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Marca");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1_1_1, "cell 3 5");
		
		textFieldProfit = new JTextField();
		textFieldProfit.setToolTipText("Este campo no puede ser editado");
		textFieldProfit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldProfit.setEditable(false);
		textFieldProfit.setColumns(10);
		panelCentral.add(textFieldProfit, "cell 1 6,grow");
		
		textFieldMarca = new JTextField();
		textFieldMarca.setEditable(false);
		textFieldMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMarca.setToolTipText("Este campo no puede ser editado");
		textFieldMarca.setColumns(10);
		panelCentral.add(textFieldMarca, "cell 3 6,grow");
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Descripción del producto");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1_1_2, "cell 1 8");
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane(txtDescripcion);
		scroll.setBorder(null);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBackground(Color.LIGHT_GRAY);
		
			panelCentral.add(panel, "cell 1 9 3 1,grow");
			//panel.setLayout(new MigLayout("", "["+ancho*0.47+"]", "[165.00px]"));
			panel.setLayout(new MigLayout("", "["+ancho*0.47+"]", "[165.00px]"));
			
			panel.add(scroll, "cell 0 0,grow");
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad disponible");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1_1, "cell 1 11");
		
		JLabel lblPrecioVenta = new JLabel("Precio de Venta");
		lblPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblPrecioVenta, "cell 3 11");
		
		textFieldCantidadEnStock = new JTextField();
		textFieldCantidadEnStock.setEditable(false);
		textFieldCantidadEnStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCantidadEnStock.setToolTipText("Este campo no puede ser editado");
		textFieldCantidadEnStock.setColumns(10);
		panelCentral.add(textFieldCantidadEnStock, "cell 1 12,grow");
		
		textFieldPrecioVenta = new JTextField();
		textFieldPrecioVenta.setToolTipText("Este campo no puede ser editado");
		textFieldPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPrecioVenta.setEditable(false);
		textFieldPrecioVenta.setColumns(10);
		panelCentral.add(textFieldPrecioVenta, "cell 3 12,grow");
		
		JLabel lblCantidadVender = new JLabel("Cantidad a vender");
		lblCantidadVender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblCantidadVender, "cell 1 14");

		cantidad = new JTextField();
		cantidad.setDisabledTextColor(Color.WHITE);
		cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isLetter(validar)) {
					e.consume();
					lblAviso.setText("<html><center>Solo puede ingresar valores numericos en el campo \"(Cantidad a vender)\". <br/>Este campo debe ser rellenado obligatoriamente</center><html>");
				}
			}
		});
		cantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cantidad.setToolTipText("Ingresa la nueva cantidad de productos que quieres establecer.");
		cantidad.setColumns(10);

		panelCentral.add(cantidad, "cell 3 14,grow");
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(listener);
		btnCancel.setActionCommand("cancelSellProduct");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnCancel, "cell 2 1,grow");
		
		btnSell = new JButton("Vender");
		btnSell.addActionListener(listener);
		btnSell.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnSell, "cell 1 1,grow");
		btnSell.setActionCommand(getTextFieldCodigo().getText()+"_confirmSellProduct");
	}

	
	public void setActionSell() {
		btnSell.setActionCommand(getTextFieldCodigo().getText()+"_confirmSellProduct");
	}

	public void errorMessage(String msg) {
		JOptionPane.showMessageDialog(jf, msg, "Error", JOptionPane.ERROR_MESSAGE);	
	}
	public void warningMessage(String msg) {
		JOptionPane.showMessageDialog(jf, msg, "Atencion", JOptionPane.WARNING_MESSAGE);	
	}
	public void informationMessage(String msg) {
		JOptionPane.showMessageDialog(jf, msg, "Informacion", JOptionPane.INFORMATION_MESSAGE);	
	}
	public int validateWindow(String msg) {
		return JOptionPane.showOptionDialog(jf, msg,"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"}, "Si");
	}
	
	public JTextField getTextFieldPrecioVenta() {
		return textFieldPrecioVenta;
	}

	public void setTextFieldPrecioVenta(String textFieldPrecioVenta) {
		this.textFieldPrecioVenta.setText(textFieldPrecioVenta);
	}

	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}

	public void setTextFieldCodigo(String textFieldCodigo) {
		this.textFieldCodigo.setText(textFieldCodigo);
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(String textFieldNombre) {
		this.textFieldNombre.setText(textFieldNombre);
	}

	public JTextField getTextFieldCantidadEnStock() {
		return textFieldCantidadEnStock;
	}

	public void setTextFieldCantidadEnStock(String textFieldCantidadEnStock) {
		this.textFieldCantidadEnStock.setText(textFieldCantidadEnStock);
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarca;
	}

	public void setTextFieldMarca(String textFieldMarca) {
		this.textFieldMarca.setText(textFieldMarca);
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(String txtDescripcion) {
		this.txtDescripcion.setText(txtDescripcion);
	}

	public JTextField getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad.setText(cantidad);}
	
	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(String lblAviso) {
		this.lblAviso.setText(lblAviso);;
	}
	
	public JTextField getTextFieldProfit() {
		return textFieldProfit;
	}

	public void setTextFieldProfit(String textFieldProfit) {
		this.textFieldProfit.setText(textFieldProfit);
	}

	public void resetWindow() {
		textFieldPrecioVenta.setText("");
		textFieldCodigo.setText("");
		textFieldNombre.setText("");
		textFieldCantidadEnStock.setText("");
		textFieldMarca.setText("");
		txtDescripcion.setText("");
		cantidad.setText("0");
	}
}
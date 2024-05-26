package view;

import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import controller.Controller;

import java.awt.event.ActionListener;
import javax.swing.JSeparator;

public class AddProduct extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel seePane;
	private JTextField textFieldCodigoVer;
	private JTextField textFieldNombreVer;
	private JTextField textFieldCantidadVer;
	private JTextField textFieldMarcaVer;
	private JTextArea txtDescripcionVer;
	private JTextField AddProd_txt_cant;
	private JTextField AddProd_txt_Price;
	private JButton AddProd_btnComprar;
	private JButton AddProd_btnCancel;
	private JLabel lblAviso;

	public AddProduct(JFrame frame, boolean modal,ActionListener listener) {
		super(frame,modal);
		initComponents(listener);
	}

	
	public void initComponents(ActionListener listener) {
		double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

		setUndecorated(true);
		Shape forma = new RoundRectangle2D.Double(0, 0, ancho*0.5, alto*0.6, 30, 30);
		this.setShape(forma);
		this.setLocationRelativeTo(null);

		
		seePane = new JPanel();
		seePane.setBorder(new RoundBorder(new Color(0, 0, 0), 1, true,30,30));
		setBounds((int)(ancho/2-(ancho*0.5)/2), (int)(alto/2-(alto*0.6)/2),(int)(ancho*0.5),(int)(alto*0.6));
		setContentPane(seePane);
		seePane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSuperior = new JLabel("PRODUCTO");
		lblSuperior.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		lblSuperior.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperior.setFont(new Font("Tahoma", Font.PLAIN, 40));
		seePane.add(lblSuperior, BorderLayout.NORTH);
		
		JPanel panelInferior = new JPanel();
		seePane.add(panelInferior, BorderLayout.SOUTH);
		//new MigLayout("", "["+(ancho*0.5-445)+"][210][210][25.00]", "[57px][15.00]"));
		panelInferior.setLayout(new MigLayout("", "[270.0][210][210][270.0]", "[57px]"));


		JPanel panelCentral = new JPanel();
		seePane.add(panelCentral, BorderLayout.CENTER);
		//new MigLayout("", "[40.00]["+((ancho*0.5/2)-70)+"][50.00]["+((ancho*0.5/2)-70)+"][40.00]", "[][][][][40.00][][][40.00][][][fill]"));
		panelCentral.setLayout(new MigLayout("", "[40.00]["+((ancho*0.5/2)-70)+"][50.00]["+((ancho*0.5/2)-70)+"][40.00]", "[][][40.00][][][40.00][][][136.00,fill][][][45.00][][40.00][]"));

		JSeparator separator_1 = new JSeparator();
		panelCentral.add(separator_1, "cell 1 0 3 1,growx");
		
		JSeparator separator = new JSeparator();
		panelCentral.add(separator, "cell 1 10 3 1,growx");
		
		JLabel lblComprarProductos = new JLabel("COMPRAR PRODUCTOS");
		lblComprarProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCentral.add(lblComprarProductos, "cell 1 11 3 1,alignx center,aligny center");
		
		JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad de productos a comprar *");
		lblIngreseLaCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblIngreseLaCantidad, "cell 1 12");
		
		JLabel lblIngrese = new JLabel("Ingrese el valor total de la compra *");
		lblIngrese.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblIngrese, "cell 3 12");
		lblAviso = new JLabel("");
		lblAviso.setForeground(new Color(204, 0, 0));
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 15));

		panelCentral.add(lblAviso, "cell 1 0 3 1,alignx center");
		
		AddProd_txt_cant = new JTextField();
		AddProd_txt_cant.setToolTipText("Ingrese la cantidad del producto que compro");
		AddProd_txt_cant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddProd_txt_cant.setColumns(10);
		AddProd_txt_cant.setBackground(Color.WHITE);
		AddProd_txt_cant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					e.consume();
					lblAviso.setText("Debe ingresar numeros enteros positivos.");
				}
			}
		});
		panelCentral.add(AddProd_txt_cant, "cell 1 13,grow");
		
		AddProd_txt_Price = new JTextField();
		AddProd_txt_Price.setToolTipText("Agregue el precio total de todos los productos comprados");
		AddProd_txt_Price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddProd_txt_Price.setColumns(10);
		AddProd_txt_Price.setBackground(Color.WHITE);
		AddProd_txt_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isLetter(validar)) {
					e.consume();
					lblAviso.setText("Solo se deben ingresar valores numericos positivos. \nPara colocar valores decimales se debe poner (.)");
				}
			}
		});
		panelCentral.add(AddProd_txt_Price, "cell 3 13,grow");
		
		JLabel lblNewLabelAviso2 = new JLabel("");
		lblNewLabelAviso2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelAviso2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabelAviso2, "cell 1 3 3 1,alignx center");
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel, "cell 1 1");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1, "cell 3 1");
		
		textFieldCodigoVer = new JTextField();
		textFieldCodigoVer.setBackground(Color.WHITE);
		textFieldCodigoVer.setEditable(false);
		textFieldCodigoVer.setText("12345");
		textFieldCodigoVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCodigoVer.setToolTipText("");
		panelCentral.add(textFieldCodigoVer, "cell 1 2,grow");
		textFieldCodigoVer.setColumns(10);
		
		textFieldNombreVer = new JTextField();
		textFieldNombreVer.setBackground(Color.WHITE);
		textFieldNombreVer.setEditable(false);
		textFieldNombreVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNombreVer.setToolTipText("");
		panelCentral.add(textFieldNombreVer, "cell 3 2,grow");
		textFieldNombreVer.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1_1, "cell 1 4");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Marca");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1_1_1, "cell 3 4");
		
		textFieldCantidadVer = new JTextField();
		textFieldCantidadVer.setBackground(Color.WHITE);
		textFieldCantidadVer.setEditable(false);
		textFieldCantidadVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCantidadVer.setToolTipText("");
		textFieldCantidadVer.setColumns(10);
		panelCentral.add(textFieldCantidadVer, "cell 1 5,grow");
		
		textFieldMarcaVer = new JTextField();
		textFieldMarcaVer.setBackground(Color.WHITE);
		textFieldMarcaVer.setEditable(false);
		textFieldMarcaVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMarcaVer.setToolTipText("");
		textFieldMarcaVer.setColumns(10);
		panelCentral.add(textFieldMarcaVer, "cell 3 5,grow");
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Descripción del producto");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCentral.add(lblNewLabel_1_1_2, "cell 1 7");
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtDescripcionVer = new JTextArea();
		txtDescripcionVer.setBackground(Color.WHITE);
		txtDescripcionVer.setEditable(false);
		txtDescripcionVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane(txtDescripcionVer);
		scroll.setBorder(null);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtDescripcionVer.setWrapStyleWord(true);
		txtDescripcionVer.setLineWrap(true);
		
		panelCentral.add(panel, "cell 1 8 3 1,grow");
		//panel.setLayout(new MigLayout("", "["+ancho*0.47+"]", "[165.00px]"));
		panel.setLayout(new MigLayout("", "["+ancho*0.47+"]", "[165.00px]"));
		
		panel.add(scroll, "cell 0 0,grow");
		
		AddProd_btnCancel = new JButton("Cancelar");
		AddProd_btnCancel.addActionListener(listener);
		AddProd_btnCancel.setActionCommand("CancelBuy");
		AddProd_btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(AddProd_btnCancel, "cell 2 0,grow");
		
		AddProd_btnComprar = new JButton("Comprar");
		AddProd_btnComprar.addActionListener(listener);
		AddProd_btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		AddProd_btnComprar.setActionCommand("buyProduct");
		panelInferior.add(AddProd_btnComprar, "cell 1 0,grow");
	}
	
	public JButton getbtnComprar() {
		return AddProd_btnComprar;
	}
	
	public void warningMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Atencion", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void errorMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);	
	}
	
	public JTextField getTextFieldCodigo() {
		return textFieldCodigoVer;
	}

	public void setTextFieldCodigo(String textFieldCodigoVer) {
		this.textFieldCodigoVer.setText(textFieldCodigoVer);
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombreVer;
	}

	public void setTextFieldNombre(String textFieldNombreVer) {
		this.textFieldNombreVer.setText(textFieldNombreVer);
	}

	public JTextField getTextFieldCantidad() {
		return textFieldCantidadVer;
	}

	public void setTextFieldCantidad(String textFieldCantidadVer) {
		this.textFieldCantidadVer.setText(textFieldCantidadVer);
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarcaVer;
	}

	public void setTextFieldMarca(String textFieldMarcaVer) {
		this.textFieldMarcaVer.setText(textFieldMarcaVer);
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcionVer;
	}

	public void setTxtDescripcion(String txtDescripcionVer) {
		this.txtDescripcionVer.setText(txtDescripcionVer);
	}

	public void openModifyWindow(Controller controller) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getAddProd_txt_cant() {
		return AddProd_txt_cant;
	}

	public void setAddProd_txt_cant(String addProd_txt_cant) {
		AddProd_txt_cant.setText(addProd_txt_cant);
	}

	public JTextField getAddProd_txt_Price() {
		return AddProd_txt_Price;
	}

	public void setAddProd_txt_Price(String addProd_txt_Price) {
		AddProd_txt_Price.setText(addProd_txt_Price);
	}
	
}

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Login2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private JSeparator separator;
	private JLabel lblIngresarUyC;
	private JTextField textFieldUser;
	private JPasswordField textFieldPassword;
	private JLabel titulo2;
	private JButton btnIngresar;
	private JButton btnRecover;
	private JLabel lblRecover;
	private JTextField textFieldRespuesta;
	private JLabel lblPregunta;
	private JSeparator separator_1;
	private JLabel lblAvisoPassword;
	private JButton btnRestablecerContrasea;
	private JLabel lblAvisoRecover;
	private JButton btnNewButton;

	public Login2(ActionListener listener) {
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		dim=super.getToolkit().getScreenSize();
		setSize(dim);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setAlwaysOnTop(true);

		setContentPane(contentPane);
		//setBounds(100,100, 800,800);
		double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		//contentPane.setLayout(new MigLayout("", "["+ancho*0.3+"]["+ancho*0.4+",grow]["+ancho*0.3+"]", "["+alto*0.1+"]["+alto*0.8+",grow]["+alto*0.1+"]"));
		contentPane.setLayout(new MigLayout("", "["+ancho*0.3+"][768.0,grow]["+((ancho*0.3)-48)+"][48.00]", "[48.0][864.0,grow][108.0]"));
		
		btnNewButton = new JButton("X");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(listener);
		btnNewButton.setActionCommand("CloseProgram");
		contentPane.add(btnNewButton, "cell 3 0");
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new RoundBorder(new Color(64, 64, 64), 2, true,30,30));
		contentPane.add(panel, "cell 1 1,grow");
		//new MigLayout("", "["+(ancho*0.4)*0.2+"]["+(ancho*0.4)*0.6+"]["+(ancho*0.4)*0.2+"]", "[][][][][][][46.00][64.00][64.00][][][][46.00][45.00][66.00][][][][][64.00]"));
		panel.setLayout(new MigLayout("", "["+(ancho*0.4)*0.2+"]["+(ancho*0.4)*0.6+"]["+(ancho*0.4)*0.2+"]", "[][][][][][][46.00][64.00][64.00][42.00][][][46.00][45.00][66.00][41.00][][grow][64.00][grow]"));
		
		JLabel titulo1 = new JLabel("SISTEMA DE INVENTARIO");
		titulo1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(titulo1, "cell 1 1,alignx center");
		
		titulo2 = new JLabel("MAXICOPIAS");
		titulo2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(titulo2, "cell 1 2,alignx center");
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		panel.add(separator, "cell 1 4,grow");
		
		lblIngresarUyC = new JLabel("Ingrese su usuario y contraseña");
		lblIngresarUyC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblIngresarUyC, "cell 1 6");
		
		textFieldUser = new JTextField();;
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUser.setColumns(10);
		textFieldUser.setBorder(new TitledBorder(null, "Usuario:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textFieldUser, "cell 1 7,grow");
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBorder(new TitledBorder(null, "Contraseña:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textFieldPassword, "cell 1 8,grow");
		
		btnRecover = new JButton("¿Ha olvidado su contraseña?");
		btnRecover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRecover.setBorder(null);
		btnRecover.setBackground(new Color(255, 255, 255));
		btnRecover.addActionListener(listener);
		btnRecover.setActionCommand("RecoverUser");
		panel.add(btnRecover, "cell 1 10,alignx center");
		
		lblAvisoPassword = new JLabel("");
		lblAvisoPassword.setForeground(new Color(204, 0, 0));
		lblAvisoPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblAvisoPassword, "cell 1 9,alignx center");
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		panel.add(separator_1, "cell 1 11,growx");
		
		lblRecover = new JLabel("Recuperación de la contraseña:");
		lblRecover.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRecover.setVisible(false);
		panel.add(lblRecover, "cell 1 12");
		
		lblPregunta = new JLabel("");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPregunta.setVisible(false);
		panel.add(lblPregunta, "cell 1 13");
		
		textFieldRespuesta = new JTextField();
		textFieldRespuesta.setToolTipText("Ingrese la respuesta a su pregunta de seguridad.");
		textFieldRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldRespuesta.setColumns(10);
		textFieldRespuesta.setVisible(false);
		textFieldRespuesta.setBorder(new TitledBorder(null, "Respuesta:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textFieldRespuesta, "cell 1 14,grow");
		
		lblAvisoRecover = new JLabel("");
		lblAvisoRecover.setForeground(new Color(204, 0, 0));
		lblAvisoRecover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblAvisoRecover, "cell 1 15,alignx center");
		
		btnRestablecerContrasea = new JButton("RESTABLECER CONTRASEÑA");
		btnRestablecerContrasea.setBackground(Color.WHITE);
		btnRestablecerContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRestablecerContrasea.setVisible(false);
		btnRestablecerContrasea.addActionListener(listener);
		btnRestablecerContrasea.setActionCommand("restablecer");
		panel.add(btnRestablecerContrasea, "cell 1 16,alignx center");
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngresar.addActionListener(listener);
		btnIngresar.setActionCommand("Ingresar");
		panel.add(btnIngresar, "cell 1 18,alignx center,growy");
	}
	
	public void resetPanel() {
		textFieldUser.setText("");
		textFieldPassword.setText("");
		lblAvisoPassword.setText("");
		lblPregunta.setText("");
		textFieldRespuesta.setText("");
		lblAvisoRecover.setText("");
	}
	
	public void openRecovery () {
		lblRecover.setVisible(true);
		lblPregunta.setVisible(true);
		textFieldRespuesta.setVisible(true);
		btnRestablecerContrasea.setVisible(true);
	}
	
	public void closeRecovery () {
		lblRecover.setVisible(false);
		lblPregunta.setVisible(false);
		textFieldRespuesta.setVisible(false);
		btnRestablecerContrasea.setVisible(false);
	}

	public JTextField getTextFieldUser() {
		return textFieldUser;
	}

	public void setTextFieldUser(String textFieldUser) {
		this.textFieldUser.setText(textFieldUser);
	}
	
	public void setlblPregunta(String lblPregunta) {
		this.lblPregunta.setText(lblPregunta);
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public void setTextFieldPassword(String textFieldPassword) {
		this.textFieldPassword.setText(textFieldPassword);
	}

	public JTextField getTextFieldRespuesta() {
		return textFieldRespuesta;
	}

	public void setTextFieldRespuesta(String textFieldRespuesta) {
		this.textFieldRespuesta.setText(textFieldRespuesta);
	}

	public void setLblAvisoPassword(String lblAvisoPassword) {
		this.lblAvisoPassword.setText(lblAvisoPassword);
	}

	public void setLblAvisoRecover(String lblAvisoRecover) {
		this.lblAvisoRecover.setText(lblAvisoRecover);
	}
	
	
}

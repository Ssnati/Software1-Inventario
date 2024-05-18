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

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private JTextField txtUserName;
	private JTextField textField_Contraseña;
	private JTextField textField_Confirmar;
	private JSeparator separator;
	private JLabel lbl_Pregunta;
	private JTextField textField_Pregunta;
	private JLabel lbl_IngreseUsuario_1;
	private JTextField textField_Respuesta;
	private JButton btnAceptar;
	private JLabel lblConfirmacionContra;
	private JLabel lblBtnConfirm;
	private JButton btnNewButton;

	public Login(ActionListener listener) {
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		setAlwaysOnTop(true);
		dim=super.getToolkit().getScreenSize();
		setSize(dim);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		//"["+ancho*0.3+"][768.0,grow]["+((ancho*0.3)-48)+"][48.00]",
		contentPane.setLayout(new MigLayout("", "["+ancho*0.3+"][768.0,grow]["+((ancho*0.3)-48)+"][48.00]", "[48]["+((alto*0.1)-48)+"]["+alto*0.8+",grow]["+alto*0.1+"]"));
		
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
		contentPane.add(panel, "cell 1 2,grow");
		panel.setLayout(new MigLayout("", "["+(ancho*0.4)*0.2+"]["+(ancho*0.4)*0.6+",grow]["+(ancho*0.4)*0.2+"]", "[][][][46.00][64.00][27.00][64.00][64.00][30.00][][][][46.00][64.00][64.00][][30.00][][56.00]"));
		
		JLabel Titulo1 = new JLabel("BIENVENIDO");
		Titulo1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(Titulo1, "cell 1 1,alignx center");
		
		JLabel lbl_IngreseUsuario = new JLabel("Ingrese un usuario y contraseña:");
		lbl_IngreseUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lbl_IngreseUsuario, "cell 1 3");
		
		txtUserName = new JTextField();
		txtUserName.setText("MAXICOPIAS");
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUserName.setToolTipText("Ingrese un nombre de usuario");
		txtUserName.setBorder(new TitledBorder(null, "Usuario", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(txtUserName, "cell 1 4,grow");
		txtUserName.setColumns(10);
		
		lbl_IngreseUsuario_1 = new JLabel("El usuario por defecto es MAXICOPIAS.");
		lbl_IngreseUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbl_IngreseUsuario_1, "cell 1 5,aligny top");
		
		textField_Contraseña = new JPasswordField();
		textField_Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Contraseña.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField_Contraseña.setToolTipText("Ingrese una contraseña");
		textField_Contraseña.setColumns(10);
		textField_Contraseña.setBorder(new TitledBorder(null, "Contraseña", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textField_Contraseña, "cell 1 6,grow");
		
		textField_Confirmar = new JPasswordField();
		textField_Confirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Confirmar.setToolTipText("Vuelva a ingresar la contraseña");
		textField_Confirmar.setColumns(10);
		textField_Confirmar.setBorder(new TitledBorder(null, "Confime la contraseña", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textField_Confirmar, "cell 1 7,grow");
		
		lblConfirmacionContra = new JLabel("");
		lblConfirmacionContra.setForeground(new Color(204, 0, 0));
		lblConfirmacionContra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblConfirmacionContra, "cell 1 8,grow");
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		panel.add(separator, "cell 1 10,grow");
		
		lbl_Pregunta = new JLabel("Ingrese una pregunta de seguridad:");
		lbl_Pregunta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lbl_Pregunta, "cell 1 12");
		
		textField_Pregunta = new JTextField();
		textField_Pregunta.setToolTipText("Esta pregunta se usará en caso de olvidar la contraseña.");
		textField_Pregunta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Pregunta.setColumns(10);
		textField_Pregunta.setBorder(new TitledBorder(null, "Pregunta:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textField_Pregunta, "cell 1 13,grow");
		
		textField_Respuesta = new JTextField();
		textField_Respuesta.setToolTipText("Esta pregunta se usará en caso de olvidar la contraseña.");
		textField_Respuesta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Respuesta.setColumns(10);
		textField_Respuesta.setBorder(new TitledBorder(null, "Respuesta:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textField_Respuesta, "cell 1 14,grow");
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(listener);
		
		lblBtnConfirm = new JLabel("");
		lblBtnConfirm.setForeground(new Color(204, 0, 0));
		lblBtnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblBtnConfirm, "cell 1 16,alignx center,growy");
		btnAceptar.setActionCommand("logAccept");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAceptar.setSize(191,57);
		panel.add(btnAceptar, "cell 1 18,alignx center,growy");
	}
	
	public void resetPanel() {
		txtUserName.setText("MAXICOPIAS");
		textField_Contraseña.setText("");
		textField_Confirmar.setText("");
		textField_Pregunta.setText("");
		textField_Respuesta.setText("");
		lblBtnConfirm.setText("");
		lblConfirmacionContra.setText("");
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(String txtUserName) {
		this.txtUserName.setText(txtUserName);
	}

	public JTextField getTextFieldContraseña() {
		return textField_Contraseña;
	}

	public void setTextField_Contraseña(String textField_Contraseña) {
		this.textField_Contraseña.setText(textField_Contraseña);
	}

	public JTextField getTextField_Confirmar() {
		return textField_Confirmar;
	}

	public void setTextField_Confirmar(String textField_Confirmar) {
		this.textField_Confirmar.setText(textField_Confirmar);
	}

	public JTextField getTextField_Pregunta() {
		return textField_Pregunta;
	}

	public void setTextField_Pregunta(String textField_Pregunta) {
		this.textField_Pregunta.setText(textField_Pregunta);
	}

	public JTextField getTextField_Respuesta() {
		return textField_Respuesta;
	}

	public void setTextField_Respuesta(JTextField textField_Respuesta) {
		this.textField_Respuesta = textField_Respuesta;
	}

	public void setLblConfirmacionContra(String lblConfirmacionContra) {
		this.lblConfirmacionContra.setText(lblConfirmacionContra);
	}
	
	public void setLblBtnConfirm(String lblBtnConfirm) {
		this.lblBtnConfirm.setText(lblBtnConfirm);
	}
	
}

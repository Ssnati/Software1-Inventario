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

public class CambiarContrasena extends JFrame {

    private JPanel contentPane;
    private Dimension dim;
    private JTextField txtOldPassword;
    private JTextField textField_password;
    private JTextField textField_Confirmar;
	private JButton btnAceptar;
    private JLabel lblConfirmacionContra;
    private JLabel lblBtnConfirm;
    private JButton btnNewButton;

    public CambiarContrasena(ActionListener listener) {
        setUndecorated(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        initComponents(listener);
    }

    private void 	initComponents(ActionListener listener) {
		setAlwaysOnTop(true);
        dim = super.getToolkit().getScreenSize();
        setSize(dim);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
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
		
		JLabel lbl_IngreseUsuario = new JLabel("Ingrese su contraseña anterior y la nueva contraseña:");
		lbl_IngreseUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lbl_IngreseUsuario, "cell 1 3");
		
		txtOldPassword = new JPasswordField();
		txtOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtOldPassword.setToolTipText("Ingrese su contraseña actual");
		txtOldPassword.setBorder(new TitledBorder(null, "Contraseña Actual", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(txtOldPassword, "cell 1 4,grow");
		txtOldPassword.setColumns(10);

		textField_password = new JPasswordField();
		textField_password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_password.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField_password.setToolTipText("Ingrese una contraseña");
		textField_password.setColumns(10);
		textField_password.setBorder(new TitledBorder(null, "Nueva Contraseña", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel.add(textField_password, "cell 1 6,grow");
		
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

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		panel.add(separator, "cell 1 10,grow");

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(listener);
		
		lblBtnConfirm = new JLabel("");
		lblBtnConfirm.setForeground(new Color(204, 0, 0));
		lblBtnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblBtnConfirm, "cell 1 16,alignx center,growy");
		btnAceptar.setActionCommand("acept_cambiar_contrasena");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAceptar.setSize(191,57);
		panel.add(btnAceptar, "cell 1 18,alignx center,growy");
	}
	
	public void resetPanel() {
		txtOldPassword.setText("");
		textField_password.setText("");
		textField_Confirmar.setText("");
		lblBtnConfirm.setText("");
		lblConfirmacionContra.setText("");
	}

    public JTextField getTxtOldPassword() {
        return txtOldPassword;
    }

    public void setTxtOldPassword(String txtOldPassword) {
        this.txtOldPassword.setText(txtOldPassword);
    }

    public JTextField getTextFiel_password() {
        return textField_password;
    }

    public void setTextField_password(String textField_password) {
        this.textField_password.setText(textField_password);
    }

    public JTextField getTextField_Confirmar() {
        return textField_Confirmar;
    }

    public void setTextField_Confirmar(String textField_Confirmar) {
        this.textField_Confirmar.setText(textField_Confirmar);
    }

    public void setLblConfirmacionContra(String lblConfirmacionContra) {
        this.lblConfirmacionContra.setText(lblConfirmacionContra);
    }

    public void setLblBtnConfirm(String lblBtnConfirm) {
        this.lblBtnConfirm.setText(lblBtnConfirm);
    }

}

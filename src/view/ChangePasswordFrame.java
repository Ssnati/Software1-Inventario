package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import persistence.PDFHelpReader;

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

public class ChangePasswordFrame extends JFrame {

    private JPanel contentPane;
    private Dimension dim;
    private JTextField txtOldPassword, txtNewPassword, txtConfirmPassword;
    private JButton btnAcceptChangePassword, btnClosePanel;
    private JLabel lblValidateFieldInfo, lblFieldsUncompletedInfo;
    private String comeFrom;
    private JPanel midPanel;

    public ChangePasswordFrame(ActionListener listener) {
        setUndecorated(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        initComponents(listener);
        initHelpButton();
    }

    private void initComponents(ActionListener listener) {
        setAlwaysOnTop(true);
        dim = super.getToolkit().getScreenSize();
        setSize(dim);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));

        setContentPane(contentPane);
        double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        contentPane.setLayout(new MigLayout("", "[" + ancho * 0.3 + "][768.0,grow][" + ((ancho * 0.3) - 48) + "][48.00]", "[48][" + ((alto * 0.1) - 48) + "][" + alto * 0.8 + ",grow][" + alto * 0.1 + "]"));

        btnClosePanel = new JButton("Atras");
        btnClosePanel.setFont(new Font("Verdana", Font.BOLD, 20));
        btnClosePanel.setBackground(new Color(136, 136, 136));
        btnClosePanel.setForeground(Color.WHITE);
        btnClosePanel.setFocusPainted(false);
        btnClosePanel.addActionListener(listener);
        btnClosePanel.setActionCommand("CloseChangePasswordPanel");
        contentPane.add(btnClosePanel, "cell 3 0");


        midPanel = new JPanel();
        midPanel.setBackground(new Color(255, 255, 255));
        midPanel.setBorder(new RoundBorder(new Color(64, 64, 64), 2, true, 30, 30));
        contentPane.add(midPanel, "cell 1 2,grow");
        midPanel.setLayout(new MigLayout("", "[" + (ancho * 0.4) * 0.2 + "][" + (ancho * 0.4) * 0.6 + ",grow][" + (ancho * 0.4) * 0.2 + "]", "[][][][46.00][64.00][27.00][64.00][64.00][30.00][][][][46.00][64.00][64.00][][30.00][][56.00]"));

        JLabel Titulo1 = new JLabel("BIENVENIDO");
        Titulo1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        midPanel.add(Titulo1, "cell 1 1,alignx center");

        JLabel lbl_IngreseUsuario = new JLabel("Ingrese su contraseña anterior y la nueva contraseña:");
        lbl_IngreseUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
        midPanel.add(lbl_IngreseUsuario, "cell 1 3");

        txtOldPassword = new JPasswordField();
        txtOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtOldPassword.setToolTipText("Ingrese su contraseña actual");
        txtOldPassword.setBorder(new TitledBorder(null, "Contraseña Actual", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
        midPanel.add(txtOldPassword, "cell 1 4,grow");
        txtOldPassword.setColumns(10);

        txtNewPassword = new JPasswordField();
        txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtNewPassword.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        txtNewPassword.setToolTipText("Ingrese una contraseña");
        txtNewPassword.setColumns(10);
        txtNewPassword.setBorder(new TitledBorder(null, "Nueva Contraseña", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
        midPanel.add(txtNewPassword, "cell 1 6,grow");

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtConfirmPassword.setToolTipText("Vuelva a ingresar la contraseña");
        txtConfirmPassword.setColumns(10);
        txtConfirmPassword.setBorder(new TitledBorder(null, "Confirme la contraseña", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 18), null));
        midPanel.add(txtConfirmPassword, "cell 1 7,grow");

        lblValidateFieldInfo = new JLabel("");
        lblValidateFieldInfo.setForeground(new Color(204, 0, 0));
        lblValidateFieldInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        midPanel.add(lblValidateFieldInfo, "cell 1 8,grow");

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 0, 0));
        midPanel.add(separator, "cell 1 10,grow");

        btnAcceptChangePassword = new JButton("ACEPTAR");
        btnAcceptChangePassword.setBackground(Color.WHITE);
        btnAcceptChangePassword.addActionListener(listener);

        lblFieldsUncompletedInfo = new JLabel("");
        lblFieldsUncompletedInfo.setForeground(new Color(204, 0, 0));
        lblFieldsUncompletedInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        midPanel.add(lblFieldsUncompletedInfo, "cell 1 16,alignx center,growy");
        btnAcceptChangePassword.setActionCommand("acept_cambiar_contrasena");
        btnAcceptChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAcceptChangePassword.setSize(191, 57);
        midPanel.add(btnAcceptChangePassword, "cell 1 18,alignx center,growy");
    }

    private void initHelpButton() {
        JButton helpButton = new JButton("Ayuda");
        helpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        helpButton.setBackground(new Color(215, 215, 215));
        helpButton.addActionListener(e -> showHelpPDF());
        midPanel.add(helpButton, "cell 2 1");
    }

    public void showHelpPDF() {
        PDFHelpReader frameHelp = new PDFHelpReader("Manual-Usuario.pdf", 1, this);
        frameHelp.setVisible(true);
        this.setVisible(false);
    }


    public void resetPanel() {
        txtOldPassword.setText("");
        txtNewPassword.setText("");
        txtConfirmPassword.setText("");
        lblFieldsUncompletedInfo.setText("");
        lblValidateFieldInfo.setText("");
    }

    public JTextField getTxtOldPassword() {
        return txtOldPassword;
    }

    public void setTxtOldPassword(String txtOldPassword) {
        this.txtOldPassword.setText(txtOldPassword);
    }

    public JTextField getTextFiel_password() {
        return txtNewPassword;
    }

    public void setTxtNewPassword(String txtNewPassword) {
        this.txtNewPassword.setText(txtNewPassword);
    }

    public JTextField getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword.setText(txtConfirmPassword);
    }

    public void setLblValidateFieldInfo(String lblValidateFieldInfo) {
        this.lblValidateFieldInfo.setText(lblValidateFieldInfo);
    }

    public void setLblFieldsUncompletedInfo(String lblFieldsUncompletedInfo) {
        this.lblFieldsUncompletedInfo.setText(lblFieldsUncompletedInfo);
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }
}

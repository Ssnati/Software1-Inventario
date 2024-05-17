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
    private JSeparator separator_1;
    private JLabel lblAvisoPassword;
    private JButton btnNewButton;

    public Login2(ActionListener listener) {
        setUndecorated(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setupFrame();
        setupContentPane();
        setupCloseButton(listener);
        setupUserPanel(listener);
    }

    private void setupFrame() {
        dim = super.getToolkit().getScreenSize();
        setSize(dim);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
    }

    private void setupContentPane() {
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);
        double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        contentPane.setLayout(new MigLayout("", "[" + ancho * 0.3 + "][768.0,grow][" + ((ancho * 0.3) - 48) + "][48.00]", "[48.0][864.0,grow][108.0]"));
    }

    private void setupCloseButton(ActionListener listener) {
        btnNewButton = createButton("X", "Verdana", Font.BOLD, 20, new Color(204, 0, 0), Color.WHITE, "CloseProgram", listener);
        contentPane.add(btnNewButton, "cell 3 0");
    }

    private void setupUserPanel(ActionListener listener) {
        JPanel panel = createUserPanel();
        contentPane.add(panel, "cell 1 1,grow");
        setupUserPanelComponents(panel, listener);
    }

    private JPanel createUserPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new RoundBorder(new Color(64, 64, 64), 2, true, 30, 30));
        double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        panel.setLayout(new MigLayout("", "[" + (ancho * 0.4) * 0.2 + "][" + (ancho * 0.4) * 0.6 + "][" + (ancho * 0.4) * 0.2 + "]", "[][][][][][][46.00][64.00][64.00][42.00][][][46.00][45.00][66.00][41.00][][grow][64.00][grow]"));
        return panel;
    }

    private void setupUserPanelComponents(JPanel panel, ActionListener listener) {
        JLabel titulo1 = createLabel("SISTEMA DE INVENTARIO", "Tahoma", Font.PLAIN, 40);
        panel.add(titulo1, "cell 1 1,alignx center");

        titulo2 = createLabel("VARIEDADES FERCHO", "Tahoma", Font.PLAIN, 40);
        panel.add(titulo2, "cell 1 2,alignx center");

        separator = createSeparator(Color.BLACK);
        panel.add(separator, "cell 1 4,grow");

        lblIngresarUyC = createLabel("Ingrese su usuario y contrase\u00F1a", "Tahoma", Font.PLAIN, 20);
        panel.add(lblIngresarUyC, "cell 1 6");

        textFieldUser = createTextField(10, "Usuario:", "Tahoma", Font.PLAIN, 18);
        panel.add(textFieldUser, "cell 1 7,grow");

        textFieldPassword = createPasswordField(10, "Contraseña:", "Tahoma", Font.PLAIN, 18);
        panel.add(textFieldPassword, "cell 1 8,grow");

        lblAvisoPassword = createLabel("", "Tahoma", Font.PLAIN, 15);
        lblAvisoPassword.setForeground(new Color(204, 0, 0));
        panel.add(lblAvisoPassword, "cell 1 9,alignx center");

        separator_1 = createSeparator(Color.BLACK);
        panel.add(separator_1, "cell 1 11,growx");

        btnIngresar = createButton("INGRESAR", "Tahoma", Font.PLAIN, 20, Color.WHITE, null, "Ingresar", listener);
        panel.add(btnIngresar, "cell 1 18,alignx center,growy");
    }

    private JButton createButton(String text, String fontName, int fontStyle, int fontSize, Color backgroundColor, Color foregroundColor, String actionCommand, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font(fontName, fontStyle, fontSize));
        button.setBackground(backgroundColor);
        button.setForeground(foregroundColor);
        button.addActionListener(listener);
        button.setActionCommand(actionCommand);
        return button;
    }

    private JLabel createLabel(String text, String fontName, int fontStyle, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        return label;
    }

    private JSeparator createSeparator(Color color) {
        JSeparator separator = new JSeparator();
        separator.setBackground(color);
        return separator;
    }

    private JTextField createTextField(int columns, String title, String fontName, int fontStyle, int fontSize) {
        JTextField textField = new JTextField();
        textField.setFont(new Font(fontName, fontStyle, fontSize));
        textField.setColumns(columns);
        textField.setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font(fontName, fontStyle, fontSize), null));
        return textField;
    }

    private JPasswordField createPasswordField(int columns, String title, String fontName, int fontStyle, int fontSize) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font(fontName, fontStyle, fontSize));
        passwordField.setColumns(columns);
        passwordField.setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font(fontName, fontStyle, fontSize), null));
        return passwordField;
    }

    public void resetPanel() {
        textFieldUser.setText("");
        textFieldPassword.setText("");
        lblAvisoPassword.setText("");
    }

    public JTextField getTextFieldUser() {
        return textFieldUser;
    }

    public void setTextFieldUser(String textFieldUser) {
        this.textFieldUser.setText(textFieldUser);
    }

    public JTextField getTextFieldPassword() {
        return textFieldPassword;
    }

    public void setTextFieldPassword(String textFieldPassword) {
        this.textFieldPassword.setText(textFieldPassword);
    }

    public void setLblAvisoPassword(String lblAvisoPassword) {
        this.lblAvisoPassword.setText(lblAvisoPassword);
    }


}

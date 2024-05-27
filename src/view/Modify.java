package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Modify extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel modifyPane;
    private JTextField textFieldNombreModify;
    private JTextField textFieldCodigoModify;
    private JTextField textFieldProfitModify;
    private JTextField textFieldCantidadModify;
    private JTextField textFieldMarcaModify;
    private JTextField textFieldRangoModify;
    private JTextArea txtDescripcionModify;
    private JLabel lblAvisoModify;
    private JButton btnAccept;
    private JFrame jf;
    private JLabel lblPrecioCompra;
    private JTextField textFieldPrecioCompra;

    public Modify(JFrame frame, boolean modal, ActionListener listener) {
        super(frame, modal);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        jf = new JFrame();
        jf.setAlwaysOnTop(true);
        setAlwaysOnTop(true);
        double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        setUndecorated(true);
        Shape forma = new RoundRectangle2D.Double(0, 0, ancho * 0.5, alto * 0.6, 30, 30);
        this.setShape(forma);
        this.setLocationRelativeTo(null);

        modifyPane = new JPanel();
        modifyPane.setBorder(new RoundBorder(new Color(0, 0, 0), 1, true, 30, 30));
        setBounds((int) (ancho / 2 - (ancho * 0.5) / 2), (int) (alto / 2 - (alto * 0.6) / 2), (int) (ancho * 0.5), (int) (alto * 0.6));
        setContentPane(modifyPane);
        modifyPane.setLayout(new BorderLayout(0, 0));

        JLabel lblSuperior = new JLabel("MODIFICAR PRODUCTO");
        lblSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        lblSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        lblSuperior.setFont(new Font("Tahoma", Font.PLAIN, 40));
        modifyPane.add(lblSuperior, BorderLayout.NORTH);

        JPanel panelInferior = new JPanel();
        modifyPane.add(panelInferior, BorderLayout.SOUTH);
        panelInferior.setLayout(new MigLayout("", "[" + (ancho * 0.25 - 210) + "][210][210][" + (ancho * 0.25 - 210) + "]", "[57px][15.00]"));

        JPanel panelCentral = new JPanel();
        modifyPane.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new MigLayout("", "[20.00][271.5,grow][50.00][271.5,grow][20.00]", "[][][40.00][][][40.00][][][fill]"));

        lblAvisoModify = new JLabel("");
        lblAvisoModify.setForeground(new Color(204, 0, 0));
        lblAvisoModify.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAvisoModify.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentral.add(lblAvisoModify, "cell 1 0 3 1,alignx center");

        JLabel lblNewLabelAviso2 = new JLabel("");
        lblNewLabelAviso2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabelAviso2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabelAviso2, "cell 1 3 3 1,alignx center");

        JLabel lblNewLabel = new JLabel("Código");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel, "cell 1 1");


        textFieldCodigoModify = new JTextField();
        textFieldCodigoModify.setEditable(false);
        textFieldCodigoModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldCodigoModify.setToolTipText("El código no puede ser cambiado.");
        panelCentral.add(textFieldCodigoModify, "cell 1 2,grow");
        textFieldCodigoModify.setColumns(10);


        JLabel lblNewLabel_1_2 = new JLabel("Nombre*");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_2, "cell 1 4");

        textFieldNombreModify = new JTextField();
        textFieldNombreModify.setToolTipText("Ingrese el nombre del producto. Este campo debe ser rellenado obligatoriamente.");
        textFieldNombreModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldNombreModify.setColumns(10);
        panelCentral.add(textFieldNombreModify, "cell 1 5,grow");

        JLabel lblNewLabel_1 = new JLabel("Porcentaje de Utilidad (%) *");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1, "cell 3 4");


        textFieldProfitModify = new JTextField();
        textFieldProfitModify.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if (Character.isLetter(validar)) {
                    e.consume();
                    lblAvisoModify.setText("<html><center>Solo puede ingresar valores numericos positivos. <br/>Para colocar valores decimales se debe poner (.)<html><center>");
                }
            }
        });
        textFieldProfitModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldProfitModify.setToolTipText("Ingrese el valor numérico del porcentaje de utilidad. No es necesario digitar el símbolo (%). Este campo debe ser rellenado obligatoriamente.");
        panelCentral.add(textFieldProfitModify, "cell 3 5,grow");
        textFieldProfitModify.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Cantidad*");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1, "cell 1 8");

        JLabel lblNewLabel_1_1_1 = new JLabel("Marca");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_1, "cell 3 6");
        JLabel lblNewLabel_rango = new JLabel("Stock mínimo *");
        lblNewLabel_rango.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_rango, "cell  3 8");

        textFieldCantidadModify = new JTextField();

        textFieldCantidadModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldCantidadModify.setToolTipText("La cantidad no puede ser modificada.");
        textFieldCantidadModify.setEditable(false);
        textFieldCantidadModify.setColumns(10);
        panelCentral.add(textFieldCantidadModify, "cell 1 9,grow");

        textFieldMarcaModify = new JTextField();
        textFieldMarcaModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldMarcaModify.setToolTipText("Escriba la marca del producto que quiere ingresar.");
        textFieldMarcaModify.setColumns(10);
        panelCentral.add(textFieldMarcaModify, "cell 3 7,grow");

        textFieldRangoModify = new JTextField();
        textFieldRangoModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldRangoModify.setToolTipText("Colocar el stock mínimo del producto. Este campo debe ser rellenado obligatoriamente.");
        textFieldRangoModify.setColumns(10);
        panelCentral.add(textFieldRangoModify, "cell 3 9,grow");
        textFieldRangoModify.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if (Character.isLetter(validar)) {
                    e.consume();
                    lblAvisoModify.setText("<html><center>Solo puede ingresar valores numericos positivos en el campo \"(Stock mínimo)\".<html><center>");
                }
            }
        });

        lblPrecioCompra = new JLabel("Precio de Compra");
        lblPrecioCompra.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblPrecioCompra, "cell 1 6");

        textFieldPrecioCompra = new JTextField();
        textFieldPrecioCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldPrecioCompra.setToolTipText("Este campo no puede ser modificado.");
        textFieldPrecioCompra.setColumns(10);
        textFieldPrecioCompra.setEditable(false);
        panelCentral.add(textFieldPrecioCompra, "cell 1 7,grow");

        JLabel lblNewLabel_1_1_2 = new JLabel("Descripción del producto");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_2, "cell 1 11");

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        txtDescripcionModify = new JTextArea();
        txtDescripcionModify.setDisabledTextColor(Color.WHITE);
        txtDescripcionModify.setBackground(Color.WHITE);
        txtDescripcionModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scroll = new JScrollPane(txtDescripcionModify);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        txtDescripcionModify.setWrapStyleWord(true);
        txtDescripcionModify.setLineWrap(true);
        txtDescripcionModify.setToolTipText("En este campo se puede ingresar una nueva descripción para el producto.");

        panelCentral.add(panel, "cell 1 12 3 1,grow");
        //panel.setLayout(new MigLayout("", "["+ancho*0.47+"]", "[165.00px]"));
        panel.setLayout(new MigLayout("", "[" + ancho * 0.47 + "]", "[165.00px]"));
        panel.add(scroll, "cell 0 0,grow");

        btnAccept = new JButton("Aceptar");
        btnAccept.addActionListener(listener);
        btnAccept.setActionCommand(getTextFieldCodigoModify().getText() + "_saveModification");
        btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panelInferior.add(btnAccept, "cell 1 0,grow");

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(listener);
        btnCancel.setActionCommand("cancelarModificar");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panelInferior.add(btnCancel, "cell 2 0,grow");
    }

    public void setActionModify() {
        btnAccept.setActionCommand(getTextFieldCodigoModify().getText() + "_saveModification");
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
        return JOptionPane.showOptionDialog(jf, msg, "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "No");
    }

    public JTextField getTextFieldCodigoModify() {
        return textFieldCodigoModify;
    }

    public void setTextFieldCodigoModify(String textFieldCodigoModify) {
        this.textFieldCodigoModify.setText(textFieldCodigoModify);
    }

    public JTextField getTextFieldNombreModify() {
        return textFieldNombreModify;
    }

    public void setTextFieldNombreModify(String textFieldNombreModify) {
        this.textFieldNombreModify.setText(textFieldNombreModify);
    }

    public JTextField getTextFieldCantidadModify() {
        return textFieldCantidadModify;
    }

    public void setTextFieldCantidadModify(String textFieldCantidadModify) {
        this.textFieldCantidadModify.setText(textFieldCantidadModify);
    }

    public JTextField getTextFieldMarcaModify() {
        return textFieldMarcaModify;
    }

    public void setTextFieldMarcaModify(String textFieldMarcaModify) {
        this.textFieldMarcaModify.setText(textFieldMarcaModify);
    }

    public JTextArea getTxtDescripcionModify() {
        return txtDescripcionModify;
    }

    public void setTxtDescripcionModify(String txtDescripcionModify) {
        this.txtDescripcionModify.setText(txtDescripcionModify);
    }

    public JLabel getLblAvisoModify() {
        return lblAvisoModify;
    }

    public void setLblAvisoModify(String lblAvisoModify) {
        this.lblAvisoModify.setText(lblAvisoModify);
    }

    public JTextField getTextFieldRangoModify() {
        return textFieldRangoModify;
    }

    public void setTextFieldRangoModify(String textFieldRango) {
        this.textFieldRangoModify.setText(textFieldRango);
    }

    public JTextField getTextFieldProfit() {
        return textFieldProfitModify;
    }

    public void setTextFieldProfit(String textFieldProfit) {
        this.textFieldProfitModify.setText(textFieldProfit);
    }

    public void setTextFieldPrecioCompra(String textFieldPrecioCompra) {
        this.textFieldPrecioCompra.setText(textFieldPrecioCompra);
    }
}

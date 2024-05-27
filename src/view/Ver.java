package view;

import java.awt.Shape;
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

import java.awt.event.ActionListener;

public class Ver extends JDialog {
    private static final long serialVersionUID = 1L;
    private JFrame jf;
    private JPanel seePane;
    private JTextField textFieldCodigoVer;
    private JTextField textFieldNombreVer;
    private JTextField textFieldCantidadVer;
    private JTextField textFieldMarcaVer;
    private JTextArea txtDescripcionVer;
    private JLabel lblAvisoVer;
    private JButton btnModify;
    private JButton btnDelete;
    private JButton btnCancel;
    private JTextField textFieldProfit;
    private JTextField textFieldSalePrice;
    private JTextField textFieldRango;
    private JTextField textFieldPrecioCompra;

    public Ver(JFrame frame, boolean modal, ActionListener listener) {
        super(frame, modal);
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        jf = new JFrame();
        jf.setAlwaysOnTop(true);
        setAlwaysOnTop(true);
        double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        setUndecorated(true);
        Shape forma = new RoundRectangle2D.Double(0, 0, ancho * 0.5, alto * 0.7, 30, 30);
        this.setShape(forma);
        this.setLocationRelativeTo(null);


        seePane = new JPanel();
        seePane.setBorder(new RoundBorder(new Color(0, 0, 0), 1, true, 30, 30));
        setBounds((int) (ancho / 2 - (ancho * 0.5) / 2), (int) (alto / 2 - (alto * 0.7) / 2), (int) (ancho * 0.5), (int) (alto * 0.7));
        setContentPane(seePane);
        seePane.setLayout(new BorderLayout(0, 0));

        JLabel lblSuperior = new JLabel("PRODUCTO");
        lblSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        lblSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        lblSuperior.setFont(new Font("Tahoma", Font.PLAIN, 40));
        seePane.add(lblSuperior, BorderLayout.NORTH);

        JPanel panelInferior = new JPanel();
        seePane.add(panelInferior, BorderLayout.SOUTH);
        //new MigLayout("", "["+(ancho*0.5-445)+"][210][210][25.00]", "[57px][15.00]"));
        panelInferior.setLayout(new MigLayout("", "[" + (ancho * 0.25 - 315) + "][210][210][210][" + (ancho * 0.25 - 315) + "]", "[57px][15.00]"));

        JPanel panelCentral = new JPanel();
        seePane.add(panelCentral, BorderLayout.CENTER);
        //new MigLayout("", "[40.00]["+((ancho*0.5/2)-70)+"][50.00]["+((ancho*0.5/2)-70)+"][40.00]", "[][][][][40.00][][][40.00][][][fill]"));
        panelCentral.setLayout(new MigLayout("", "[40.00][271.5,grow][50.00][271.5,grow][40.00]", "[][][][][][][][][][][40.00][][][][][40.00][][][fill]"));

        lblAvisoVer = new JLabel("Solo para visualización. Para modificar los datos, el botón se encuentra en la parte inferior");
        lblAvisoVer.setForeground(new Color(0, 204, 0));
        lblAvisoVer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAvisoVer.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentral.add(lblAvisoVer, "cell 1 0 3 1,alignx center");

        JLabel lblNewLabel = new JLabel("Código");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel, "cell 1 1");

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1, "cell 3 1");

        textFieldCodigoVer = new JTextField();
        textFieldCodigoVer.setEditable(false);
        textFieldCodigoVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldCodigoVer.setToolTipText("Esto campos no pueden ser editados");
        panelCentral.add(textFieldCodigoVer, "cell 1 2,grow");
        textFieldCodigoVer.setColumns(10);

        textFieldNombreVer = new JTextField();
        textFieldNombreVer.setEditable(false);
        textFieldNombreVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldNombreVer.setToolTipText("Estos campos no pueden ser editados");
        panelCentral.add(textFieldNombreVer, "cell 3 2,grow");
        textFieldNombreVer.setColumns(10);

        JLabel lblNewLabelAviso2 = new JLabel("");
        lblNewLabelAviso2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabelAviso2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabelAviso2, "cell 1 3 3 1,alignx center");

        JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1, "cell 3 4");

        JLabel lblNewLabel_1_1_1 = new JLabel("Marca");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_1, "cell 1 4");

        textFieldCantidadVer = new JTextField();
        textFieldCantidadVer.setEditable(false);
        textFieldCantidadVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldCantidadVer.setToolTipText("Estos campos no pueden ser editados");
        textFieldCantidadVer.setColumns(10);
        panelCentral.add(textFieldCantidadVer, "cell 3 5,grow");

        textFieldMarcaVer = new JTextField();
        textFieldMarcaVer.setEditable(false);
        textFieldMarcaVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldMarcaVer.setToolTipText("Estos campos no pueden ser editados");
        textFieldMarcaVer.setColumns(10);
        panelCentral.add(textFieldMarcaVer, "cell 1 5,grow");

        JLabel lblNewLabel_1_1_3 = new JLabel("Porcentaje de Utilidad");
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_3, "cell 1 7");

        JLabel lblNewLabel_1_1_4 = new JLabel("Precio de Venta");
        lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_4, "cell 3 9");

        JLabel lblNewLabel_1_1_5 = new JLabel("Stock mínimo");
        lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_5, "cell 3 7");

        JLabel lblPrecioCompra = new JLabel("Precio de Compra");
        lblPrecioCompra.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblPrecioCompra, "cell 1 9");


        textFieldProfit = new JTextField();
        textFieldProfit.setToolTipText("Estos campos no pueden ser editados");
        textFieldProfit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldProfit.setEditable(false);
        textFieldProfit.setColumns(10);
        panelCentral.add(textFieldProfit, "cell 1 8,growx");

        textFieldSalePrice = new JTextField();
        textFieldSalePrice.setToolTipText("Estos campos no pueden ser editados");
        textFieldSalePrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldSalePrice.setEditable(false);
        textFieldSalePrice.setColumns(10);
        panelCentral.add(textFieldSalePrice, "cell 3 10,growx");

        textFieldRango = new JTextField();
        textFieldRango.setToolTipText("Estos campos no pueden ser editados");
        textFieldRango.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldRango.setEditable(false);
        textFieldRango.setColumns(10);
        panelCentral.add(textFieldRango, "cell 3 8,growx");

        textFieldPrecioCompra = new JTextField();
        textFieldPrecioCompra.setToolTipText("Estos campos no pueden ser editados");
        textFieldPrecioCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldPrecioCompra.setEditable(false);
        textFieldPrecioCompra.setColumns(10);
        panelCentral.add(textFieldPrecioCompra, "cell 1 10,growx");

        JLabel lblNewLabel_1_1_2 = new JLabel("Descripción del producto");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_2, "cell 1 12");

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        txtDescripcionVer = new JTextArea();
        txtDescripcionVer.setEditable(false);
        txtDescripcionVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scroll = new JScrollPane(txtDescripcionVer);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        txtDescripcionVer.setWrapStyleWord(true);
        txtDescripcionVer.setLineWrap(true);
        txtDescripcionVer.setBackground(Color.LIGHT_GRAY);

        panelCentral.add(panel, "cell 1 13 3 1,grow");
        //panel.setLayout(new MigLayout("", "["+ancho*0.47+"]", "[165.00px]"));
        panel.setLayout(new MigLayout("", "[" + ancho * 0.47 + "]", "[165.00px]"));

        panel.add(scroll, "cell 0 0,grow");

        btnModify = new JButton("Modificar");
        btnModify.addActionListener(listener);
        btnModify.setActionCommand(getTextFieldCodigoVer().getText() + "_modifyProduct");
        btnModify.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panelInferior.add(btnModify, "cell 1 0,grow");

        btnDelete = new JButton("Eliminar");
        btnDelete.addActionListener(listener);
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnDelete.setActionCommand(getTextFieldCodigoVer().getText() + "_deleteProduct");
        panelInferior.add(btnDelete, "cell 2 0,grow");

        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(listener);
        btnCancel.setActionCommand("cancelSeeModify");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panelInferior.add(btnCancel, "cell 3 0,grow");
    }

    public void setActionSee() {
        btnCancel.setActionCommand("cancelSeeModify");
        btnDelete.setActionCommand(getTextFieldCodigoVer().getText() + "_deleteProduct");
        btnModify.setActionCommand(getTextFieldCodigoVer().getText() + "_modifyProduct");
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
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
        return JOptionPane.showOptionDialog(jf, msg, "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
    }

    public JTextField getTextFieldCodigoVer() {
        return textFieldCodigoVer;
    }

    public void setTextFieldCodigoVer(String textFieldCodigoVer) {
        this.textFieldCodigoVer.setText(textFieldCodigoVer);
    }

    public JTextField getTextFieldNombreVer() {
        return textFieldNombreVer;
    }

    public void setTextFieldNombreVer(String textFieldNombreVer) {
        this.textFieldNombreVer.setText(textFieldNombreVer);
    }

    public JTextField getTextFieldCantidadVer() {
        return textFieldCantidadVer;
    }

    public void setTextFieldCantidadVer(String textFieldCantidadVer) {
        this.textFieldCantidadVer.setText(textFieldCantidadVer);
    }

    public JTextField getTextFieldMarcaVer() {
        return textFieldMarcaVer;
    }

    public void setTextFieldMarcaVer(String textFieldMarcaVer) {
        this.textFieldMarcaVer.setText(textFieldMarcaVer);
    }

    public JTextArea getTxtDescripcionVer() {
        return txtDescripcionVer;
    }

    public void setTxtDescripcionVer(String txtDescripcionVer) {
        this.txtDescripcionVer.setText(txtDescripcionVer);
    }

    public JLabel getLblAvisoVer() {
        return lblAvisoVer;
    }

    public void setLblAvisoVer(String lblAvisoVer) {
        this.lblAvisoVer.setText(lblAvisoVer);
    }

    public JTextField getTextFieldProfit() {
        return textFieldProfit;
    }

    public void setTextFieldProfit(String textFieldProfit) {
        this.textFieldProfit.setText(textFieldProfit);
        ;
    }

    public JTextField getTextFieldRango() {
        return textFieldRango;
    }

    public void setTextFieldRango(String textFieldRango) {
        this.textFieldRango.setText(textFieldRango);
        ;
    }

    public JTextField getTextFieldSalePrice() {
        return textFieldSalePrice;
    }

    public void setTextFieldSalePrice(String textFieldSalePrice) {
        this.textFieldSalePrice.setText(textFieldSalePrice);
    }

    public void setTextFieldPrecioCompra(String textFieldPrecioCompra) {
        this.textFieldPrecioCompra.setText(textFieldPrecioCompra);
    }
}

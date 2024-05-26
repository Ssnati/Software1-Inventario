package view;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import net.miginfocom.swing.MigLayout;
import persistence.PDFHelpReader;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;

public class Create extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCod;
    private JTextField textFieldNom;
    private JTextField textFieldUtil;
    private JTextField textFieldMarca;
    private JLabel lblAviso;
    private JTextArea txtrADesc;
    private JTextField textFieldRango;
    private JLabel lblAvisoModify;
    private JPanel panelCentral;

    public Create(JFrame frame, boolean modal, ActionListener listener) {
        super(frame, modal);
        initComponents(listener);
        initHelpButton(frame);
    }

    private void initComponents(ActionListener listener) {
        setAlwaysOnTop(true);
        double ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        double alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        setUndecorated(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Shape forma = new RoundRectangle2D.Double(0, 0, ancho * 0.5, alto * 0.6, 30, 30);
        this.setShape(forma);
        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new RoundBorder(new Color(0, 0, 0), 1, true, 30, 30));
        setBounds((int) (ancho / 2 - (ancho * 0.5) / 2), (int) (alto / 2 - (alto * 0.6) / 2), (int) (ancho * 0.5), (int) (alto * 0.6));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblSuperior = new JLabel("CREAR PRODUCTO");
        lblSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        lblSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        lblSuperior.setFont(new Font("Tahoma", Font.PLAIN, 40));
        contentPane.add(lblSuperior, BorderLayout.NORTH);

        JPanel panelInferior = new JPanel();
        contentPane.add(panelInferior, BorderLayout.SOUTH);
        //new MigLayout("", "["+(ancho*0.5-445)+"][210][210][25.00]", "[57px][15.00]"));
        panelInferior.setLayout(new MigLayout("", "[" + ((ancho * 0.5 / 2) - 210) + "][210][210][" + ((ancho * 0.5 / 2) - 210) + "]", "[57px][15.00]"));

        lblAviso = new JLabel("");
        lblAviso.setForeground(new Color(204, 0, 0));
        lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelInferior.add(lblAviso, "cell 0 0,alignx center");

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(listener);

        JButton btnCreate = new JButton("Crear");
        btnCreate.addActionListener(listener);
        btnCreate.setActionCommand("CreateProduct");
        btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panelInferior.add(btnCreate, "cell 1 0,grow");
        btnCancel.setActionCommand("CancelCreate");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panelInferior.add(btnCancel, "cell 2 0,grow");


        panelCentral = new JPanel();
        contentPane.add(panelCentral, BorderLayout.CENTER);
        //new MigLayout("", "[40.00]["+((ancho*0.5/2)-70)+"][50.00]["+((ancho*0.5/2)-70)+"][40.00]", "[][][][][40.00][][][40.00][][][fill]"));
        panelCentral.setLayout(new MigLayout("", "[40.00][" + ((ancho * 0.5 / 2) - 70) + "][50.00][" + ((ancho * 0.5 / 2) - 70) + "][40.00]", "[][][][][40.00][][][40.00][][][fill]"));


        lblAvisoModify = new JLabel("");
        lblAvisoModify.setForeground(new Color(204, 0, 0));
        lblAvisoModify.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAvisoModify.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentral.add(lblAvisoModify, "cell 1 0 3 1,alignx center");


        JLabel lblNewLabel_2_1 = new JLabel("Solo aquellos marcados con un * son obligatorios.");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_2_1, "cell 1 1 3 1,alignx center");

        JLabel lblNewLabel = new JLabel("Código");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel, "cell 1 3");

        JLabel lblNewLabel_1 = new JLabel("Nombre *");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1, "cell 3 3");

        textFieldCod = new JTextField();
        textFieldCod.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldCod.setToolTipText("En caso de no escribirlo el sistema asignará un codigo, recuerde que una vez creado, el codigo no podrá ser cambiado.");
        textFieldCod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if (Character.isLetter(validar)) {
                    e.consume();
                    lblAvisoModify.setText("Debe ingresar numeros enteros positivos.");
                }
            }
        });
        panelCentral.add(textFieldCod, "cell 1 4,grow");
        textFieldCod.setColumns(10);


        textFieldNom = new JTextField();
        textFieldNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldNom.setToolTipText("Ingrese el nombre del producto. Este campo debe ser rellenado obligatoriamente.");
        panelCentral.add(textFieldNom, "cell 3 4,grow");
        textFieldNom.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Porcentaje de Utilidad");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1, "cell 1 6");

        JLabel lblNewLabel_1_1_1 = new JLabel("Marca");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_1_1_1, "cell 3 6");

        JLabel lblNewLabel_rango = new JLabel("                         Stock mínimo");
        lblNewLabel_rango.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabel_rango, "cell  3 6");

        textFieldUtil = new JTextField();
        textFieldUtil.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldUtil.setToolTipText("En caso de no escribirlo el sistema asignará un porcentaje de utilidad del 25% al producto.");
        textFieldUtil.setColumns(10);
        textFieldUtil.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if (Character.isLetter(validar)) {
                    e.consume();
                    lblAvisoModify.setText("Solo se deben ingresar valores numericos positivos. \nPara colocar valores decimales se debe poner (.)");
                }
            }
        });
        panelCentral.add(textFieldUtil, "cell 1 7,grow");


        textFieldMarca = new JTextField();
        textFieldMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldMarca.setToolTipText("Escriba la marca del producto a crear. En caso de no escribirla no se asignara una marca.");
        textFieldMarca.setColumns(10);
        panelCentral.add(textFieldMarca, "cell 3 7,grow");

        textFieldRango = new JTextField();
        textFieldRango.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldRango.setToolTipText("En caso de no escribirlo el sistema asignará un rango de stock mínimo de 5.");
        textFieldRango.setColumns(10);
        textFieldRango.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if (Character.isLetter(validar)) {
                    e.consume();
                    lblAvisoModify.setText("Debe ingresar numeros enteros positivos.");
                }
            }
        });
        panelCentral.add(textFieldRango, "cell 3 7,grow");

        JLabel lblNewLabelDesc = new JLabel("Descripción del producto");
        lblNewLabelDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelCentral.add(lblNewLabelDesc, "cell 1 9");

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        txtrADesc = new JTextArea();
        txtrADesc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scroll = new JScrollPane(txtrADesc);
        txtrADesc.setToolTipText("En este campo se puede poner una descripición para el producto a crear.");
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        txtrADesc.setWrapStyleWord(true);
        txtrADesc.setLineWrap(true);

        panelCentral.add(panel, "cell 1 10 3 1,grow");
        //panel.setLayout(new MigLayout("", "["+ancho*0.47+"]", "[165.00px]"));
        panel.setLayout(new MigLayout("", "[" + ancho * 0.47 + "]", "[165.00px]"));

        panel.add(scroll, "cell 0 0,grow");
    }

    private void initHelpButton(JFrame frame) {
        JButton helpButton = new JButton("Ayuda");
        helpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        helpButton.setBackground(new Color(215, 215, 215));
        helpButton.setFocusPainted(false);
        helpButton.addActionListener(e -> showHelpPDF(frame));
        panelCentral.add(helpButton, "cell 3 1,alignx right");
    }

    public void showHelpPDF(JFrame frame) {
        PDFHelpReader frameHelp = new PDFHelpReader("Manual-Usuario.pdf", 1, frame, this);
        frameHelp.setVisible(true);
        this.setVisible(false);
        frame.setVisible(false);
    }

    public JTextField getTextFieldCod() {
        return textFieldCod;
    }

    public void setTextFieldCod(String textFieldCod) {
        this.textFieldCod.setText(textFieldCod);
    }

    public JTextField getTextFieldNom() {
        return textFieldNom;
    }

    public void setTextFieldNom(String textFieldNom) {
        this.textFieldNom.setText(textFieldNom);
    }

    public JTextField getTextFieldUtil() {
        return textFieldUtil;
    }

    public void setTextFieldUtil(String textFieldUtil) {
        this.textFieldUtil.setText(textFieldUtil);
    }

    public JTextField getTextFieldMarca() {
        return textFieldMarca;
    }

    public void setTextFieldMarca(String textFieldMarca) {
        this.textFieldMarca.setText(textFieldMarca);
    }

    public JLabel getLblAviso() {
        return lblAviso;
    }

    public void setLblAviso(String lblAviso) {
        this.lblAviso.setText(lblAviso);
    }

    public JTextArea getTxtrADesc() {
        return txtrADesc;
    }

    public void setTxtrADesc(String txtrADesc) {
        this.txtrADesc.setText(txtrADesc);
    }

    public JTextField getTextFieldRango() {
        return textFieldRango;
    }

    public void setTextFieldRango(String textFieldRango) {
        this.textFieldRango.setText(textFieldRango);
    }


}

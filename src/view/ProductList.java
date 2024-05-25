package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ProductList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Dimension dim;
    private JTextField textField;
    private ImageIcon seeIcon;
    private JButton searchProduct;
    private JButton btnSeeProduct;
    private JButton btnSellProduct;
    private JButton btnBuy;
    private JButton btnState;
    private JScrollPane scrollPane;
    private JPanel panel_1;
    private JTable table;
    private DefaultTableModel dTable;

    public int getStockMMinimo() {
        return stockMMinimo;
    }

    public void setStockMMinimo(int stockMMinimo) {
        this.stockMMinimo = stockMMinimo;
    }

    private int stockMMinimo;

    public ProductList(ActionListener listener, String[][] dataTable) {
        setUndecorated(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new BorderLayout(0, 0));
        initComponents(listener, dataTable);
    }

    private void initComponents(ActionListener listener, String[][] dataTable) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        dim = super.getToolkit().getScreenSize();
        setSize(dim);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new MigLayout("", "[250.00px,grow]", "[23px,grow]"));

        JPanel panelMenu = new JPanel();
        panel.setBackground(new Color(174, 226, 244));
        panelMenu.setBackground(new Color(174, 226, 244));
        panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));

        panelMenu.setLayout(new MigLayout("", "[20][210][20]", "[69.00][][57.00][][57.00][][57.00][][grow][57.00][]"));

        JLabel lblimage_Menu = new JLabel("");
        ImageIcon iconMaxiCopias = new ImageIcon(getClass().getResource("/iconos/Logo.png"));
        lblimage_Menu.setIcon(iconMaxiCopias);
        panelMenu.add(lblimage_Menu, "cell 1 0");

        JButton btnInventario_Menu = new JButton("INVENTARIO");
        btnInventario_Menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnInventario_Menu.addActionListener(listener);
        btnInventario_Menu.setActionCommand("menu_inventario");
        btnInventario_Menu.setBackground(Color.WHITE);
        panelMenu.add(btnInventario_Menu, "cell 1 2,grow");

        JButton btnHistorial_Menu = new JButton("HISTORIAL");
        btnHistorial_Menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnHistorial_Menu.addActionListener(listener);
        btnHistorial_Menu.setActionCommand("menu_historial");
        btnHistorial_Menu.setBackground(Color.WHITE);
        panelMenu.add(btnHistorial_Menu, "cell 1 4,grow");

        JButton btnCrearProducto_Menu = new JButton("CREAR PRODUCTO");
        btnCrearProducto_Menu.addActionListener(listener);
        btnCrearProducto_Menu.setActionCommand("menu_crear");
        btnCrearProducto_Menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCrearProducto_Menu.setBackground(Color.WHITE);
        panelMenu.add(btnCrearProducto_Menu, "cell 1 6,grow");

        JButton btnCambiarDatosUsuario = new JButton("CAMBIAR CONTRASEÑA");
        btnCambiarDatosUsuario.addActionListener(listener);
        btnCambiarDatosUsuario.setActionCommand("cambiar_contrasena");
        btnCambiarDatosUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCambiarDatosUsuario.setBackground(Color.WHITE);
        btnCambiarDatosUsuario.setPreferredSize(new Dimension(200, 55));
        panelMenu.add(btnCambiarDatosUsuario, "cell 1 8,aligny bottom");

        JButton btnCerrarSesion = new JButton("CERRAR SESION");
        btnCerrarSesion.addActionListener(listener);
        btnCerrarSesion.setActionCommand("menu_cerrar");
        btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCerrarSesion.setBackground(Color.WHITE);
        panelMenu.add(btnCerrarSesion, "cell 1 9,grow");

        panel.add(panelMenu, "cell 0 0,grow");

        panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new MigLayout("", "[18.00][grow][33.00][210][]", "[][][][40][]"));
        JButton btnNewButton = new JButton("Cerrar");
        btnNewButton.setFont(new Font("Verdana", Font.BOLD, 20));
        btnNewButton.setBackground(new Color(204, 0, 0));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFocusPainted(false);
        btnNewButton.addActionListener(listener);
        btnNewButton.setActionCommand("CloseProgram");
        panel_2.add(btnNewButton, "cell 4 0");

        JLabel lblNewLabel = new JLabel("Inventario");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        panel_2.add(lblNewLabel, "cell 0 1 5 1,alignx center");

        textField = new JTextField();
        panel_2.add(textField, "cell 1 3,grow");
        textField.setColumns(10);

        searchProduct = new JButton("Buscar");
        searchProduct.setFont(new Font("Tahoma", Font.PLAIN, 25));
        searchProduct.addActionListener(listener);
        searchProduct.setActionCommand("BuscarProdInvent");
        searchProduct.setBackground(Color.WHITE);
        panel_2.add(searchProduct, "cell 3 3,grow");

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.WEST);
        panel_3.setLayout(new MigLayout("", "[15]", "[]"));

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4, BorderLayout.EAST);
        panel_4.setLayout(new MigLayout("", "[15]", "[]"));

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5, BorderLayout.SOUTH);
        panel_5.setLayout(new MigLayout("", "[]", "[25]"));

        table = new JTable();
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / table.getRowHeight();

                if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                    Object value = table.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                    }
                }
            }
        });

        table.setCellSelectionEnabled(true);
        dTable = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setDefaultRenderer(Object.class, new Render());
        table.setRowHeight(20);

        dTable.addColumn("ID");
        dTable.addColumn("Nombre");
        dTable.addColumn("Descripción");
        dTable.addColumn("Precio");
        dTable.addColumn("Cantidad");
        dTable.addColumn(" ");
        dTable.addColumn(" ");
        dTable.addColumn(" ");
        dTable.addColumn(" ");

        scrollPane = new JScrollPane(table);
        panel_1.add(scrollPane, BorderLayout.CENTER);

        updateTable(listener, dataTable);
    }


    public String getTextFromTextField() {
        return textField.getText();
    }

    public void updateTable(ActionListener listener, String[][] dataTable) {


        seeIcon = new ImageIcon(getClass().getResource("/iconos/ico_ver_prod.png"));

        while (dTable.getRowCount() > 0) {
            dTable.removeRow(0);
        }
        Object[] rowData = new Object[10];
        String id = "";
        for (int i = 0; i < dataTable.length; i++) {
            id = dataTable[i][0];
            btnState = new JButton();
            btnState.setBorderPainted(false);
            if (Integer.parseInt(dataTable[i][5]) <= Integer.parseInt(dataTable[i][9])) {
                btnState.setBackground(Color.RED);
            } else {
                btnState.setBackground(Color.GREEN);
            }
            btnBuy = new JButton("Comprar");
            btnSellProduct = new JButton("Vender");
            btnSeeProduct = new JButton();

            btnSeeProduct.setIcon(seeIcon);
            btnBuy.addActionListener(listener);
            btnBuy.setActionCommand(id + "_TableBuy");
            btnSeeProduct.addActionListener(listener);
            btnSeeProduct.setActionCommand(id + "_TableSee");
            btnSellProduct.addActionListener(listener);
            btnSellProduct.setActionCommand(id + "_TableSell");
            rowData[0] = id;
            rowData[1] = dataTable[i][1];
            rowData[2] = dataTable[i][4];
            rowData[3] = dataTable[i][7];
            rowData[4] = dataTable[i][5];
            rowData[5] = btnState;
            rowData[6] = btnSeeProduct;
            rowData[7] = btnSellProduct;
            rowData[8] = btnBuy;
            dTable.addRow(rowData);
        }
        table.setModel(dTable);

        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(350);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(5).setResizable(false);
        table.getTableHeader().setReorderingAllowed(false);

    }
}

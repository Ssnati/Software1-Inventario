package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;
import net.miginfocom.swing.MigLayout;
import persistence.PDFHelpReader;

import java.awt.Label;
import javax.swing.JTextField;

public class HVR extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Dimension dim;
    private JTextField totalVendido;
    private JTextField totalGanancias;
    private JTable table;
    public JDateChooser fechaInicio;
    public JDateChooser fechaFin;
    private JPanel panelCentral;
    private DefaultTableModel dTable;
    private JPanel panelMid;

    public HVR(ActionListener listener, String[][] dataTable, String ganado, String vendido) {
        setUndecorated(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        initComponents(listener, dataTable, ganado, vendido);
        initHelpButton();
    }

    private void initComponents(ActionListener listener, String[][] dataTable, String ganado, String vendido) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        contentPane = new JPanel();
        dim = super.getToolkit().getScreenSize();
        setSize(dim);


        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));


        JPanel panelIzq = new JPanel();
        contentPane.add(panelIzq, BorderLayout.WEST);
        panelIzq.setLayout(new MigLayout("", "[250px,grow]", "[23px,grow]"));

        JPanel panelMenu = new JPanel();
        panelIzq.setBackground(new Color(174, 226, 244));
        panelMenu.setBackground(new Color(174, 226, 244));
        panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelIzq.add(panelMenu, "cell 0 0,grow");
        panelMenu.setLayout(new MigLayout("", "[20][210][20]", "[69.00][][57.00][][57.00][][57.00][][grow][57.00][]"));

        JLabel lblimage_Menu = new JLabel("");
        ImageIcon iconMaxiCopias = new ImageIcon(getClass().getResource("/iconos/Logo.png"));
        lblimage_Menu.setIcon(iconMaxiCopias);
        panelMenu.add(lblimage_Menu, "cell 1 0,alignx center");

        JButton btnInventario_Menu = new JButton("INVENTARIO");
        btnInventario_Menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnInventario_Menu.addActionListener(listener);
        btnInventario_Menu.setBackground(Color.WHITE);
        btnInventario_Menu.setActionCommand("menu_inventario");
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

        panelCentral = new JPanel();
        contentPane.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0, 0));

        panelMid = new JPanel();
        panelCentral.add(panelMid, BorderLayout.NORTH);
        panelMid.setLayout(new MigLayout("", "[85][200.00][250.00][70.00,grow][200.00][250.00][25.00][210px][]", "[][][][40px][]"));

        JButton btnNewButton = new JButton("Cerrar");
        btnNewButton.setBackground(new Color(204, 0, 0));
        btnNewButton.setFont(new Font("Verdana", Font.BOLD, 20));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(listener);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setActionCommand("CloseProgram");
        panelMid.add(btnNewButton, "cell 8 0");

        JLabel lblNewLabel = new JLabel("Historial de ventas");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        panelMid.add(lblNewLabel, "cell 0 1 8 1,alignx center,aligny top");

        JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelMid.add(lblNewLabel_1, "cell 1 3,alignx center");

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        fechaInicio = new JDateChooser();
        fechaInicio.setDate(currentDate);
        panelMid.add(fechaInicio, "cell 2 3,grow");

        JLabel lblNewLabel_2 = new JLabel("Fecha Fin");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelMid.add(lblNewLabel_2, "cell 4 3,alignx center");

        fechaFin = new JDateChooser();
        fechaFin.setDate(currentDate);
        panelMid.add(fechaFin, "cell 5 3,grow");

        JButton btnNewButton_2 = new JButton("Filtrar");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_2.addActionListener(listener);
        btnNewButton_2.setActionCommand("FiltrarPorFecha");
        btnNewButton_2.setBackground(Color.WHITE);
        panelMid.add(btnNewButton_2, "cell 7 3,grow");


        JPanel panel_1 = new JPanel();
        panelCentral.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new MigLayout("", "[225.00][200][300][200][300]", "[][40][]"));

        JLabel lblNewLabel_3 = new JLabel("Total Ganancias");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(lblNewLabel_3, "cell 1 1");

        totalGanancias = new JTextField();
        totalGanancias.setEditable(false);
        panel_1.add(totalGanancias, "cell 2 1,grow");

        Label label = new Label("Total Vendido");
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(label, "cell 3 1");

        totalVendido = new JTextField();
        totalVendido.setEditable(false);
        panel_1.add(totalVendido, "cell 4 1,grow");
        totalVendido.setColumns(10);

        JPanel panel_2 = new JPanel();
        panelCentral.add(panel_2, BorderLayout.EAST);
        panel_2.setLayout(new MigLayout("", "[15]", "[]"));

        JPanel panel_3 = new JPanel();
        panelCentral.add(panel_3, BorderLayout.WEST);
        panel_3.setLayout(new MigLayout("", "[15]", "[]"));

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
        dTable.addColumn("Descripcion");
        dTable.addColumn("Cantidad");
        dTable.addColumn("Utilidad");
        dTable.addColumn("Valor de compra");
        dTable.addColumn("Valor de venta");
        dTable.addColumn("Fecha de venta");
        JScrollPane scrollPane = new JScrollPane(table);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        updateTable(listener, dataTable, ganado, vendido);
    }

    public void updateTable(ActionListener listener, String[][] dataTable, String ganado, String vendido) {

        new ImageIcon(getClass().getResource("/iconos/ico_ver_prod.png"));

        while (dTable.getRowCount() > 0) {
            dTable.removeRow(0);
        }
        Object[] rowData = new Object[8];
        String id;
        for (int i = 0; i < dataTable.length; i++) {
            id = dataTable[i][0];
            rowData[0] = id;
            rowData[1] = dataTable[i][1];
            rowData[2] = dataTable[i][4];
            rowData[3] = dataTable[i][5];
            rowData[4] = dataTable[i][2] + " %";
            rowData[5] = dataTable[i][8];
            rowData[6] = dataTable[i][7];
            rowData[7] = dataTable[i][6];
            dTable.addRow(rowData);
        }
        table.setModel(dTable);

        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(17);
        table.getColumnModel().getColumn(6).setPreferredWidth(17);
        table.getColumnModel().getColumn(7).setPreferredWidth(10);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(5).setResizable(false);
        table.getTableHeader().setReorderingAllowed(false);

        totalVendido.setText("  $" + vendido);
        totalGanancias.setText("  $" + ganado);
    }

    private void initHelpButton() {
        JButton helpButton = new JButton("Ayuda");
        helpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        helpButton.setBackground(new Color(215, 215, 215));
        helpButton.addActionListener(e -> showHelpPDF());
        panelMid.add(helpButton, "cell 8 3,grow");
    }

    public void showHelpPDF() {
        PDFHelpReader frameHelp = new PDFHelpReader("Manual-Usuario.pdf", 1, this);
        frameHelp.setVisible(true);
        this.setVisible(false);
    }

    public String getFechaIniString() {
        JTextField dateEditorField = (JTextField) fechaInicio.getDateEditor().getUiComponent();
        String textoFecha = dateEditorField.getText();
        return textoFecha;
    }

    public String getFechaFinString() {
        JTextField dateEditorField = (JTextField) fechaFin.getDateEditor().getUiComponent();
        String textoFecha = dateEditorField.getText();
        return textoFecha;
    }

    public String getFechaFormatFinString() {
        return fechaFin.getDateFormatString();
    }

    public LocalDate getFechaIni() {
        Date fechaIni = fechaInicio.getDate();
        return fechaIni.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getFechaFin() {
        Date fechaF = fechaFin.getDate();
        return fechaF.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Date getDateIni() {
        return fechaInicio.getDate();
    }

    public Date getDateFin() {
        return fechaFin.getDate();
    }
}

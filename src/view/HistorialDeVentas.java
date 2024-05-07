package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import net.miginfocom.swing.MigLayout;

public class HistorialDeVentas extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ImageIcon seeIcon;
	private JButton btnSellProduct;
	private JTextField textField_1;
	private JTextField textField;

	public HistorialDeVentas(ActionListener listener, String[][] dataTable) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(bounds.width, bounds.height);
        setLocation(bounds.x, bounds.y);
		contentPane = new JPanel();
		contentPane.setSize(bounds.width, bounds.height);
		contentPane.setLocation(bounds.x, bounds.y);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		
		seeIcon = new ImageIcon(getClass().getResource("/iconos/ico_ver_prod.png"));
		
		table = new JTable();
		
		table.setCellSelectionEnabled(true);
		DefaultTableModel dTable = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setDefaultRenderer(Object.class, new Render());
		table.setModel(dTable);
		table.setRowHeight(20);
		
		dTable.addColumn("ID");
		dTable.addColumn("Nombre");
		dTable.addColumn("Descripción");
		dTable.addColumn("Precio");
		dTable.addColumn(" ");
		dTable.addColumn(" ");
		Object[] rowData = new Object[6];
		String id = "";
		for (int i = 0; i < dataTable.length; i++) {
			id = dataTable[i][0];
			btnSellProduct = new JButton("Vender");
			JButton btnSeeProduct = new JButton();
			btnSeeProduct.setOpaque(false);
			btnSeeProduct.setContentAreaFilled(false);
			btnSeeProduct.setIcon(seeIcon);
			btnSeeProduct.setBorderPainted(false);
			btnSeeProduct.addActionListener(listener);
			btnSeeProduct.setActionCommand("T_see"+id);
			btnSellProduct.addActionListener(listener);
			btnSellProduct.setActionCommand("T_sell"+id);
			rowData[0] = id;
			rowData[1] = dataTable[i][1];
			rowData[2] = dataTable[i][2];
			rowData[3] = dataTable[i][3];
			rowData[4] = btnSeeProduct;
			rowData[5] = btnSellProduct;
			dTable.addRow(rowData);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(17);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		
		
		contentPane.setLayout(new MigLayout("", "[303.00px][22.00][206px][9px][97px][25px][49px][70px][134px][10px][157px][10px][3px][53px][197px]", "[89px][28px][33px][29px][489px][5.00px][29.00px]"));
		JScrollPane scrollPane_1 = new JScrollPane(table);
		contentPane.add(scrollPane_1, "cell 2 4 13 1,grow");
		JButton filterButton = new JButton("Filtrar");
		filterButton.addActionListener(listener);
		filterButton.setActionCommand("filter");
		contentPane.add(filterButton, "cell 14 2,grow");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 0 1 7,grow");
		
		JLabel lblNewLabel = new JLabel("Historial de ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		contentPane.add(lblNewLabel, "cell 4 0 9 1,growx,aligny bottom");
		
		Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDate(currentDate);
		contentPane.add(dateChooser, "cell 4 2 3 1,grow");
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDate(currentDate);
		contentPane.add(dateChooser_1, "cell 10 2 3 1,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1, "cell 2 2,alignx right,growy");
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha Fin");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1_1, "cell 8 2,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Total Vendido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_2, "cell 10 6,alignx trailing,aligny center");
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Ganancias");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_2_1, "cell 4 6,growx,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setText("$ 1.200");
		textField_1.setMargin(new Insets(2, 15, 2, 2));
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setDisabledTextColor(Color.DARK_GRAY);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		contentPane.add(textField_1, "cell 6 6 3 1,growx,aligny top");
		
		textField = new JTextField();
		textField.setText("$ 1.200");
		textField.setMargin(new Insets(2, 15, 2, 2));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setDisabledTextColor(Color.DARK_GRAY);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		contentPane.add(textField, "cell 12 6 3 1,growx,aligny top");
		
		setVisible(true);
	}
}
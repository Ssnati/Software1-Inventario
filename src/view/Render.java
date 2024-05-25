package view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		if (value instanceof JButton) {//Pregunto si el dato que instancio es un boton
			JButton btn = (JButton) value;//asignelo a la tabla
			return btn;
		}

		if (value instanceof JLabel) {
			JLabel lbl = (JLabel) value;
			return lbl;
		}

		if (value instanceof JPanel) {
			JPanel panel = (JPanel) value;
			return panel;
		}
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}

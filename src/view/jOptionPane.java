package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class jOptionPane {
	private JFrame jf;
	
	public jOptionPane() {
		jf=new JFrame();
		jf.setAlwaysOnTop(true);
	}
	
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(jf, msg,"",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(jf, msg,"",JOptionPane.ERROR_MESSAGE);
	}
}

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class RoundBorder extends AbstractBorder {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Color color;
    private final int thickness;
    private final boolean rounded;
    private int wArc;
    private int hArc;

    public RoundBorder(Color color, int thickness, boolean rounded, int wArc, int hArc) {
        this.color = color;
        this.thickness = thickness;
        this.rounded = rounded;
        this.wArc = wArc;
        this.hArc = hArc;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        if (rounded) {
            g.drawRoundRect(x, y, width - 1, height - 1, wArc, hArc); // Ajusta el radio según sea necesario
        } else {
            g.drawRect(x, y, width - 1, height - 1);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = thickness;
        return insets;
    }
}
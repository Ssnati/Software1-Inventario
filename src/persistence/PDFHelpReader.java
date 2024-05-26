package persistence;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFHelpReader extends JFrame {

    public PDFHelpReader(String pdfPath, int pageIndex, JFrame parentFrame) {
        setTitle("PDF Viewer");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnClosePanel = new JButton("Atras");
        btnClosePanel.setFont(new Font("Verdana", Font.BOLD, 20));
        btnClosePanel.setBackground(new Color(136, 136, 136));
        btnClosePanel.setForeground(Color.WHITE);
        btnClosePanel.setFocusPainted(false);
        btnClosePanel.addActionListener(e -> {
            parentFrame.setVisible(true);
            dispose();
        });
        add(btnClosePanel, BorderLayout.NORTH);
        try {
            PDDocument document = PDDocument.load(new File(pdfPath));
            JScrollPane scrollPane = getjScrollPane(document, pageIndex);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            add(scrollPane);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar el PDF: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static JScrollPane getjScrollPane(PDDocument document, int pageIndex) throws IOException {
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(pageIndex, 180);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);

        JLabel jLabel = new JLabel(imageIcon);
        JScrollPane scrollPane = new JScrollPane(jLabel);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }
}

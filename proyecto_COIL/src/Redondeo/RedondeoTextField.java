package Redondeo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RedondeoTextField extends JTextField {
    private int cornerRadius = 15;

    public RedondeoTextField(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape round = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        g2.setColor(getBackground());
        g2.fill(round);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Opcional: dibuja el borde si lo necesitas
    }
}
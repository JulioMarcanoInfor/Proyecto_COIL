package Redondeo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RedondeoPanel extends JPanel {
    private int cornerRadius = 15;

    public RedondeoPanel(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape round = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcs.width, arcs.height);
        g2.setColor(getBackground());
        g2.fill(round);
    }
}
package com.panaderiamatemagica.core.visual.componentes;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JComponent;

/**
 * Panel que escala automáticamente sus componentes hijos
 * manteniendo las proporciones relativas al tamaño de diseño original.
 */
public class ResponsivePanel extends JPanel {
    private final int designWidth;
    private final int designHeight;

    /**
     * Crea un panel responsivo
     * 
     * @param designWidth  Ancho de diseño original (ej: 640)
     * @param designHeight Alto de diseño original (ej: 660)
     */
    public ResponsivePanel(int designWidth, int designHeight) {
        super(null); // Layout nulo para posicionamiento manual
        this.designWidth = designWidth;
        this.designHeight = designHeight;
    }

    @Override
    public void doLayout() {
        super.doLayout();

        // Calcular factores de escala
        double scaleX = (double) getWidth() / designWidth;
        double scaleY = (double) getHeight() / designHeight;

        // Usar el factor de escala más pequeño para mantener proporciones
        double scale = Math.min(scaleX, scaleY);

        // Calcular offsets para centrar el contenido
        int offsetX = (int) ((getWidth() - (designWidth * scale)) / 2);
        int offsetY = (int) ((getHeight() - (designHeight * scale)) / 2);

        // Escalar y reposicionar todos los componentes hijos
        for (Component comp : getComponents()) {
            if (comp instanceof JComponent && comp.getBounds() != null) {
                JComponent jcomp = (JComponent) comp;
                Rectangle originalBounds = getOriginalBounds(jcomp);

                int newX = offsetX + (int) (originalBounds.x * scale);
                int newY = offsetY + (int) (originalBounds.y * scale);
                int newWidth = (int) (originalBounds.width * scale);
                int newHeight = (int) (originalBounds.height * scale);

                comp.setBounds(newX, newY, newWidth, newHeight);

                // Escalar fuente si es posible
                if (comp.getFont() != null) {
                    Font originalFont = getOriginalFont(jcomp);
                    float newSize = (float) (originalFont.getSize() * scale);
                    comp.setFont(originalFont.deriveFont(newSize));
                }
            }
        }
    }

    /**
     * Almacena las dimensiones originales del componente
     */
    public void addScalable(Component comp, int x, int y, int width, int height) {
        if (comp instanceof JComponent) {
            JComponent jcomp = (JComponent) comp;
            jcomp.putClientProperty("originalBounds", new Rectangle(x, y, width, height));
            jcomp.putClientProperty("originalFont", comp.getFont());
        }
        comp.setBounds(x, y, width, height);
        add(comp);
    }

    private Rectangle getOriginalBounds(JComponent comp) {
        Rectangle bounds = (Rectangle) comp.getClientProperty("originalBounds");
        return bounds != null ? bounds : comp.getBounds();
    }

    private Font getOriginalFont(JComponent comp) {
        Font font = (Font) comp.getClientProperty("originalFont");
        return font != null ? font : comp.getFont();
    }
}

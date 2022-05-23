
package Modelo;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class IconCellRenderer extends DefaultTableCellRenderer {
    
    private ImageIcon icono = new ImageIcon(getClass().getResource("/RecursosGraficos/btnEliminar.png"));
    
    public void fillColor(JTable tabla, JLabel etiqueta, boolean isSelected) {
        if (isSelected) {
            etiqueta.setBackground(tabla.getSelectionBackground());
            etiqueta.setForeground(tabla.getSelectionForeground());
        } else {
            etiqueta.setBackground(tabla.getBackground());
            etiqueta.setForeground(tabla.getForeground());
        }
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (value instanceof JLabel) {
            JLabel etiqueta = (JLabel) value;
            etiqueta.setIcon(icono);
            etiqueta.setOpaque(true);
            etiqueta.setBorder(javax.swing.BorderFactory.createSoftBevelBorder(javax.swing.border.SoftBevelBorder.RAISED));
            fillColor(table, etiqueta, isSelected);
            return etiqueta;
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

}

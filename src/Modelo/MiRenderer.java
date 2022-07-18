

package Modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class MiRenderer extends DefaultTableCellRenderer {

    Color background;
    Color foreground;
    

    public MiRenderer(Color background, Color foreground) {
        super();
        this.background = background;
        this.foreground = foreground;
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        comp.setBackground(background);
        comp.setForeground(foreground);
        comp.setFont(new java.awt.Font("Roboto", 3, 20));
        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        return comp;
    }

}

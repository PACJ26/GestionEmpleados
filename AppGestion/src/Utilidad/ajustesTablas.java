
package Utilidad;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class ajustesTablas {
     public static void ajustarTabla(JTable tabla) {

        int totalColumnas = 13;
        int alturaEncabezado = 30;
       
        for (int i = 0; i < totalColumnas; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(125);
            tabla.getColumnModel().getColumn(i).setResizable(false);
            tabla.setRowHeight(30);
        }
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), alturaEncabezado));

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        headerRenderer.setVerticalAlignment(JLabel.CENTER);
        headerRenderer.setBackground(new Color(133, 198, 241));
        headerRenderer.setOpaque(true);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer.setVerticalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < totalColumnas; i++) {
            tabla.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            tabla.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
}

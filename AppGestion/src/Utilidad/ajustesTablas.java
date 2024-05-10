package Utilidad;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ajustesTablas {

    public static void ajustarTabla(JTable tabla) {
        // Ajuste de ancho de columnas
        ajustarAnchoColumnas(tabla);

        // Ajuste de altura de filas
        tabla.setRowHeight(30);

        // Ajuste del renderizador de celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tabla.setDefaultRenderer(Object.class, centerRenderer);

        // Ajuste del renderizador de encabezados
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        headerRenderer.setVerticalAlignment(DefaultTableCellRenderer.CENTER);

        // Establecer color de fondo y otros ajustes de los encabezados
        setColorFondoEncabezados(tabla);
    }

    private static void ajustarAnchoColumnas(JTable tabla) {
        int totalColumnas = tabla.getColumnCount();
        for (int i = 0; i < totalColumnas; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(125);
            tabla.getColumnModel().getColumn(i).setResizable(false);
        }
    }

    private static void setColorFondoEncabezados(JTable tabla) {
        JTableHeader header = tabla.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer());
    }

    static class HeaderRenderer extends DefaultTableCellRenderer {
        public HeaderRenderer() {
            setOpaque(true);
            setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            setVerticalAlignment(DefaultTableCellRenderer.CENTER);
            setForeground(Color.WHITE); // Establecer el color del texto
            setBackground(Color.darkGray); // Establecer el color de fondo
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Establecer el borde
            setFont(new Font("Arial", Font.BOLD, 13)); // Establecer la fuente y la negrita
            return this;
        }
    }
}

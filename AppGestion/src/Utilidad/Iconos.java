package Utilidad;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Juan
 */
public class Iconos {

    public static void setIcon(JTabbedPane tabbedPane, int index, String imageName) {
        // Obtener la ruta completa de la imagen
        String pathToIcon = "/img/ICONOS/" + imageName;
        // Crear el ImageIcon
        ImageIcon icon = new ImageIcon(Iconos.class.getResource(pathToIcon));
        // Establecer el icono en el tab correspondiente
        tabbedPane.setIconAt(index, icon);
    }

    public static void setJFrameIcon(JFrame frame, String imageName) {
        // Obtener la ruta completa de la imagen
        String pathToIcon = "/img/ICONOS/" + imageName;
        // Crear el ImageIcon
        ImageIcon icon = new ImageIcon(Iconos.class.getResource(pathToIcon));
        // Establecer el icono en el JFrame
        frame.setIconImage(icon.getImage());
    }

}

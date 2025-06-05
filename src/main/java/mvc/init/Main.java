package mvc.init;

import com.formdev.flatlaf.FlatDarkLaf;  // Importar FlatDarkLaf
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;  // Importar para manejar la excepciÃ³n
import mvc.view.PrincipalView;
import mvc.control.Controlador;

public class Main {
    public static void main(String[] args) {
        try {
            // Establecer el Look and Feel de FlatLaf (tema oscuro)
            UIManager.setLookAndFeel(new FlatDarkLaf());


        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  // Si ocurre un error al configurar el Look and Feel
        }
        try {
            PrincipalView vista = new PrincipalView();
            new Controlador(vista);
            vista.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace(); // Esto imprimirá la excepción real en consola
        }
    }
}
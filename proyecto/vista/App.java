package vista;

import javax.swing.JFrame;

import controlador.Controlador;

public class App {
    /**
     * Inicia una ventana para mostrar la simulación.
     */
    public static void initWindow() {
        JFrame window = new JFrame("Simulación");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel board = new Panel();
        window.add(board);
        Controlador input = board.getControlador();
        window.addMouseListener(input);

        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

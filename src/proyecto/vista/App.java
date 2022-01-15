package proyecto.vista;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import proyecto.controlador.Controlador;

public class App {
    /**
     * Inicia una ventana para mostrar la simulación.
     */
    public static void initWindow() {
        JFrame window = new JFrame("Simulación");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimulationPanel simulationPanel = new SimulationPanel();
        window.add(new UIPanel(simulationPanel.getControlador()), BorderLayout.EAST);
        window.add(simulationPanel);
        Controlador input = simulationPanel.getControlador();
        window.addMouseListener(input);

        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

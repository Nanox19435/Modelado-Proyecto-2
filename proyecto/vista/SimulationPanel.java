package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;

import javax.swing.JPanel;

import controlador.Controlador;
import modelo.entidades.Entidad;

public class SimulationPanel extends JPanel {

    private Controlador controlador;

    public SimulationPanel() {
        setPreferredSize(new Dimension(500, 500));
        this.controlador = new Controlador(this);
    }

    /**
     * Regresa el controlador asociado a este panel.
     */
    public Controlador getControlador() {
        return this.controlador;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<Entidad> iter = controlador.getEntidades();
        while (iter.hasNext()) {
            //Pinta a las entidades
            Entidad e = iter.next();
            if (e == null) continue;
            e.draw((Graphics2D) g);
        }
    }
}

package proyecto.controlador.strategy;

import java.awt.*;
import java.awt.event.*;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;
import proyecto.modelo.entidades.Nombres;

/**
 * Estragia de spawnear al preso
 */
public class SpawnPreso implements ClickStrategy {

    @Override
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador) {
        Point clickPosition = e.getPoint();
        //Corregimos un ligero desfase que ocurre por el uso de paneles.
        clickPosition.y -= 30;
        modelo.agregaPreso(Nombres.getNombre(), clickPosition);
    }
    
}

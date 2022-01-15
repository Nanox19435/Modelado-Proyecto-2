package proyecto.controlador.strategy;

import java.awt.event.*;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;

/**
 * Implementación del patrón strategy para cuando el usuario interactua con la simulación.
 */
public interface ClickStrategy {
    /** Estrategia a usar cuando se da clic. */
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador);
}

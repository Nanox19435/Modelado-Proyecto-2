package proyecto.controlador.strategy;

import java.awt.event.MouseEvent;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;

/**
 * Esta estrategia no hace nada. Apreviación de Uncaring Void
 */
public class UVoid implements ClickStrategy {
    @Override
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador) {}
}

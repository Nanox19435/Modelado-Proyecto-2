package proyecto.controlador.strategy;

import java.awt.event.MouseEvent;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;

public class UVoid implements ClickStrategy {
    @Override
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador) {}
}

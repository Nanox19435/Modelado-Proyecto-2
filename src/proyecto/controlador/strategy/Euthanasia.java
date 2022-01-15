package proyecto.controlador.strategy;

import java.awt.*;
import java.awt.event.MouseEvent;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;
import proyecto.modelo.entidades.Entidad;

/**
 * Estrategia de eutanasiar.
 */
public class Euthanasia implements ClickStrategy {

    @Override
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador) {
        Point clickPosition = e.getPoint();
        //Corregimos un ligero desfase que ocurre por el uso de paneles.
        clickPosition.y -= 30;
        Entidad entidad = controlador.seleccionar(clickPosition);
        if (entidad==null) return;
        modelo.eutanasiar(entidad);
    }
    
}

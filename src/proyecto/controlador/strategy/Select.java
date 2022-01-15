package proyecto.controlador.strategy;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;
import proyecto.modelo.entidades.Entidad;

/**
 * Estrategia de seleccionar una entidad
 */
public class Select implements ClickStrategy {
    
    @Override
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador) {
        Point clickPosition = e.getPoint();
        //Corregimos un ligero desfase que ocurre por el uso de paneles.
        clickPosition.y -= 30;
        Entidad entidad = controlador.seleccionar(clickPosition);
        if (entidad == null) return;
        JOptionPane.showMessageDialog(null, entidad.info());
        
    }
    
}

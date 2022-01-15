package proyecto.controlador.strategy;

import java.awt.Point;
import java.awt.event.MouseEvent;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;
import proyecto.modelo.entidades.Nombres;

public class SpawnGuardia implements ClickStrategy {

    @Override
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador) {
        Point clickPosition = e.getPoint();
        //Corregimos un ligero desfase que ocurre por el uso de paneles.
        clickPosition.y -= 30;
        modelo.agregaGuardia(Nombres.getNombre(), clickPosition);
        
    }
    
}

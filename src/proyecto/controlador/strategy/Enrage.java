package proyecto.controlador.strategy;

import java.awt.*;
import java.awt.event.MouseEvent;

import proyecto.controlador.Controlador;
import proyecto.modelo.Prision;
import proyecto.modelo.entidades.Entidad;
import proyecto.modelo.entidades.Preso;
import proyecto.modelo.state.preso.Agresivo;

public class Enrage implements ClickStrategy {

    @Override
    public void onClick(MouseEvent e, Prision modelo, Controlador controlador) {
        Point clickPosition = e.getPoint();
        //Corregimos un ligero desfase que ocurre por el uso de paneles.
        clickPosition.y -= 30;
        
        Preso p = controlador.seleccionarPreso(clickPosition);
        if (p == null) return;
        Entidad random = modelo.entidadAzar(p);
        if (random==null) return;
        p.cerebro = new Agresivo(p, random);
        //Notifica a los guardias de que hay un prisionero agresivo.
        controlador.notifyAgression(p);
    }


}

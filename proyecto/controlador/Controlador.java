package controlador;

import java.util.Iterator;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

import modelo.Prision;
import modelo.entidades.Entidad;
import modelo.entidades.Preso;
import modelo.state.preso.Agresivo;
import vista.SimulationPanel;
/**
 * Maneja la entrada del usuario y la interacción entre la vista y el modelo (Simulación).
 */
public class Controlador implements MouseInputListener {
    private Prision modelo;
    private SimulationPanel vista;
    private ClickModes modo;

    public Controlador(SimulationPanel vista) {
        this.modelo = new Prision(this);
        this.vista = vista;
        this.modo = ClickModes.AparecerPreso;
    }

    /**
     * Modifica el modo de clic, de tal forma que cambia la acción que se realizará cuando el usuario haga clic en el panel de la simulación.
     * @param modo Nuevo modo.
     */
    public void setClicMode(ClickModes modo) {
        this.modo = modo;
    }

    /**
     * Regresa un iterador con todas las entidades indiscriminadamente.
     * @return
     */
    public Iterator<Entidad> getEntidades() {
        return modelo.getEntidades();
    }

    /**
     * Para llamarse cuando se acabe la lógica. Manda a repintar la pantalla.
     */
    public void requestRedraw() {
        vista.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // No se implementa porque no se usa.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // No se implementa porque no se usa.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // No se implementa porque no se usa.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point clickPosition = e.getPoint();
        //Corregimos un ligero desfase que ocurre por el uso de paneles.
        clickPosition.y -= 30;
        //No hace nada si se se hace clic fuera del panel de la simulación.
        if (500 <= clickPosition.x || 500 <= clickPosition.y) return;

        switch (this.modo) {
            case AparecerPreso:
                modelo.agregaPreso("", clickPosition);
                break;
            case AparecerGuardia:
                modelo.agregaGuardia("", clickPosition);
                break;
            case Seleccionar: //Muestra al usuario la información del 
                {
                    Entidad entidad = seleccionar(clickPosition);
                    JOptionPane.showMessageDialog(null, entidad.info());
                }
                break;
            case Enfurecer: //Vuelve agresivo al prisionero (Sólo prisioneros).
                Preso p = seleccionarPreso(clickPosition);
                if (p == null) break;
                Entidad random = modelo.entidadAzar(p);
                if (random==null) break;
                p.cerebro = new Agresivo(p, random);
                break;
            case Matar:
                {
                    Entidad entidad = seleccionar(clickPosition);
                    if (entidad==null) break;
                    modelo.eutanasiar(entidad);
                }
                break;
            case Inactivo:
                //En este caso no se hace nada.
                break;
            
        }
        
    }

    /**
     * Regresa la primera entidad que encuentre que contenga el punto p en su forma de colisión.
     * @param p punto a examinar.
     * @return una entidad que contenga al punto, si existe. null si no.
     */
    private Entidad seleccionar(Point p) {
        Iterator<Entidad> iter = modelo.getEntidades();
        while (iter.hasNext()) {
            Entidad entidad = iter.next();
            if (entidad == null) continue;
            if (entidad.shape().contains(p)) 
                return entidad;
        }
        return null;
    }

    /**
     * Regresa el primer guardia que contenga el punto p en su forma de colisión.
     * @param p punto a examinar
     * @return un guardia que contenga al punto, si existe. null si no.
     */
    private Preso seleccionarPreso(Point p) {
        Iterator<Preso> iter = modelo.getPresos();
        while (iter.hasNext()) {
            Preso preso = iter.next();
            if (preso == null) continue;
            if (preso.shape().contains(p)) 
                return preso;
        }
        return null;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // No se implementa porque no se usa.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // No se implementa porque no se usa.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // No se implementa porque no se usa.
    }
    
}

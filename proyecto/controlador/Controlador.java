package controlador;

import java.util.Iterator;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import modelo.Prision;
import modelo.entidades.Entidad;
import vista.Panel;
/**
 * Maneja la entrada del usuario y la interacción entre la vista y el modelo (Simulación).
 */
public class Controlador implements MouseInputListener {
    private Prision modelo;
    private Panel vista;

    public Controlador(Panel vista) {
        this.modelo = new Prision(this);
        this.vista = vista;
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point clickPosition = e.getPoint();
        //Corregimos un ligero desfase que ocurre por el uso de paneles.
        clickPosition.y -= 30;

        modelo.agregaPreso("", clickPosition);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}

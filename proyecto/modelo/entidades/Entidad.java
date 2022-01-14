package modelo.entidades;

//import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;

import aux.IDeable;
import modelo.Observer.DateObserver;
import modelo.state.State;

public abstract class Entidad implements DateObserver, IDeable {
    public State cerebro;
    private int id;
    protected String nombre;
    public Point2D.Float position;
    
    /**
     * Mueve a la direccion dada esta entidad.
     */
    public void goTo() {
        //TODO
    }

    /**
     * Permite cambiar la ID de un preso
     * @param id
     */
    public void setID(int ID) {
        this.id = ID;
    }

    /**
     * Regresa la ID de este preso.
     * @return
     */
    public int getID() {
        return this.id;
    }

    public abstract Rectangle shape();

    public abstract void draw(Graphics2D g2D);
    
}

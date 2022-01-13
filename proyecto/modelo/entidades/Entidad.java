package modelo.entidades;

import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.*;

import modelo.Observer.DateObserver;
import modelo.state.State;

public abstract class Entidad implements DateObserver {
    public State cerebro;
    private int id;
    protected String nombre;
    public Point position;
    protected Rectangle2D collision;
    
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
    public void setId(int ID) {
        this.id = ID;
    }

    /**
     * Regresa la ID de este preso.
     * @return
     */
    public int getID() {
        return this.id;
    }

    public abstract void draw(Graphics2D g2D);
    
}

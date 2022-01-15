package proyecto.modelo.entidades;

//import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;

import proyecto.aux.IDeable;
import proyecto.modelo.Observer.DateObserver;
import proyecto.modelo.state.State;

public abstract class Entidad implements IDeable {
    public State cerebro;
    private int id;
    protected String nombre;
    public Point2D.Float position;

    @Override
    public void setID(int ID) {
        this.id = ID;
    }

    @Override
    public int getID() {
        return this.id;
    }

    /**
     * Regresa la información de esta entidad. Usese ara comunicar al usuario del estado de esta entidad.
     * @return
     */
    public abstract String info();

    /**
     * Calcula el rectangulo que constituye a esta entidad. Usese para hacer operaciones con el área.
     * @return
     */
    public abstract Rectangle shape();

    /**
     * Dibuja a esta entidad.
     * @param g2D objeto para dibujar.
     */
    public abstract void draw(Graphics2D g2D);
    
}

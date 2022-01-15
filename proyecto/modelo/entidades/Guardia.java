package modelo.entidades;

import java.awt.*;
import java.awt.geom.*;

import modelo.GuardControl;
import modelo.state.guard.Patrullando;

public class Guardia extends Entidad {
    public static final int WIDTH = 5;
    public static final int HEIGTH = 8;

    private GuardControl control;

    public Guardia(String nombre, Point2D.Float position, GuardControl control) {
        this.nombre = nombre;
        this.position = position;
        this.control = control;

        this.cerebro = new Patrullando(this);
    }

    /**
     * Regresa el control de este guardia.
     * @return
     */
    public GuardControl getControl() {
        return control;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect((int) this.position.x, (int) this.position.y, WIDTH, HEIGTH);
        g2d.setColor(Color.BLACK);
        g2d.drawRect((int) this.position.x, (int) this.position.y, WIDTH, HEIGTH);
    }

    @Override
    public Rectangle shape() {
        return new Rectangle((int) position.x, (int) position.y, WIDTH, HEIGTH);
    }

    @Override
    public String info() {
        String str = "Guardia:" + this.nombre +"\n";
        str += "ID:" + getID() + "\n";

        return str;
    } 
}

package modelo.entidades;

import java.awt.*;
import java.awt.geom.*;

import modelo.state.guard.Patrullando;

public class Guardia extends Entidad {
    public static final int WIDTH = 5;
    public static final int HEIGTH = 8;
    public Guardia(String nombre, Point2D.Float position) {
        this.nombre = nombre;
        this.position = position;

        this.cerebro = new Patrullando(this);
    }

    @Override
    public void upDate(int fecha) {
        // TODO Auto-generated method stub
        
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
}

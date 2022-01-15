package proyecto.modelo.entidades;

import java.awt.geom.*;

import proyecto.modelo.state.preso.Paseando;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Preso extends Entidad {
    public final int WIDTH = 5;
    public final int HEIGTH = 8;

    public Preso(String nombre, Point2D.Float position) {
        this.nombre = nombre;
        
        this.position = position;

        this.cerebro = new Paseando(this);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.ORANGE);
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
        String str = "Preso:" + this.nombre +"\n";
        str += "ID:" + getID() + "\n";

        return str;
    }
    
}

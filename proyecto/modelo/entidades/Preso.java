package modelo.entidades;

import java.awt.geom.*;

import modelo.state.preso.Paseando;

import java.awt.Color;
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
    public void upDate(int fecha) {
        // TODO Auto-generated method stub
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.ORANGE);
        g2d.fillRect((int) this.position.x, (int) this.position.y, WIDTH, HEIGTH);
        g2d.setColor(Color.BLACK);
        g2d.drawRect((int) this.position.x, (int) this.position.y, WIDTH, HEIGTH);
    }
    
}

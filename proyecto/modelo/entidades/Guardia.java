package modelo.entidades;

import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.*;

import modelo.state.guard.Patrullando;

public class Guardia extends Entidad {
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
        // TODO Auto-generated method stub
        g2d.setColor(Color.BLUE);
        g2d.fillRect((int) this.position.x, (int) this.position.y, 5, 8);
        g2d.setColor(Color.BLACK);
        g2d.drawRect((int) this.position.x, (int) this.position.y, 5, 8);
    } 
}

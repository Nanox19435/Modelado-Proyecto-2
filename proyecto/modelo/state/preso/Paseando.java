package modelo.state.preso;

import modelo.entidades.Preso;
import modelo.state.State;

import java.awt.geom.*;

import java.util.Random;


public class Paseando implements State {
    public Point2D.Float destino;
    public Preso dueño;

    private Point2D.Float dirección;

    public Paseando(Preso dueño) {
        this.dueño = dueño;

        nuevoDestino();
    }

    /**
     * Genera un nuevo destino al azar y calcula la dirección a la que se tiene que mover para llegar.
     */
    public void nuevoDestino() {
        Random rand = new Random();
        destino = new Point2D.Float(rand.nextFloat()*500, rand.nextFloat()*500);

        dirección = new Point2D.Float(destino.x - dueño.position.x, destino.y -dueño.position.y);
        int distance = (int) dueño.position.distance(destino);
        dirección.y /= distance;
        dirección.x /= distance;
    }

    @Override
    public void process() {
        // Si está cerca del destino, cambia su dirección.
        if (dueño.position.distanceSq(destino) <= 1.0) 
            nuevoDestino();

        dueño.position.x += dirección.x;
        dueño.position.y += dirección.y;
        
    }
    
}

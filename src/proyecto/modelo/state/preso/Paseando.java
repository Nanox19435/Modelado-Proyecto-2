package proyecto.modelo.state.preso;

import proyecto.modelo.entidades.Entidad;
import proyecto.modelo.entidades.Preso;
import proyecto.modelo.state.Dead;
import proyecto.modelo.state.State;

import java.awt.geom.*;

import java.util.Random;


public class Paseando implements State {
    public Point2D.Float destino;
    public Preso cuerpo;

    private Point2D.Float dirección;

    public Paseando(Preso cuerpo) {
        this.cuerpo = cuerpo;

        nuevoDestino();
    }

    /**
     * Genera un nuevo destino al azar y calcula la dirección a la que se tiene que mover para llegar.
     */
    public void nuevoDestino() {
        Random rand = new Random();
        destino = new Point2D.Float(rand.nextFloat()*500, rand.nextFloat()*500);

        dirección = new Point2D.Float(destino.x - cuerpo.position.x, destino.y -cuerpo.position.y);
        int distance = (int) cuerpo.position.distance(destino);
        dirección.y /= distance;
        dirección.x /= distance;
    }

    @Override
    public boolean process() {
        // Si está cerca del destino, cambia su dirección.
        if (cuerpo.position.distanceSq(destino) <= 1.0) 
            nuevoDestino();

        cuerpo.position.x += dirección.x;
        cuerpo.position.y += dirección.y;
        
        return false;
    }

    @Override
    public void eutanasiar() {
        cuerpo.cerebro = new Dead();
    }

    @Override
    public Entidad dueño() {
        return cuerpo;
    }
    
}

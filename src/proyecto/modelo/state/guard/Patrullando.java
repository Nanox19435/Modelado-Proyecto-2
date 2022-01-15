package proyecto.modelo.state.guard;

import proyecto.modelo.Observer.agresion.AgresionObserver;
import proyecto.modelo.entidades.Entidad;
import proyecto.modelo.entidades.Guardia;
import proyecto.modelo.state.Dead;
import proyecto.modelo.state.State;

import java.awt.geom.*;

import java.util.Random;


public class Patrullando implements State, AgresionObserver {
    public Point2D.Float destino;
    public Guardia cuerpo;

    private Point2D.Float dirección;

    public Patrullando(Guardia cuerpo) {
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
    public boolean agressionNotified(Entidad agresor) {
        // Decide al azar si va a perseguir o no a el agresor dado.
        boolean random = (new Random()).nextInt(2) == 1;

        if (random) 
            cuerpo.cerebro = new Persiguiendo(cuerpo, agresor);

        return random;
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

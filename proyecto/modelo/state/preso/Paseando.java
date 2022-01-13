package modelo.state.preso;

import modelo.entidades.Preso;
import modelo.state.State;

import java.awt.Point;
import java.util.Random;

public class Paseando implements State {
    public Point destino;
    public Preso dueño;

    public Paseando(Preso dueño) {
        this.dueño = dueño;

        Random rand = new Random();
        destino = new Point(rand.nextInt()%500, rand.nextInt()%500);
    }

    public void setDestino() {}

    @Override
    public void process() {
        // TODO Auto-generated method stub
        dueño.position = destino;
        Random rand = new Random();
        destino = new Point(rand.nextInt()%500, rand.nextInt()%500);
    }
    
}

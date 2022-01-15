package proyecto.modelo.state.preso;

import java.util.ArrayList;
import java.util.Iterator;

import proyecto.modelo.Observer.neutralization.NeutralizationObserver;
import proyecto.modelo.Observer.neutralization.NeutralizationSubject;
import proyecto.modelo.entidades.Entidad;
import proyecto.modelo.entidades.Preso;
import proyecto.modelo.state.Dead;
import proyecto.modelo.state.State;

public class Agresivo implements State, NeutralizationSubject {
    public Preso cuerpo;
    private Entidad objetivo;
    private ArrayList<NeutralizationObserver> persecutores;

    public Agresivo(Preso cuerpo, Entidad objetivo) {
        this.cuerpo = cuerpo;
        this.objetivo = objetivo;
        this.persecutores = new ArrayList<>();
    }

    @Override
    public boolean process() {
        double distance = objetivo.position.distance(cuerpo.position);

        if (distance <= 5.0) {
            //El objetivo está en rango del cuerpo. Se procede a eutanasiar.
            objetivo.cerebro.eutanasiar();
            notifyNeutralization();
            cuerpo.cerebro = new Paseando(cuerpo);
        }

        float dx =  objetivo.position.x - cuerpo.position.x;
        float dy = objetivo.position.y - cuerpo.position.y;

        dx /= distance;
        dy /= distance;

        cuerpo.position.x += dx;
        cuerpo.position.y += dy;

        return false;
    }

    @Override
    public void notifyNeutralization() {
        for (NeutralizationObserver persecutor : persecutores) {
            persecutor.neutralizado();
        }
        
    }

    @Override
    public void addObserver(NeutralizationObserver o) {
        persecutores.add(o);
    }

    @Override
    public void removeObserver(NeutralizationObserver o) {
        persecutores.remove(o);
    }

    @Override
    public void eutanasiar() {
        // TODO Auto-generated method stub
        notifyNeutralization();
        cuerpo.cerebro = new Dead();
    }

    @Override
    public Iterator<NeutralizationObserver> getObservers() {
        return persecutores.iterator();
    }

    @Override
    public Entidad dueño() {
        return cuerpo;
    }
    
}

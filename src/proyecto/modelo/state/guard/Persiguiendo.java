package proyecto.modelo.state.guard;

import proyecto.modelo.Observer.neutralization.NeutralizationObserver;
import proyecto.modelo.entidades.Entidad;
import proyecto.modelo.entidades.Guardia;
import proyecto.modelo.state.Dead;
import proyecto.modelo.state.State;

public class Persiguiendo implements State, NeutralizationObserver {

    public Guardia cuerpo;
    private Entidad objetivo;

    public Persiguiendo(Guardia cuerpo, Entidad objetivo) {
        this.objetivo = objetivo;
        this.cuerpo = cuerpo;

        //Se registra como observador del objetivo.
        ((Agresivo) objetivo.cerebro).addObserver(this);
    }

    @Override
    public boolean process() {
        double distance = objetivo.position.distance(cuerpo.position);

        if (distance <= 9.0) {
            //El objetivo está en rango del cuerpo. Se procede a eutanasiar.
            objetivo.cerebro.eutanasiar();
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
    public void eutanasiar() {
        cuerpo.cerebro = new Dead();
    }

    @Override
    public void neutralizado() {
        cuerpo.getControl().registerPatrulla(cuerpo);
        cuerpo.cerebro = new Patrullando(cuerpo);
    }

    @Override
    public Entidad dueño() {
        return cuerpo;
    }
    
    
}

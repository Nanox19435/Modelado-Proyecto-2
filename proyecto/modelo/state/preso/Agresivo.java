package modelo.state.preso;

import modelo.entidades.Entidad;
import modelo.state.State;

public class Agresivo implements State {
    public Entidad cuerpo;
    private Entidad objetivo;

    public Agresivo(Entidad cuerpo, Entidad objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public void process() {
        double distance = objetivo.position.distance(cuerpo.position);

        if (distance <= 5.0) {
            //El objetivo está en rango del cuerpo. Se procede a eutanasiar.
            
        }

        float dx =  objetivo.position.x - cuerpo.position.x;
        float dy = objetivo.position.y - cuerpo.position.y;

        dx /= distance;
        dy /= distance;

        cuerpo.position.x += dx;
        cuerpo.position.y += dy;
    }
    
}

package modelo.state;

import modelo.entidades.Entidad;

public interface State {
    /**
     * Código a ejecutarse en cada frame de la simulación.
     * @return Regresa si el objeto se elimina o no.
     */
    public boolean process();

    /**
     * Mata a esta entidad.
     */
    public void eutanasiar();


    /**
     * Regresa el dueño de este estado.
     * @return
     */
    public Entidad dueño();
}

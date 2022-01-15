package proyecto.modelo.state;

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

}

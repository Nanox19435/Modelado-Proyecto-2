package modelo.state;

public interface State {
    /**
     * Código a ejecutarse en cada frame de la simulación.
     */
    public void process();
}

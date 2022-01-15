package proyecto.modelo.Observer.neutralization;

public interface NeutralizationSubject {
    /**
     * Notifica que esta amenaza fue neutralizada.
     */
    public void notifyNeutralization();
    /**
     * Agrega este observador
     * @param o
     */
    public void addObserver(NeutralizationObserver o);
    /**
     * Remueve este observador
     * @param o
     */
    public void removeObserver(NeutralizationObserver o);
}

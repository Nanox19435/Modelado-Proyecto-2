package modelo.Observer.neutralization;

import java.util.Iterator;

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

    /**
     * Regresa los guardias que estaban persiguiendo a este objetivo.
     */
    public Iterator<NeutralizationObserver> getObservers();
}

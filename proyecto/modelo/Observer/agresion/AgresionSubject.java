package modelo.Observer.agresion;

import modelo.entidades.Entidad;

/**
 * Interfaz del sujeto que administra la agresividad. No se implementa en todos los presos.
 */
public interface AgresionSubject {
    /**
     * Notifica cuál es la entidad que está siendo agresiva.
     * @param agresor
     */
    public void notifyAgression(Entidad agresor);

    /**
     * Agrega un observador. Los observadores son los estados de los guardias que están patrullando, es decir,
     * los que están disponibles para perseguir a un agresor.
     */
    public void addObserver(AgresionObserver observador);

    /**
     * Remueve el observador dado.
     * @param observador
     */
    public void removeObserver(AgresionObserver observador);
}

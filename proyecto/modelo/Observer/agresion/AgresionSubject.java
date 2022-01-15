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

    // Otros métodos se encargaran de manejar las añadidos de observadores en la implementación de esta interfaz.
}

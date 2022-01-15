package proyecto.modelo.Observer.agresion;

import proyecto.modelo.entidades.Entidad;

/**
 * Observador de el estado de agresividad de un preso. Usese para notificar
 * las intenciones homicidas de un preso.
 */
public interface AgresionObserver {
    /**
     * Notifica de una agresión.
     * @return Regresa si esta entidad va a perseguir al agresor o no (Es decir, si cambia de estado).
     */
    public boolean agressionNotified(Entidad agresor);
}

package proyecto.modelo.Observer;

import proyecto.modelo.entidades.Entidad;

public interface DateSubject {
    
    /**
     * Avisa a los observadores de un cambio de fecha.
     * @param fecha nueva fecha.
     */
    public void actualizaFecha(int fecha);

    /**
     * Añade un observador a este sujeto.
     */
    public void añadirObservador(Entidad o);

    /**
     * Elimina un observador de este sujeto. Ya no será notificado.
     */
    public void eliminarObservador(Entidad o);
}

package modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

import modelo.Observer.agresion.AgresionSubject;
import modelo.entidades.Entidad;
import modelo.entidades.Guardia;
import modelo.entidades.Preso;
import modelo.state.guard.Patrullando;
import modelo.state.guard.Persiguiendo;

/**
 * Clase que guarda la información relacionada con los guardias.
 */
public class GuardControl implements AgresionSubject {
    private Hashtable<Integer, Guardia> guardias;
    private ArrayList<Patrullando> patrullando;
    private ArrayList<Persiguiendo> persiguiendo;


    public GuardControl() {
        guardias = new Hashtable<>();
        patrullando = new ArrayList<>();
        persiguiendo = new ArrayList<>();
    }

    public void put(int id, Guardia g) {
        guardias.put(id, g);
        registerPatrulla(g);
    }

    /**
     * Elimina de la lista de guardias al guardia con esta ID
     * @param id
     */
    public void remove(int id) {
        guardias.remove(id);
    }

    /**
     * Regresa a todos los guardias en forma de iterador
     * @return
     */
    public Iterator<Guardia> getGuardias() {
        return guardias.values().iterator();
    }

    public Iterator<Patrullando> getPatrullando() {
        return patrullando.iterator();
    }

    public Iterator<Persiguiendo> getPersiguiendo() {
        return persiguiendo.iterator();
    }

    /**
     * Registra al guardia dado como persiguiendo.
     * @param g
     */
    public void registerPersecución(Guardia g, Preso objetivo) {
        Persiguiendo p = new Persiguiendo(g, objetivo);
        persiguiendo.add(p);
    }

    /**
     * Registra al guardia dado como patrullando
     */
    public void registerPatrulla(Guardia g) {
        Patrullando p = new Patrullando(g);
        patrullando.add(p);
    }

    @Override
    public void notifyAgression(Entidad agresor) {
        Iterator<Patrullando> iter = getPatrullando();
        LinkedList<Guardia> asignados = new LinkedList<Guardia>();
        
        while (iter.hasNext()) {
            Patrullando p = iter.next();
            Guardia g = (Guardia) p.dueño();
            if (p.agressionNotified(agresor)) {
                asignados.add(g);
            }
        }

        for (Guardia guardia : asignados) {
            registerPersecución(guardia, (Preso) agresor);
        }
    }
}

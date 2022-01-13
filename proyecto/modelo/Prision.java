package modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.Timer;

import controlador.Controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Observer.DateSubject;
import modelo.entidades.Entidad;
import modelo.entidades.Guardia;
import modelo.entidades.Preso;

/**
 * Clase principal de la simulación. Maneja toda la lógica del programa.
 */
public class Prision implements DateSubject, ActionListener {
    private Hashtable<Integer, Preso> presos;
    private Hashtable<Integer, Guardia> guardias;
    private ArrayList<Entidad> entidades;
    private Timer timer;
    private Controlador controlador;

    public Prision(Controlador controlador) {
        //Aproximadamente 30 frames.
        timer = new Timer(32, this);
        timer.start();

        this.controlador = controlador;
        this.entidades = new ArrayList<>();
        this.guardias = new Hashtable<>();
        this.presos = new Hashtable<>();
    }

    /**
     * Añade un preso a la prisión.
     * @param nombre Nombre del preso a añadir.
     */
    public void agregaPreso(String nombre, Point position) {
        Preso p = new Preso(nombre, position);
        p.setId(entidades.size());
        this.añadirObservador(p);
        presos.put(p.getID(), p);
    }

    /**
     * Agrega un guardia a la prisión.
     * @param nombre Nombre del guardia a añadir.
     */
    public void agregaGuardia(String nombre) {
        Guardia g = new Guardia(nombre);
        g.setId(entidades.size());
        this.añadirObservador(g);
        guardias.put(g.getID(), g);
        
    }
    
    public Iterator<Entidad> getEntidades() {
        return entidades.iterator();
    }

    @Override
    public void actualizaFecha(int fecha) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void añadirObservador(Entidad o) {
        entidades.add(o);
    }

    @Override
    public void eliminarObservador(Entidad o) {
        entidades.remove(o);
    }

    /**
     * Se manda a llamar en cada frame para actualizar el estado de todas las entidades.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Iterator<Entidad> iter = getEntidades();
        while (iter.hasNext()) {
            Entidad entidad = iter.next();
            entidad.cerebro.process();
        }
        System.out.println(entidades.size());
        
        //Tras acabar la lógica, pide al controlador dibujar el estado actual de la simulación.
        controlador.requestRedraw();
    }

    
    
}

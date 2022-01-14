package modelo;

import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.Timer;

import aux.IDList;
import controlador.Controlador;

import java.awt.Point;
import java.awt.geom.*;
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
    private IDList<Entidad> entidades;
    private Timer timer;
    private Controlador controlador;

    public Prision(Controlador controlador) {
        //Aproximadamente 30 frames.
        timer = new Timer(16, this);
        timer.start();

        this.controlador = controlador;
        this.entidades = new IDList<>();
        this.guardias = new Hashtable<>();
        this.presos = new Hashtable<>();
    }

    /**
     * Añade un preso a la prisión.
     * @param nombre Nombre del preso a añadir.
     */
    public void agregaPreso(String nombre, Point position) {
        Point2D.Float fpos = new Point2D.Float((float) position.x, (float) position.y);
        Preso p = new Preso(nombre, fpos);
        p.setID(entidades.size());
        this.añadirObservador(p);
        presos.put(p.getID(), p);
    }

    /**
     * Agrega un guardia a la prisión.
     * @param nombre Nombre del guardia a añadir.
     */
    public void agregaGuardia(String nombre, Point position) {
        Point2D.Float fpos = new Point2D.Float((float) position.x, (float) position.y);
        Guardia g = new Guardia(nombre, fpos);
        g.setID(entidades.size());
        this.añadirObservador(g);
        guardias.put(g.getID(), g);
        
    }

    /**
     * Mata/remueve a la entidad dada. Para ser llamado por otras entidades.
     * @param eutanasiado
     */
    protected void eutanasiar(Entidad eutanasiado) {
        int id = eutanasiado.getID();
        entidades.remove(id);

        //Removemos la aparición de esta entidad en estas tablas.
        guardias.remove(id);
        presos.remove(id);
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
        Iterator<Entidad> iter = getEntidades();
        while (iter.hasNext()) {
            Entidad entidad = iter.next();
            if (entidad == null) continue;
            entidad.cerebro.process();
        }
        
        //Tras acabar la lógica, pide al controlador dibujar el estado actual de la simulación.
        controlador.requestRedraw();
    }

    
    
}

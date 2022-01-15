package modelo;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Timer;

import aux.IDList;
import controlador.Controlador;

import java.awt.Point;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.entidades.Entidad;
import modelo.entidades.Guardia;
import modelo.entidades.Preso;

/**
 * Clase principal de la simulación. Maneja toda la lógica del programa.
 */
public class Prision implements ActionListener {
    private Hashtable<Integer, Preso> presos;
    private GuardControl guardias;
    private IDList<Entidad> entidades;
    private Timer timer;
    private Controlador controlador;

    public Prision(Controlador controlador) {
        //Aproximadamente 30 frames.
        timer = new Timer(16, this);
        timer.start();

        this.controlador = controlador;
        this.entidades = new IDList<>();
        this.guardias = new GuardControl();
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
        entidades.add(p);
        presos.put(p.getID(), p);
    }

    /**
     * Agrega un guardia a la prisión.
     * @param nombre Nombre del guardia a añadir.
     */
    public void agregaGuardia(String nombre, Point position) {
        Point2D.Float fpos = new Point2D.Float((float) position.x, (float) position.y);
        Guardia g = new Guardia(nombre, fpos, guardias);
        g.setID(entidades.size());
        entidades.add(g);
        guardias.put(g.getID(), g);
    }

    /**
     * Mata/remueve a la entidad dada. Para ser llamado por otras entidades.
     * @param eutanasiado
     */
    public void eutanasiar(Entidad eutanasiado) {
        int id = eutanasiado.getID();
        entidades.remove(id);

        //Removemos la aparición de esta entidad en estas tablas.
        presos.remove(id);
    }
    
    /**
     * @return Regresa un iterador de todas las entidades.
     */
    public Iterator<Entidad> getEntidades() {
        return entidades.iterator();
    }

    /**
     * @return Regresa un iterador de sólo los prisioneros.
     */
    public Iterator<Preso> getPresos() {
        return presos.values().iterator();
    }

    /**
     * @return Regresa un iterador de sólo los guardias.
     */
    public Iterator<Guardia> getGuardias() {
        return guardias.getGuardias();
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
            boolean eliminar = entidad.cerebro.process();

            if (eliminar) {
                eutanasiar(entidad);
            }
        }
        
        //Tras acabar la lógica, pide al controlador dibujar el estado actual de la simulación.
        controlador.requestRedraw();
    }

    public void notifyAgression(Entidad agresor) {
        guardias.notifyAgression(agresor);
    }

    /**
     * Regresa una entidad al azar. distinta del objeto pasado.
     * @return
     */
    public Entidad entidadAzar(Object distinto) {
        if(entidades.size()==1) return null;
        Random rand = new Random();
        Entidad retornable = null;
        while (retornable == null && distinto != retornable) {
            int i = rand.nextInt(entidades.size());
            retornable = entidades.get(i);
        }
        return retornable;
    }
}

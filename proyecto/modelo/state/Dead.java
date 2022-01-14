package modelo.state;

import modelo.entidades.Entidad;

/**
 * Estado en el que se encontrarán las entidades muertas.
 */
public class Dead implements State {
    public Entidad cuerpo;
    public int decomposition = 0;
    public final int CORPSE_DURATION = 300;

    @Override
    public boolean process() {
        return CORPSE_DURATION <= decomposition++;
    }

    @Override
    public void eutanasiar() {
        //No se hace nada
    }
}

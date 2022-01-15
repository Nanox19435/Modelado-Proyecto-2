package proyecto.controlador;

import proyecto.controlador.strategy.ClickStrategy;
import proyecto.controlador.strategy.*;

/**
 * Enum que define los distintos modos de clic, es decir, que acción se realizará cuando el usuario dé clic
 * en el panel.
 */
public enum ClickModes {
    AparecerPreso("Spawnear Preso", new SpawnPreso()),
    AparecerGuardia("Spawnear Guardia", new SpawnGuardia()),
    Seleccionar("Seleccionar", new Select()),
    Enfurecer("Hacer agresivo", new Enrage()),
    Matar("Matar/Eutanasiar/Eliminar", new Euthanasia()),
    Inactivo("Inactivo", new UVoid());

    private String text;
    private ClickStrategy strategy;

    private ClickModes(String text, ClickStrategy strategy) {
        this.text = text;
        this.strategy = strategy;
    }

    public ClickStrategy getStrategy() {
        return this.strategy;
    }

    @Override
    public String toString() {
        return this.text;
    }
}

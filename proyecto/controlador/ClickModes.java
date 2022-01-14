package controlador;

/**
 * Enum que define los distintos modos de clic, es decir, que acción se realizará cuando el usuario dé clic
 * en el panel.
 */
public enum ClickModes {
    AparecerPreso("Spawnear Preso"),
    AparecerGuardia("Spawnear Guardia"),
    Inactivo("Inactivo");

    private String text;

    private ClickModes(String toString) {
        text = toString;
    }
    @Override
    public String toString() {
        return this.text;
    }
}

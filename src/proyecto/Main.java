package proyecto;

import javax.swing.SwingUtilities;

import proyecto.vista.App;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");

        //Se supone que esto se hace para evitar problemas con threads.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App.initWindow();
            }
        });
    }
}

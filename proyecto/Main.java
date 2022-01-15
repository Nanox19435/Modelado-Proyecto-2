import javax.swing.SwingUtilities;

import vista.App;

public class Main {
    public static void main(String[] args) {
        //Se supone que esto se hace para evitar problemas con threads.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App.initWindow();
            }
        });
    }
}

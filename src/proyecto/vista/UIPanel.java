package proyecto.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import proyecto.controlador.ClickModes;
import proyecto.controlador.Controlador;

public class UIPanel extends JPanel implements ActionListener {
    private Controlador controlador;

    private JComboBox<ClickModes> dropDown;
    private JButton pause;

    public UIPanel(Controlador controlador) {
        this.controlador = controlador;

        buildButtons();
    }

    /**
     * Construye los botones que nos interesan.
     */
    private void buildButtons() {
        Box box = Box.createVerticalBox();
        dropDown = new JComboBox<>(ClickModes.values());
        pause = new JButton("Pausar simulación");
        box.add(dropDown);
        box.add(pause);

        pause.addActionListener(this);
        dropDown.addActionListener(this);
        add(box);
    }

    /**
     * Para mandarse a llamar cuando se presione uno de los botones de la Interfaz de usuario.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dropDown) 
            controlador.setClicMode((ClickModes) dropDown.getSelectedItem());
        else if (e.getSource() == pause) {
            controlador.toggleTimeFlow();
            if (pause.getText().equals("Pausar simulación"))
                pause.setText("Reanudar simulación");
            else 
                pause.setText("Pausar simulación");
        }
    }
}

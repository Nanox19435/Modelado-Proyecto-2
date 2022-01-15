package proyecto.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import proyecto.controlador.ClickModes;
import proyecto.controlador.Controlador;

public class UIPanel extends JPanel implements ActionListener {
    private Controlador controlador;

    private JComboBox<ClickModes> dropDown;
    //private JButton botón;

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
        box.add(dropDown);
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
        
    }
}

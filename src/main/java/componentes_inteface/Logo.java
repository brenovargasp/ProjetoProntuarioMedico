package componentes_inteface;

import javax.swing.*;
import java.util.Objects;

// Classe criada para auxiliar na hora de adicionar uma logo.
public class Logo extends JLabel{

    public Logo(String local, int x, int y, int w, int h) {
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(local))));
        setBounds(x, y, w, h);
    }
}

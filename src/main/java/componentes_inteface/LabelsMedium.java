package componentes_inteface;

import javax.swing.*;
import java.awt.*;

// Classe criada para evitar a repetição e juntar o comando para criação de um label.
public class LabelsMedium extends JLabel {

    public LabelsMedium(String titulo, int x, int y, int w, int h, int size) {
        setText(titulo);
        setForeground(Color.white);
        setFont(new Font("AmpleSoftPro-Medium", Font.PLAIN, size));
        setBounds(x, y, w, h);
    }
}

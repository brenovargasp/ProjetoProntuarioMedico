package componentes_inteface;

import javax.swing.*;
import java.util.Objects;

// Classe criada para colocar as decorações nos cantos em todos os painéis.
public class CornerDecoration {

    JLabel parteDeBaixo, parteDeCima;

    public CornerDecoration() {
        parteDeCima = new JLabel();
        parteDeCima.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/parteDeCima.png"))));
        parteDeCima.setBounds(424, 0, 176, 186);

        parteDeBaixo = new JLabel();
        parteDeBaixo.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/parteDeBaixo.png"))));
        parteDeBaixo.setBounds(0, 391, 201, 209);
    }

    public JLabel getParteDeBaixo() {
        return parteDeBaixo;
    }

    public JLabel getParteDeCima() {
        return parteDeCima;
    }
}

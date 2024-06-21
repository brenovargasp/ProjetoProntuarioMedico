package componentes_inteface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// Classe criada para evitar a repetição e juntar o comando para criação de um botão.
public class ButtonsPanel extends JButton {

    public ButtonsPanel(String titulo, int x, int y, int w, int h) {
        setText(titulo);
        setForeground(new Color(0, 113, 182));
        setBackground(Color.white);
        setFocusPainted(false);
        setFont(new Font("AmpleSoftPro-Medium", Font.PLAIN, 20));
        Border compoundBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(1, 76, 121), 1),
                this.getBorder()
        );
        setBorder(compoundBorder);
        Insets marginBotao = this.getMargin();
        marginBotao.top = 7;
        setMargin(marginBotao);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBounds(x, y, w, h);
    }
}

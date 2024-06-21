package interfaces;

import componentes_inteface.ButtonsPanel;
import componentes_inteface.CornerDecoration;
import componentes_inteface.LabelsMedium;
import componentes_inteface.Logo;

import javax.swing.*;
import java.awt.*;

public class PainelPrincipal extends JPanel {

    Logo logo;
    LabelsMedium textoProntuario, textoNome;
    ButtonsPanel buttonInformacoes, buttonAbrir, buttonAnteriores, buttonSair;
    CornerDecoration cornerDecoration;

    // Mesmo explicado na classe PainelAcesso.
    public PainelPrincipal() {
        setBackground(new Color(0, 113, 182));
        setSize(600, 600);
        setVisible(false);

        logo = new Logo("/images/icone.png", 185, 40, 231, 113);

        cornerDecoration = new CornerDecoration();

        textoProntuario = new LabelsMedium("Prontuário de:", 240, 190, 200, 25, 20);

        textoNome = new LabelsMedium(null, 0, 220, 600, 25, 20);
        textoNome.setBackground(new Color(0, 113, 182));
        textoNome.setHorizontalAlignment(JLabel.CENTER);

        // Esse método botoesMenu será explicado logo abaixo, mas ele é usado para evitar repetição de código.
        buttonInformacoes = new ButtonsPanel("Informações do paciente", 160, 260, 281, 43);

        buttonAbrir = new ButtonsPanel("Abrir prontuário", 160, 320, 281, 43);

        buttonAnteriores = new ButtonsPanel("Prontuários anteriores", 160, 380, 281, 43);

        buttonSair = new ButtonsPanel("Voltar para o acesso", 160, 440, 281, 43);

        // Usando o setLayout null para usarmos o setBounds e posicionarmos os componentes onde quiser.
        setLayout(null);
        add(logo);
        add(textoProntuario);
        add(textoNome);
        add(buttonInformacoes);
        add(buttonAbrir);
        add(buttonAnteriores);
        add(buttonSair);
        add(cornerDecoration.getParteDeBaixo());
        add(cornerDecoration.getParteDeCima());
    }
}

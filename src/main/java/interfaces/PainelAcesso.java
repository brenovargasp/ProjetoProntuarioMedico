package interfaces;

import componentes_inteface.ButtonsPanel;
import componentes_inteface.CornerDecoration;
import componentes_inteface.LabelsMedium;
import componentes_inteface.Logo;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

// Extendemos a classe JPanel para essa classe se tornar um JPanel.
public class PainelAcesso extends JPanel {

    Logo logo;
    LabelsMedium acesso, prontuario, cpf;
    JFormattedTextField cpfField;
    ButtonsPanel acessar;
    CornerDecoration cornerDecoration;

    // Fizemos o construtor, setando a cor de fundo do painel, o tamanho e a visibilidade inicial dele.
    public PainelAcesso() {
        setBackground(new Color(0, 113, 182));
        setSize(600, 600);
        setVisible(true);

        // Adicionamos a logo da UPA ao Painel.
        logo = new Logo("/images/icone.png", 185, 80, 231, 113);

        // Adicionamos os enfeites no canto do painel.
        cornerDecoration = new CornerDecoration();

        // Criamos um label para o texto de acesso.
        acesso = new LabelsMedium("Acesso ao", 210, 240, 300, 40, 35);
        acesso.setFont(new Font("AmpleSoftPro-Bold", Font.PLAIN, 35));

        // Criamos um label para o texto de Prontuário médico.
        prontuario = new LabelsMedium("Prontuário Médico", 110, 280, 370, 50, 45);
        prontuario.setFont(new Font("AmpleSoftPro-Bold", Font.PLAIN, 45));

        // Adicionamos um label para o CPF.
        cpf = new LabelsMedium("CPF:", 195, 345, 100, 35, 20);

        // Adicionamos um campo de texto formatado para a escrita do CPF.
        try {
            MaskFormatter formatter = new MaskFormatter("###.###.###-##");
            formatter.setPlaceholderCharacter('_');
            cpfField = new JFormattedTextField(formatter);
            cpfField.setBackground(Color.white);
            cpfField.setBorder(BorderFactory.createLineBorder(new Color(1, 76, 121), 1));
            cpfField.setHorizontalAlignment(JFormattedTextField.CENTER);
            cpfField.setBounds(195, 372, 194, 30);
            cpfField.setFont(new Font("Arial", Font.PLAIN, 15));
        } catch(ParseException e) {
            e.getStackTrace();
        }

        acessar = new ButtonsPanel("Acessar", 235, 420, 115, 34);

        // Setamos o layout para null, para podermos posicionar nossos componentes onde quiséssemos, já que o Layout
        // padrão é o BorderLayout, após isso, adicionamos todos os elementos no painel.
        setLayout(null);
        add(logo);
        add(acesso);
        add(prontuario);
        add(cpf);
        add(cpfField);
        add(acessar);
        add(cornerDecoration.getParteDeBaixo());
        add(cornerDecoration.getParteDeCima());
    }
}

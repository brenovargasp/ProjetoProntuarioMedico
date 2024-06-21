package interfaces;

import componentes_inteface.ButtonsPanel;
import componentes_inteface.CornerDecoration;
import componentes_inteface.LabelsMedium;
import componentes_inteface.Logo;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class PainelCriarProntuario extends JPanel {

    Logo logo;
    LabelsMedium campoTexto, cpfLabel;
    JTextArea campoArea, anamnese, planoTerapeutico, encaminhamento;
    JFormattedTextField cpfField;
    ButtonsPanel abrir, cancelar;
    JScrollPane campoScroll;
    CornerDecoration cornerDecoration;

    // Mesmo explicado na classe PainelAcesso.
    public PainelCriarProntuario() {
        setBackground(new Color(0, 113, 182));
        setSize(600, 600);
        setVisible(false);

        // Colocando a logo no painel
        logo = new Logo("/images/iconeTelaAbrir.png", 20, 5, 201, 70);

        // Decorações no canto
        cornerDecoration = new CornerDecoration();

        // Campos para o preenchimento de informações
        anamnese = camposDePreenchimento("Anamnese:", 138, 90, 325, 110);

        planoTerapeutico = camposDePreenchimento("Plano terapêutico:", 138, 230, 325, 110);

        encaminhamento = camposDePreenchimento("Encaminhamento:", 200, 370, 200, 25);

        cpfField = cpfArea("CPF do médico:", 200, 425, 200, 25);

        // Botões do painel
        abrir = new ButtonsPanel("Abrir", 168, 470, 115, 34);

        cancelar = new ButtonsPanel("Cancelar", 318, 470, 115, 34);

        // Adicionamos os componentes no painel
        setLayout(null);
        add(logo);
        add(abrir);
        add(cancelar);
        add(cornerDecoration.getParteDeBaixo());
        add(cornerDecoration.getParteDeCima());
    }

    // Criamos um método para evitar a repetição do código, nesse método criamos um label e um área de texto.
    public JTextArea camposDePreenchimento(String titulo, int x, int y, int w, int h) {
        campoTexto = new LabelsMedium(titulo, x, y - 20, w, 25, 20);

        campoArea = new JTextArea();
        campoArea.setFont(new Font("AmpleSoftPro-Medium", Font.PLAIN, 15));
        campoArea.setLineWrap(true);
        campoArea.setWrapStyleWord(true);
        Insets marginCampos = campoArea.getMargin();
        marginCampos.left = 2;
        marginCampos.top = 3;
        marginCampos.right = 2;
        campoArea.setMargin(marginCampos);

        campoScroll = new JScrollPane(campoArea);
        campoScroll.setBackground(Color.white);
        campoScroll.setBorder(BorderFactory.createLineBorder(new Color(1, 76, 121), 1));
        campoScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        campoScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        campoScroll.setBounds(x, y, w, h);

        add(campoTexto);
        add(campoScroll);

        return campoArea;
    }

    // Criamos um método para evitar a repetição do código, nesse método criamos um label e um área de texto formatada.
    public JFormattedTextField cpfArea(String titulo, int x, int y, int w, int h) {
        cpfLabel = new LabelsMedium(titulo, x, y - 20, w, 25, 20);

        try {
            MaskFormatter formatter = new MaskFormatter("###.###.###-##");
            formatter.setPlaceholderCharacter('_');
            cpfField = new JFormattedTextField(formatter);
            cpfField.setFont(new Font("Arial", Font.PLAIN, 15));
            cpfField.setBackground(Color.white);
            cpfField.setBorder(BorderFactory.createLineBorder(new Color(1, 76, 121), 1));
            cpfField.setHorizontalAlignment(JFormattedTextField.CENTER);

            cpfField.setBounds(x, y, w, h);
            add(cpfLabel);
            add(cpfField);

            return cpfField;
        } catch(ParseException e) {
            e.getStackTrace();
            return null;
        }
    }
}

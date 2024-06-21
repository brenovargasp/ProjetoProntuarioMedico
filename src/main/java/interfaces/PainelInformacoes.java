package interfaces;

import componentes_inteface.ButtonsPanel;
import componentes_inteface.CornerDecoration;
import componentes_inteface.LabelsMedium;
import componentes_inteface.Logo;
import entidades.Paciente;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.time.LocalDate;

// Mesmo explicado na classe PainelAcesso.
public class PainelInformacoes extends JPanel {

    Logo logo;
    LabelsMedium descricao, numeroSUS;
    JTextField campoTexto;
    JPanel nome, cpf, email, dataNascimento, celular, endereco, cep, sexoBiologico, variavelFormatada;
    ButtonsPanel voltar;
    CornerDecoration cornerDecoration;

    // Mesmo explicado na classe PainelAcesso.
    public PainelInformacoes() {
        setBackground(new Color(0, 113, 182));
        setSize(600, 600);
        setVisible(false);

        logo = new Logo("/images/iconeTelaAbrir.png", 20, 10, 201, 93);

        cornerDecoration = new CornerDecoration();

        voltar = new ButtonsPanel("Voltar", 240, 460, 115, 34);

        setLayout(null);
    }

    // Método para preenchimento dos dados do paciente sempre que for chamado, para ser alterado sempre que um novo
    // paciente for escolhido no acesso
    public void preenchePaciente(Paciente paciente) {

        numeroSUS = new LabelsMedium("Número SUS: " + paciente.getNr_SUS(), 350, 10, 250, 100, 14);

        nome = camposPanel("Nome:", paciente.getNome(), 50, 180, 235, 50);

        cpf = campoFormatado("###.###.###-##", paciente.getCpf(), "CPF: ", 300, 180, 235, 50);

        email = camposPanel("Email: ", paciente.getEmail(), 50, 250, 235, 50);

        LocalDate data = LocalDate.parse(paciente.getData_nasc());
        String dataNascimentoFormatada = String.format("%02d", data.getDayOfMonth()) + "/" +
                String.format("%02d", data.getMonthValue()) + "/" +
                data.getYear();
        dataNascimento = camposPanel("Data de nascimento: ", dataNascimentoFormatada, 300, 250, 235, 50);

        celular = campoFormatado("(##) #####-####", paciente.getCelular(), "Celular: ", 50, 320, 235, 50);

        endereco = camposPanel("Endereço: ", paciente.getEndereco() + ", " + paciente.getCidade(), 300, 320, 235, 50);

        cep = campoFormatado("#####-###", paciente.getCep(), "CEP: ", 50, 390, 235, 50);

        sexoBiologico = camposPanel("Sexo: ", paciente.getGenero(), 300, 390, 235, 50);

        // Para evitar que as informações dos antigos pacientes fiquem e não apareça a do novo paciente, é necessário
        // fazer a remoção de todos os componentes e adicionar novamente com informações atualizadas
        removeAll();
        add(logo);
        add(numeroSUS);
        add(nome);
        add(cpf);
        add(email);
        add(dataNascimento);
        add(celular);
        add(endereco);
        add(cep);
        add(sexoBiologico);
        add(voltar);
        add(cornerDecoration.getParteDeBaixo());
        add(cornerDecoration.getParteDeCima());
        revalidate();
    }

    // Método para evitar a repetição de código dos 8 campos de informações
    public JPanel camposPanel(String titulo, String informacao, int x, int y, int w, int h) {
        JPanel painelJuncao = new JPanel();
        painelJuncao.setSize(235, 50);
        painelJuncao.setVisible(true);
        painelJuncao.setBackground(new Color(0, 113, 182));

        descricao = new LabelsMedium(titulo, 0, 0, 235, 25, 20);

        campoTexto = new JTextField(informacao);
        campoTexto.setCaretPosition(0);
        campoTexto.setEditable(false);
        campoTexto.setFont(new Font("AmpleSoftPro-Medium", Font.PLAIN, 15));
        Border compoundBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(1, 76, 121), 1),
                campoTexto.getBorder()
        );
        campoTexto.setBorder(compoundBorder);
        Insets marginCampos = campoTexto.getMargin();
        marginCampos.left = 1;
        marginCampos.top = 4;
        campoTexto.setMargin(marginCampos);
        campoTexto.setBackground(Color.white);
        campoTexto.setBounds(0, 24, 234, 26);

        painelJuncao.setLayout(null);
        painelJuncao.add(descricao);
        painelJuncao.add(campoTexto);
        painelJuncao.setBounds(x, y, w, h);

        return painelJuncao;
    }

    // Método para evitar repetição na hora de formatar um dado
    public JPanel campoFormatado(String mascara, String conteudo, String titulo, int x, int y, int w, int h) {
        try {
            MaskFormatter formatter = new MaskFormatter(mascara);
            formatter.setValueContainsLiteralCharacters(false);
            String textoFormatado = formatter.valueToString(conteudo);
            variavelFormatada = camposPanel(titulo, textoFormatado, x, y, w, h);
            return variavelFormatada;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
}

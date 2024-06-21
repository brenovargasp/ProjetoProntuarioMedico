package interfaces;

import BancoDeDados.DAO;
import componentes_inteface.DialogPersonalizado;
import componentes_inteface.TabelaProntuarios;
import entidades.Paciente;
import entidades.ProntuarioMedico;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

// Extendemos a classe JFrame para essa classe se tornar um JFrame.
public class MainFrame extends JFrame implements ActionListener {
    PainelAcesso acesso;
    PainelPrincipal menu;
    PainelInformacoes informacoes;
    PainelCriarProntuario prontuario;
    PainelVerProntuarios verProntuarios;
    PainelProntuarioAberto prontuarioAberto;
    DAO dao;

    static String cpfNaoFormatado;
    int confirma = 0;


    // Criando o frame principal onde armazenará todos os paineis.
    public MainFrame() {

        // Inicializando todos os painéis, exceto 1 que veremos depois.
        acesso = new PainelAcesso();
        menu = new PainelPrincipal();
        informacoes = new PainelInformacoes();
        prontuario = new PainelCriarProntuario();
        prontuarioAberto = new PainelProntuarioAberto();
        dao = new DAO();

        // Colocando um ícone para o frame.
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/icone.png"))).getImage());
        setSize(600, 600);
        setTitle("Acessar prontuário");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        // Adicionando todos os painéis ao frame.
        add(acesso);
        add(menu);
        add(informacoes);
        add(prontuario);
        add(prontuarioAberto);

        // Adicionando "escutadores de ação" para os botões dos painéis, colocando basicamente todas as ações
        // no frame principal.
        acesso.acessar.addActionListener(this);
        menu.buttonSair.addActionListener(this);
        menu.buttonInformacoes.addActionListener(this);
        menu.buttonAbrir.addActionListener(this);
        menu.buttonAnteriores.addActionListener(this);
        informacoes.voltar.addActionListener(this);
        prontuario.abrir.addActionListener(this);
        prontuario.cancelar.addActionListener(this);
        prontuarioAberto.voltar.addActionListener(this);
    }

    // Método que precisamos colocar ao chamar o "implements ActionListener".
    @Override
    public void actionPerformed(ActionEvent e) {

        // Esse objeto "e" será responsável por escutar e "ver" qual botão foi clicado.
        if(e.getSource() == acesso.acessar) {

            // Tiramos a formatação do cpf para validá-lo no banco de dados e deixamos ele estático para usá-lo em outras classes
            // sem precisar criar um construtor do MainFrame.
            cpfNaoFormatado = acesso.cpfField.getText().replaceAll("[^0-9]", "");

            // Como é necessário o CPF para preencher a tabela do painel verProntuarios,
            // foi preciso inicializá-lo depois da validação de clique ao acessar.
            // Ou seja, inicializamos a o objeto, adicionamos ao frame, adicionamos um ActionListener
            // e adicionamos um MouseListener.
            verProntuarios = new PainelVerProntuarios();
            add(verProntuarios);
            verProntuarios.voltar.addActionListener(this);
            verProntuarios.tabela.addMouseListener(new MouseInputAdapter() {
                // Esse evento é para escutar o clique do mouse, onde, nesse método usamos para verificar o
                // double click em alguma linha da tabela e, dessa forma, abrir a área para visualização de
                // informações de prontuários anteriores.
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount() == 2) {
                        int rowIndex = verProntuarios.tabela.getSelectedRow();

                        if(rowIndex != -1) {

                            ArrayList<String> informacoes;

                            try {
                                String id = (String) verProntuarios.tabela.getValueAt(rowIndex, 0);
                                informacoes = dao.preencheProntuario(id);

                                prontuarioAberto.anamnese.setText(informacoes.get(0));
                                prontuarioAberto.planoTerapeutico.setText(informacoes.get(1));
                                prontuarioAberto.encaminhamento.setText(informacoes.get(2));
                                prontuarioAberto.cpfField.setText(informacoes.get(3));

                            }catch(Exception ex) {
                                ex.getStackTrace();
                            }

                            verProntuarios.setVisible(false);
                            prontuarioAberto.setVisible(true);
                            setTitle("Prontuário");
                        }
                    }
                }
            });

            try {
                Paciente paciente = new Paciente(cpfNaoFormatado);

                // Verificamos a validade do CPF e se será possível acessar o sistema.
                if(dao.verificaCpf(paciente)) {
                    DialogPersonalizado.showMessageDialog(this, "Acesso liberado");

                    // Colocamos o nome do paciente no menu principal.
                    menu.textoNome.setText(dao.getPaciente().getNome());

                    // Preenchemos o painel de informações do paciente.
                    informacoes.preenchePaciente(dao.getPaciente());

                    // Altero a visibilidade para o painel de acesso sumir e trocar para o menu principal.
                    acesso.setVisible(false);
                    menu.setVisible(true);
                    acesso.cpfField.setValue(null);
                    setTitle("Menu principal");

                } else {
                    DialogPersonalizado.showMessageDialog(this, "CPF inválido");
                    acesso.cpfField.setValue(null);
                }
            } catch (Exception ex) {
                ex.getStackTrace();
                DialogPersonalizado.showMessageDialog(this, "Error");
                }
        }

        // Até o próximo comentário, os if's são para alterar entre telas.
        if(e.getSource() == menu.buttonInformacoes) {
            menu.setVisible(false);
            informacoes.setVisible(true);
            setTitle("Informações do paciente");
        }

        if(e.getSource() == menu.buttonAbrir) {
            menu.setVisible(false);
            prontuario.setVisible(true);
            setTitle("Criar prontuário médico");
        }

        if(e.getSource() == menu.buttonAnteriores) {
            menu.setVisible(false);
            verProntuarios.setVisible(true);
            setTitle("Acessar prontuários anteriores");
        }

        if(e.getSource() == menu.buttonSair) {
            menu.setVisible(false);
            acesso.setVisible(true);
            setTitle("Acessar prontuário");
        }

        if(e.getSource() == informacoes.voltar) {
            informacoes.setVisible(false);
            menu.setVisible(true);
            setTitle("Menu principal");
        }

        if(e.getSource() == verProntuarios.voltar) {
            verProntuarios.setVisible(false);
            menu.setVisible(true);
            setTitle("Menu principal");
        }

        // Esse evento é especial, é onde ocorre a validação do cpf médico, validação dos campos do prontuário,
        // criação do prontuário no banco de dados e atualização da tabela de prontuários.
        if(e.getSource() == prontuario.abrir) {
            try {
                // Tiramos a formatação do texto para fazer a validação do CPF do médico no banco de dados.
                String cpfFuncionario = prontuario.cpfField.getText().replaceAll("[^0-9]", "");

                // Verificamos se o prontuário NÃO é válido.
                if(!dao.verificaFuncionario(cpfFuncionario)) {
                    DialogPersonalizado.showMessageDialog(this, "Erro: CPF inválido");
                    prontuario.cpfField.setValue(null);
                } else {
                    // Verificamos se os campos anamnese, planoTerapeutico e encaminhamento não são vázios, o trim()
                    // serve para tirar os espaços no início e fim do texto.
                    if(prontuario.anamnese.getText().trim().equals("") || prontuario.planoTerapeutico.getText().trim().equals("")
                            || prontuario.encaminhamento.getText().trim().equals("")) {

                        DialogPersonalizado.showMessageDialog(this, "Erro: Campo vazio");

                    } else {

                        // Campo para fazer a confirmação do prontuário antes de enviá-lo
                        if(confirma == 0) {
                            DialogPersonalizado.showMessageDialog(this, "Confirme os dados");
                            prontuario.cpfField.setValue(null);
                            confirma++;
                        } else {
                            DialogPersonalizado.showMessageDialog(this, "Prontuário criado");
                            confirma = 0;

                            // Para criação de um prontuário, nós precisamos de alguns parâmetros, incluindo o
                            // ID do Funcionário e o ID do Atendimento, o ID do Funcionários nós conseguimos através
                            // do CPF do criados do prontuário, o id_Atendimento, através do cpf do paciente.
                            int id_Funcionario = dao.getId_Funcionario();
                            int id_Atendimento = dao.pegaIdAtendimento(cpfNaoFormatado);

                            // Usamos uma classe suporte, que chamamos de uma entidade do Prontuario Médico, para
                            // armazenar esses dados e passarmos de uma forma "empacotada" para o DAO.
                            ProntuarioMedico prontuarioMedico = new ProntuarioMedico(
                                    prontuario.anamnese.getText(),
                                    prontuario.planoTerapeutico.getText(),
                                    prontuario.encaminhamento.getText(),
                                    Integer.toString(id_Funcionario),
                                    Integer.toString(id_Atendimento));

                            dao.adicionaProntuario(prontuarioMedico);

                            // Atualizamos a tabela com o novo prontuário criado.
                            try {
                                verProntuarios.tabela.setModel(new TabelaProntuarios(dao.pegaTabelaEntidade(MainFrame.cpfNaoFormatado)));
                                verProntuarios.atualizaTabela();
                            } catch (Exception ex) {
                                ex.getStackTrace();
                            }

                            // Ao finalizar a criação, nós chamamos o botão de cancelar para voltar ao menu principal e limpar os campos.
                            prontuario.cancelar.doClick();
                        }
                    }
                }
            } catch (Exception ex) {
                ex.getStackTrace();
            }
        }

        // Botão cancelar, que usamos também no botão de abrir.
        if(e.getSource() == prontuario.cancelar) {
            prontuario.setVisible(false);
            menu.setVisible(true);
            setTitle("Menu principal");
            prontuario.anamnese.setText("");
            prontuario.planoTerapeutico.setText("");
            prontuario.encaminhamento.setText("");
            prontuario.cpfField.setText("");
        }

        // Botão para voltar ao menu de tabelas, quando se da double click em uma linha da tabela.
        if(e.getSource() == prontuarioAberto.voltar) {
            prontuarioAberto.setVisible(false);
            verProntuarios.setVisible(true);
            setTitle("Acessar prontuários anteriores");
        }
    }
}

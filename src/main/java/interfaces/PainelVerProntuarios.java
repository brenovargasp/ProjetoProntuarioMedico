package interfaces;

import BancoDeDados.DAO;
import componentes_inteface.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class PainelVerProntuarios extends JPanel {

    CornerDecoration cornerDecoration;
    JLabel logo;
    LabelsMedium prontuarios_anteriores;
    ButtonsPanel voltar;
    JTable tabela;
    JScrollPane tabelaScroll, retornoTabela;

    // Mesmo explicado na classe PainelAcesso.
    public PainelVerProntuarios() {
        setBackground(new Color(0, 113, 182));
        setSize(600, 600);
        setVisible(false);

        cornerDecoration = new CornerDecoration();

        logo = new Logo("/images/iconeTelaAbrir.png", 20, 10, 201, 93);

        prontuarios_anteriores = new LabelsMedium("Prontuários anteriores", 178, 150, 244, 30, 25);

        retornoTabela = retornaTabela();

        voltar = new ButtonsPanel("Voltar", 240, 460, 115, 34);

        setLayout(null);
        add(logo);
        add(prontuarios_anteriores);
        add(retornoTabela);
        add(voltar);
        add(cornerDecoration.getParteDeCima());
        add(cornerDecoration.getParteDeBaixo());
    }

    public JScrollPane retornaTabela() {
        DAO dao = new DAO();

        tabela = new JTable();
        tabelaScroll = new JScrollPane(tabela);

        try {
            tabela.setModel(new TabelaProntuarios(dao.pegaTabelaEntidade(MainFrame.cpfNaoFormatado)));
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        atualizaTabela();

        tabelaScroll.setBorder(BorderFactory.createLineBorder(new Color(1, 76, 121), 1));
        tabelaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        tabelaScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tabelaScroll.setBounds(95, 180, 400, 250);
        return tabelaScroll;
    }

    public void atualizaTabela() {
        tabela.setFillsViewportHeight(true);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setFont(new Font("Arial", Font.PLAIN, 15));
        tabela.setRowHeight(20);
        tabela.getTableHeader().setFont(new Font("AmpleSoftPro-Medium", Font.PLAIN, 20));
        tabela.getTableHeader().setForeground(new Color(0, 113, 182));

        // Configurar o renderizador de células personalizado para o cabeçalho da tabela
        TableColumnModel columnModel = tabela.getColumnModel();
        for (int columnIndex = 0; columnIndex < columnModel.getColumnCount(); columnIndex++) {
            TableColumn column = columnModel.getColumn(columnIndex);
            column.setHeaderRenderer(new TableMarginHeader(5)); // Definir a margem superior desejada (neste exemplo, 5 pixels)
        }

        for (int columnIndex = 0; columnIndex < columnModel.getColumnCount(); columnIndex++) {
            TableColumn column = columnModel.getColumn(columnIndex);
            column.setResizable(false); // Impede o redimensionamento da coluna
        }

        int columnIndex1 = 0; // Índice da primeira coluna
        int preferredWidth1 = 50; // Largura preferencial da primeira coluna (em pixels)
        TableColumn column1 = columnModel.getColumn(columnIndex1);
        column1.setPreferredWidth(preferredWidth1);

        int columnIndex2 = 1; // Índice da segunda coluna
        int preferredWidth2 = 258; // Largura preferencial da segunda coluna (em pixels)
        TableColumn column2 = columnModel.getColumn(columnIndex2);
        column2.setPreferredWidth(preferredWidth2);

        int columnIndex3 = 2; // Índice da terceira coluna
        int preferredWidth3 = 90; // Largura preferencial da terceira coluna (em pixels)
        TableColumn column3 = columnModel.getColumn(columnIndex3);
        column3.setPreferredWidth(preferredWidth3);
    }

}

package componentes_inteface;

import entidades.TabelaEntidade;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

// Classe criada para servir de modelo para a tabela e preencher os dados das linhas.
public class TabelaProntuarios extends AbstractTableModel {

    ArrayList<TabelaEntidade> tabelaEntidades;

    public TabelaProntuarios(ArrayList<TabelaEntidade> tabela) {
        this.tabelaEntidades = tabela;
    }

    String[] columns = {"ID", "Nome do Médico", "Data"};

    @Override
    public int getRowCount() {
        if(tabelaEntidades == null) {
            return 0;
        } else {
            return tabelaEntidades.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tabelaEntidades.get(rowIndex).getId();
            case 1:
                return tabelaEntidades.get(rowIndex).getNomeMedico();
            case 2:
                return tabelaEntidades.get(rowIndex).getData();
            default:
                return null;
        }
    }
}

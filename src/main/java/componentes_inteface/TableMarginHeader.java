package componentes_inteface;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

// Classe criada para colocar uma margem entre o topo da tabela e o título das colunas.
public class TableMarginHeader extends DefaultTableCellRenderer {

    private final int topMargin;

    public TableMarginHeader(int topMargin) {
        this.topMargin = topMargin;
        setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JTableHeader header = table.getTableHeader();
        setFont(header.getFont());
        setText(value != null ? value.toString() : "");
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY), // Adiciona uma borda inferior e direita para as células do cabeçalho
                BorderFactory.createEmptyBorder(topMargin, 0, 0, 0) // Define a margem superior
        ));
        return this;
    }
}



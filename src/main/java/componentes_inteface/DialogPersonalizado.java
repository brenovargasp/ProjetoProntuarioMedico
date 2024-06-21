package componentes_inteface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// Nessa classe eu criei o meu próprio showMessageDialog, de forma personalizada.
public class DialogPersonalizado extends JDialog {
    LabelsMedium messageLabel;
    private JButton button;

    public DialogPersonalizado(Frame owner, String message) {
        super(owner, "Aviso", true);
        setSize(200, 150);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/icone.png"))).getImage());
        setResizable(false);
        setLocationRelativeTo(owner); // Define a posição do diálogo em relação ao frame pai

        messageLabel = new LabelsMedium(message, 0, 20, 185, 50, 20);
        messageLabel.setForeground(new Color(0, 113, 182));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        button = new ButtonsPanel("OK", 57, 75, 70, 25);
        button.setFont(new Font("AmpleSoftPro-Medium", Font.PLAIN, 15));

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setLayout(null);
        getContentPane().add(messageLabel);
        getContentPane().add(button);
    }

    public static void showMessageDialog(Frame parent, String message) {
        DialogPersonalizado dialog = new DialogPersonalizado(parent, message);
        dialog.setVisible(true);
    }
}

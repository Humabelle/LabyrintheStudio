import javax.swing.*;
import java.awt.*;

public class LabyrintheStudio {
    private final Niveau niveau = new Niveau(12, 8);
    public final JPanel racine;

    public LabyrintheStudio() {
        racine = new JPanel(new BorderLayout(5, 5));
        racine.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea text = new JTextArea(DemoConsole.texte(niveau));
        text.setEditable(false);
        text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(text);
        scroll.setPreferredSize(new Dimension(400, 400));

        racine.add(new JLabel("Labyrinthe Studio : D = départ, S = sortie, # = mur\""), BorderLayout.NORTH);
        racine.add(new JLabel("Seance 3 dessiner grille"), BorderLayout.SOUTH);
        racine.add(scroll, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LabyrintheStudio app = new LabyrintheStudio();
            JFrame fenetre = new JFrame("Labyrinthe Studio");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setContentPane(app.racine);
            fenetre.pack();
            fenetre.setLocationRelativeTo(null);
            fenetre.setVisible(true);
        });
    }
}

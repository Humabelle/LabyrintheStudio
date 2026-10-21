
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.concurrent.ExecutionException;

public class PremiereFenetre {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Premier atelier");
            JPanel racine = new JPanel(new BorderLayout(8, 8));
            racine.add(new JLabel("Bienvenue dans Swing"), BorderLayout.CENTER);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setContentPane(racine);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }

    private static void ouvrir(JComponent contenu) {
        JFrame fenetre = new JFrame("PremiereFenetre");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setContentPane(contenu);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
}

import java.awt.*;
import javax.swing.*;

public class LabyrintheStudio {
    private Niveau niveau = new Niveau(12, 8);
    public final JPanel racine;
    public LabyrintheStudio() {
        racine = new JPanel(new BorderLayout(8, 8));
        racine.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        racine.add(new JLabel("Labyrinthe Studio : D = départ, S = sortie, # = mur\""), BorderLayout.NORTH);
        racine.add(new JLabel("Seance 3 dessiner grille"), BorderLayout.SOUTH);
        racine.add(new Vue(), BorderLayout.CENTER);
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
private final class Vue extends JPanel {
        private static final int MARGE = 12;

        Vue() {
            setBackground(Color.LIGHT_GRAY);
            setPreferredSize(new Dimension(480, 340));
        }

        private int taille() {
            int tLargeur = (getWidth() - 2 * MARGE) / niveau.getColonnes();
            int tHauteur = (getHeight() - 2 * MARGE) / niveau.getLignes();
            return Math.max(0, Math.min(tLargeur, tHauteur));
        }

        private int origineX() {
            return (getWidth() - niveau.getColonnes() * taille()) / 2;
        }

        private int origineY() {
            return (getHeight() - niveau.getLignes() * taille()) / 2;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int t = taille();
            if (t == 0) return;
            int ox = origineX(), oy = origineY();

            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, Math.max(10, t / 2)));
            for (int l = 0; l < niveau.getLignes(); l++) {
                for (int c = 0; c < niveau.getColonnes(); c++) {
                    int x = ox + c * t;
                    int y = oy + l * t;

                    g.setColor(niveau.lire(c, l) == Niveau.Case.MUR
                            ? new Color(45, 55, 70) : Color.WHITE);
                    g.fillRect(x, y, t, t);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, t, t);

                    if (c == niveau.getDepartColonne() && l == niveau.getDepartLigne()) {
                        g.setColor(new Color(0, 100, 50));
                        g.drawString("D", x + t / 3, y + 2 * t / 3);
                    }
                    if (c == niveau.getSortieColonne() && l == niveau.getSortieLigne()) {
                        g.setColor(new Color(150, 55, 0));
                        g.drawString("S", x + t / 3, y + 2 * t / 3);
                    }
                }
            }
        }
    }
}

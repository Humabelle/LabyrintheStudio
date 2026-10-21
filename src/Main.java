import javax.swing.*;

public class Main {
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

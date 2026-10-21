/** Squelette etudiant : completer les quatre methodes marquees TODO. */
public class Niveau {
    public enum Case { SOL, MUR }
    private final int colonnes;
    private final int lignes;
    private final Case[][] cases;
    private int departColonne = 1, departLigne = 1;
    private int sortieColonne, sortieLigne;

    public Niveau(int colonnes, int lignes) {
        if (colonnes < 4 || lignes < 4) {
            throw new IllegalArgumentException("Dimensions minimales : 4 par 4");
        }
        this.colonnes = colonnes; this.lignes = lignes;
        sortieColonne = colonnes - 2; sortieLigne = lignes - 2;
        cases = new Case[lignes][colonnes];
        for (int l = 0; l < lignes; l++) {
            for (int c = 0; c < colonnes; c++) {
                boolean bord = l == 0 || c == 0 || l == lignes - 1 || c == colonnes - 1;
                cases[l][c] = bord ? Case.MUR : Case.SOL;
            }
        }
    }
    public int getColonnes() { return colonnes; }
    public int getLignes() { return lignes; }
    public int getDepartColonne() { return departColonne; }
    public int getDepartLigne() { return departLigne; }
    public int getSortieColonne() { return sortieColonne; }
    public int getSortieLigne() { return sortieLigne; }

    /** Vrai seulement si les indices sont ceux d'une case existante. */
    public boolean dansGrille(int colonne, int ligne) {
        return colonne >= 0 && ligne >= 0 && colonne < colonnes && ligne < lignes;
    }

    /** Retourne la case ; rejette les indices invalides par IllegalArgumentException. */
    public Case lire(int colonne, int ligne) {
        if (dansGrille(colonne, ligne)){
            return cases[ligne][colonne];
        } else  {
            throw new IllegalArgumentException("Colonne ou Ligne invalide !");
        }
    }
    /**
     * Pose un mur sauf sur depart/sortie ou hors grille.
     * Renvoie vrai uniquement si une case SOL devient MUR.
     * Un refus ou un mur deja present ne modifie rien et renvoie faux.
     */
    public boolean poserMur(int colonne, int ligne) {
        if (!dansGrille(colonne, ligne)) return false;
        if ((colonne == departColonne && ligne == departLigne) || (colonne == sortieColonne && ligne == sortieLigne)) return false;
        if (cases[ligne][colonne] == Case.MUR) return false;
        cases[ligne][colonne] = Case.MUR;
                return true;
    }
    /** Retire un mur. Faux hors grille ou si la case est deja SOL. */
    public boolean retirerMur(int colonne, int ligne) {
        if (!dansGrille(colonne, ligne)) return false;
        if (cases[ligne][colonne] != Case.MUR) return false;
        cases[ligne][colonne] = Case.SOL;
        return true;
    }
}

/** Verifications explicites : aucun framework ni option -ea necessaire. */
public class VerificationNiveau {
    private static void verifier(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
    public static void main(String[] args) {
        Niveau n = new Niveau(12, 8);
        verifier(n.dansGrille(11, 7), "Derniere case valide");
        verifier(!n.dansGrille(12, 7), "Colonne hors grille");
        verifier(!n.dansGrille(2, 8), "Ligne hors grille");
        verifier(!n.dansGrille(-1, 0), "Indice negatif");
        verifier(n.lire(0, 0) == Niveau.Case.MUR, "Bord initial");
        verifier(n.lire(2, 2) == Niveau.Case.SOL, "Sol initial");
        verifier(n.poserMur(2, 2), "Premier ajout accepte");
        verifier(!n.poserMur(2, 2), "Pas de faux changement");
        verifier(n.retirerMur(2, 2), "Retrait accepte");
        verifier(!n.retirerMur(2, 2), "Retrait sans effet");
        verifier(!n.poserMur(1, 1), "Depart protege");
        verifier(!n.poserMur(10, 6), "Sortie protegee");
        verifier(!n.poserMur(99, 99), "Modification hors grille refusee");
        boolean refuse = false;
        try { n.lire(12, 0); } catch (IllegalArgumentException e) { refuse = true; }
        verifier(refuse, "Lecture hors grille rejetee explicitement");
        // TODO : ajouter au moins une verification choisie par votre equipe.
        verifier(n.poserMur(5, 1), "Mur autorisé sur la ligne du départ");
        verifier(n.poserMur(10, 3), "Mur autorisé sur la colonne de la sortie");
        verifier(!n.poserMur(0, 0), "Bord déjà mur : pas de changement");
        System.out.println("Verifications de base reussies.");
    }
}

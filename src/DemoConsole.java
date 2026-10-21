public class DemoConsole {
    static String texte(Niveau niveau) {
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < niveau.getLignes(); l++) {
            for (int c = 0; c < niveau.getColonnes(); c++) {
                if (c == niveau.getDepartColonne() && l == niveau.getDepartLigne()) {
                    sb.append('D');
                } else if (c == niveau.getSortieColonne() && l == niveau.getSortieLigne()) {
                    sb.append('S');
                } else if (niveau.lire(c, l) == Niveau.Case.MUR) {
                    sb.append('#');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Niveau niveau = new Niveau(12, 8);
        System.out.println("Labyrinthe Studio : " + niveau.getColonnes() + " x " + niveau.getLignes());
        System.out.print(texte(niveau));
    }
}
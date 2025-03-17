public class Morpion {

    private char[][] grille;
    private Player currentPlayer;
    private Player player1;
    private Player player2;


    public Morpion(){

    }

    public Morpion(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        grille = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grille[i][j] = ' ';
            }
        }
    }

    public String afficherGrille() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(" ").append(grille[i][j]).append(" ");
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("---+---+---\n");
        }
        return sb.toString();
    }


    public boolean jouer(String position) {
        int[] coord = convertirPosition(position);
        if (coord == null || grille[coord[0]][coord[1]] != ' ') {
            return false;
        }
        grille[coord[0]][coord[1]] = currentPlayer.getSymbol();
        switchPlayer();
        return true;
    }

    private int[] convertirPosition(String position) {
        if (position.length() != 2) return null;
        int x = position.charAt(0) - 'A';
        int y = position.charAt(1) - '1';
        if (x < 0 || x >= 3 || y < 0 || y >= 3) return null;
        return new int[]{x, y};
    }

    public char getCase(int x, int y) {
        return grille[x][y];
    }


    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean verifierVictoire() { //modifier pour victoire verticale et diagonale
        char symbole = (currentPlayer == player1) ? player2.getSymbol() : player1.getSymbol();
        for (int i = 0; i < 3; i++) {
            if (grille[i][0] == symbole && grille[i][1] == symbole && grille[i][2] == symbole) return true;
            if (grille[0][i] == symbole && grille[1][i] == symbole && grille[2][i] == symbole) return true;
        }
        if (grille[0][0] == symbole && grille[1][1] == symbole && grille[2][2] == symbole) return true;
        if (grille[0][2] == symbole && grille[1][1] == symbole && grille[2][0] == symbole) return true;
        return false;
    }

    public boolean verifierEgaliter() {
        if (verifierVictoire()) return false;
        for (int i = 0; i < 3; i++) {
            if(grille[i].length != 3 ) return false;
        }
        return true;
    }
}

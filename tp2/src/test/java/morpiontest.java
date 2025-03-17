import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class morpiontest {

    Player player1;
    Player player2;
    Morpion jeu;

    @BeforeEach
    public void initPlayerAndJeu(){
        player1 = new Player("Alice", 'X');
        player2 = new Player("Bob", 'O');
        jeu = new Morpion(player1, player2);
    }

    @Test
    public void testMorpionInstance() {
        assertThat(new Morpion(), instanceOf(Morpion.class));
    }

    @Test
    public void testGrilleVideAuDebut() {
        assertEquals("   |   |   \n---+---+---\n   |   |   \n---+---+---\n   |   |   \n", jeu.afficherGrille());
    }

    @Test
    public void testGrilleJoueBonneEndroit(){
        jeu.jouer("A1");
        assertEquals(" X |   |   \n---+---+---\n   |   |   \n---+---+---\n   |   |   \n", jeu.afficherGrille());
    }

    @Test
    public void testGrilleJoueBonneEndroitAvecAlternanceJoueur(){
        jeu.jouer("A1");
        jeu.jouer("C3");
        assertEquals(" X |   |   \n---+---+---\n   |   |   \n---+---+---\n   |   | O \n", jeu.afficherGrille());
    }


    @Test
    public void testPlacementSymbole() {
        jeu.jouer("A1");
        assertEquals('X', jeu.getCase(0, 0));
    }

    @Test
    public void testCaseDejaOccupee() {
        jeu.jouer("A1");
        assertFalse(jeu.jouer("A1"));
    }






    static Stream<Arguments> FalsePositionPlacement() {
        return Stream.of(
                Arguments.of("D1"),
                Arguments.of("A4"),
                Arguments.of("Y7"),
                Arguments.of("B6")
                );
    }

    @ParameterizedTest
    @MethodSource("FalsePositionPlacement")
    @DisplayName("Test de la fonction Fibonacci avec différents nombres")
    public void testPlacementEnDehors(String input) {
       assertFalse(jeu.jouer(input));
    }


    @Test
    public void testStartRightPlayer(){
        assertEquals(player1, jeu.getCurrentPlayer()); //alice
    }


    @Test
    public void testAlternanceDesJoueurs() {
        jeu.jouer("A1"); //alice
        assertEquals(player2, jeu.getCurrentPlayer()); //bob
    }

    @Test
    public void testBouclePlayer(){
        jeu.jouer("A1"); //alice
        jeu.jouer("B2"); //bob
        assertEquals(player1, jeu.getCurrentPlayer()); //alice
    }

    @Test
    public void testVictoireHorizontale() {
        jeu.jouer("A1"); //alice
        jeu.jouer("B2"); //bob
        jeu.jouer("A3"); //alice
        jeu.jouer("B1"); //bob
        jeu.jouer("A2"); //alice
        assertTrue(jeu.verifierVictoire());
    }

    @Test
    public void testVictoireVerticale(){
        jeu.jouer("A1"); //alice
        jeu.jouer("B2"); //bob
        jeu.jouer("B1"); //alice
        jeu.jouer("B3"); //bob
        jeu.jouer("C1"); //alice
        assertTrue(jeu.verifierVictoire());
    }

    @Test
    public void testVictoireDiagonale(){
        jeu.jouer("A1"); //alice
        jeu.jouer("B1"); //bob
        jeu.jouer("B2"); //alice
        jeu.jouer("B3"); //bob
        jeu.jouer("C3"); //alice
        assertTrue(jeu.verifierVictoire());
    }

    @Test
    public void testEgalité(){
        jeu.jouer("A1"); //alice
        jeu.jouer("A2"); //bob
        jeu.jouer("B1"); //alice
        jeu.jouer("B2"); //bob
        jeu.jouer("C2"); //alice
        jeu.jouer("C1"); //bob
        jeu.jouer("A3"); //alice
        jeu.jouer("C3"); //bob
        jeu.jouer("B3"); //alice
        assertTrue(jeu.verifierEgaliter());
    }
}



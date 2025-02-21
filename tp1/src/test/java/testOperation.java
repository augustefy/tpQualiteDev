import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testOperation {
    @Test
    void testAddition(){
        assertEquals(Operation.additionner(5,5), 10);
        assertEquals(Operation.additionner(15,-5), 10);
        assertEquals(Operation.additionner(0,0), 0);
    }
    @Test
    void testAdditionnerAvecMoinsDeDeuxValeurs() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Operation.additionner(5));
        assertEquals("Il faut au moins 2 nombres pour additionner.", exception.getMessage());
    }


    @Test
    void testMultiplier() {
        assertEquals(50, Operation.multiplier(5, 10));
        assertEquals(0, Operation.multiplier(5, 0, 10));
        assertEquals(1000, Operation.multiplier(10, 10, 10));
        assertEquals(-25, Operation.multiplier(-5, 5));
    }



    @Test
    void testMultiplierAvecMoinsDeDeuxValeurs() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Operation.multiplier(5));
        assertEquals("Il faut au moins 2 nombres pour multiplier.", exception.getMessage());
    }

    @Test
    void testDiviser() {
        assertEquals(2, Operation.diviser(10, 5));
        assertEquals(1, Operation.diviser(100, 10, 10));
        assertEquals(-5, Operation.diviser(-10, 2));
    }

    @Test
    void testDiviserAvecDivisionParZero() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> Operation.diviser(10, 0));
        assertEquals("Division par zéro non autorisée.", exception.getMessage());
    }

    @Test
    void testDiviserAvecMoinsDeDeuxValeurs() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Operation.diviser(10));
        assertEquals("Il faut au moins 2 nombres pour diviser.", exception.getMessage());
    }

    @Test
    void testValidPythagoreanTriples() {
        assertTrue(Operation.pythagore(5, 3, 4));  // 3^2 + 4^2 = 5^2
        assertTrue(Operation.pythagore(13, 5, 12)); // 5^2 + 12^2 = 13^2
        assertTrue(Operation.pythagore(25, 7, 24)); // 7^2 + 24^2 = 25^2
    }

    @Test
    void testInvalidPythagoreanTriples() {
        assertFalse(Operation.pythagore(6, 3, 4));  // 3^2 + 4^2 != 6^2
        assertTrue(Operation.pythagore(10, 6, 8)); // 6^2 + 8^2 != 10^2
        assertTrue(Operation.pythagore(15, 9, 12)); // 9^2 + 12^2 != 15^2
    }

    @Test
    void testZeroAndNegativeValues() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Operation.pythagore(0, 0, 0));
        assertEquals("Pas de triangle avec un côté à 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> Operation.pythagore(-5, -3, -4));
        assertEquals("Pas de triangle avec un côté à 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> Operation.pythagore(5, -3, 4));
        assertEquals("Pas de triangle avec un côté à 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> Operation.pythagore(5, 3, -4));
        assertEquals("Pas de triangle avec un côté à 0", exception.getMessage());

    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testPGCD {

    @Test
    void testPGCDCasNormaux() {
        assertEquals(6, PGCD.calculerPGCD(54, 24));
        assertEquals(1, PGCD.calculerPGCD(17, 31));
        assertEquals(12, PGCD.calculerPGCD(36, 48));
        assertEquals(5, PGCD.calculerPGCD(10, 5));
    }

    @Test
    void testPGCDAvecZero() {
        assertEquals(10, PGCD.calculerPGCD(10, 0));
        assertEquals(25, PGCD.calculerPGCD(0, 25));
        assertEquals(0, PGCD.calculerPGCD(0, 0));
    }

    @Test
    void testPGCDAvecMemeNombre() {
        assertEquals(8, PGCD.calculerPGCD(8, 8));
        assertEquals(100, PGCD.calculerPGCD(100, 100));
    }

    @Test
    void testPGCDAvecNombreNegatif() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> PGCD.calculerPGCD(-5, 15));
        assertEquals("Les nombres doivent être positifs ou nuls.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> PGCD.calculerPGCD(10, -20));
        assertEquals("Les nombres doivent être positifs ou nuls.", exception.getMessage());
    }

    @Test
    void testPGCDAvecNombrePremier(){
        assertEquals(1, PGCD.calculerPGCD(73, 79));
        assertEquals(1, PGCD.calculerPGCD(2, 3));
        assertEquals(1, PGCD.calculerPGCD(1129, 2411));

    }
}

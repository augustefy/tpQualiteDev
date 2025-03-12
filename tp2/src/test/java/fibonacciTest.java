import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class fibonacciTest {

    @Test
    void testFibonacciInstance() {
        assertThat(new Fibonacci(), instanceOf(Fibonacci.class));
    }

    @Test
    void testFibonacciZero() {
        assertEquals(BigInteger.ZERO, Fibonacci.fibonacci(BigInteger.ZERO));
    }

    @Test
    void testFibonacciOne() {
        assertEquals(BigInteger.ONE, Fibonacci.fibonacci(BigInteger.ONE));
    }

    static Stream<Arguments> fibonacciTestCases() {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(8), BigInteger.valueOf(21)),
                Arguments.of(BigInteger.valueOf(15), BigInteger.valueOf(610)),
                Arguments.of(BigInteger.valueOf(20), BigInteger.valueOf(6765)),
                Arguments.of(
                        BigInteger.valueOf(10000000),
                        new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875"))
            );
    }
    @ParameterizedTest
    @MethodSource("fibonacciTestCases")
    @DisplayName("Test de la fonction Fibonacci avec différents nombres")

    

    void testFibonacci(BigInteger input, BigInteger expected) {
        assertEquals(expected, Fibonacci.fibonacci(input));
    }
}

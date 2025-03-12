import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fibonacci(BigInteger n) {

        if (n.compareTo(BigInteger.ZERO) <= 0) return BigInteger.ZERO;
        if (n.compareTo(BigInteger.ONE) == 0) return BigInteger.ONE;

        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE, somme;
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            somme = a.add(b);
            a = b;
            b = somme;
        }

        return b;
    }

}
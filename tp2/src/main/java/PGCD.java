public class PGCD {
    public static long calculerPGCD(long a, long b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Les nombres doivent être positifs ou nuls.");
        }
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


import java.util.Arrays;

public class Operation {
    public static long additionner(long... nombres) {
        if (nombres.length < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 nombres pour additionner.");
        }
        long somme = 0;
        for (long nombre : nombres) {
            somme += nombre;
        }
        return somme;
    }

    public static long multiplier(long... nombres) {
        if (nombres.length < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 nombres pour multiplier.");
        }
        long produit = 1;
        for (long nombre : nombres) {
            produit *= nombre;
        }
        return produit;
    }

    public static long diviser(long... nombres) {
        if (nombres.length < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 nombres pour diviser.");
        }
        long quotient = nombres[0];
        for (int i = 1; i < nombres.length; i++) {
            if (nombres[i] == 0) {
                throw new ArithmeticException("Division par zéro non autorisée.");
            }
            quotient /= nombres[i];
        }
        return quotient;
    }

    public static Boolean pythagore(long h, long a, long o) {
        if (h <= 0 || o <= 0 || a <= 0) {
            throw new IllegalArgumentException("Pas de triangle avec un côté à 0");
        }
        long aa = a * a;
        long oo = o * o;
        long hh = h * h;
        return aa + oo == hh;
    }
}

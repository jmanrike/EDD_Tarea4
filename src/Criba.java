import java.util.Scanner;

public class Criba {

    public static int[] generatePrimes(int numberEntered) {
        int arraySize = numberEntered + 1;
        boolean[] isPrime = new boolean[arraySize];

        if (numberEntered >= 2) {

            initializeArray(arraySize, isPrime);
            criba(arraySize, isPrime);
            int[] primes = new int[getCount(arraySize, isPrime)];
            count(arraySize, isPrime, primes);
            return primes;

        } else {
            return new int[0];
        }
    }
    private static void initializeArray(int arraySize, boolean[] isPrime) {
        for (int i = 0; i < arraySize; i++) {
            isPrime[i] = true;

        }
        isPrime[0] = isPrime[1] = false;
    }

    private static void criba(int arraySize, boolean[] isPrime) {

        for (int i = 2; i < Math.sqrt(arraySize) + 1; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < arraySize; j += i)
                    isPrime[j] = false;
            }
        }
    }

    private static int getCount(int arraySize, boolean[] isPrime) {
        int count = 0;
        for (int i = 0; i < arraySize; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }

    private static void count(int arraySize, boolean[] isPrime, int[] primes) {
        for (int i = 0, j = 0; i < arraySize; i++) {
            if (isPrime[i])
                primes[j++] = i;
        }
    }



    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
        vector = generatePrimes(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}

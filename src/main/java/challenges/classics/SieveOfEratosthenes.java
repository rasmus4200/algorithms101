package challenges.classics;

public class SieveOfEratosthenes {

    public void print(int upperBound) {
        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);

        // isComposite means not prime
        boolean[] isComposite = new boolean[upperBound + 1];

        // going from prime 2 up to sqrt n
        for (int m = 2; m <= upperBoundSquareRoot; m++) {

            // if prime
            if (!isComposite[m]) {
                // Print it...
                System.out.print(m + " ");

                // Then mark all the others multiples as no prime
                for (int k = m * m; k <= upperBound; k += m) {
                    isComposite[k] = true;
                }
            }
        }

        System.out.println("\nEverything left over is prime...");

        for (int m = upperBoundSquareRoot; m <= upperBound; m++) {
            if (!isComposite[m])
                System.out.print(m + " ");
        }

    }

}

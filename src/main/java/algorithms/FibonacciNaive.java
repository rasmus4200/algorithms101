package algorithms;

public class FibonacciNaive {

    public int fib(int n) {
        System.out.println("Start fib(" + n + ")");
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}



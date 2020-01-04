package algorithms;

public class FibonacciMemoized {

    private int[] memo = new int[10001];

    public int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int fib1 = (memo[n-1] == 0) ? fib(n-1) : memo[n-1];
        int fib2 = (memo[n-2] == 0) ? fib(n-2) : memo[n-2];
        memo[n] = fib1 + fib2;
        return memo[n];
    }

}

package challenges.classics;

public class FizzBuzz {

    //
    // This solution is all about the 'modulus' operator.
    // If you can divide the number by 3, 5, or 15 and have no remainder,
    // you have a candidate for printing.
    //
    // Things to watch out for:
    // - start your loop at index 1 and end at 101
    // - know the modulus operator
    //
    public void print() {
        for (int i=1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}

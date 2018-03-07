package questions.classics;

import datastructures.PrettyPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import questions.arraysAndStrings.*;

import java.util.ArrayList;

public class ClassicsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void SetUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void FizzBuzz() {
        // Challenge: Write a program that prints 1 to 100.
        // But for multiples of three print 'Fizz' instead of the number.
        // And for multiples of five  print 'Buzz'.
        // For numbers which are multiples of both three and five print 'FizzBuzz'.

        fizzBuzz.print();
    }

}

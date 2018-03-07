package questions.classics;

import datastructures.PrettyPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import questions.arraysAndStrings.*;

import java.util.ArrayList;

public class ClassicsTest {

    private FizzBuzz fizzBuzz;
    private RansomNote ransomNote;

    @Before
    public void SetUp() {
        fizzBuzz = new FizzBuzz();
        ransomNote = new RansomNote();
    }

    @Test
    public void FizzBuzz() {
        // Challenge: Write a program that prints 1 to 100.
        // But for multiples of three print 'Fizz' instead of the number.
        // And for multiples of five  print 'Buzz'.
        // For numbers which are multiples of both three and five print 'FizzBuzz'.

        fizzBuzz.print();
    }

    @Test
    public void HarmlessRansomNote() {
        // Challenge: Write a ransom note by cutting letters out of the available
        // magazines and pasting them together to form a letter. Given an arbitrary
        // ransom note string and another string containing all the contents of all
        // the magazines, write a function that will return true if the ransom
        // note can be made from the magazines; otherwise, it will return false.
        // Every letter found in the magazine string can only be used once in your
        // ransom note.

        Assert.assertTrue(ransomNote.canWrite("Pay", "yaP"));
        Assert.assertTrue(ransomNote.canWrite("Pay", "yaP a"));
        Assert.assertTrue(ransomNote.canWrite("Pay me $1000", "ayPem0001$"));

        Assert.assertFalse(ransomNote.canWrite("Pay", "Pa"));
    }

}

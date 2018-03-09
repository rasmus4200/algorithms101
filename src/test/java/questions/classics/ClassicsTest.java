package questions.classics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClassicsTest {

    private FizzBuzz fizzBuzz;
    private RansomNote ransomNote;
    private CaesarCipherSimple caesarSimple;
    private CaesarCipherAdvanced caesarAdvanced;
    private SieveOfEratosthenes sieveOfEratosthenes;

    @Before
    public void SetUp() {
        fizzBuzz = new FizzBuzz();
        ransomNote = new RansomNote();
        caesarSimple = new CaesarCipherSimple();
        caesarAdvanced = new CaesarCipherAdvanced();
        sieveOfEratosthenes = new SieveOfEratosthenes();
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

    @Test
    public void CaesarCipher() {
        // Challenge: Implement a Caesar Cipher.
        //
        // A Caesar Cipher is a basic encryption algorithm that takes all the letters message
        // and encrypts them by shifting them over some fixed amount.
        //
        // For example a Caesar Cipher of x3 would map the alphabet like this:
        //
        // Plain:    ABCDEFGHIJKLMNOPQRSTUVWXYZ
        // Cipher:   XYZABCDEFGHIJKLMNOPQRSTUVW
        //
        // And the following text like this:
        //
        // Plaintext:  THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG
        // Ciphertext: QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD
        //
        // Write an encrypt and decrypt method using an offset of three
        //

        // First attempt...

        Assert.assertEquals("XYZ", caesarSimple.encrypt("ABC"));
        Assert.assertEquals("X Y Z", caesarSimple.encrypt("A B C"));
        Assert.assertEquals("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD", caesarSimple.encrypt("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));

        Assert.assertEquals("ABC", caesarSimple.decrypt("XYZ"));

        // Second attempt (after some Googling...)

        Assert.assertEquals("DEF", caesarAdvanced.encrypt("ABC", 3));
        Assert.assertEquals("D E F", caesarAdvanced.encrypt("A B C", 3));
        Assert.assertEquals("WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ", caesarAdvanced.encrypt("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", 3));

        Assert.assertEquals("A B C", caesarAdvanced.decrypt("D E F", 3));

        // Note: The reason why the first attempt and second attempt have different expectations (ABC vs DEF)
        // is because the second attempt shifts the other way. I left the examples as is so they match wikiPedia examples
        // and to make the more advanced algorithm simpler and easier to understand.
    }

    @Test
    public void SieveOfEratosthenes() {
        // Challenge: Given a number n, print all primes smaller than or equal to n (assume n < 30).
        //
        // Hint: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        //

        sieveOfEratosthenes.print(30);
    }

}

package challenges.arraysAndStrings;

import datastructures.PrettyPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ArraysAndStringsTest {

    private UniqueCharacterDetector charDetector;
    private PermutationDetector permDetector;
    private URLConverter urlConverter;
    private PalindromeDetector palindromeDetector;
    private OneAwayDetector oneAwayDetector;
    private Compressor compressor;
    private Zeroer1 zeroer1;
    private Zeroer2 zeroer2;

    @Before
    public void SetUp() {
        charDetector = new UniqueCharacterDetector();
        permDetector = new PermutationDetector();
        urlConverter = new URLConverter();
        palindromeDetector = new PalindromeDetector();
        oneAwayDetector = new OneAwayDetector();
        compressor = new Compressor();
        zeroer1 = new Zeroer1();
        zeroer2 = new Zeroer2();
    }

    @Test
    public void UniqueCharacters() {
        // Challenge: Given a string, see if you can detect whether it contains only
        // unique chars
        Assert.assertTrue(charDetector.isUnique("ab"));
        Assert.assertFalse(charDetector.isUnique("aa"));
        Assert.assertTrue(charDetector.isUnique("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void PermutationOfTheOther() {
        // Challenge: Given two strings, check if one is a permutation of the other
        Assert.assertTrue(permDetector.isPermutation("abc", "cba"));
        Assert.assertFalse(permDetector.isPermutation("abc", "xyz"));
    }

    @Test
    public void URLIfy() {
        // Challenge: See if you can replaces all the spaces in a a string with the
        // ASCII symbol for space '%20'. Assume you are given the length of the final
        // string. Hint: Use array of char[]
        Assert.assertEquals("My%20Home%20Page", urlConverter.urlify("My Home Page    ", 16));

    }

    @Test
    public void Palindromes() {
        // Challenge: Detect if a given string is a palindrome.
        // A palindrome is a word that can be spelt the same way forwards and backwards.

        Assert.assertTrue(palindromeDetector.isPalindrome("abba"));
        Assert.assertTrue(palindromeDetector.isPalindrome("mom"));
        Assert.assertTrue(palindromeDetector.isPalindrome("dad"));
        Assert.assertFalse(palindromeDetector.isPalindrome("rush"));
        Assert.assertFalse(palindromeDetector.isPalindrome("yes"));
    }

    @Test
    public void OneAway() {
        // Challenge: There are three types of edits that can be performed on strings: insert a character,
        // remove a character, or replace a character. Given two strings, write a function to check if they are
        // one or zero edits away.

        Assert.assertTrue(oneAwayDetector.oneAway("pale", "ple"));
        Assert.assertTrue(oneAwayDetector.oneAway("pales", "pale"));
        Assert.assertTrue(oneAwayDetector.oneAway("pale", "bale"));
        Assert.assertFalse(oneAwayDetector.oneAway("pale", "bake"));
    }

    @Test
    public void Compressor() {
        // Challenge: Give a string with repeating characters (i.e. "aaabb") write
        // an algorithm that will compress the string down to the character, followed
        // by the number of times it appears in the string (i.e "a3b2").
        // If the compressed string is not smaller than original, return original.

        Assert.assertEquals("a3b2", compressor.compress("aaabb"));
        Assert.assertEquals("aabb", compressor.compress("aabb"));
        Assert.assertEquals("ab", compressor.compress("ab"));
        Assert.assertEquals("abc", compressor.compress("abc"));
        Assert.assertEquals("z3", compressor.compress("zzz"));
        Assert.assertEquals("aabbaabb", compressor.compress("aabbaabb")); // not shorter
    }

    @Test
    public void ZeroOutMatrixRowsAndColumnsSolution1() {
        // Challenge: Given an nxm matrix, write an algorithm such that if an element in an
        // NxM matrix is zero, its entire row and column are set to 0.

        // Solution: This is an example divide and conquer. Here We can divide the problem
        // into two parts.
        //
        // 1. Get the zeros.
        // 2. Zero them out.
        //

        int[][] matrix = new int[][]{
                {1, 1, 1},
                {0, 1, 1},
                {1, 1, 1}
        };

//        PrettyPrinter.printMatrix(matrix);

        // Step 1: Get zeros
        ArrayList<Zeroer1.Pair> zeros = zeroer1.getZeros(matrix);

        Assert.assertEquals(1, zeros.size());
        Assert.assertEquals(1, zeros.get(0).y);
        Assert.assertEquals(0, zeros.get(0).x);

        // Step 2a: Zero out a row
        zeroer1.zeroOutRow(zeros.get(0).y, matrix);
        PrettyPrinter.printMatrix(matrix);

        // Step 2b: Zero out a column
        zeroer1.zeroOutCol(zeros.get(0).x, matrix);
        PrettyPrinter.printMatrix(matrix);

        // Step 3: Here is a convenience routine that brings it all together
        int[][] matrix2 = new int[][]{
                {1, 1, 1},
                {0, 1, 1},
                {1, 1, 0}
        };

        zeroer1.zeroOut(matrix2);

        PrettyPrinter.printMatrix(matrix2);

        // Things of note:
        // - use of tests
        // - use of ArrayList
        // - use or no use of immutable (creating many arrays vs changing original)
        // - Runtime: O(NM x P) - not great
    }

    @Test
    public void ZeroOutMatrixRowsAndColumnsSolution2() {
        // The first solution is OK. It's just not that space efficient.
        // Here is a super efficient solution that uses the matrix itself as a means
        // of tracking which rows and columns are zero.

        int[][] matrix = new int[][]{
                {1, 1, 1},
                {0, 1, 1},
                {1, 1, 0}
        };

        zeroer2.zeroOut(matrix);

        PrettyPrinter.printMatrix(matrix);

    }

}

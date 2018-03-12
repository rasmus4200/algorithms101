package questions.classics;

public class IntReverser {

    //
    // So the way this works is you take your number (say x)...
    // and then constantly apply the modulus 10 operator (%10)
    // to get the '1s' number.
    //
    // i.e. 123 => 3
    //
    // Once you have the single digit number, you take your current reverse result,
    // multiple it by 10, and then add your new digit.
    //
    // reverse = reverse * 10 + lastDigit; => 0 + 3 = 3
    //
    // Then you take whatever is left over (123) and divide it by 10 to get rid of the last digit
    //
    // x = x / 10; => 123 => 12
    //
    // Then you repeat the process. Grab the single digit, add it to the accumulating reverse, shave off a 10.
    //

    public int reverse(int x) {
        boolean isNegative = x < 0 ? true : false;

        if(isNegative) {
            x = x * -1;
        }

        int reverse = 0;
        int lastDigit = 0;

        while (x >= 1) {
            lastDigit = x % 10; // gives you last digit
            reverse = reverse * 10 + lastDigit;
            x = x / 10; // get rid of last digit
        }

        return isNegative == true? reverse*-1 : reverse;

    }

    // Soln based off http://www.java67.com/2015/08/how-to-reverse-integer-in-java-leetcode-solution.html
}

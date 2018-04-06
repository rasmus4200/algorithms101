package challenges.classics;

import java.util.HashMap;

public class StringReverser {

    // Soln1: Easy - use StringBuilder

    public String soln2(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        return sb.toString();
    }


    // Soln2: Create an array of chars and swap with pointers

    public String soln1(String text) {

        // Convert into array
        char[] chars = text.toCharArray();

        // Initialize pointers
        int left;
        int right = text.length() - 1;

        // Loop through swapping left and right until we hit the middle
        for (left = 0; left < right; left++, right--) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }

        return String.valueOf(chars);
    }

}

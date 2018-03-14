package questions.classics;

import java.util.Arrays;

public class Anagram {

    //
    // One string is an anagram of another if you can sort them alphabetically
    // and they equal each other.
    //
    public boolean isAnagram(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        Arrays.sort(chars1);

        char[] chars2 = text2.toCharArray();
        Arrays.sort(chars2);

        // Note: Don't do ==
        return Arrays.equals(chars1, chars2);
    }
}

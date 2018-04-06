package challenges.classics;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    //
    // Soln1:
    //
    // Build a map of each text's character and frequency and then compare to
    // to see if they are the same.
    //
    public boolean isAnagram1(String text1, String text2) {

        // Map 1
        HashMap<String, Integer> map1 = map(text1);

        // Map 2
        HashMap<String, Integer> map2 = map(text2);

        // Compare letters and frequency of characters in Maps
        return map1.equals(map2);
    }

    private HashMap<String, Integer> map(String text) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        char[] chars = text.toCharArray();

        // Loop through and build the map one letter at a time...
        for (int i=0; i < chars.length; i++) {
            String letter = String.valueOf(chars[i]);

            // if we already have, just increment
            if (map.containsKey(letter)) {
                Integer currentCount = map.get(letter);
                map.put(letter, currentCount + 1);
            } else { // else add
                map.put(letter, 1);
            }
        }

        return map;
    }

    //
    // Soln2:
    //
    // One string is an anagram of another if you can sort them alphabetically
    // and they equal each other.
    //
    public boolean isAnagram2(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        Arrays.sort(chars1);

        char[] chars2 = text2.toCharArray();
        Arrays.sort(chars2);

        // Note: Don't do ==
        return Arrays.equals(chars1, chars2);
    }

}

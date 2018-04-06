package challenges.arraysAndStrings;

public class UniqueCharacterDetector {

    // There are lots of ways we could solve this:
    //  - HashMap where we store every character and a boolean on whether found
    //  - An array that counts the number of times a character occurs
    //
    // But as an example of of how optimized and tight we can make this, checkout this solution below
    // to see how a simple array, that stores booleans, gives us everything we need.

    public boolean isUnique(String text) {
        // Create an array representing all unique 128 characters in ASCII.
        // Set a flag to true for each letter.

        // Return false when we find we already have a match.

        // If length > 128 there must be a duplicate
        if (text.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < text.length(); i++) {
            int val = text.charAt(i);
            if (char_set[val]) { // Already found
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }


}

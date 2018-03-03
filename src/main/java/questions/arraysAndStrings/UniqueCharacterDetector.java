package questions.arraysAndStrings;

public class UniqueCharacterDetector {

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

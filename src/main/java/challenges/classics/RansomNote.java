package challenges.classics;

import java.util.HashMap;

public class RansomNote {

    //
    // This is basically an exercise in counting and book keeping.
    //
    // If we can count the number of times a letter appears in the ransom note,
    // and then compare it with the number of times it appears in the letters,
    // we can tell if the ransom note can be written.
    //

    public boolean canWrite(String note, String letters) {

        // Assumption: We don't need to count spaces in our note
        String noteNoSpaces = note.replaceAll("\\s+","");

        HashMap<String, Integer> noteMap = map(noteNoSpaces);
        HashMap<String, Integer> letterMap = map(letters);

        return canWriteRansom(noteMap, letterMap);
    }

    private HashMap<String, Integer> map(String text) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        char[] characters = text.toCharArray();

        for (int i=0; i < characters.length; i++) {

            String character = String.valueOf(characters[i]);

            // If we already have this character...increment the count
            if (map.containsKey(character)) {
                Integer currentCount = map.get(character);
                map.put(character, currentCount + 1);
            }
            // Else add
            else {
                map.put(String.valueOf(characters[i]), 1);
            }
        }

        return map;
    }

    private boolean canWriteRansom(HashMap<String, Integer> noteMap, HashMap<String, Integer> letterMap) {
        for (String key : noteMap.keySet()) {

            if (!letterMap.containsKey(key)) {
                return false;
            }

            int noteCount = noteMap.get(key);
            int letterCount = letterMap.get(key);

            if (letterCount < noteCount) {
                return false;
            }

        }
        return true;
    }

}

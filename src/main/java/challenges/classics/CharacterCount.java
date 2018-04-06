package challenges.classics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CharacterCount {

    public String maxChar(String text) {

        // Build a map of character and count
        HashMap<String, Integer> characterMap = map(text);

        // Return the max
        return max(characterMap);
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

    private String max(HashMap<String, Integer> map) {
        int maxCount = 0;
        String maxLetter = "";

        // Loop through keeping track of the highest letter count
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry)it.next();
            int value = (Integer)pair.getValue();

            if (value > maxCount) {
                maxLetter = (String)pair.getKey();
                maxCount = (Integer)pair.getValue();
            }

            it.remove(); // avoids a ConcurrentModificationException
        }

        return maxLetter;
    }

}

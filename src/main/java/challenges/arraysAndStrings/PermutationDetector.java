package challenges.arraysAndStrings;

import java.util.Arrays;

public class PermutationDetector {

    public boolean isPermutation(String text, String perm) {
        if (perm.length() != text.length()) return false;

        return sort(text).equals(sort(perm));
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

}

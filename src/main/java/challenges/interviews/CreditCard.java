package challenges.interviews;

import java.util.ArrayList;
import java.util.Arrays;

public class CreditCard {

    private String name;
    private ArrayList<String> prefixes;
    private ArrayList<Integer> lengths;

    public String Name() {
        return name;
    }

    public CreditCard(String name, String[] prefixes, int[] lengths) {
        this.name = name;
        this.prefixes = new ArrayList<>(Arrays.asList(prefixes));

        Integer[] lengthsAsIntegers = Arrays.stream( lengths ).boxed().toArray( Integer[]::new );
        this.lengths = new ArrayList<>(Arrays.asList(lengthsAsIntegers));
    }

    public boolean matches(String cardNumber) {

        // check lengths
        if (!lengths.contains(cardNumber.length())) {
            return false;
        }

        // check prefixes
        boolean matchesPrefix = false;
        for (String prefix: prefixes) {
            if (cardNumber.startsWith(prefix)) {
                matchesPrefix = true;
            }
        }

        return matchesPrefix;
    }
}
